/**
* Write a succinct, meaningful description of the class here. You should avoid wordiness
* and redundancy. If necessary, additional paragraphs should be preceded by <p>,
* the html tag for a new paragraph.
*
* <p>Bugs: (a list of bugs and / or other problems)
*
* @author Miles Dame
* @date September 23, 2022
* */

package utilities;

import java.util.Comparator;

/**
 * A linked list of equivalent values according
 * to a specified canonical value.
 *
 * @author taterosen & milesdame & nickmakuch
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
	 * @return
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
		if (_rest.size() == 0 && _canonical == null) return true;
		return false;
	}

	/**
	 * Clears the LinkedEquivalenceClass
	 */
	public void clear()
	{
		_canonical = null;
		_rest.clear();
	}


	public void clearNonCanonical()
	{
		_rest.clear();
	}

	public int size()
	{
		return _rest.size() + 1;
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

	}

}
