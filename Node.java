public class Node {
	private Node next;
	private Task task;

	// constructor
	public Node() {

	}

	public Node(Task task) {
		this.task = task;
	}

	// getters
	public Node getNext() {
		return next;
	}

	public Task getTask() {
		return task;
	}
	// setters

	public void setNext(Node n) {
		this.next = n;
	}

	public void setTask(Task t) {
		this.task = t;
	}
}