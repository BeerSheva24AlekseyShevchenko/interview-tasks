package telran.interview;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackInt {
	LinkedList<Integer> stack = new LinkedList<>();

	public void push(int num) {
		stack.push(num);
	}

	public int pop() {
		validateEmptyStack();
		return stack.pop();
	}

	public int peek() {
		validateEmptyStack();
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int getMaxElement() {
		validateEmptyStack();

		return -1;
	}

	private void validateEmptyStack() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
	}
}
