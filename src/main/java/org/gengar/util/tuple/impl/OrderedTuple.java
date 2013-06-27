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

package org.gengar.util.tuple.impl;

import org.gengar.util.tuple.IOrderedTuple;
import org.gengar.util.tuple.TupleUtils;

/**
 * Implementation of a tuple which is comparable and orderable relative to other tuples,
 * on account of how its components are similarly comparable
 * @author awitt
 *
 * @param <First> The comparable data type of the first object in the tuple.
 * @param <Second> The comparable data type of the second object in the tuple.
 */
public class 
	OrderedTuple<
		First extends Comparable<First>, 
		Second extends Comparable<Second> > 

	extends 
	GenericTuple<
		First, 
		Second > 

	implements 
		IOrderedTuple<
			First, 
			Second > 
{

	private static final long serialVersionUID = 3061080672363685089L;
	
	public OrderedTuple(First _first, Second _second) {
		super( _first, _second );
		$first = _first;
		$second = _second;
	}

	@Override
	public First first() {
		return $first;
	}

	@Override
	public Second second() {
		return $second;
	}

	@Override
	public int compareTo(IOrderedTuple<First, Second> _other) {
		
		if( null == _other ) {
			return 1; // Null is less than everything; anything is greater than null.
		}
		
		int first_pass = TupleUtils.compare_helper( $first, _other.first() );
		
		if( 0 != first_pass ) {
			// The first two elements were not identical, so... we know where this tuple falls.
			return first_pass;
		}
		
		// If the first two elements are the same, the ordering depends on the second elements.
		return TupleUtils.compare_helper( $second, _other.second() );
	}
}
