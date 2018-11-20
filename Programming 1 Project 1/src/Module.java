
/**
 * The Class Module, which is used to represent the modules being taken by the student.
 * 
 * @author Wilfrid Askins
 */
public class Module {
	
	/** The module's code. */
	private String code;
	
	/** The name of the module. */
	private String name;
	
	/** This module's coursework weighting. */
	private int courseworkWeighting;
	
	/** The credits the module is worth. */
	private int credits;
	
	/** Whether the module is core. */
	private boolean core;
	
	/** Whether the module has an exam. */
	private boolean hasExam;
	
	/**
	 * Instantiates a new module.
	 *
	 * @param code the module's code
	 * @param name the name of the module
	 * @param courseworkWeighting the weighting of the coursework
	 * @param credits the credits the module is worth
	 */
	public Module(String code, String name, int courseworkWeighting, int credits) {
		this(code, name, courseworkWeighting, credits, false);
	}
	
	/**
	 * Instantiates a new module. Used to specify whether the module is core or not.
	 *
	 * @param code the module's code
	 * @param name the name of the module
	 * @param courseworkWeighting the weighting of the coursework
	 * @param credits the credits the module is worth
	 * @param core whether the module is core or not
	 */
	public Module(String code, String name, int courseworkWeighting, int credits, boolean core) {
		super();
		this.code = code;
		this.name = name;
		this.courseworkWeighting = courseworkWeighting;
		this.credits = credits;
		this.core = core;
		
		// If the coursework is worth less than 100, there is also an exam for this module
		this.hasExam = courseworkWeighting < 100;
	}
	
	/**
	 * Gets the computed module mark, using the formula provided for the task and the specified conditions.
	 *
	 * @param courseworkMark the coursework mark
	 * @param examinationMark the examination mark
	 * @return the computed module mark
	 */
	public int getComputedModuleMark(int courseworkMark, int examinationMark){
		
		// Finds the result of the formula
		int computedMark = ((courseworkMark * this.courseworkWeighting) + (examinationMark * (100 - this.courseworkWeighting))) / 100;
		
		// If either the exam (if there was an exam) or coursework mark is less than 35
		boolean lessThanBoundary = (this.getHasExam() && examinationMark < 35) || (courseworkMark < 35);
		
		// Return the minimum of 35 and the computed mark, if either the exam or coursework mark was less than the boundary. Otherwise return the computed mark.
		return lessThanBoundary? Math.min(35, computedMark) : computedMark;		
	}
	
	/**
	 * Gets the code of the module.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Gets the name of the module.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the coursework weighting of the module.
	 *
	 * @return the coursework weighting
	 */
	public int getCourseworkWeighting() {
		return courseworkWeighting;
	}
	
	/**
	 * Gets the credits the module is worth.
	 *
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * Checks if the module is core.
	 *
	 * @return true, if the module is core
	 */
	public boolean isCore(){
		return core;
	}
	
	/**
	 * Checks if the module has an exam.
	 *
	 * @return true, if the module has an exam
	 */
	public boolean getHasExam(){
		return hasExam;
	}
}
