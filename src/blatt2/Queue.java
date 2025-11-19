package blatt2;

public interface Queue<E> {
	boolean empty();
	E first();
	E enqueue(E element);
	E dequeue();
}
