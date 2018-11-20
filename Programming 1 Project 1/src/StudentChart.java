
/**
 * The Class StudentChart, which is used to generate a bar chart using a student's marks.
 * 
 * @author Wilfrid Askins
 */
public class StudentChart {
	
	/** The marks the student has received. */
	private ModuleMark[] marks;
	
	/** The MarkCalculator object, needed to calculate the student's marks */
	private MarkCalculator markCalculator;
	
	/** The Constant BAR_WIDTH, which defines the width of the bars. */
	private static final int BAR_WIDTH = 5, 
	/** The Constant BAR_PADDING, which defines the size of the space between the bars. */
	BAR_PADDING = 30, 
	/** The Constant CANVAS_SIZE, which matches the canvas size used by the shapes class. */
	CANVAS_SIZE = 300,
	/** The Constant AXES_PADDING, which defines how far the axes are from the edge of the canvas. */
	AXES_PADDING = 20;
	
	/**
	 * Instantiates a new student chart.
	 *
	 * @param marks the marks to be put onto the chart
	 */
	public StudentChart(ModuleMark[] marks){
		super();
		this.marks = marks;
		this.markCalculator = new MarkCalculator();
	}
	
	/**
	 * Draws the chart.
	 */
	public void draw(){
		
		// Gets the array of integers returned by the method in the mark calculator
		int[] calculatedMarks = this.markCalculator.computeMarks(marks);
		
		// Iterates through all the marks that were given
		for(int i = 0; i <= calculatedMarks.length-1; i++){
			
			// The current module being processed
			ModuleMark mark = marks[i];
			
			// The result the student achieved in this module
			ModuleResult result = mark.getResult();
			
			// Gets the mark achieved in the module
			int moduleMark = calculatedMarks[i];
			
			// The height which the bar needs
			int barHeight = moduleMark*2;
			
			// Draws the bar for the current result, at the needed position
			// The position of the new bars will move from the left to right as they are drawn
			drawRectangle(result.getColour(), AXES_PADDING+(BAR_PADDING*2)+(i-1)*(BAR_WIDTH+BAR_PADDING), CANVAS_SIZE-AXES_PADDING-barHeight, BAR_WIDTH, barHeight);
		}
		
		// Draws the x and y-axis lines based off of the constants CANVAS_SIZE and AXES_PADDING
		drawRectangle(Colour.BLACK, AXES_PADDING, CANVAS_SIZE-AXES_PADDING, CANVAS_SIZE-AXES_PADDING*2, 5);
		drawRectangle(Colour.BLACK, AXES_PADDING, AXES_PADDING, 5, CANVAS_SIZE-AXES_PADDING*2);
	}

	/**
	 * 
	 * Creates a rectangle at the specified position. This method is intended to make it easier to use the bar class for drawing.
	 * 
	 * @param colour the colour of the rectangle
	 * @param posX the x position of the rectangle
	 * @param posY the y position of the rectangle
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 */
	private void drawRectangle(Colour colour, int posX, int posY, int width, int height){
		
		// Creates the bar which will be shown
		Bar bar = new Bar();
		
		// Makes the bar visible
		bar.makeVisible();
		
		// Makes the bar the correct width and height
		bar.changeSize(width, height);
		
		// Makes the bar the correct colour
		bar.changeColour(colour);
		
		// Sets the bar to the correct position
		// Also uses the positions set when the bar is first created 
		bar.moveHorizontal(posX-60);
		bar.moveVertical(posY-50);
	}
	
	/**
	 * Prints the summary of the student's marks.
	 */
	public void printSummary(){
		
		// The parts about printing a formatted table were learnt from lectures and from
		// https://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java
		
		// This prints a single empty line to stop users from typing in the output console and messing up the formatting of the table
		System.out.println();
		
		// The format in which the output should be printed in, with a larger column width for the larger fields
		String tableFormat = "%-16s%-45s%-18s%-18s%-18s\n";
		
		// The headers for the table
		String[] headers = new String[]{ "Module Code", "Module Name", "Exam mark", "Coursework mark", "Overall mark" };
		
		// Prints the table's headers
		System.out.format(tableFormat, (Object[])headers);
		
		// Iterates through all the marks that were entered
		for(ModuleMark mark : this.marks){
			
			// The module this mark is in
			Module module = mark.getModule();
			
			// Makes an array of all the module's information for the next row to be printed
			String[] moduleRow = new String[]{ 
					module.getCode(),
					module.getName(),
					// Converts the integer values of the marks to strings
					Integer.toString(mark.getExamMark()),
					Integer.toString(mark.getCourseworkMark()),
					Integer.toString(mark.getComputedModuleMark()) 
				};
			
			// Prints the row
			System.out.format(tableFormat, (Object[])moduleRow);
		}
		
		// Gets the result calculated by the mark calculator
		MarkCalculator.StageResult result = this.markCalculator.computeResult(marks);
		
		// Prints a space between the table and overall result
		System.out.println();
		
		// Prints the result
		System.out.println("Overall Result: " + result.getName());
	}
}
