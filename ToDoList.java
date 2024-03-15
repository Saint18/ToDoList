
public class ToDoList {
	private Node first;

	// constructor
	public ToDoList() {
		this.first = null;

	}

	// add a task
	private void addNodeToEnd(Node list, Node nodeToAdd) {
		if (list.getNext() == null) {
			list.setNext(nodeToAdd);
		} else {
			addNodeToEnd(list.getNext(), nodeToAdd);
		}
	}

	public void addTask(int id, String description, Date date, Boolean completed, Priority priority) {
		Task newTask = new Task(id, description, date, completed, priority);
		Node newNode = new Node(newTask);

		if (first == null) {
			first = newNode;
		} else {
			addNodeToEnd(first, newNode);
		}
	}

	// remove
	public void removeTask(Node prev, Node curr, int id) {
		if (curr == null) {
			return;
		} else if (curr.getTask().getId() == id) {
			if (prev == null) {
				first = first.getNext();
			} else {
				prev.setNext(curr.getNext());
			}
			return;
		}

		removeTask(curr, curr.getNext(), id);
	}

	// remove
	public void removeTask(int id) {
		removeTask(null, first, id);
	}

	// count all
	public int countCompletedTasks() {
	     return this.countCompletedTasks(first, 0); // calling recursive helper
	  	 
	    }


	public int countCompletedTasks(Node node, int completedTasks) {

	      if(node == null){
	        return completedTasks;
	      }
	  
	      if(node.getTask().getCompleted()){
	        ++completedTasks;
	      }
	  
	      return countCompletedTasks(node.getNext(), completedTasks);
	                                 
	}
	    



	public int countExpiredTasks() {
	     return this.countExpiredTasks(first, 0); // calling recursive helper
	  	 
	    }


	public int countExpiredTasks(Node node, int expiredTasks) {

	      if(node == null){
	        return expiredTasks;
	      }
	  
	      if(node.getTask().expired()){
	        ++expiredTasks;
	      }
	  
	      return countExpiredTasks(node.getNext(), expiredTasks);
	                                
	}

	// count all
	public int countAllTasks() {
	     return this.countAllTasks(first, 0); // calling recursive helper
	  	 
	    }


	public int countAllTasks(Node node, int allTasks) {

	      if(node == null){
	        return allTasks;
	      }
	  
	     ++allTasks;
	      
	  
	      return countAllTasks(node.getNext(), allTasks);
	                                
	}
	// change date
	public void changeDate(Node currNode, int id, Date newDate) {
		if (currNode != null) {
			if (currNode.getTask().getId() == id) {
				currNode.getTask().setDate(newDate);
				return;
			}
			changeDate(currNode.getNext(), id, newDate);

		}
	}

	public void removeAll() {
		this.first = null;
	}

	// remove all, expired, completed

	public void removeExpired() {
		Node currNode = this.first;
		Node prevNode = null;
		while (currNode != null) {
			if (currNode.getTask().expired() == true) {
				prevNode.setNext(currNode.getNext());
				currNode = currNode.getNext();
			} else {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
	}

	public void removeCompleted() {
		Node currNode = this.first;
		Node prevNode = null;
		while (currNode != null) {
			if (currNode.getTask().getCompleted() == true) {
				prevNode.setNext(currNode.getNext());
				currNode = currNode.getNext();
			} else {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
	}

	public void printAllTasks() {
		printAllTasks(first);
	}

	public void printAllTasks(Node currNode) {
		if (currNode != null) {
			System.out.println("ID: " + currNode.getTask().getId());
			System.out.println("Description: " + currNode.getTask().getDescription());
			System.out.println("Date: " + currNode.getTask().getDate());
			System.out.println("Completed: " + currNode.getTask().getCompleted());
			System.out.println("Priority: " + currNode.getTask().getPriority());
			System.out.println("---------------------");

			printAllTasks(currNode.getNext());
		}
	}

	public void printPriorityTasks(Priority priority) {
		printPriorityTasks(first, priority);
	}

	public void printPriorityTasks(Node currNode, Priority priority) {
		if (currNode != null) {
			if (currNode.getTask().getPriority() == priority) {
				System.out.println("ID: " + currNode.getTask().getId());
				System.out.println("Description: " + currNode.getTask().getDescription());
				System.out.println("Date: " + currNode.getTask().getDate());
				System.out.println("Completed: " + currNode.getTask().getCompleted());
				System.out.println("Priority: " + currNode.getTask().getPriority());
				System.out.println("---------------------");
			}
			printPriorityTasks(currNode.getNext(), priority);

		}

	}

	public void printExpiredTasks() {
		printExpiredTasks(first);
	}

	public void printExpiredTasks(Node currNode) {
		if (currNode != null) {
			if (currNode.getTask().expired() == true) {
				System.out.println("ID: " + currNode.getTask().getId());
				System.out.println("Description: " + currNode.getTask().getDescription());
				System.out.println("Date: " + currNode.getTask().getDate());
				System.out.println("Completed: " + currNode.getTask().getCompleted());
				System.out.println("Priority: " + currNode.getTask().getPriority());
				System.out.println("---------------------");
			}
			printExpiredTasks(currNode.getNext());

		}

	}

}
