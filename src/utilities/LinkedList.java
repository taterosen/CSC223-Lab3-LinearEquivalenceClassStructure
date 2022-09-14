package utilities;

/**
 * A list of nodes including head and tail sentinels
 * that each contain an item and a next, which points
 * to the next node in the list.
 * 
 * @author taterosen & milesdame & nickmakuch
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
	 * Finds and returns the node containing a given piece of data 
	 * @param target - the piece of data we are looking for
	 * @return Node
	 */
	public Node get(T target) {
		// Create node variable to return
		Node found = null;
		// Loop through the list until you find the node with the data equal to target
		for (Node n = _head._next; n != _tail; n = n._next) {
			// When you find the data set the found variable equal to that node
			if (n._item.equals(target)) found = n;
		}
		return found;
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
		if(current == _tail) return null;
		if(current._next._item.equals(target)) return current;
		return previous(target, current._next);
	}
	/**
	 * A helper method to assist with deleting a node. 
	 * Takes the node before the node to be deleted and points its _next at the node
	 * after the one to be deleted
	 * @param previous - node before the one to be deleted
	 * @param next - node after the one to be deleted
	 */
	private void deleteNode(Node previous, Node next) {
		// See the next value of the previous node to point to the next value of the node being deleted
		previous._next = next;
	}
	
	/**
	 * Removes Node containing data "target"
	 * @return boolean
	 * */
	public boolean remove (T target) {
		if(this.contains(target)) {
			// Find the target node and delete it
			this.deleteNode(this.previous(target), this.get(target));
			// Adjust the size of the list to reflect the removal.
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
		// Loop through the nodes until you find the last node
		while(current != _tail) {
			// Check to see if the current node is the last node
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
	 * checks to see if Node n is the last in the list
	 * @return boolean
	 * */
	public boolean atEnd (Node n) {
		if (n._next == _tail) return true;
		return false;
	}
	
	/**
	 * 
	 * */
	public boolean nextToEnd(Node n) {
		if (n._next._next == _tail) return true;
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
		if(n == _head) return;
		this.addToBack(n._item);
		Node prev = list.previous(n._item);
		reverse(list, prev);
	}
	
}