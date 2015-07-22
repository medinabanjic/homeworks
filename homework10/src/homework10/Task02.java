package homework10;

import java.util.EmptyStackException;

public class Task02 {

	private Node head;
	private Node last;

	public Task02() {
		head = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public String push(String s) {
		Node newNode = new Node(s);
		if (head == null) {
			head = newNode;
			newNode.setPrevious(null);
			last = head;
		} else {
			last.setNext(newNode);
			newNode.setPrevious(last);
			last = newNode;
		}
		return s;
	}

	public String pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			last = last.getPrevious();
		}
		return last.getValue();
	}

	public String peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return last.getValue();
		}
	}

	public int search(String s) {
		int counter = 1;
		Node temp = last;
		while (true) {

			if (temp.getValue().equals(s)) {
				return counter;
			}
			counter++;
			if (temp.getPrevious().equals(null)) {
				return -1;
			}
			temp = temp.previous;
		}
	}

	public Node getLast() {
		Node temp = head;
		if (isEmpty()) {
			last = temp;
		} else {
			while (temp.getNext() != null) {
				last = head.getNext();
				temp = temp.getNext();
			}
		}
		return last;
	}

	private class Node {
		private Node next;
		private Node previous;
		private String value;

		public Node(String value) {
			super();
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Node getPrevious() {
			return previous;
		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Task02 ss2 = new Task02();
		ss2.push("Medina");
		ss2.push("Banjic");
		ss2.push("Davud");
		ss2.push("Zaid");
		// ss2.pop();
		System.out.println(ss2.peek());
		System.out.println(ss2.isEmpty());
		System.out.println(ss2.search("Medina"));
		System.out.println(System.currentTimeMillis() - start);
	}

}
