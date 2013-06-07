package org.gengar.util.tuple;

public interface IOrderedTuple<
	First extends Comparable<First>, 
	Second extends Comparable<Second>> extends 
		IGenericTuple<First, Second>, 
		Comparable<IOrderedTuple<First, Second>> {
}
