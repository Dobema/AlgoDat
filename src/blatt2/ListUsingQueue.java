package blatt2;

import blatt1.LinkedList;

public class ListUsingQueue<E> implements Queue<E> {


	private LinkedList<E> list = new LinkedList<>();

	ListUsingQueue(){
		
	}
	
	public int returnGetZugriff() {
		return list.returnGetZugriff();
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if(list.size() != 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public E first() {
		if(list.size()==0) {
			return null;
		}else {
		return list.get(0);
		}	
	}

	@Override
	public E enqueue(E element) {
		list.add(element);
		return list.get(list.size()-1);
	}

	@Override
	public E dequeue() {
		if(list.size()==0) {
			return null;
		}else {
		return list.remove(0);
	}
	}
	


}
