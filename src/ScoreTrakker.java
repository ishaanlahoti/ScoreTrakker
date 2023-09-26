import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	
	private static ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	public static void loadDataFile(String inputFile) throws FileNotFoundException {
		students = new ArrayList<Student>();
		FileReader file = null;
		Boolean fileFound = false;
		
		try {
			file = new FileReader(inputFile);
		}
		catch(FileNotFoundException f) {
			throw f;
		}
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNext()) {
			String name = scan.nextLine();
			String line = scan.nextLine();
			int score = 0;
			
			try {
				score = Integer.parseInt(line);
			}
			catch(NumberFormatException n) {
				System.out.println("Incorrect format for " + name + " not a valid score: " + line + "\n");
				continue;
			}
			
			Student student = new Student(name, score);
			students.add(student);
		}
		
	}
	
	public void printInOrder() {
		Collections.sort(students);
		System.out.println("Student Score List");
		for(Student s: students) {
			System.out.println(s);
		}
		System.out.println();
	}
	
	public void processFiles() {
		for(String s: files) {
			try {
				loadDataFile(s);
				printInOrder();
			} catch (FileNotFoundException f) {
				System.out.println("Can not open file: " + s);
			}

		}
	}

	public static void main(String[] args) {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}
}
