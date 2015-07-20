package ba.bitcamp.homework08.task01;

import java.util.NoSuchElementException;

public class LinkedListDouble {
	private Node start;
	private int size;

	public LinkedListDouble() {
		start = null;
		size = 0;
	}

	public LinkedListDouble(LinkedListDouble d) {
		for (int i = 0; i < d.size + 1; i++) {
			add(d.get(i).value);
		}
	}

	public void add(Double d) {
		Node newNode = new Node(d);
		if (start == null) {
			start = newNode;
			return;
		} else {
			Node last = getLast();
			last.setNext(newNode);
			last = newNode;
		}
		size++;
	}

	public Node get(int index) {
		if (size - 1 < index) {
			return null;
		}
		Node temp = start;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	private Node getLast() {
		if (start == null) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;
	}

	private Node getFirst() {
		return start;
	}

	private void deleteFirst() {
		if (start.getNext() != null) {
			start = start.getNext();
		} else {
			start = null;
		}
	}

	private void deleteLast() {
		if (start != null) {
			remove(size() - 1);
		}
	}

	private void setLast(Node node) {
		Node last = node;
	}

	public int size() {
		return size;
	}

	public void remove(int index) {
		if (index == 0) {
			start = start.getNext();
		} else {
			Node node = get(index);

			Node previous = start;
			while (previous.getNext() != node) {
				previous = previous.getNext();
			}

			previous.setNext(node.getNext());
		}
		size--;
	}

	// Odgovor na pitanje je da, moguce je.
	// Samo jednom proci kroz listu mislim da je nemoguce.

	public Node getMiddle() {
		if (start != null) {
			int index = (size() - 1) / 2;
			return get(index);
		} else {
			return null;
		}
	}

	public void add(Double d, int index) throws ArrayIndexOutOfBoundsException {
		if (size() + 1 >= index) {
			Node newNode = new Node(d);
			Node previous = start;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.getNext();
			}
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	private class Node {
		private Node next;
		private Double value;

		public Node(Double value) {
			this.value = value;
			this.next = null;
		}

		public void setNext(Node node) {
			this.next = node;
		}

		public Node getNext() {
			return next;
		}

		@Override
		public String toString() {

			if (next == null) {
				return value.toString();
			}
			return value.toString() + ", " + next.toString();
		}
	}

	public static void main(String[] args) {
		LinkedListDouble lld = new LinkedListDouble();
		lld.add(2.3);
		lld.add(4.3);
		lld.add(1.2, 0);
		// System.out.println(lld.get(2));
		// System.out.println(lld.size());
		// System.out.println(lld.getMiddle());
		// lld.remove(1);
		System.out.println(lld.toString());
	}

}
