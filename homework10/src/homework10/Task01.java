package homework10;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Task01 {
	private String[] array;

	public Task01() {
		super();
		array = new String[0];
	}

	public boolean isEmpty() {
		return (array.length == 0);
	}

	public String push(String s) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = s;
		return s;
	}

	public String pop() throws EmptyStackException {
		if (array.length <= 0) {
			throw new EmptyStackException();
		} else {
			String temp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);
			return temp;
		}
	}

	public String peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return array[array.length - 1];
		}
	}

	public int search(String s) {
		int counter = 1;
		for (int i = array.length - 1; i >= 0; i--) {

			if (array[i].equals(s)) {
				return counter;
			}
			counter++;
		}
		return -1;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Task01 ss = new Task01();
		ss.push("Medina");
		ss.push("Banjic");
		ss.push("Davud");
		ss.push("Zaid");
		// ss.pop();
		System.out.println(ss.peek());
		System.out.println(ss.isEmpty());
		System.out.println(ss.search("Medina"));
		System.out.println(System.currentTimeMillis() - start);
	}
}
