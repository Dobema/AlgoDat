package blatt1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

	static final int MAX_SIZE = 32;
	int size;
	E[] elementArray;
	int zugriffIterator;
	int zugriffElement;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		size = 0;
		elementArray = (E[]) new Object[MAX_SIZE];
		zugriffIterator = 0;
		zugriffElement = 0;
	}
	
	boolean remove(Object o) {
		
		return false;
	}
	
	int indexOf(Object o) {
		
		return -1;
	}
	
	E remove(int index) {
		E element = elementArray[index];
		if(index < 0 || index  > size) {
			
			return null;
		}
		else {
		
			for (int i = index; i < elementArray.length - 1; i++) {
				elementArray[i] = elementArray[i + 1];
			
			}
			return element;
		}
		
		
	}

	@Override
	public boolean add(E element) {
		if (size < MAX_SIZE) {
			elementArray[size] = element;
			size++;
			return true;
		} else {
			return false;
		}
	}
	
	public int returnZugriffIterator() {
		return zugriffIterator;
		
	}
	
	public int returnGetZugriff() {
		return zugriffElement;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		zugriffElement = index;
		return elementArray[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int nextIndex = 0;
			int currentIndex;

			@Override
			public boolean hasNext() {
				return nextIndex < size;
			}

			@Override
			public E next() {
				if (nextIndex == size) {
					throw new NoSuchElementException();
				}
				currentIndex = nextIndex;
				if (nextIndex < size) {
					nextIndex++;
					zugriffIterator++;
				}
				return elementArray[currentIndex];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
