package org.gengar.util.tuple;

/**
 * A tuple that contains items of only one type.
 * @author Austin
 *
 * @param <SingleType>
 */
public class MatchedTuple<SingleType> extends GenericTuple<SingleType, SingleType> implements IMatchedTuple<SingleType> {

	private static final long serialVersionUID = -536718241949678099L;

	public MatchedTuple(SingleType _first, SingleType _second) {
		super(_first, _second);
	}

}
