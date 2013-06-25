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
import static org.junit.Assert.assertTrue;

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
	}


	@Test
	public void creation_valid() {
		
		populate_with_animals();
		
		assertEquals( new Integer(5), $list_map.get( "dogs" ).get( 0 ) );
		
		assertTrue( $list_map.get( "dogs" ).contains( 7 ) );
	}
}
