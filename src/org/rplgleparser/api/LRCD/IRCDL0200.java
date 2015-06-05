package org.rplgleparser.api.LRCD;

/**
 * Public interface of classes that implement the IBM QUSLRCD RCDL0200 interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */

public interface IRCDL0200 extends RCDLoutputFormat {
	/**
	 * @return the recordTextDescriptionCCSID
	 */
	public Integer getRecordTextDescriptionCCSID();
	/**
	 * @return the reservedRCDL01002
	 */
	public String getReservedRCDL01002();
	/**
	 * @return the recordTextDescription
	 */
	public String getRecordTextDescription();
	/**
	 * @return the numberOfFields
	 */
	public Integer getNumberOfFields();
	/**
	 * @return the recordLength
	 */
	public Integer getRecordLength();
	/**
	 * @return the reservedRCDL01001
	 */
	public String getReservedRCDL01001();
	/**
	 * @return the recordFormatID
	 */
	public String getRecordFormatID();

}
