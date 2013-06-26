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

package org.gengar.util.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * User: awitt
 * Date: 13-06-12
 */
public class TestCollectionMap {
	
	private DefaultListMap<String, Integer> $list_map;
	
	@Before
	public void before() {
		$list_map = new DefaultListMap<String, Integer>();
	}
	
	private void populate_with_animals() {
		$list_map.add( "dogs", 5 );
		$list_map.add( "dogs", 6 );
		$list_map.add( "dogs", 7 );
		
		$list_map.add( "cats", 0 );
		$list_map.add( "cats", 5 );
		
		$list_map.add( "bunnies", -5 );
		$list_map.add( "bunnies", -5 );
		$list_map.add( "bunnies", -5 );
		$list_map.add( "bunnies", 5 );
		
		$list_map.add( "fawns", -9 );
		$list_map.add( "fawns", 6 );
		$list_map.add( "fawns", 20 );
		
	}
	
	@Test
	public void test_insertion() {
		populate_with_animals();
	}

	@Test
	public void recall_valid() {
		
		populate_with_animals();
		
		assertEquals( new Integer(5), $list_map.get( "dogs" ).get( 0 ) );
		
		assertTrue( $list_map.get( "dogs" ).contains( 7 ) );
	}
	
	@Test
	public void recall_dumb() {
		
		// Should succeed, but is dumb.
		$list_map.add( "bunnies", null );
		assertEquals( null, $list_map.get( "bunnies" ).get( 0 ) );
		
		// This is also dumb. Don't do it.
		$list_map.add( null, 5 );
		assertEquals( new Integer(5), $list_map.get( null ).get( 0 ) );
	}
	
	@Test
	public void deletion_valid() {
		
		populate_with_animals();
		
		// Three animals should have "5" mapped to them.
		assertTrue( $list_map.get( "dogs" ).contains( 5 ) );
		assertTrue( $list_map.get( "cats" ).contains( 5 ) );
		assertTrue( $list_map.get( "bunnies" ).contains( 5 ) );
		
		Set<String> removeds = $list_map.remove_all( 5 );
		
		// THESE three animals should've had a "5" removed.
		assertTrue( removeds.contains( "dogs" ) );
		assertTrue( removeds.contains( "cats" ) );
		assertTrue( removeds.contains( "bunnies" ) );
		// and ONLY these three.
		assertTrue( 3 == removeds.size() );
		
		// Finally, there should be no more 5s
		assertFalse( $list_map.containsValue( 5 ) );
	}
	
	@Test
	public void deletion_selective() {
		
		populate_with_animals();
		
		// Three animals should have "5" mapped to them.
		assertTrue( $list_map.get( "dogs" ).contains( 5 ) );
		assertTrue( $list_map.get( "cats" ).contains( 5 ) );
		assertTrue( $list_map.get( "bunnies" ).contains( 5 ) );
		
		boolean removed = $list_map.remove_from( "bunnies", 5 );
		
		assertTrue( $list_map.get( "dogs" ).contains( 5 ) );
		assertTrue( $list_map.get( "cats" ).contains( 5 ) );
		
		// Bunnies should have no more 5s.
		assertFalse( $list_map.get( "bunnies" ).contains( 5 ) );
		
		// but the others should
		assertTrue( $list_map.get( "dogs" ).contains( 5 ) );
		assertTrue( $list_map.get( "cats" ).contains( 5 ) );
		
		// Finally, there are still 5s overall.
		assertTrue( $list_map.containsValue( 5 ) );
	}
	
	@Test
	public void deletion_invalid() {
		
		populate_with_animals();
		
		Set<String> removeds = $list_map.remove_all( 100000 );
		
		assertTrue( 0 == removeds.size() );
	}
}
