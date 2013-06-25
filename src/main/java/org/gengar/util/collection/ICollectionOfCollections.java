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

import java.util.Collection;

/**
 * An interface that defines a collection that contains other collections.
 * Ideally, some higher-level, interesting functionality such as, in the case of a List of Lists, get(1, 4) or add( 1, object ) could occur.
 * However, not all collections are randomly-access compatible or ordered, so this interface remains mostly for consistency's sake with the other X-of-Y interfaces.
 * 
 * @author awitt
 *
 * @param <InnerValueType> The data type in the inner collection.
 * @param <InnerType> The data type of the inner collection (don't forget your generics!).
 * @param <OuterType> The data type of the outer collection (don't forget your generics!).
 */
public interface
	ICollectionOfCollections<
		InnerValueType,
		InnerType extends Collection<InnerValueType>,
		OuterType extends Collection<InnerType>
	> extends
	Collection<
		InnerType
	>
{
	
}
