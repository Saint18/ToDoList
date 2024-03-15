import java.time.LocalDate;

public class Task {

	int id;
	String description;
	Date date;
	Boolean completed;
	Priority priority;

	public Task(int id, String description, Date date, Boolean completed, Priority priority) {
		this.id = id;
		this.description = description;
		this.date = date;
		this.completed = completed;
		this.priority = priority;

	}

	public void printTask() {

		System.out.println("Task ID:" + this.id);
		System.out.println("Task Description:" + this.description);
		System.out.println("Task Date:" + this.date);
		System.out.println("Task Completion:" + this.completed);
		System.out.println("Task Priiority Level:" + this.priority);

	}

	public int getId() {
		return id;
	}

	public void setId(int newValue) {
		this.id = newValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newValue) {
		this.description = newValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date newValue) {
		this.date = newValue;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean newValue) {
		this.completed = newValue;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority newValue) {
		this.priority = newValue;
	}

	public Boolean expired() {
		if (LocalDate.now().getYear() < this.date.getYear()) {
			return false;
		}
		if (LocalDate.now().getMonthValue() < this.date.getMonth()) {
			return false;
		}
		if (LocalDate.now().getDayOfMonth() < this.date.getDay()) {
			return false;
		}
		return true;
	}

}
