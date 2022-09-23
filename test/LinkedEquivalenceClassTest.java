

import org.junit.jupiter.api.Test;

import utilities.LinkedEquivalenceClass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

public class LinkedEquivalenceClassTest
{
	public LinkedEquivalenceClass createLEC() {
		Comparator<Integer> c = new Comparator<Integer>()
		{
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			{ return x % 2 == y % 2 ? 0 : 1; }
		};
		return new LinkedEquivalenceClass(c);
	}
	
	/**
	 * Tests clear() by filling a LinkedEquivClass and then clearing it
	 * */
	@Test
	void testClear() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
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
	 * Tests clearNonCanocical by filling a LinkedEquivcClass then
	 * clearing it ensure the canonical was unchanged
	 * */
	@Test
	void testClearNonCanonical() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
		tester.setCanonical(2);
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		assertEquals(6, tester.size());
		assertEquals(2, tester.canonical());
		tester.clearNonCanonical();
		assertEquals(1, tester.size());
		assertEquals(2, tester.canonical());
	}
	
	/**
	 * Tests add() by adding to LinkedEquivClass
	 * and ensuring it contains added elements
	 * */
	@Test
	void testAdd() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
		assertTrue(tester.add(1));
		assertTrue(tester.add(2));
		assertTrue(tester.add(3));
		assertTrue(tester.add(4));
		assertTrue(tester.add(5));
		assertTrue(tester.contains(1));
		assertTrue(tester.contains(3));
		assertTrue(tester.contains(5));
	}
	
	/**
	 * Tests contains() by filling a LinkedEquivClass and then checking 
	 * its contents
	 * */
	@Test
	void testContains() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
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
	 * Tests belongs() by setting a canonical and testing if test values belongs 
	 * based on said canonical (positive and negative)
	 * */
	@Test
	void testBelongs()
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
		tester.setCanonical(2);
		assertTrue(tester.belongs(4));
		assertFalse(tester.belongs(5));
		assertTrue(tester.belongs(6));
		assertFalse(tester.belongs(7));
		
		assertTrue(tester.belongs(-4));
		assertFalse(tester.belongs(-3));
		
	}
	
	/**
	 * Tests remove() by filling a LinkedEquivClass then removing elements from it
	 * and checking if the class still contains said elements
	 * */
	@Test
	void testRemove() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		
		assertTrue(tester.remove(2));
		assertFalse(tester.contains(2));
		assertTrue(tester.remove(3));
		assertTrue(tester.remove(4));
		assertTrue(tester.remove(5));
		assertEquals(1, tester.size());
	}
	
	/**
	 * Tests removeCanonical() an both empty and non-empty LinkedEquivClass
	 * */
	@Test
	void testRemoveCanonical() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
		assertFalse(tester.removeCanonical());
		tester.setCanonical(2);
		tester.add(2);
		tester.add(4);
		tester.add(6);
		tester.add(8);
		assertEquals(2, tester.canonical());
		assertTrue(tester.removeCanonical());
		assertEquals(8, tester.canonical());
		
	}
	
	/**
	 * Tests demoteAndSetCanonical() an both empty and non-empty LinkedEquivClass
	 * */
	@Test
	void testDemoteAndSetCanonical() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
		assertFalse(tester.removeCanonical());
		
		tester.setCanonical(2);
		tester.add(4);
		tester.add(6);
		tester.add(8);
		assertTrue(tester.demoteAndSetCanonical(1));
		assertEquals(1, tester.canonical());
	}
	
	/**
	 * Tests toString() an both empty and non-empty LinkedEquivClass
	 * */
	@Test
	void testToString() 
	{
		LinkedEquivalenceClass<Integer> tester = createLEC();
		assertEquals("Class is empty", tester.toString());
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		
		assertEquals("Canonical: 1 Rest: 5 4 3 2", tester.toString());
	}
}
