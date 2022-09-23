

import org.junit.jupiter.api.Test;

import utilities.LinkedEquivalenceClass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

public class LinkedEquivalenceClassTest
{
	/**
	 * Tests clear() by filling a LinkedEquivClass and then clearing it
	 * */
	@Test
	void testClear() 
	{
		LinkedEquivalenceClass<Integer> tester = new LinkedEquivalenceClass<>(null);
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		assertEquals(5, tester.size());
		
		tester.clear();
		
		assertEquals(0, tester.size());
	}
	
	/**
	 * 
	 * */
	@Test
	void testClearNonConical() 
	{
		LinkedEquivalenceClass<Integer> tester = new LinkedEquivalenceClass<>(null);
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		assertEquals(5, tester.size());
		tester.clearNonCanonical();
		
		assertEquals(1, tester.size());
	}
	
	/**
	 * 
	 * */
	@Test
	void testAdd() 
	{
		LinkedEquivalenceClass<Integer> tester = new LinkedEquivalenceClass<>(null);
		assertTrue(tester.add(1));
		assertTrue(tester.add(2));
		assertTrue(tester.add(3));
		assertTrue(tester.add(4));
		assertTrue(tester.add(5));
		assertTrue(tester.contains(1));
	}
	
	/**
	 * Tests contains() by filling a LinkedEquivClass and then checking 
	 * its contents
	 * */
	@Test
	void testContains() 
	{
		LinkedEquivalenceClass<Integer> tester = new LinkedEquivalenceClass<>(null);
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		
		assertTrue(tester.contains(1));
		assertTrue(tester.contains(2));
		assertTrue(tester.contains(3));
		assertTrue(tester.contains(4));
		assertTrue(tester.contains(5));
	}
	
	/**
	 * 
	 * */
	@Test
	void testBelongs()
	{
		
	}
	
	/**
	 * Tests remove() by filling a LinkedEquivClass then removing elements from it
	 * and checking if the class still contains said elements
	 * */
	@Test
	void testRemove() 
	{
		LinkedEquivalenceClass<Integer> tester = new LinkedEquivalenceClass<>(null);
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		
		assertTrue(tester.remove(1));
		assertFalse(tester.contains(1));
		assertTrue(tester.remove(2));
		assertTrue(tester.remove(3));
		assertTrue(tester.remove(4));
		assertTrue(tester.remove(5));
		assertEquals(0, tester.size());
	}
	
	/**
	 * 
	 * */
	@Test
	void testRemoveConical() 
	{
		
	}
	
	/**
	 * 
	 * */
	@Test
	void testDemoteAndSetConical() 
	{
		
	}
	
	/**
	 * 
	 * */
	@Test
	void testToString() 
	{
		LinkedEquivalenceClass<Integer> tester = new LinkedEquivalenceClass<>(null);
		//assertEquals("Conical: null Rest: ", tester.toString());
		
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		
		assertEquals("Conical: null Rest 5 4 3 2 1 ", tester.toString());
	}
}
