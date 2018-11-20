
/**
 * The Enum ModuleResult. This needs it's own file because leaving it inside ModuleMark would stop it importing Colour from the default package.
 * 
 * Learnt from lectures and https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 * 
 * @author Wilfrid Askins
 */
public enum ModuleResult{

	/** If a ModuleResult is undefined. This should never happen unless an error occurs. */
	UNDEFINED(Colour.BLACK),
	/** When a student has passed the module. */
	PASS(Colour.GREEN), 
	/** When a student has been given a compensatable fail. */
	COMPENSATABLE_FAIL(Colour.YELLOW), 
	/** When a student has been given a fail. */
	FAIL(Colour.RED);

	/** The colour which should be used in this result's bar in bar chart. */
	private Colour colour;

	/**
	 * Instantiates a new module result.
	 *
	 * @param colour the colour of this result's bar in the bar chart
	 */
	private ModuleResult(Colour colour){
		this.colour = colour;
	}

	/**
	 * Gets the colour of this result for the bar chart.
	 *
	 * @return the colour
	 */
	public Colour getColour(){
		return this.colour;
	}
}
