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
