package org.elsys.todo.impl;

import java.util.Arrays;

import org.elsys.todo.Task;

public class TagCriteria extends AbstractCriteria{
	private String[] tags;

	
	public TagCriteria(String[] tags) {
		super();
		this.tags = tags;
	}
	

	@Override
	public boolean matches(Task task) {
		boolean a = Arrays.asList(task.getTags()).containsAll(Arrays.asList(tags));
		if(not)
			a = !a;
		if(and)
			a = a && other.matches(task);
		if(or)
			a = a || other.matches(task);
		return a;

	}

}
