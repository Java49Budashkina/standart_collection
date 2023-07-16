package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.*;
import telran.interviews.*;

class ListTests {
Integer[] numbers = {10, -30, 13, 48, 22,17, 23};
List<Integer> immutableList = Arrays.asList(numbers);
List<Integer> mutableList;
	@BeforeEach
	void setUp() throws Exception {
		mutableList = new ArrayList<>(immutableList);
	}

	@Test
	void toArrayTest() {
		assertIterableEquals(mutableList, immutableList);
		assertArrayEquals(numbers, mutableList.toArray(Integer[]::new));
		assertArrayEquals(numbers, immutableList.toArray(Integer[]::new));
	}
	@Test
	void updateListsTest() {
		assertThrowsExactly(UnsupportedOperationException.class,
				() -> immutableList.remove(0));
		List<Integer> subList = mutableList.subList(2, 5);
		subList.clear();
		Integer[] expected1 = {10, -30, 17, 23};
		assertArrayEquals(expected1, mutableList.toArray(Integer[]::new));
		subList = mutableList.subList(2, 4);
		subList.set(1, 500);
		Integer[] expected2 = {10, -30, 17, 500};
		assertArrayEquals(expected2, mutableList.toArray(Integer[]::new));
		subList.add(0, -50);
		Integer[] expected3 = {10, -30, -50, 17, 500};
		assertArrayEquals(expected3, mutableList.toArray(Integer[]::new));
		Integer[] expected4 = {-50, 17, 500};
		Integer[] expected5 = {10, -30, -50, 17};
		subList.remove(2);
//		List<Integer> subList2 = mutableList.subList(0, 2);
//		subList.add(40);
//		//assertArrayEquals(expected5, mutableList.toArray(Integer[]::new));
//		System.out.println(subList2);
		
		
		
		
		
		
	}
	@Test
	void stackTest() {
		StackInt stack = new StackInt();
		assertThrowsExactly(NoSuchElementException.class, ()->stack.pop());
		assertThrowsExactly(NoSuchElementException.class, ()->stack.max());
		
		stack.push(10);
		stack.print();
		assertFalse(stack.isEmpty());
		assertEquals(10, stack.pop());
		assertTrue(stack.isEmpty());
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.print();
		assertEquals(12, stack.pop());
		
	}
	@Test
	void stackMaximumTest() {
		StackInt stack = new StackInt();
		stack.push(10);
		assertEquals(10, stack.max());
		stack.push(6);
		stack.push(2);
		assertEquals(10, stack.max());
		stack.push(12);
		stack.print();
		assertEquals(12, stack.max());
		stack.push(6);
		assertEquals(12, stack.max());
		stack.push(14);
		assertEquals(14, stack.max());
		stack.print();
		stack.pop();		
		stack.pop();
		stack.pop();	
		assertEquals(10, stack.max());
		stack.print();
		
	}
	
	@Test
	void queueTest() {
		Queue<Integer> queue = new LinkedList<>(); 
		assertThrowsExactly(NoSuchElementException.class, ()->queue.remove());
	}

}