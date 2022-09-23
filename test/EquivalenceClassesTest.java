

import org.junit.jupiter.api.Test;

import utilities.LinkedList;
import utilities.EquivalenceClasses;
import utilities.LinkedEquivalenceClass;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class EquivalenceClassesTest 
{
	public EquivalenceClasses<Integer> createEC() {
		Comparator<Integer> c = new Comparator<Integer>()
		{
			public int compare(Integer x, Integer y)
			{ return x % 5 == y % 5 ? 0 : 1; }
		};
		return new EquivalenceClasses<Integer>(c);
	}

	public EquivalenceClasses<String> createECString() {
		Comparator<String> c = new Comparator<String>()
		{
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		return new EquivalenceClasses<String>(c);
	}

	/**
	 * Tests constructor of EquivalenceClasses
	 * */
	@Test 
	void testEquivalenceClasses() 
	{
		EquivalenceClasses<Integer> tester = createEC();
		assertTrue(tester instanceof EquivalenceClasses<?>);
		assertEquals(0, tester.size());
		assertEquals(0, tester.numClasses());
	}

	/**
	 * Tests add() method
	 * */
	@Test 
	void testAdd() 
	{
		EquivalenceClasses<Integer> tester = createEC();
		tester.add(0);
		assertTrue(tester.contains(0));
		assertEquals(1, tester.size());
		assertEquals(1, tester.numClasses());


		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		tester.add(5);
		tester.add(-11);
		tester.add(-222);
		assertEquals(8, tester.size());
		assertEquals(7, tester.numClasses());
		assertTrue(tester.contains(3));

		tester.add(1000);
		tester.add(-11);
		tester.add(-5);
		tester.add(333);
		tester.add(0);
		tester.add(-2);
		assertEquals(14, tester.size());
		assertEquals(7, tester.numClasses());
	}

	/**
	 * Tests contains() by filling a EquivClasses and checking if it contains
	 * certain test values
	 * */
	@Test 
	void testContains() 
	{
		EquivalenceClasses<Integer> tester = createEC();
		tester.add(0);
		assertTrue(tester.contains(0));	

		tester.add(-3);
		assertTrue(tester.contains(-3));

		tester.add(3);
		assertTrue(tester.contains(3));
		
		tester.add(100);
		assertTrue(tester.contains(100));

		EquivalenceClasses<String> stringTester = createECString();
		stringTester.add("abc");
		assertTrue(stringTester.contains("abc"));	

		stringTester.add("");
		assertTrue(stringTester.contains(""));

		stringTester.add(null);
		assertTrue(stringTester.contains(null));
	}

	/**
	 * Tests size() by filling a EquivClasses and checking its size
	 * */
	@Test 
	void testSize() 
	{
		EquivalenceClasses<Integer> tester = createEC();
		assertEquals(0, tester.size());

		tester.add(1);
		assertEquals(1, tester.size());

		tester.add(2);
		tester.add(2);
		tester.add(3003);
		tester.add(10000);
		assertEquals(5, tester.size());
	}

	/**
	 * Tests numClasses() by filling a EquivClasses and
	 * checking how many classes it contains
	 * */
	@Test 
	void testNumClasses() 
	{
		EquivalenceClasses<Integer> tester = createEC();
		assertEquals(0, tester.numClasses());

		tester.add(1);
		assertEquals(1, tester.numClasses());

		//repeated 2 and 10000 do not create new classes
		tester.add(2);
		tester.add(2);
		tester.add(3003);
		tester.add(30);
		tester.add(10000);
		tester.add(-2);
		assertEquals(5, tester.numClasses());
	}

	/**
	 * Tests toString()
	 * */
	@Test 
	void testToString() 
	{
		EquivalenceClasses<Integer> tester = createEC();
		assertEquals("", tester.toString());
		
		tester.add(1);
		tester.add(11);
		assertEquals("Canonical: 1 Rest: 11", tester.toString());
	}
}
