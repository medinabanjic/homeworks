package homework10;

public class Task03 {
	private Node start;
	private Node finish;

	public Task03() {
		start = null;
		finish = null;
	}
	
	public boolean empty() {
		return start == null;
	}

	public boolean add(Double value) {
		Node n = new Node(value);

		if (start == null) {
			start = n;
			finish = n;
		} else if (start == finish) {
			n.prev = start;
			finish = n;
			start.next = n;
		} else {
			finish.next = n;
			n.prev = finish;
			finish = n;
		}
		return true;
	}

	public Double poll() {
		try {
			Double tmp = start.value;
			start = start.next;
			start.prev = null;
			return tmp;
		} catch (NullPointerException ex) {
			return null;
		}
	}

	public Double peek() {
		if (start == null) {
			return null;
		}

		return start.value;
	}

	@Override
	public String toString() {
		if(start == null){
			return "queue is empty";
		}
		return start.toString();
	}
	
	private class Node {
		Double value;
		Node prev;
		Node next;

		public Node(Double value) {
			this.value = value;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Double getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			if (next == null) {
				return String.valueOf(value);
			}
			return value + ", " + next.toString();
		}
	}

public static void main(String[] args) {
	long start = System.currentTimeMillis();
	Task03 queue = new Task03();
	for (int i = 0; i < 10000; i++) {
		queue.add(i + 0.2);
	}
	while (!queue.empty()) {
		queue.poll();
	}
	System.out.println(System.currentTimeMillis() - start);
}
}
