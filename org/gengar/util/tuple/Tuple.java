package org.gengar.util.tuple;

public class Tuple implements ITuple {
	
	private static final long serialVersionUID = -7022725964715713830L;
	
	protected Object $first;
	protected Object $second;
	
	public Tuple(Object _first, Object _second) {
		$first = _first;
		$second = _second;
	}

	@Override
	public Object first() {
		return $first;
	}

	@Override
	public Object second() {
		return $second;
	}

}
