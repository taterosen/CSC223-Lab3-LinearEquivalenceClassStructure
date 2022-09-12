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
	
	public boolean isEmpty() {
		return this._head._next == _tail;
	}
	
	public void clear() {
		this._head._next = _tail;
		this._size = 0;
	}
	
	public int size() {
		return this._size;
	}
	
	public void addToFront(T element) {
		Node addedElement = new Node(element, _head._next);
		this._head._next = addedElement;
		_size++;
	}
	
	public boolean contains (T target) {
		Node n = _head._next;
		while(!n.equals(_tail)) {
			if (n._item.equals(target)) return true;
			n = n._next;
		}
		return false;
	}
	
	public Node previous (T target) {
		if(!this.contains(target)) return null;
		return previous(target, this._head);
	}
	
	private Node previous (T target, Node current) { 
		if(current.equals(_tail)) return null;
		if(current._next._item.equals(target)) return current;
		return previous(target, current._next);
	}
	
	public boolean remove (T target) {
		if(this.contains(target)) {
			// how to get one pointing to this
			_size--;
			return true;
		}
		return false;
	}
	
	public Node last() {
		Node current = _head._next;
		while(!current.equals(_tail)) {
			if (atEnd(current)) return current;
		}
		return _head;
	}
	
	public void addToBack(T element) {
		Node addedElement = new Node(element, _tail);
		Node last = this.last();
		last._next = addedElement;
		_size++;
	}
	
	public String toString () {
		return toStringHelper(new StringBuilder(), _head._next);
	}
	
	private String toStringHelper(StringBuilder s, Node n) {
		if(atEnd(n)) return s.toString();
		s.append(n._item + " ");
		return toStringHelper(s, n._next);
	}
	
	public boolean atEnd (Node n) {
		if (n._next.equals(_tail)) return true;
		return false;
	}
	
	public boolean nextToEnd(Node n) {
		if (n._next._next.equals(_tail)) return true;
		return false;
	}
	
	public void reverse() {
		
		LinkedList<T> copyList = this;
		Node n = copyList.last();
		this.clear();
		this.reverse(copyList, n);
	}
	
	private void reverse(LinkedList<T> list, Node n) {
		if(n.equals(_head)) return;
		this.addToBack(n._item);
		Node prev = list.previous(n._item);
		reverse(list, prev);
	}
	
}
