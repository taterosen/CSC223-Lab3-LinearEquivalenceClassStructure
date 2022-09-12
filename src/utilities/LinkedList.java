package utilities;

/**
 * 
 * @author taterosen
 * @date 09/07/2022
 */

public class LinkedList<T> {
	
	Node _head;
	Node _tail;
	int _size;
	
	/**
	 * Node class
	 * */
	private class Node{
		private T _item;
		private Node _next;
		
		public Node(T item, Node next) {
			this._item = item;
			this._next = next;
		}
	}
	
	/**
	 * Constructor: initializes head & tail nodes and size
	 * */
	public LinkedList() {
		this._tail = new Node(null, null);
		this._head = new Node(null, _tail);
		this._size = 0;
	}
	
	/**
	 * checks if List  is empty
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
	 * getter for size
	 * @return int
	 * */
	public int size() {
		return this._size;
	}
	
	/**
	 * Adds Node with data "element" to front of list
	 * */
	public void addToFront(T element) {
		Node addedElement = new Node(element, _head._next);
		this._head._next = addedElement;
		_size++;
	}
	
	/**
	 * Checks if Node with data "target" is in the list
	 * @return boolean
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
	 * */
	public Node previous (T target) {
		if(!this.contains(target)) return null;
		return previous(target, this._head);
	}
	
	/**
	 * 
	 * */
	private Node previous (T target, Node current) { 
		if(current.equals(_tail)) return null;
		if(current._next._item.equals(target)) return current;
		return previous(target, current._next);
	}
	
	/**
	 * Removes Node containing data "target"
	 * @return boolean
	 * */
	public boolean remove (T target) {
		if(this.contains(target)) {
			// how to get one pointing to this
			_size--;
			return true;
		}
		return false;
	}
	
	/**
	 * getter for last Node in the list
	 * @return Node
	 * */
	public Node last() {
		Node current = _head._next;
		while(!current.equals(_tail)) {
			if (atEnd(current)) return current;
		}
		return _head;
	}
	
	/**
	 * Adds a node with data "element" to back of list
	 * */
	public void addToBack(T element) {
		Node addedElement = new Node(element, _tail);
		Node last = this.last();
		last._next = addedElement;
		_size++;
	}
	
	/**
	 * Converts list to a String
	 * @return String
	 * */
	public String toString () {
		return toStringHelper(new StringBuilder(), _head._next);
	}
	
	/**
	 * Helper method to convert list to a String
	 * @return String
	 * */
	private String toStringHelper(StringBuilder s, Node n) {
		if(atEnd(n)) return s.toString();
		s.append(n._item + " ");
		return toStringHelper(s, n._next);
	}
	
	/**
	 * checks to if Node n is the last in the list
	 * @return boolean
	 * */
	public boolean atEnd (Node n) {
		if (n._next.equals(_tail)) return true;
		return false;
	}
	
	/**
	 * 
	 * */
	public boolean nextToEnd(Node n) {
		if (n._next._next.equals(_tail)) return true;
		return false;
	}
	
	/**
	 * Reverses that list
	 * */
	public void reverse() {
		
		LinkedList<T> copyList = this;
		Node n = copyList.last();
		this.clear();
		this.reverse(copyList, n);
	}
	
	/**
	 * Helper method to reverse the list recursively 
	 * */
	private void reverse(LinkedList<T> list, Node n) {
		if(n.equals(_head)) return;
		this.addToBack(n._item);
		Node prev = list.previous(n._item);
		reverse(list, prev);
	}
	
}