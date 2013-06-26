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

import java.io.Serializable;

/**
 * Most generic tuple interface: Two objects of two unspecified types.
 * @author awitt
 *
 * @param <First> The data type of the first object in the tuple.
 * @param <Second> The data type of the second object in the tuple.
 */
public interface IGenericTuple<First, Second> extends Serializable {
	
	/**
	 * Get the first object in the tuple.
	 * @return The first object in the tuple.
	 */
	public First first();
	
	/**
	 * Get the second object in the tuple.
	 * @return The second object in the tuple.
	 */
	public Second second();
}
