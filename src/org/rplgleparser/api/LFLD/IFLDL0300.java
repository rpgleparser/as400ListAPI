package org.rplgleparser.api.LFLD;

/**
 * Public interface of classes that implement the IBM QUSLFLD FLDL0300 interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */
public interface IFLDL0300 {
	/**
	 * @return the displacementToAllFieldsDefinedByFLD0100Format
	 */
	public Integer getDisplacementToAllFieldsDefinedByFLD0100Format();

	/**
	 * @return the displacementToAlternativeFieldName
	 */
	public Integer getDisplacementToAlternativeFieldName();

	/**
	 * @return the displacementToDefaultValue
	 */
	public Integer getDisplacementToDefaultValue();

	/**
	 * @return the lengthOfDefaultValue
	 */
	public Integer getLengthOfDefaultValue();

	/**
	 * @return the lengthOfFLD0300Format
	 */
	public Integer getLengthOfFLD0300Format();

}
