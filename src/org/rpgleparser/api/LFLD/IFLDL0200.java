package org.rpgleparser.api.LFLD;

/**
 * Public interface of classes that implement the IBM QUSLFLD FLDL0200 interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */

public interface IFLDL0200 {
	/**
	 * @return the displacementToDefaultValue
	 */
	public Integer getDisplacementToDefaultValue();
	/**
	 * @return the lengthOfDefaultValue
	 */
	public Integer getLengthOfDefaultValue();

	/**
	 * @return the lengthOfFLDL0200Format
	 */
	public Integer getLengthOfFLDL0200Format();

}
