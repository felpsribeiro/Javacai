package util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyArrayListInter<T>{
	
	class Node {
		T value;
		Node prev;
		Node next;
		
		public Node(T value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
	
	class MyIterator implements Iterator<T> {
		Node nodeAtual = null;

		@Override
		public boolean hasNext() {
			if(nodeAtual == null && head != null)
				return true;
			else if(nodeAtual != null) 
				return nodeAtual.next != null;
			
			return false;
		}

		@Override
		public T next() {
			if (nodeAtual == null && head != null) {
				nodeAtual = head;
				return nodeAtual.value;
			} else if (nodeAtual != null) {
				nodeAtual = nodeAtual.next;
				return nodeAtual.value;
			}

			throw new NoSuchElementException();
		}
	}
	
	Node head;
	Node tail;
	int size;
	
	public MyArrayList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	private Node searchByPosition(int index) {
		Node auxNode = head;
		
		if(index <= size) {
			
			for(int i = 0; i < index; ++i) {
				auxNode = auxNode.next;
			}
			return auxNode;
			
		} else {
			return null;
		}
	}
	
	private Node searchByValue(Object value) {
		Node auxNode = head;
		
		while(auxNode != null && auxNode.value != value) {
			auxNode = auxNode.next;
		}
		
		return auxNode;
	}

	@Override
	public boolean add(T value) {
		
		Node newValue = new Node(value);
		
		if(head == null && tail == null) {
			head = newValue;
			tail = newValue;
		} else {
			newValue.prev = tail;
			tail.next = newValue;
			tail = newValue;
		}
		++size;
		
		return true;
	}

	@Override
	public void add(int index, T value) {
		Node auxNode = searchByPosition(index);
		
		if(auxNode != null) {
			Node newValue = new Node(value);
			
			newValue.prev = auxNode;
			newValue.next = auxNode.next;
			auxNode.next = newValue;
			
			Node nextNode = newValue.next;
			
			if(nextNode != null) {
				nextNode.prev = newValue;
			} else {
				tail = newValue;
			}
			
			++size;
		}
	}

	@Override
	public boolean addAll(Collection col) {
		if(col != null) {	
			Iterator<? extends T> ite = col.iterator();
			
			while(ite.hasNext()) {
				if(!add(ite.next())) {
					return false;
				}
			}
			
			return true;
		} else 
			throw new NullPointerException();
		
		
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			Node auxNode = head;
			head = head.next;
			if(head != null)
				head.prev = null;
			auxNode.next = null;
			--size;
		}
		tail = null;
	}

	@Override
	public boolean contains(Object value) {
		return searchByValue(value) != null;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		if(searchByPosition(index) != null)
			return searchByPosition(index).value;
		else 
			return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator iterator() {
		return new MyIterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object value) {
		Node auxNode = searchByValue(value);
		
		if(auxNode != null) {
			if(auxNode.prev != null)
				auxNode.prev.next = auxNode.next;
			else 
				head = auxNode.next;
			
			if(auxNode.next != null)
				auxNode.next.prev = auxNode.prev;
			else 
				tail = auxNode.prev;
			
			auxNode.prev = null;
			auxNode.next = null;
			
			--size;
			
			return true;
		}
		return false;
	}

	@Override
	public T remove(int index) {
		Node auxNode = searchByPosition(index);
		
		if(auxNode != null) {
			if(auxNode.prev != null)
				auxNode.prev.next = auxNode.next;
			else 
				head = auxNode.next;
			
			if(auxNode.next != null)
				auxNode.next.prev = auxNode.prev;
			else 
				tail = auxNode.prev;
			
			auxNode.prev = null;
			auxNode.next = null;
			
			--size;
			
			return auxNode.value;
		}
		return null;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String str = "";
		
		for(int i = 0; i < size; ++i) {
			str += get(i).toString() + " ";
		}
		
		return str;
	}
}
