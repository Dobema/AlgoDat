package blatt2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import blatt1.LinkedList;

class StackListTestTest {

	private Stack<Integer> stack;

	@BeforeEach
	public void setUpList() {
		stack = new LinkedStack<>();
	}
	
	
	//Test ob die Liste leer ist
	@Test
	public void isStackEmptyEmptyList() {
		assertEquals(true, stack.empty());
	}
	//Liste befüllen
	
	public void testPeekEmptyList() {
		assertEquals(null, stack.peek());
	}
	public void testPushEmptyList() {
		assertEquals(0, stack.push(0));
	}
	public void testPopEmptyList() {
		assertEquals(null, stack.pop());
	}

	
	@Test
	public void setUp() {
		
		for (int i=0; i<9; i++) {
			stack.push(i);
		}
	}
	
	public void isStackEmpty() {
		setUp();
		assertEquals(false, stack.empty());
	}
	@Test
	public void testPeek() {
		setUp();
		int element = stack.peek();
		assertEquals(8,element);
	}
	@Test
	public void testPush() {
		setUp();
		int element = stack.push(9);
		assertEquals(9,element);
		assertEquals(9,stack.peek());
	}
	@Test
	public void testPop() {
		setUp();
		int element = stack.pop();
		assertEquals(8,element);
		
	}
}
