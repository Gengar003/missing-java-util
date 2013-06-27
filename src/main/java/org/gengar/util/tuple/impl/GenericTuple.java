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

package org.gengar.util.tuple.impl;

import org.gengar.util.tuple.IGenericTuple;
import org.gengar.util.tuple.TupleUtils;

/**
 * Implementation of the most flexible generic tuple
 * @see IGenericTuple
 * @author awitt
 *
 * @param <First> The data type of the first object in the tuple.
 * @param <Second> The data type of the second object in the tuple.
 */
public class GenericTuple<First, Second> implements IGenericTuple<First, Second> 
{
	private static final long serialVersionUID = -4841201915789424450L;
	
	protected First $first;
	protected Second $second;
	
	public GenericTuple(First _first, Second _second) {
		$first = _first;
		$second = _second;
	}

	@Override
	public First first() {
		return $first;
	}

	@Override
	public Second second() {
		return $second;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (($first == null) ? 0 : $first.hashCode());
		result = prime * result + (($second == null) ? 0 : $second.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	public boolean equals(Object _other) {
		
		if( IGenericTuple.class.isInstance( _other ) ) {
			
			// Even if they're IGenericTuples of different types, the equals_helper will catch this and return false...
			return equals( (IGenericTuple<First, Second>)_other );
		}
		
		return false;
	}
	
	public boolean equals(IGenericTuple<First, Second> _other) {
		
		// If the first and second elements of both tuples are equal, then the tuples are equal.
		return
			TupleUtils.equals_helper( $first, _other.first() ) &&
			TupleUtils.equals_helper( $second, _other.second() );
	}
	
	public String toString() {
		return "(" + $first + ", " + $second + ")";
	}
}
