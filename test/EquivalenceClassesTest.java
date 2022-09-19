

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

	@Test 
	void testEquivalenceClasses() {


	}

	@Test 
	void testAdd() {

	}

	@Test 
	void testContains() {

	}

	@Test 
	void testSize() {

	}

	@Test 
	void testNumClasses() {

	}

	@Test 
	void testIndexOfClass() {

	}

	@Test 
	void testToString() {

	}
}
