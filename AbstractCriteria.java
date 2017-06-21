package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public abstract class AbstractCriteria implements Criteria{

	private boolean xor;
	private Criteria other;
	
	public AbstractCriteria(){
		xor = false;
	}


	@Override
	public Criteria and(Criteria other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria or(Criteria other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria xor(Criteria other) {
		xor= true;
		this.other = other;
		return this;
	}

	@Override
	public Criteria not() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean groupCriteriaMatch(Task t) { 
		boolean a = this.matches(t);
		if(xor)
			a = a ^ other.groupCriteriaMatch(t);
		return a;
	}

}
