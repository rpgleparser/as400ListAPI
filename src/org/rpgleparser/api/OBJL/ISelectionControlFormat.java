package org.rpgleparser.api.OBJL;

/**
 * Use this interface when working with the Selection Control Format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface ISelectionControlFormat {
	/**
	 * @return the lengthOfSelectionControlFormat
	 */
	public Integer getLengthOfSelectionControlFormat();
	/**
	 * @return the selectOrOmitStatusValuez
	 */
	public Integer getSelectOrOmitStatusValue();
	/**
	 * @return the displacementToStatuses
	 */
	public Integer getDisplacementToStatuses();
	/**
	 * @return the numberOfStatusesz
	 */
	public Integer getNumberOfStatuses();
	/**
	 * @return the reservedSelectionControlFormat
	 */
	public Integer getReservedSelectionControlFormat();
}
