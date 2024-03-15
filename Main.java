public class Main {
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		// addTask(int id, String description, Date date, Boolean completed, Priority
		// priority)
		tdl.addTask(12, "example 1", new Date(1, 4, 2029), false, Priority.HIGH);
		tdl.addTask(7, "example 2", new Date(2, 1, 2024), false, Priority.MEDIUM);
		tdl.addTask(42, "example 3", new Date(3, 4, 2000), false, Priority.LOW);

		System.out.println("PRINT ALL TASKS");
		tdl.printAllTasks();
		System.out.println();

		tdl.removeTask(2);

		System.out.println("PRINT ALL TASKS");
		tdl.printAllTasks();
		System.out.println();

		System.out.println("PRINT ALL TASKS");
		tdl.printAllTasks();
		System.out.println();
		tdl.removeTask(2);
		System.out.println("PRINT ALL TASKS");
		tdl.printAllTasks();
		System.out.println();

	}
}