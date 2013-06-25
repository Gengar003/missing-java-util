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
import java.util.Iterator;

/**
 * Abstraction of Collection-of-collection functionality, providing constructors and structure.
 * @author awitt
 *
 * @param <InnerValueType> The data type held by the inner collections.
 * @param <InnerType> The data type of the inner collections 
 * @param <OuterType> The data type of the outer collection.
 */
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
	/**
	 * A collection factory used to generate new inner collections, as needed.
	 */
	protected ICollectionFactory<InnerValueType, InnerType> $collection_factory;
	
	/**
	 * The outer collection that holds the inner collections.
	 */
	protected OuterType $underlying_collection;
	
	/**
	 * @param _outer_factory A factory that can produce collections that can hold collections produced by the inner factory.
	 * @param _inner_factory A factory that can prodcue collections that can be contained by collections produced by the outer factory
	 */
	public ACollectionOfCollections(
			final ICollectionFactory<InnerType, OuterType> _outer_factory,
			final ICollectionFactory<InnerValueType, InnerType> _inner_factory )
	{
		this( _outer_factory.make(), _inner_factory );
	}

	/**
	 * Primary constructor. Other constructors are just convenience wrappers for this one.
	 * @param _outer_collection A Collection instance to use as the outer container.
	 * @param _inner_factory A factory that can generate collections to use for the inner containers.
	 */
	public ACollectionOfCollections(
			final OuterType _outer_collection,
			final ICollectionFactory<InnerValueType, InnerType> _inner_factory )
	{
		$underlying_collection = _outer_collection;
		$collection_factory = _inner_factory;
	}
	
	@Override
	public boolean add(InnerType _elem) {
		return $underlying_collection.add( _elem );
	}

	@Override
	public boolean addAll(Collection<? extends InnerType> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<InnerType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
