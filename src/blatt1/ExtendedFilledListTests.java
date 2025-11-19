package blatt1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ExtendedFilledListTests {

	private List<Integer> list;

	@BeforeEach
	public void setUp() {
		list = new LinkedList<>();
		for (int i=0; i<9; i++) {
			list.add(i);
		}
	}
	
	@Test
	public void testIndexOfElementExists() {
		int index = list.indexOf(3);
		assertEquals(3, index);
	}
	
	@Test
	public void testIndexOfNonExistingElement() {
		int index = list.indexOf(9);
		assertEquals(-1, index);
	}
	
	@Test
	@Disabled
	public void testIndexOfNull() {
		list.add(null);
		list.add(10);
		assertEquals(9, (int)list.indexOf(null));
	}
	
	@Test
	public void testRemoveFirstIndex() {
		int removedElement = list.remove(0);
		assertEquals(0, removedElement);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(1), list.get(0));
	}
	
	@Test
	public void testRemoveLastIndex() {
		int removedElement = list.remove(8);
		assertEquals(8, removedElement);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(7), list.get(7));
	}
	
	@Test
	public void testRemoveMiddleIndex() {
		int removedElement = list.remove(4);
		assertEquals(4, removedElement);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(8), list.get(7));
	}
	
	@Test
	public void testRemoveFirstElement() {
		boolean removed = list.remove(Integer.valueOf(0));
		assertTrue(removed);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(1), list.get(0));
	}
	
	@Test
	public void testRemoveLastElement() {
		boolean removed = list.remove(Integer.valueOf(8));
		assertTrue(removed);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(7), list.get(7));
	}
	
	@Test
	public void testRemoveMiddleElement() {
		boolean removed = list.remove(Integer.valueOf(4));
		assertTrue(removed);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(8), list.get(7));
	}
	
	@Test
	public void testRemovePreIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
	}
	
	@Test
	public void testRemovePostIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(9));
	}
	
	@Test 
	public void testRemoveUncontainedElement() {
		boolean removed = list.remove(Integer.valueOf(9));
		assertFalse(removed);
		assertEquals(9, list.size());
	}
	
}
