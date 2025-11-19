package blatt2;

import blatt1.LinkedList;

	public class ListUsingStack<E> implements Stack<E> {

	private LinkedList<E> list = new LinkedList<>();
	
	
	ListUsingStack(){
		
		
	}
	public int successorZugriffe() {
		return list.returnGetZugriff();
	}
	
	@Override
	public boolean empty() {
		if(list.size() == 0) {
			return true;
			
		}
		else {
			return false;
		}
	}

	@Override
	public E peek() {
		return list.get(list.size()-1);
	}

	@Override
	public E push(E item) {
		
		if(list.add(item)) {
			return item;
		}
		else {
			return null;
		}
	}

	@Override
	public E pop() {
		return list.remove(list.size()-1);
	}
	
}
