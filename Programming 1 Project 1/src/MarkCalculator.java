
/**
 * The Class MarkCalculator, which calculates the overall marks and stage result of modules, when given their exam and coursework marks.
 * 
 * @author Wilfrid Askins
 */
public class MarkCalculator{
	
	/**
	 * Instantiates a new mark calculator.
	 */
	public MarkCalculator(){
		super();
	}
	
	/**
	 * Returns the overall marks of each module, when given an array of marks.
	 *
	 * @param marks the marks recorded in each module
	 * @return the int[] of overall marks for each module
	 */
	public int[] computeMarks(ModuleMark[] marks){
		
		// Creates a new array to store the computed marks
		int[] returnedMarks = new int[marks.length];
		
		for(int i = 0; i <= marks.length-1; i++){
			// The ModuleMark class will get the computed mark from the Module class
			returnedMarks[i] = marks[i].getComputedModuleMark();
		}
		
		return returnedMarks;
	}
	
	/**
	 * Computes the stage result for a student, given their marks.
	 *
	 * @param marks the marks the student has achieved.
	 * @return the stage result the student should be given.
	 */
	public StageResult computeResult(ModuleMark[] marks){
		
		// These variables are all needed to decide whether the student deserves a pass, fail or compensatable fail
		boolean containsFail = false; // True if one or more modules were failed
		boolean allPass = true; // True if every module was passed
		int sumOfStageMarks = 0; // A sum of all computed marks
		int compFailNumber = 0; // Number of modules with compensatable fails
		int compFailCredits = 0; // The sum of credits the compensatable fail modules are worth
		
		for(ModuleMark mark : marks){
			
			sumOfStageMarks += mark.getComputedModuleMark();
			
			if(mark.getResult() != ModuleResult.PASS){
				// This student hasn't achieved all passes
				allPass = false;
			}
			
			if(mark.getResult() == ModuleResult.FAIL){
				// This student has a module they have failed
				containsFail = true;
			}else if(mark.getResult() == ModuleResult.COMPENSATABLE_FAIL){
				// If this module is a compensatable fail
				compFailNumber++;
				compFailCredits += mark.getModule().getCredits();
			}
			
		}
		
		// The average mark number the student has got for all modules in this stage
		int stageAverage = sumOfStageMarks / marks.length;
		
		if(allPass){
			// If all the modules were passes
			return StageResult.PASS;
		}else if(stageAverage >= 40 && !containsFail && compFailNumber <= 2 && compFailCredits <= 40){
			// If the student fits the criteria of a pass by compensation
			return StageResult.PASS_BY_COMPENSATION;
		}else{
			// If the student has failed
			return StageResult.FAIL;
		}
	}
	
	/**
	 * The Enum StageResult, which is used to represent what a student has been given.
	 */
	public enum StageResult{
				
		/** Incase of an error. */
		UNDEFINED("Undefined"), 
		/** If the student passed. */
		PASS("Pass"), 
		/** If the student passed by compensation. */
		PASS_BY_COMPENSATION("Pass by compensation"), 
		/** If the student failed. */
		FAIL("Fail");
		
		/** The name of the result */
		private String name;
		
		private StageResult(String name){
			this.name = name;
		}
		
		/**
		 * 
		 * Gets the name of the result
		 * 
		 * @return the result's name
		 */
		public String getName(){
			return this.name;
		}
	}

}
