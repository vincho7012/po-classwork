package org.elsys.todo;

import org.elsys.todo.impl.StatusCriteria;

/**
 * Interface used for filtering {@link TodoList}s.
 */
public interface Criteria {

	
	public static Criteria status(Status status) {
		// TODO implement me
		return new StatusCriteria(status);
	}

	
	public static Criteria priority(Priority priority) {
		// TODO implement me
		return null;
	}

	public static Criteria tags(String[] tags) {
		// TODO implement me
		return null;
	}

	/**
	 * Creates new Criteria instance representing conjunction with the provided
	 * as argument Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria and(Criteria other);

	/**
	 * Creates new Criteria instance representing disjunction with the provided
	 * as argument Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria or(Criteria other);

	/**
	 * Creates new Criteria instance representing exclusive disjunction with the
	 * provided as argument Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria xor(Criteria other);

	/**
	 * Creates new Criteria instance representing negation of the Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria not();
	public boolean matches(Task t);
	public boolean groupCriteriaMatch(Task t);

}
