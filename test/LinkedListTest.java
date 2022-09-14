

import org.junit.jupiter.api.Test;

import utilities.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest 
{
	
	@Test 
	void testAddToFront() {
		LinkedList<Integer> arr = new LinkedList<Integer>();
		assertEquals(0, arr.size());
		arr.addToFront(1);
		assertEquals(1, arr.size());
	}
	
	@Test
	void testToSting() 
	{
		LinkedList<Integer> tester = new LinkedList<>();
		tester.addToFront(1);
		assertEquals("1", tester.toString());
		//assertFalse(tester.isEmpty());
	}
	
	@Test
	void testReverse() 
	{
		
	}
	
	@Test
	void testContains() 
	{
		LinkedList<Integer> tester = new LinkedList<>();
		tester.addToFront(1);
		assertFalse(tester.isEmpty());
		assertTrue(tester.contains(1));
	}
}
