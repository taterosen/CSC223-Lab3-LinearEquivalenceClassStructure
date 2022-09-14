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
	 * 
	 * */
	public boolean add(T element) 
	{
		
	}
	
	/**
	 * 
	 * */
	public boolean contains(T target) 
	{
		
	}
	
	/**
	 * Returns total number of elements across all Equiv classes in _rest
	 * @return int 
	 * */
	public int size() 
	{
		int size = 0;
		for(int i = 0; i < numClasses(); i++) 
		{
			size += _rest.get(i).size();
		}
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
	 * 
	 * */
	protected int indexOfClass(T element) 
	{
		
	}
	
	/**
	 * 
	 * */
	public String toString() 
	{
		
	}
}
