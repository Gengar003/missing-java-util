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

import java.util.Map;

/**
 * A factory that can make maps!
 * @author awitt
 *
 * @param <KeyType> The data type of the keys in the map.
 * @param <ValueType> The data type of the values in the map.
 * @param <MapType> The full type signature of the map produced by the factory.
 */
public interface IMapFactory<KeyType, ValueType, MapType extends Map<KeyType, ValueType>> {
	
	/**
	 * Instantiate and return a brand new map.
	 * @return A brand new map.
	 */
	public MapType make();
}
