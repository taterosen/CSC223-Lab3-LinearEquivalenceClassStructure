

import org.junit.jupiter.api.Test;

import utilities.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest
{
	/**
	 * Tests addToFront
	 * */
	@Test
	void testAddToFront() {
		LinkedList<Integer> arr = new LinkedList<Integer>();
		assertEquals(0, arr.size());
		arr.addToFront(1);
		assertEquals(1, arr.size());
		arr.addToFront(2);
	}

	/**
	 * Tests the toString() method using an empty and non-empty Integer LinkedList
	 * */
	@Test
	void testToSting()
	{
		//test on empty list
		LinkedList<Integer> tester = new LinkedList<>();
		assertTrue(tester.isEmpty());
		tester.addToFront(1);
		assertFalse(tester.isEmpty());

		//test on non-empty list
		assertEquals("1", tester.toString());
		tester.addToBack(2);
		assertEquals("1 2", tester.toString());
	}
	
	/**
	 * Tests the reverse() method by calling toString() on a reverse list
	 * and comparing it to what it should yield
	 * */
	@Test
	void testReverse()
	{
		LinkedList<Integer> tester = new LinkedList<>();
		tester.addToFront(1);
		tester.addToFront(2);
		tester.addToFront(3);
		tester.addToFront(4);
		tester.addToFront(5);

		assertEquals("1 2 3 4 5", tester.toString());
		tester.reverse();
		assertEquals("5 4 3 2 1", tester.toString());

	}

	/**
	 * Tests the contains() method using an empty and non-empty Integer LinkedList
	 * */
	@Test
	void testContains()
	{
		//Tests on empty list
		LinkedList<Integer> tester = new LinkedList<>();
		assertFalse(tester.contains(1));

		//Tests on non-empty list
		assertTrue(tester.isEmpty());
		tester.addToFront(1);
		tester.addToFront(2);
		tester.addToFront(3);
		tester.addToFront(4);
		tester.addToFront(5);
		assertFalse(tester.isEmpty());
		assertTrue(tester.contains(1));
		assertTrue(tester.contains(3));
	}
}
