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

public abstract class
		ACollectionOfCollections<
			InnerValueType,
			InnerType extends Collection<InnerValueType>,
			OuterType extends Collection<InnerType> >
		implements
		ICollectionOfCollections<
			InnerValueType,
			InnerType,
			OuterType >
{
	protected ICollectionFactory<InnerValueType, InnerType> $collection_factory;

	protected OuterType $underlying_collection;

	public ACollectionOfCollections(
			final ICollectionFactory<InnerType, OuterType> _outer_factory,
			final ICollectionFactory<InnerValueType, InnerType> _inner_factory )
	{
		this( _outer_factory.make(), _inner_factory );
	}

	// primary constructor
	public ACollectionOfCollections(
			final OuterType _outer_collection,
			final ICollectionFactory<InnerValueType, InnerType> _inner_factory )
	{
		$underlying_collection = _outer_collection;
		$collection_factory = _inner_factory;
	}
}
