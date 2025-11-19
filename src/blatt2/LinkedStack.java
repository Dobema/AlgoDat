package blatt2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
	private class Node {
		E element;
		Node successor;
		
		Node(E element) {
			this.element = element;
			this.successor = null;
		}
	}
	Node firstNode;
	Node beforeLastNode;
	Node lastNode;
	int anzahlSuccessor;
	int numberOfElements;

	LinkedStack(){
		Node emptyElement = new Node(null);
		firstNode = emptyElement;
		lastNode = emptyElement;
		beforeLastNode = null;
		numberOfElements = 0;
		anzahlSuccessor = 0;
	}
	
	@Override
	public boolean empty() {
		if(numberOfElements != 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public E peek() {
		anzahlSuccessor++;
		return lastNode.element;
	}

	@Override
	public E push(E item) {
		// TODO Auto-generated method stub
		Node addedNode = new Node(item);
		Node thisNode = lastNode;
		lastNode = addedNode;
		lastNode.successor = thisNode;
		numberOfElements++;
		return lastNode.element;
	}

	
	@Override
	public E pop() {
		if(numberOfElements == 0) {
			return null;
		}
		Node returnNode = lastNode;
		lastNode = lastNode.successor;
		numberOfElements--;
		return returnNode.element;
	}
	
	
	
	

}
