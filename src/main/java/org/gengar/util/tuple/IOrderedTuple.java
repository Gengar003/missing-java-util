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
 * A tuple which contains comparable elements, and is therefore itself comparable.
 * @author awitt
 *
 * @param <First> The data type of the first object in the tuple.
 * @param <Second> The data type of the second object in the tuple.
 */
public interface 
	IOrderedTuple<
		First extends Comparable<First>, 
		Second extends Comparable<Second>> 
	extends 
		IGenericTuple<First, Second>, 
		Comparable<IOrderedTuple<First, Second>> 
{
	
}
