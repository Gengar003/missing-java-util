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
 * Interface representing a mapping of keys to other maps.
 * @author awitt
 *
 * @param <InnerKeyType> The data type of keys in the inner maps.
 * @param <ValueType> The data type of values in the inner maps.
 * @param <InnerMapType> The data type of the inner maps.
 * @param <KeyType> The data type of keys in the outer map.
 */
public interface
	IMapOfMaps<
		InnerKeyType,
		ValueType,
		InnerMapType extends Map<InnerKeyType,ValueType>,
		KeyType
	> extends
	Map<
		KeyType,
		InnerMapType
	>
{
}
