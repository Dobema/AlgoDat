package blatt1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteratorTests {
	private List<Integer> list;
	
	@BeforeEach
	public void beforeEach() {
		list = new LinkedList<>();
	}
	
	@Test
	public void testHasNextEmptyList() {
		Iterator<Integer> iterator = list.iterator();
		boolean hasNext = iterator.hasNext();
		assertFalse(hasNext);
	}
	
	@Test
	public void testHasNextFilledList() {
		list.add(0);
		Iterator<Integer> iterator = list.iterator();
		boolean hasNext = iterator.hasNext();
		assertTrue(hasNext);
	}

	@Test
	public void testNext() {
		list.add(0);
		Iterator<Integer> iterator = list.iterator();
		int next = iterator.next();
		assertEquals(0, next);
	}
	
	@Test
	public void testNextOnEmptyList() {
		Iterator<Integer> iterator = list.iterator();
		assertThrows(NoSuchElementException.class, () -> iterator.next());
	}
	
	@Test
	public void testNextOnLastElement() {
		list.add(0);
		Iterator<Integer> iterator = list.iterator();
		iterator.next();
		assertThrows(NoSuchElementException.class, () -> iterator.next());
	}
}
