import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public void loadDataFile(String inputFile) {
		FileReader file = null;
		Boolean fileFound = false;
		
		while(!fileFound) {
			try {
				file = new FileReader(inputFile);
			}
			catch(FileNotFoundException f) {
				System.out.println(f.getMessage());
				continue;
			}
			break;
		}
		Scanner scan = new Scanner(file);
		
	}
	
	public void printInOrder() {
		
	}

}
