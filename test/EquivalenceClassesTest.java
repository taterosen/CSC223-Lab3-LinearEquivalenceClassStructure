

import org.junit.jupiter.api.Test;

import utilities.LinkedList;
import utilities.EquivalenceClasses;
import utilities.LinkedEquivalenceClass;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class EquivalenceClassesTest 
{
	public EquivalenceClasses createEC() {
		Comparator<Integer> c = new Comparator<Integer>()
		{
			// All even integers are 'equivalent'
			// All odd integers are 'equivalent'
			public int compare(Integer x, Integer y)
			{ return x % 2 == y % 2 ? 0 : 1; }
		};
		return new EquivalenceClasses(c);
	}

	/**
	 * Tests constructor of EquivalenceClasses
	 * */
	@Test 
	void testEquivalenceClasses() 
	{
		EquivalenceClasses<Integer> tester = createEC();
		assertTrue(tester instanceof EquivalenceClasses<?>);
	}

	/**
	 * Tests add()
	 * */
	@Test 
	void testAdd() 
	{
		EquivalenceClasses<Integer> tester = createEC();
	}

	/**
	 * Tests contains() by filling a EquivClasses and checking if it contains
	 * certain test values
	 * */
	@Test 
	void testContains() 
	{
		EquivalenceClasses<Integer> tester = createEC();
	}

	/**
	 * Tests size() by filling a EquivClasses and checking its size
	 * */
	@Test 
	void testSize() 
	{
		EquivalenceClasses<Integer> tester = createEC();
	}

	/**
	 * Tests numClasse() by filling a EquivClasses and
	 * checking how many classes it contains
	 * */
	@Test 
	void testNumClasses() 
	{
		EquivalenceClasses<Integer> tester = createEC();
	}

	/**
	 * Tests indexOfClass() by filling a EquivClasses
	 * and checking for if it contains test values and what class 
	 * they are in
	 * */
	@Test 
	void testIndexOfClass() 
	{
		EquivalenceClasses<Integer> tester = createEC();
	}

	/**
	 * 
	 * */
	@Test 
	void testToString() 
	{
		EquivalenceClasses<Integer> tester = createEC();
	}
}
