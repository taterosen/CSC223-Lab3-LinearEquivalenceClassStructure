

import org.junit.jupiter.api.Test;

import utilities.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
	
	/**
	 * Tests isEmpty
	 */
	@Test
	void testIsEmpty() {
		//test on empty list
		LinkedList<Integer> arr = new LinkedList<Integer>();
		assertTrue(arr.isEmpty());
		
		//test on list with items
		Integer num1 = 14;
		Integer num2 = 265;
		Integer num3 = 420;
		arr.addToBack(num1);
		arr.addToBack(num2);
		arr.addToFront(num3);
		assertFalse(arr.isEmpty());
	}
	
	/**
	 * Tests the clear method
	 */
	@Test
	void testClear() {
		//test on empty list
		LinkedList<Integer> arr = new LinkedList<Integer>();
		arr.clear();
		assertTrue(arr.isEmpty());
		assertEquals(0, arr.size());
		
		//test on list with items
		Integer num1 = 14;
		Integer num2 = 265;
		Integer num3 = 420;
		arr.addToBack(num1);
		arr.addToBack(num2);
		arr.addToFront(num3);
		arr.clear();
		assertTrue(arr.isEmpty());
		assertEquals(0, arr.size());
	}
	
	/**
	 * Tests the size method
	 */
	@Test
	void testSize() {
		//test on empty list
		LinkedList<Integer> arr = new LinkedList<Integer>();
		arr.clear();
		assertTrue(arr.isEmpty());
		assertEquals(0, arr.size());
		
		//test on list with items
		Integer num1 = 14;
		Integer num2 = 265;
		Integer num3 = 420;
		arr.addToBack(num1);
		arr.addToBack(num2);
		arr.addToFront(num3);
		assertEquals(3, arr.size());
		
		//test after removing and item
		arr.remove(num3);
		assertEquals(2, arr.size());
	}
	
	/**
	 * Tests addToFront
	 */
	@Test
	void testAddToFront() {
		// Test on empty list
		LinkedList<Integer> arr = new LinkedList<Integer>();
		arr.addToFront(1);
		assertEquals(1, arr.peakFirst());
		
		// Test of full list
		arr.addToFront(3);
		arr.addToFront(4);
		arr.addToFront(5);
		arr.addToFront(2);
		assertEquals(2, arr.peakFirst());
	}
	
	/**
	 * Tests the contains() method using an empty and non-empty Integer LinkedList
	 */
	@Test
	void testContains() {
		//Tests on empty list
		LinkedList<Integer> arr = new LinkedList<>();
		assertFalse(arr.contains(1));

		//Tests on non-empty list
		arr.addToFront(1);
		arr.addToFront(2);
		arr.addToFront(3);
		arr.addToFront(4);
		arr.addToFront(5);
		assertTrue(arr.contains(1));
		assertTrue(arr.contains(3));
		assertFalse(arr.contains(56));
	}
	
	/**
	 * Tests the remove() method
	 */
	@Test
	void testRemove() {
		//Tests on empty list
		LinkedList<Integer> arr = new LinkedList<>();
		assertFalse(arr.remove(1));

		//Tests on non-empty list
		arr.addToFront(1);
		arr.addToFront(2);
		arr.addToFront(3);
		arr.addToFront(4);
		arr.addToFront(5);
		assertTrue(arr.remove(1));
		
		// T
		assertFalse(arr.remove(56));
	}
	
	/**
	 * Tests the addToBack method
	 */
	@Test
	void testAddToBack() {
		// Test on empty list
		LinkedList<Integer> arr = new LinkedList<Integer>();
		arr.addToBack(1);
		assertEquals(1, arr.peakLast());
		
		// Test of full list
		arr.addToBack(3);
		arr.addToBack(4);
		arr.addToBack(5);
		arr.addToBack(2);
		assertEquals(2, arr.peakLast());
	}

	/**
	 * Tests the toString() method using an empty and non-empty Integer LinkedList
	 */
	@Test
	void testToString() {
		LinkedList<Integer> arr = new LinkedList<>();
		arr.addToFront(4);
		assertEquals("4", arr.toString());
		arr.addToFront(3);
		arr.addToFront(2);
		arr.addToFront(1);
		assertEquals("1 2 3 4", arr.toString());
	}
	
	/**
	 * Tests the reverse() method by calling toString() on a reverse list
	 * and comparing it to what it should yield
	 */
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

}
