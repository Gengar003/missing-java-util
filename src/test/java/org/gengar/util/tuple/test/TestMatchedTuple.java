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

package org.gengar.util.tuple.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.gengar.util.tuple.IMatchedTuple;
import org.gengar.util.tuple.impl.MatchedTuple;
import org.junit.Test;

public class TestMatchedTuple {

	private List<IMatchedTuple<String>> $stuples;
	private List<IMatchedTuple<Integer>> $intuples;
	
	public void populate_with_tuples() {
		
		$stuples = new ArrayList<IMatchedTuple<String>>();
		$intuples = new ArrayList<IMatchedTuple<Integer>>();
				
		// Strings
		$stuples.add( new MatchedTuple<String>( "Cat", "Cute" ) );
		$stuples.add( new MatchedTuple<String>( "Dog", "Loyal" ) );
		$stuples.add( new MatchedTuple<String>( "Bunny", "'dorbs" ) );
		$stuples.add( new MatchedTuple<String>( "Snake", "Slithery" ) );
		$stuples.add( new MatchedTuple<String>( "Dodecahedron", "Abnormal" ) );
		
		$stuples.add( new MatchedTuple<String>( "Bunny", "'dorbs" ) );
		$stuples.add( new MatchedTuple<String>( "Dodecahedron", "Abnormal" ) );
		
		// Integers
		$intuples.add( new MatchedTuple<Integer>( 5, 25 ) );
		$intuples.add( new MatchedTuple<Integer>( 1, 1 ) );
		$intuples.add( new MatchedTuple<Integer>( 3, 9 ) );
		$intuples.add( new MatchedTuple<Integer>( 10, 100 ) );
		$intuples.add( new MatchedTuple<Integer>( -25, 625 ) );
		
		$intuples.add( new MatchedTuple<Integer>( 3, 9 ) );
		$intuples.add( new MatchedTuple<Integer>( -25, 625 ) );
		
	}
	
	@Test
	public void test_creation() {
		populate_with_tuples();
	}
	
	@Test
	public void test_accesses() {
		
		MatchedTuple<String> test1 = new MatchedTuple<String>( "Doggly-Woggly", "dogglwoggles" );
		
		assertEquals( "Doggly-Woggly", test1.first() );
		assertEquals( "dogglwoggles", test1.second() );
	}
	
	@Test
	public void test_equality() {
		
		MatchedTuple<String> dog1a = new MatchedTuple<String>( "Dog", "Dogglywoggly" );
		MatchedTuple<String> dog1b = new MatchedTuple<String>( "Dog", "Dogglywoggly" );
		
		// Equals should say they're equal.
		assertEquals( dog1a, dog1b );
		assertEquals( dog1b, dog1a );
		
		// They should have the same hash codes.
		assertEquals( dog1a.hashCode(), dog1b.hashCode() );
	}
	
	@Test
	public void test_inequality() {
		
		MatchedTuple<String> dog1a = new MatchedTuple<String>( "Dog", "Dogglywoggly" );
		MatchedTuple<String> dog2 = new MatchedTuple<String>( "dog", "Dogglywoggly" );
		MatchedTuple<String> dog3 = new MatchedTuple<String>( "Dog", "kitter-nitter" );
		MatchedTuple<String> dog4 = new MatchedTuple<String>( null, "Dogglywoggly" );
		MatchedTuple<String> dog5 = new MatchedTuple<String>( null, null );

		assertThat( dog1a, is( not( dog2 ) ) );
		assertThat( dog2, is( not( dog1a ) ) );
		
		assertThat( dog1a, is( not( dog3 ) ) );
		assertThat( dog3, is( not( dog1a ) ) );
		
		assertThat( dog1a, is( not( dog4 ) ) );
		assertThat( dog4, is( not( dog1a ) ) );
		
		assertThat( dog1a, is( not( dog5 ) ) );
		assertThat( dog5, is( not( dog1a ) ) );
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void test_incomparable() {
		
		MatchedTuple<String> dog1a = new MatchedTuple<String>( "Dog", "Dogglywoggly" );
		MatchedTuple<Integer> dog6 = new MatchedTuple<Integer>( 1, 5 );
		MatchedTuple<Integer> dog7 = new MatchedTuple<Integer>( null, 0 );
		MatchedTuple<Integer> dog8 = new MatchedTuple<Integer>( 100, null );
		
		// If someone ignores generics and tries to compare tuples with different data types...
		assertThat( (MatchedTuple)dog1a, is( not( (MatchedTuple)dog6 ) ) );
		assertThat( (MatchedTuple)dog6, is( not( (MatchedTuple)dog1a ) ) );
		
		assertThat( (MatchedTuple)dog1a, is( not( (MatchedTuple)dog7 ) ) );
		assertThat( (MatchedTuple)dog7, is( not( (MatchedTuple)dog1a ) ) );
		
		assertThat( (MatchedTuple)dog1a, is( not( (MatchedTuple)dog8 ) ) );
		assertThat( (MatchedTuple)dog8, is( not( (MatchedTuple)dog1a ) ) );
	}

}
