package blatt1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListTests {
	private List<Integer> list;
	
	@BeforeEach
	public void beforeEach() {
		list = new LinkedList<>();
	}
	
	@Test
	public void testGetOnEmptyList() {	
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
	}
	
	@Test
	public void testGetOnFilledList() {
		list.add(17);
		assertEquals(17, (int)list.get(0));
	}
	
	@Test
	public void testGetPreIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));	
	}
	
	@Test
	public void testGetPostIndex() {
		list.add(17);
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
	}
	
	@Test
	public void testSizeEmptyList() {
		int size = list.size();
		assertEquals(0, size);
	}
	
	@Test
	public void testSizeFilledList() {
		list.add(1);
		list.add(2);
		list.add(3);
		int size = list.size();
		assertEquals(3, size);
	}
	
	@Test
	public void testAddReturnValue() {
		boolean addition = list.add(5);
		assertTrue(addition);
	}
	
	@Test
	public void testAddSizeIncreased() {
		assertEquals(0, list.size());
		list.add(5);
		assertEquals(1, list.size());
	}
	
	@Test
	public void testAddContainment() {
		list.add(5);
		assertEquals(5, (int)list.get(0));
	}
	
	@Test
	public void testAddCorrectOrder() {
		list.add(5);
		list.add(7);
		list.add(2);
		assertEquals(5, (int)list.get(0));
		assertEquals(7, (int)list.get(1));
		assertEquals(2, (int)list.get(2));
	}
	
}
