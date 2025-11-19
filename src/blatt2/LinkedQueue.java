package blatt2;

public class LinkedQueue<E> implements Queue<E> {
	private class Node {
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
	int anzahlSuccessorZugriff;
	LinkedQueue(){
		Node newNode = new Node(null);
		firstNode = newNode;
		lastNode = newNode;
		numberOfElements = 0;
		
	}

	@Override
	public boolean empty() {
		if(numberOfElements == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int returnGetZugriff() {
		return anzahlSuccessorZugriff;
	}

	@Override
	public E first() {
		if(numberOfElements == 0) {
			return null;
		}else {
		anzahlSuccessorZugriff++;
		return firstNode.successor.element;
		}
		
	}

	@Override
	public E enqueue(E element) {
		Node addedNode = new Node(element);
		lastNode.successor = addedNode;
		lastNode = addedNode;
		numberOfElements++;
		return lastNode.element;
	}

	@Override
	public E dequeue() {
		
		if(numberOfElements==0) {
			return null;
		}else {
		
		Node thisNode = firstNode.successor;
		firstNode.successor = thisNode.successor;
		numberOfElements--;
		return thisNode.element;
		}
	}
	
	
}
