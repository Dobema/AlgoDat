package blatt1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExtendedEmptyListTests {
	
	private List<Integer> list;

	@BeforeEach
	public void setUp() {
		list = new LinkedList<>();
	}

	@Test
	public void testIndexOfNonExistingElement() {
		int index = list.indexOf(1);
		assertEquals(-1, index);
	}
	
	@Test
	public void testRemoveElement() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
	}
	
	@Test
	public void testRemovePreIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
	}
	
	@Test 
	public void testRemovePostIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
	}
	
	@Test 
	public void testRemoveUncontainedElementReturnValue() {
		boolean removed = list.remove(Integer.valueOf(9));
		assertFalse(removed);
	}
	
	@Test 
	public void testRemoveUncontainedElementListSize() {
		list.remove(Integer.valueOf(9));
		assertEquals(0, list.size());
	}
	
	@Test
	public void testAddAndRemove() {
		list.add(1);
		list.remove(0);
		assertEquals(0, list.size());
	}

}
