import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private static ArrayList<Student> students = new ArrayList<Student>();
	
	public static void loadDataFile(String inputFile) {
		FileReader file = null;
		Boolean fileFound = false;
		
		try {
			file = new FileReader(inputFile);
		}
		catch(FileNotFoundException f) {
			System.out.println("Can not open file: " + inputFile);
		}
		Scanner scan = new Scanner(file);
		while(scan.hasNext()) {
			String name = scan.nextLine();
			int score = Integer.parseInt(scan.nextLine());
			Student student = new Student(name, score);
			students.add(student);
		}
		
	}
	
	public void printInOrder() {
		Collections.sort(students);
		for(Student s: students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		loadDataFile("scores.txt");
		printInOrder();
	}

	public static void main(String[] args) {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}

}
