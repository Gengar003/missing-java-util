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

public class GenericTuple<First, Second> implements IGenericTuple<First, Second> {
	
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
}
