package utilities;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;

/**
 * An array list that stores many linked 
 * equivalence classes.
 * 
 * @author taterosen & milesdame & nickmakuch
 * @date 09/14/2022
 */

public class EquivalenceClasses<T>
{
	/**
	 * Instance vars and Constructor for EquivalencyClasses
	 * */
	protected Comparator<T> _comparator;
	protected List<LinkedEquivalenceClass<T>> _rest;
	
	public EquivalenceClasses(Comparator<T> c) 
	{
		this._comparator = c;
		this._rest = new ArrayList<>();
	}
	
	/**
	 * Adds element to the Equiv. class within _rest in which it belongs and returns true if added
	 * If element doesn't fit with any of the equiv. classes, a new class is added
	 * @return boolean
	 * */
	public boolean add(T element) 
	{
		for(int i = 0; i < numClasses(); i++) 
		{
			if(_rest.get(i).belongs(element)) {
				return _rest.get(i).add(element);
			}
		}
		LinkedEquivalenceClass<T> lec = new LinkedEquivalenceClass<T>(_comparator);
		if (!lec.add(element)) return false;
		return _rest.add(lec);
	}
	
	/**
	 * Checks if target is in any of the Equiv. classes in _rest
	 * @return boolean
	 * */
	public boolean contains(T target) 
	{
		for(int i = 0; i < numClasses(); i++) 
			if(_rest.get(i).contains(target))
				return true;
		
		return false;
	}
	
	/**
	 * Returns total number of elements across all Equiv classes in _rest
	 * @return int 
	 * */
	public int size() 
	{
		int size = 0;
		for(int i = 0; i < numClasses(); i++) 
			size += _rest.get(i).size();
		
		return size;
	}
	
	/**
	 * returns number of Equiv. classes in _rest
	 * @return int
	 * */
	public int numClasses() 
	{
		return _rest.size();
	}
	
	/**
	 * Returns the index of the class in _rest containing element
	 * If element is not in _rest return -1
	 * @return int
	 * */
	protected int indexOfClass(T element) 
	{
		for(int i = 0; i < numClasses(); i++) 
			if(_rest.get(i).contains(element))
				return i;
		
		return -1;
	}
	
	/**
	 * Returns String version of _rest
	 * @return String
	 * */
	public String toString() 
	{
		String restString = "";
		for(int i = 0; i < numClasses(); i++) 
			restString += _rest.get(i).toString() + "\n";
		
		return restString;
	}
}
