package org.elsys.todo.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.elsys.todo.Criteria;
import org.elsys.todo.Priority;
import org.elsys.todo.Status;
import org.elsys.todo.Task;
import org.elsys.todo.TodoList;

public class TodoListImpl implements TodoList {

	private List<Task> tasks;

	/**
	 * TODO    | Do OOP homework              | Low    | school, programming
	 * TODO    | Get 8 hours of sleep.        | Low    | health
	 * DOING   | Party hard.                  | Normal | social
	 * DONE    | Netflix and chill.           | Normal | tv shows
	 * TODO    | Find missing socks.          | Low    | meh

	 * @param input
	 */
	public TodoListImpl(String input) {
		tasks = Arrays.stream(input.split("\n")).map(line -> {
			String[] splitted = Arrays.stream(line.split("\\|"))
				.map(String::trim)
				.toArray(size -> new String[size]);
			return new TaskImpl(
					Status.valueOf(splitted[0].toUpperCase()),
					splitted[1],
					Priority.valueOf(splitted[2].toUpperCase()),
					splitted[3].split(", "));
		}).collect(Collectors.toList());
	}

	public TodoListImpl() {
		tasks = new ArrayList<>();
	}

	@Override
	public Boolean isCompleted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double completedPercentage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double statusPercentage(Status status) {
		double doneCount = 0;
		for(Task t : tasks)
		{
			if(t.getStatus() == status)
				doneCount++;
		}
		doneCount = doneCount/size()*100;
		return (double) Math.round(doneCount * 100) / 100;
	}

	@Override
	public Double matchingPercentage(Criteria criteria) {
		double doneCount = 0;
		for(Task t : tasks)
		{
			if(criteria.matches(t))
				doneCount++;
		}
		doneCount = doneCount/size()*100;
		return (double) Math.round(doneCount * 100) / 100;
	}

	@Override
	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public TodoList filter(Criteria criteria) {
		TodoList filtered = new TodoListImpl();
		for(Task t : tasks){
			if(criteria.groupCriteriaMatch(t))
				filtered.getTasks().add(t);
		}
		return filtered;
	}

	@Override
	public int count(Criteria criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void each(Consumer<Task> consumer) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public TodoList join(TodoList other) {
		TodoList joined = new TodoListImpl();
		for(Task t : tasks){
			if(!joined.getTasks().contains(t))
					joined.getTasks().add(t);
		}
		for(Task t : other.getTasks()){
			if(!joined.getTasks().contains(t))
				joined.getTasks().add(t);
		}
		
		return joined;

	}
	public int size() {
		return tasks.size();
	}

}
