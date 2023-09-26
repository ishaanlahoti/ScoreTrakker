
public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student student) {
		return this.name.compareTo(student.name);
	}

	@Override
	public String toString() {
		return name + " " + score;
	}
	
	
}
