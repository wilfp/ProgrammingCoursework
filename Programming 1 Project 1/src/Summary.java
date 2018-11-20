import java.util.Scanner;

/**
 * The Class Summary, which is used to input data about a student's marks and produce a summary in the form of a table and a bar chart.
 * 
 * @author Wilfrid Askins
 */
public class Summary {
	
	/**
	 * Instantiates a new summary class.
	 */
	public Summary(){
		super();
	}
	
	/**
	 * The main method, to be run at startup.
	 *
	 * @param args the arguments, unused by this program
	 */
	public static void main(String[] args){
		
		// Creates a new instance of the summary class and runs the studentSummary method
		Summary summary = new Summary();
		summary.studentSummary();
	}
	
	/**
	 * Takes user input and processes it, then prints a table and draws a bar chart to summarise the data.
	 */
	public void studentSummary(){
		
		// The array of all modules
		Module[] modules = ModuleList.getModules();
		// The array which will store all the student's marks
		ModuleMark[] markArray = new ModuleMark[modules.length];
		
		// The scanner which will be used to get input data from
		Scanner sc = new Scanner(System.in);
		
		// Iterates through all the modules
		for(int i = 0; i <= modules.length-1; i++){
			
			// The current module being processed
			Module module = modules[i];
			
			// An exam mark will only be asked for if the module has an exam
			int examMark = module.getHasExam() ? input(sc, module.getCode() + " Exam Mark") : 0;
			
			// All modules have coursework, so a coursework mark is always asked for
			int courseworkMark = input(sc, module.getCode() + " Coursework Mark");
			
			// Adds a new instance of the ModuleMark class to the markArray, containing the exam and coursework marks
			markArray[i] = new ModuleMark(module, examMark, courseworkMark);
		}
		
		// Closes the scanner to prevent memory leaks
		sc.close();
		
		// Creates and draws a new chart using the marks which were just entered
		StudentChart chart = new StudentChart(markArray);
		chart.draw();
		// Prints a table of all the marks
		chart.printSummary();
	}
	
	/**
	 * Takes user input by continuing recursively until valid data is entered
	 *
	 * @param sc the scanner instance that should be used
	 * @param fieldName the field name to be entered by the user
	 * @return the valid integer which was entered by the user
	 */
	private int input(Scanner sc, String fieldName){
		
		// Prints out a message to the user to tell them which mark is expected
		System.out.println("Please enter " + fieldName + ": ");
		
		// Gets the next token entered by the user
		String next = sc.next();
		
		if(isInteger(next)){
			// If the user entered valid data, parses the text as an integer
			int value = Integer.parseInt(next);
			
			// If the integer fits the required range
			if(value >= 0 && value <= 100){
				return value;
			}else{
				// If the integer is too small or too big, displays an error and asks again
				System.out.println("Integers must be in the range 0-100!");
				return input(sc, fieldName);
			}
			
		}else{
			// If the data is invalid, displays an error and asks again
			System.out.println("Invalid integer entered!");
			return input(sc, fieldName);
		}
	}
	
	/**
	 * Checks if a string is an integer, by using a regex expression.
	 * This expression will check if the text is either one, two or three digits between zero and nine, with or without a plus sign at the beginning.
	 *
	 * @param text the string to be checked
	 * @return true, if the text is an integer
	 */
	private boolean isInteger(String text){
		// Learnt from https://www.regular-expressions.info/tutorial.html
		return text.matches("^(\\+)?[0-9][0-9]?[0-9]?$");
	}
} 
