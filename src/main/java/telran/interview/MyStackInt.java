package telran.interview;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackInt {
	LinkedList<Integer> stack = new LinkedList<>();
	LinkedList<Integer> stackMax = new LinkedList<>();

	public void push(int num) {
		stack.push(num);

		Integer prevMax = stackMax.peek();
		stackMax.push(prevMax == null || prevMax <= num ? num : prevMax);
	}

	public int pop() {
		validateEmptyStack();
		stackMax.pop();
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

		return stackMax.peek();
	}

	private void validateEmptyStack() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
	}
}
