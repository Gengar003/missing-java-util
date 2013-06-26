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

import org.gengar.util.tuple.ITuple;
import org.gengar.util.tuple.impl.Tuple;
import org.junit.Test;

public class TestPlainTuple {

	private List<ITuple> $tuples;
	
	public void populate_with_tuples() {
		
		$tuples = new ArrayList<ITuple>();
				
		// Matches
		$tuples.add( new Tuple( "Cat", "Cute" ) );
		$tuples.add( new Tuple( "Dog", "Loyal" ) );
		$tuples.add( new Tuple( "Bunny", "'dorbs" ) );
		$tuples.add( new Tuple( "Snake", "Slithery" ) );
		$tuples.add( new Tuple( "Dodecahedron", "Abnormal" ) );
		
		// Mismatches
		$tuples.add( new Tuple( "Cat", 5 ) );
		$tuples.add( new Tuple( "Dog", 6 ) );
		$tuples.add( new Tuple( "Bunny", -1 ) );
		$tuples.add( new Tuple( "Snake", 0 ) );
		$tuples.add( new Tuple( "Dodecahedron", null ) );
		
		// Duplicates
		$tuples.add( new Tuple( "Cat", 5 ) );
		$tuples.add( new Tuple( "Cat", "Cute" ) );
		
	}
	
	@Test
	public void test_creation() {
		populate_with_tuples();
	}
	
	@Test
	public void test_accesses() {
		
		Tuple test1 = new Tuple( "Doggly-Woggly", -90 );
		
		assertEquals( "Doggly-Woggly", test1.first() );
		assertEquals( new Integer( -90 ), test1.second() );
	}
	
	@Test
	public void test_equality() {
		
		Tuple dog1a = new Tuple( "Dog", new Integer( 30 ) );
		Tuple dog1b = new Tuple( "Dog", new Integer( 30 ) );
		Tuple dog2 = new Tuple( "dog", new Integer( 15 ) );
		Tuple dog3 = new Tuple( "Dog", null );
		Tuple dog4 = new Tuple( null, new Integer( 30 ) );
		Tuple dog5 = new Tuple( null, null );
		
		// Equals should say they're equal.
		assertEquals( dog1a, dog1b );
		assertEquals( dog1b, dog1a );
		
		// They should have the same hash codes.
		assertEquals( dog1a.hashCode(), dog1b.hashCode() );

		assertThat( dog1a, is( not( dog2 ) ) );
		assertThat( dog2, is( not( dog1a ) ) );
		
		assertThat( dog1a, is( not( dog3 ) ) );
		assertThat( dog3, is( not( dog1a ) ) );
		
		assertThat( dog1a, is( not( dog4 ) ) );
		assertThat( dog4, is( not( dog1a ) ) );
		
		assertThat( dog1a, is( not( dog5 ) ) );
		assertThat( dog5, is( not( dog1a ) ) );
	}

}
