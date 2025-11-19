package blatt1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
	public class Node {
		E element;
		Node successor;

		Node(E element) {
			this.element = element;
			this.successor = null;
		}
		
		
	}

	Node firstNode;
	Node lastNode;
	int numberOfElements;
	int zugriffSuccessor;
	int zugriffSuccessorIterator;
	
	public LinkedList() {
		Node newNode = new Node(null);
		firstNode = newNode;
		lastNode = newNode;
		numberOfElements = 0;
		zugriffSuccessor = 0;
		zugriffSuccessorIterator = 0;
		
	}
	
	
	public int returnGetZugriff() {
		return zugriffSuccessor;
		
	}
	
	public int returnZugriffIterator() {
		return zugriffSuccessorIterator;
	}
	

	@Override
	public boolean add(E element) {
		Node addedNode = new Node(element);
		lastNode.successor = addedNode;
		lastNode = addedNode;
		numberOfElements++;
		return true;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= numberOfElements) {
			throw new IndexOutOfBoundsException();
		}
		Node nodeAtCurrentIndex = firstNode.successor;
		for (int currentIndex = 0; currentIndex < index; currentIndex++) {
			nodeAtCurrentIndex = nodeAtCurrentIndex.successor;	
			zugriffSuccessor++;
		}
		
		return nodeAtCurrentIndex.element;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	public E remove(int index) {
		
		if (index < 0 || index >= numberOfElements) {
			throw new IndexOutOfBoundsException();
		}
		
		Node nodeBeforeCurrentIndex = firstNode;
		Node nodeAtCurrentIndex = firstNode.successor;
		
		
		for (int currentIndex = 0; currentIndex < index; currentIndex++) {
			
			nodeBeforeCurrentIndex = nodeAtCurrentIndex;
			nodeAtCurrentIndex = nodeAtCurrentIndex.successor;
			
		}
		nodeBeforeCurrentIndex.successor = nodeAtCurrentIndex.successor;
		numberOfElements--;
		return nodeAtCurrentIndex.element;
		
				
	}
	
	public boolean remove(Object o) {

		
		if(indexOf(o) == -1) {
			return false;
		}
		else {
			remove(indexOf(o));
			return true;
		}				
	}
	
	public int indexOf(Object o) {
		int index = numberOfElements-1;
		
		Node nodeAtCurrentIndex = firstNode.successor;
		
		if(o.equals(firstNode.successor.element)) {
			return 0;
		}
		for (int currentIndex = 0; currentIndex < index; currentIndex++) {
			nodeAtCurrentIndex = nodeAtCurrentIndex.successor;
			if(o.equals(nodeAtCurrentIndex.element)) {
				return currentIndex+1;
			}
		}
		return -1;
			
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node nextNode = firstNode.successor;
			Node currentNode;

			@Override
			public boolean hasNext() {
				return nextNode != null;
			}

			@Override
			public E next() {
				if (nextNode == null) {
					throw new NoSuchElementException();
				}
				currentNode = nextNode;
				zugriffSuccessorIterator++;
				nextNode = nextNode.successor;
				return currentNode.element;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
