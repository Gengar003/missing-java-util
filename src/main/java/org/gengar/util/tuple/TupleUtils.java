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

package org.gengar.util.tuple;

/**
 * There are lots of repeated operations involved in handling tuples, especially where equality and comparisons are concerned.
 * Let's write this code once and keep it here, instead of writing it once per Tuple implementation!
 * @author awitt
 *
 */
public class TupleUtils {
	
	/**
	 * Compare two objects, and handle nulls gracefully.
	 * <table border=1 cellspacing=0><tbody>
	 * 	<tr><td>col.compareTo(row)</td><td>null</td><td>value</td></tr>
	 * 	<tr><td>null</td><td>0</td><td>-1</td></tr>
	 * 	<tr><td>value</td><td>1</td><td>value.compareTo(value)</td></tr>
	 * </tbody></table>
	 * @param _first The first object to compare, may be null.
	 * @param _second The second object to compare, may be null.
	 * @return effectively _first.compareTo( _second ), but tolerant of null inputs.
	 */
	public static <SomeType extends Comparable<SomeType>> int compare_helper( SomeType _first, SomeType _second ) {
		
		if( null != _first && null != _second ) {
			// both can be compared.
			return _first.compareTo( _second );
		} else if( null == _first && null == _second ) {
			// both are null, they're equal.
			return 0;
		} else if( null == _first && null != _second ) {
			return -1;
		} else if( null != _first && null == _second ) {
			return 1;
		}
		
		throw new RuntimeException( "Given two values `" + _first + "' and `" + _second + "', they were neither both null, both non-null, (first non-null and second null), or (first null and second non-null). This should have been impossible." );
	}
	
	/**
	 * Checks equality of two objects, and is null-tolerant.
	 * @param _first The first object.
	 * @param _second The second object
	 * @return True if the first and second objects are semantically equal. False otherwise.
	 */
	public static boolean equals_helper( Object _first, Object _second ) {
		
		if( null != _first && null != _second ) {
			// Both are non-null; we can compare them IF they're of the same type.
			
			if( _first.getClass().equals( _second.getClass()) ) {
				// They're the same class.
				return _first.equals( _second );
			}
			
		} else if( null == _first && null == _second ) {
			// Both are null; they're equal.
			
			return true;
		}
		
		// One is null, the other isn't. Unequal!
		return false;
		
	}

}
