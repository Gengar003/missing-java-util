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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Default implementation of a map of lists suitable for everyday use.
 * @author awitt
 *
 * @param <KeyType> The type of the keys used to lookup lists.
 * @param <ValueType> The type of data stored in the lists.
 */
public class DefaultListMap<KeyType, ValueType> 
	extends
		AMapOfCollections<KeyType, ValueType, ArrayList<ValueType>>
{
	
	public DefaultListMap() {
		super(
				new HashMap<KeyType, ArrayList<ValueType>>(), 
				new ICollectionFactory<ValueType, ArrayList<ValueType>>() {
					@Override
					public ArrayList<ValueType> make() {
						return new ArrayList<ValueType>();
					}
				});
	}
}
