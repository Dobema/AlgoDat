package blatt2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListUsingQueueTest {
	
	private Queue<Integer> queue;

	@BeforeEach
	public void setUpList() {
		queue = new ListUsingQueue<>();
	}
	@Test
	
	//Prüfen ob die Liste leer ist
	
	public void isQueueEmpty() {
		boolean isQueueEmpty = queue.empty();
		assertEquals(true, isQueueEmpty);
	
	}
	@Test
	public void testFirstElementEmptyList() {

		assertEquals(null,queue.first());
	}
	@Test
	public void testDequeueEmptyList() {
		assertEquals(null, queue.dequeue());
	}
	
	public void setUp() {
		
		for (int i=0; i<9; i++) {
			queue.enqueue(i);
		}
	}
	@Test
	public void testFirstElement() {
		setUp();
		int item = queue.first();
		assertEquals(0,item);
	}
	@Test
	public void testEnqueue() {
		setUp();
		assertEquals(9,queue.enqueue(9));
	}
	@Test
	public void testDequeue() {
		setUp();
		assertEquals(0, queue.dequeue());
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
