
/**
 * The Class ModuleMark, which represents the exam and coursework marks received for a module.
 * 
 * @author Wilfrid Askins
 */
public class ModuleMark {
	
	/** The module the marks were received in. */
	private Module module;
	
	/** The examination mark received by the student. */
	private int examinationMark;
	
	/** The coursework mark received by the student. */
	private int courseworkMark;
	
	/**
	 * Instantiates a new module mark.
	 *
	 * @param module the module the marks were received in
	 * @param examMark the exam mark received by the student
	 * @param courseworkMark the coursework mark received by the student
	 */
	public ModuleMark(Module module, int examMark, int courseworkMark){
		super();
		this.module = module;
		this.examinationMark = examMark;
		this.courseworkMark = courseworkMark;
	}

	/**
	 * Gets the module the marks were received in.
	 *
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * Gets the exam mark received by the student.
	 *
	 * @return the exam mark
	 */
	public int getExamMark() {
		return examinationMark;
	}
	
	/**
	 * Gets the computed module mark received by the student.
	 *
	 * @return the computed module mark
	 */
	public int getComputedModuleMark(){
		// Uses the formula contained in the Module class to find the computed mark
		return this.module.getComputedModuleMark(courseworkMark, examinationMark);
	}
	
	/**
	 * Considers the computed mark the student has received, then returns the result which should be received.
	 *
	 * @return the result
	 */
	public ModuleResult getResult(){
		
		// Uses the provided formula to get the computed mark
		int computedMark = this.getComputedModuleMark();
		
		if(computedMark >= 40){
			// If the student passed this module
			return ModuleResult.PASS;
		}else if (!this.module.isCore() && computedMark >= 35){
			// If the student achieved a compensatable fail
			return ModuleResult.COMPENSATABLE_FAIL;
		}else{
			// If the student failed
			return ModuleResult.FAIL;
		}
		
	}

	/**
	 * Gets the coursework mark received by the student.
	 *
	 * @return the coursework mark
	 */
	public int getCourseworkMark() {
		return courseworkMark;
	}
}
