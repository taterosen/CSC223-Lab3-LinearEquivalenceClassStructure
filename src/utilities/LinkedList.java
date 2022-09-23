package utilities;

/**
 * A list of nodes including head and tail sentinels
 * 
 * @author taterosen & milesdame & nickmakuch
 * @date 09/07/2022
 */

public class LinkedList<T> {

	Node _head;
	Node _tail;
	int _size;

	/**
	 * A private class that creates a "Node"
	 * object that contains an item and a next, 
	 * which points to the next node in the list.
	 * */
	private class Node{
		private T _item;
		private Node _next;

		public Node(T item, Node next) {
			this._item = item;
			this._next = next;
		}
	}

	public LinkedList() {
		this._tail = new Node(null, null);
		this._head = new Node(null, _tail);
		this._size = 0;
	}

	/**
	 * checks if List is empty
	 * @return boolean
	 * */
	public boolean isEmpty() {
		return this._head._next == _tail;
	}

	/**
	 * Clears list
	 * */
	public void clear() {
		this._head._next = _tail;
		this._size = 0;
	}

	/**
	 * 
	 * @return number of nodes in the list
	 * */
	public int size() {
		return this._size;
	}

	/**
	 * Adds Node with given item to front of list
	 * */
	public void addToFront(T element) {
		Node addedElement = new Node(element, _head._next);
		this._head._next = addedElement;
		_size++;
	}

	/**
	 * 
	 * @param target - the piece of data we are looking for
	 * @return true if Node with given item is in the list,
	 * 			false otherwise
	 * */
	public boolean contains (T target) {
		Node n = _head._next;
		while(!n.equals(_tail)) {
			if (n._item.equals(target)) return true;
			n = n._next;
		}
		return false;
	}

	/**
	 * 
	 * @param target - the piece of data we are looking for
	 * @return the Node containing a given piece of data 
	 */
	public Node get(T target) {
		Node found = null;
		for (Node n = _head._next; n != _tail; n = n._next) {
			if (n._item.equals(target)) found = n;
		}
		return found;
	}

	/**
	 * @param target - the piece of data in the Node following 
	 * 					the Node we are looking for
	 * @return the before the Node containing a given piece of data 
	 * */
	public Node previous (T target) {
		if(!this.contains(target)) return null;
		return previous(target, this._head);
	}

	/**
	 * 
	 * */
	private Node previous (T target, Node current) { 
		if(current == _tail) return null;
		if(current._next._item.equals(target)) return current;
		return previous(target, current._next);
	}

	/**
	 *  
	 * @return true if Node containing data "target" is removed,
	 * 			false otherwise
	 * */
	public boolean remove (T target) {
		if(this.contains(target)) {
			this.previous(target)._next = 
					this.previous(target)._next._next;
			_size--;
			return true;
		}
		return false;
	}

	/**
	 *  
	 * @return the last Node in the list
	 * */
	private Node last() {
		Node current = _head._next;
		// Loop through the nodes until you find the last node
		while(current != _tail) {
			// Check to see if the current node is the last node
			if (atEnd(current)) return current;
			current = current._next;
		}
		return _head;
	}

	/**
	 * Adds a node with item "element" to back of list
	 * @param element - given object to be added
	 * */
	public void addToBack(T element) {
		Node addedElement = new Node(element, _tail);
		Node last = this.last();
		last._next = addedElement;
		_size++;
	}

	/**
	 *
	 * @return String representing the linked list
	 * */
	@Override 
	public String toString () {
		return toStringHelper(new StringBuilder(), _head._next);
	}

	/**
	 * Helper method to convert list to a String
	 * @return String
	 * */
	private String toStringHelper(StringBuilder s, Node n) {
		if(atEnd(n)) {
			s.append(n._item);
			return s.toString();
		}
		s.append(n._item + " ");
		return toStringHelper(s, n._next);
	}

	/**
	 * 
	 * @return true if Node n is the last in the list,
	 * 			false otherwise
	 * */
	public boolean atEnd (Node n) {
		if (n._next == _tail) return true;
		return false;
	}

	/**
	 * 
	 * @return true if Node n is next to last in the list,
	 * 			false otherwise
	 * */
	public boolean nextToEnd(Node n) {
		if (n._next._next == _tail) return true;
		return false;
	}

	/**
	 * Gets the first element in the LinkedList and returns it 
	 * @return data stored in node 
	 */
	public T peakFirst() {
		// Check if the list is empty
		if(this.isEmpty()) return null;
		
		return _head._next._item;
	}
	
	/**
	 * Gets the last element in the LinkedList and returns it 
	 * @return data stored in node 
	 */
	public T peakLast() {
		// Check if the list is empty
		if(this.isEmpty()) return null;
		
		Node n = this.last();
		return n._item;
	}
	
	/**
	 * Gets the first element in the LinkedList and returns and removes it 
	 * @return data stored in node 
	 */
	public T pop() {
		// Check if the list is empty
		if(this.isEmpty()) return null;
		
		// Get data from first node
		T data = _head._next._item;
		// Set head node's next to the node after the first node
		_head._next = _head._next._next;
		return data;
	}
	
	
	public void reverse() {
		Node newLast = reverse(_head._next);
		newLast._next = _tail;
	}
	
	private Node reverse (Node n) {
		if (n._next == _tail) {
			_head._next = n;
			return n;
		}
		Node node = reverse(n._next);
		node._next = n;
		return n;
	}

}