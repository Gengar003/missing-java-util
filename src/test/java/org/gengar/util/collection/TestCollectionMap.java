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

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: awitt
 * Date: 13-06-12
 */
public class TestCollectionMap {


	@Test
	public void basic_use_case() {

		IMapOfLists<String,Integer> simple_map = new GeneralListMap<>();
		simple_map.put( "cat", 5 );
		simple_map.put( "cat", 6 );
		simple_map.put("dog", 10);
		simple_map.put( "cat", 5 );

		List<Integer> cats = simple_map.get( "cat" );
		Integer specific_cat = simple_map.get( "cat", 0 );

		assertEquals(specific_cat, (Integer)5);
	}
}
