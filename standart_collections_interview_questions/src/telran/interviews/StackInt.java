package telran.interviews;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 
 * All methods have to have the Complexity O[1]
 *
 */
public class StackInt {
 
	private LinkedList<Integer> stack;
	private LinkedList<Integer> maximus;
	
//TODO fields
	/**
	 * 
	 * @param num
	 * adds num in the stack
	 */
	public  StackInt() {
		stack = new LinkedList<>();
		maximus = new LinkedList<>();
	}
	
	public void push(int num) {
		
		stack.addLast(num);
		if (maximus.isEmpty() ||  maximus.getFirst() < num)
			maximus.addFirst(num);
	}
	/**
	 * 
	 * @return
	 * takes out and returns the top stack number
	 * in the case the stack is empty the exception of the class NoSuchElement should be thrown
	 */
	public int pop() {
		
		if(stack.isEmpty())
			throw new NoSuchElementException("Stack is empty");
	 	Integer res = stack.removeLast();
	 	if (res == maximus.getFirst())
	 		maximus.removeFirst();
	 	
		return res;
	}
	/**
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	/**
	 * 
	 * @return maximal value existing in the stack
	 * throws NoSuchElementException in the case the stack is empty
	 */
	public int max() {
		if(stack.isEmpty())
			throw new NoSuchElementException("Stack is empty");
		return maximus.getFirst();
	}
	
	public void print() {
		stack.stream().forEach(it ->System.out.printf("%d ",it));
		System.out.println();
		System.out.print("max ");
		maximus.stream().forEach(it ->System.out.printf("%d ",it));
		System.out.println();
	}
}