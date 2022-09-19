
package utilities;

import java.util.Comparator;

/**
 * A linked list of equivalent values according
 * to a specified canonical value.
 *
 * @author Tate Rosen & Miles Dame & Nick MaKuch
 * @date 09/14/2022
 */

public class LinkedEquivalenceClass<T>
{
	protected T _canonical;
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest;

	/**
	 * Create a new LinkedEquivalenceClass
	 * @param c - Comparator taken as argument
	 */
	public LinkedEquivalenceClass(Comparator<T> c)
	{
		_canonical = null;
		_comparator = c;
		_rest = new LinkedList<T>();
	}

	/**
	 * Retrieves and returns the canonical
	 * @return T (the canonical data)
	 */
	public T canonical()
	{
		return _canonical;
	}

	/**
	 * Checks to see if the LinkedEquivalenceClass is empty
	 * @return true or false;
	 */
	public boolean isEmpty()
	{	
		// if _rest and canonical are both empty the the LinkedEquivalenceClass is empty
		if (_rest.size() == 0 && _canonical == null) return true;
		return false;
	}

	/**
	 * Clears the LinkedEquivalenceClass by setting the 
	 * canonical to null and calling clear on _rest
	 */
	public void clear()
	{	
		_canonical = null;
		_rest.clear();
	}

	/**
	 * Removes all items except the canonical by clearing _rest
	 */
	public void clearNonCanonical()
	{
		_rest.clear();
	}
	
	/**
	 * Returns the size of the LinkedEquivalenceClass
	 * @return int 
	 */
	public int size() {	
		// Check to make sure _canonical has data before adding one to return the size
		if (_canonical != null) return _rest.size() + 1;
		else return _rest.size();
	}

	public boolean add(T element)
	{
		_rest.addToFront(element);
		return _rest.contains(element);
	}

	public boolean contains(T target)
	{
		return _rest.contains(target);
	}

	public boolean belongs(T target)
	{
		return(_comparator.compare(_canonical, target) == 0);
	}

	public boolean remove(T target)
	{
		return _rest.remove(target);
	}

	public boolean removeCanonical()
	{
		if (_canonical != null) {
		_canonical = _rest.pop();
		return true;
		}
		return false;

	}

	public boolean demoteAndSetCanonical(T element)
	{
		if (_canonical != null) {
		T data = _rest.pop();
		_rest.addToFront(_canonical);
		_canonical = data;
		return true;
		}
		return false;

	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("Canonical: " + _canonical + " Rest: ");
		str.append(_rest.toString());
		
		return str.toString();
		
	}

}
