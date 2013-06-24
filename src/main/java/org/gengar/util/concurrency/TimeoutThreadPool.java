/*
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.gengar.util.concurrency;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * You can put runnables here. You can specify the maximum number of runnables that will be running at any given time.
 * You can also specify a maximum time period for which any given runnable will run.
 * Before you start the thread pool, runnables will queue up for execution.
 * Once started, the thread pool will run runnables until it runs out of runnables, adhering to the constraints of the pool. 
 * After started, runnables will queue up and run immediately if possible. Otherwise, they'll wait their turn.
 * @author Austin
 *
 */
public class TimeoutThreadPool {
	
	protected Timer $timer;
	protected Queue<Runnable> $queue;
	protected Integer $num_tasks;
	protected Integer $current_tasks;
	protected int $timeout;
	protected ScheduledThreadPoolExecutor $executor;
	protected Boolean $started;
	
	/**
	 * Create a thread pool.
	 * @param _num_tasks The maximum number of simultaneous tasks to run.
	 * @param _miliseconds The maximum time, in milliseconds, that any one task will be allowed to run.
	 */
	public TimeoutThreadPool(int _num_tasks, int _miliseconds) {
		
		$timer = new Timer(true);
		$queue = new ConcurrentLinkedQueue<Runnable>();
		$num_tasks = _num_tasks;
		$timeout = _miliseconds;
		$current_tasks = 0;
		$executor = new ScheduledThreadPoolExecutor( $num_tasks * 2 );
		$started = false;
	}
	
	/**
	 * Add the given task to the queue, and execute it when there's time.
	 * @param _runnable The task to execute.
	 */
	public void execute(Runnable _runnable) {
		System.out.println("Queueing task: [" + _runnable + "]" );
		$queue.add( _runnable );
		
		synchronized( $started ) {
			if( $started ) {
				start_next_task( false );
			}
		}
	}
	
	/**
	 * Start the thread pool. It will run tasks until it is out of tasks, and then run any subsequent tasks immediately upon receiving them.
	 */
	public void start() {
		
		int num_tasks = 0;
		
		synchronized( $started ) {
			$started = true;
		}
		
		synchronized( $num_tasks ) {
			num_tasks = $num_tasks;
		}
		
		synchronized( $current_tasks ) {
			for( int task = 0; task < num_tasks; task++ ) {
				start_next_task( false );			
			}
		}
	}
	
	/**
	 * Helper method. Starts a new task up, if appropriate, and ensures that it will time out.
	 * @param _just_finished
	 */
	protected void start_next_task( boolean _just_finished ) {
		
		synchronized( $current_tasks ) {
			if( _just_finished ) { $current_tasks --; }
			
			if( $current_tasks < $num_tasks ) {
				Runnable runnable = $queue.poll();
				
				if( null != runnable ) {
					int remain = $queue.size();
					if( 0 == remain % $num_tasks ) {
						System.out.println( "Starting a task... ["  + remain + "] remain." );
					}
					Thread thread = new Thread( new InterruptableRunnable( this, runnable ) );
					
					$executor.schedule( new TimeOutTask( thread ), $timeout, TimeUnit.MILLISECONDS );
					
					thread.start();
					
					$current_tasks++;
				}
			}
		}
	}
	
	/**
	 * A runnable that can be interrupted.
	 * @author Austin
	 *
	 */
	 static class InterruptableRunnable implements Runnable {
		 
		protected Runnable $runnable;
		protected TimeoutThreadPool $pool;
		protected long start;
		
		/**
		 * Creates a new interruptable runnable.
		 * @param _pool The pool that this interruptable will be run in.
		 * @param _r The runnable that contains the actual execution logic.
		 */
		public InterruptableRunnable( TimeoutThreadPool _pool, Runnable _r ) {
			$pool = _pool;
			$runnable = _r;
		}

		@Override
		public void run() {
			start = System.nanoTime();
			try {
				$runnable.run();
				Thread.sleep( 1 ); // so we can compile with interruptedexception...
			} catch( InterruptedException e ) {
				// We don't care.
			}
			
			$pool.start_next_task( true );
		}
		
	}
	
	 /**
	  * Timer used to interrupt a runnable after a set amount of time
	  * @author Austin
	  *
	  */
	static class TimeOutTask extends TimerTask {
		Thread $thread;
		
		/**
		 * Create a new timeout task that will time out the specified thread.
		 * @param _thread THe thread that will time out.
		 */
		TimeOutTask( Thread _thread ) {
			$thread = _thread;
		}
		
		public void run() {
			if( null != $thread ) {
				
				for( int attempt = 0; attempt < 10 && !$thread.isInterrupted(); attempt++ ) {
					$thread.interrupt();
				}
			}
		}
	}

}
