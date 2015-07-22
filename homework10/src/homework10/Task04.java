package homework10;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task04 {
	private double[] array;

	public Task04() {
		array = new double[0];
	}

	public boolean empty() {
		return array.length == 0;
	}

	public Double add(double value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return value;
	}

	public boolean offer(double value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return true;
	}

	public Double remove() throws NoSuchElementException {
		if (array.length == 0)
			throw new NoSuchElementException();
		double value = array[0];
		array = Arrays.copyOfRange(array, 1, array.length);
		return value;
	}

	public Double poll() {
		if (array.length == 0)
			return null;
		double value = array[0];
		array = Arrays.copyOfRange(array, 1, array.length);
		return value;
	}

	public Double peek() {
		if (array.length == 0)
			return null;
		return array[0];
	}

	public Double element() throws NoSuchElementException {
		if (array.length == 0)
			throw new NoSuchElementException();
		return array[0];
	}

	public int search(double value) {
		for (int i = 0; i < array.length; i++) {
			if (Double.compare(array[i], value) == 0) {
				return i + 1;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		if (array.length == 0) {
			return "Queue is empty";
		}
		return Arrays.toString(array);
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		Task04 queue = new Task04();
		for (int i = 0; i < 10000; i++) {
			queue.add(i + 0.2);
		}
		while (!queue.empty()) {
			queue.poll();
		}
		System.out.println(System.currentTimeMillis() - start);

	}
}
