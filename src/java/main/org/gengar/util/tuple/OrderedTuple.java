package org.gengar.util.tuple;

public class OrderedTuple<First extends Comparable<First>, Second extends Comparable<Second>> implements IOrderedTuple<First, Second> {

	private static final long serialVersionUID = 3061080672363685089L;
	
	protected First $first;
	protected Second $second;
	
	public OrderedTuple(First _first, Second _second) {
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
	public int compareTo(IOrderedTuple<First, Second> _other) {
		
		int first_round = $first.compareTo( _other.first() );
		
		if( 0 == first_round ) {
			
			int second_round = $second.compareTo( _other.second() );
			
			return second_round;
		}
		
		return first_round;
	}
	
	public boolean equals(IOrderedTuple<First, Second> _other) {
		
		return $first.equals( _other.first() ) && $second.equals( _other.second() );
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object _other) {
		
		if( _other instanceof IOrderedTuple<?, ?> ) {
			
			IOrderedTuple<?,?> _other_tuple = (IOrderedTuple<?, ?>)_other;
			
			if( 
				$first.getClass().equals( _other_tuple.first().getClass() ) &&
				$second.getClass().equals( _other_tuple.second().getClass() ) ) {
				
				return 0 == compareTo( (IOrderedTuple<First, Second>)_other_tuple );
			}
		}
		return false;
	}
	
	public int hashCode() {
		
		// All tuples start out the same.
		int hash_code = this.getClass().hashCode();
		
		// If either first or second is set, the hash changes.
		if( null != $first ) { hash_code += $first.hashCode(); }
		if( null != $second ) { hash_code += $second.hashCode(); }
		
		return hash_code;
	}

}
