package org.elsys.todo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TodoListImplTest {

	private TodoList todoList = TodoList.parse(
			"TODO    | Do OOP homework              | Low    | school, programming\r\n" + 
			"TODO    | Get 8 hours of sleep.        | Low    | health\r\n" + 
			"DOING   | Party hard.                  | Normal | social\r\n" + 
			"DONE    | Netflix and chill.           | Normal | tv shows\r\n" + 
			"TODO    | Find missing socks.          | Low    | meh\r\n" + 
			"");
	
	@Test
	public void filterByStatus() {
		TodoList filtered = todoList.filter(Criteria.status(Status.DOING).xor(Criteria.status(Status.DONE)));
		assertEquals(2, filtered.getTasks().size());
	}
	@Test
	public void testMatchingPercentege() {
		assertEquals(20.0,todoList.matchingPercentage(Criteria.status(Status.DONE)),0);
		System.out.println(todoList.matchingPercentage(Criteria.status(Status.DONE)));
	}
}
