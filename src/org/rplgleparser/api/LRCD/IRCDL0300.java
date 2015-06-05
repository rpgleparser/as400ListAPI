package org.rplgleparser.api.LRCD;

/**
 * Public interface of classes that implement the IBM QUSLRCD RCDL0300 interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */
public interface IRCDL0300 extends IRCDL0100, RCDLoutputFormat {
	/**
	 * @return the bufferSize
	 */
	public Integer getBufferSize();
	/**
	 * @return the lowestResponseIndicator
	 */
	public String getLowestResponseIndicator();
	/**
	 * @return the recordFormatType
	 */
	public String getRecordFormatType();
	/**
	 * @return the separateIndicatorAreaPresent
	 */
	public String getSeparateIndicatorAreaPresent();	
	/**
	 * @return the startingLineNumber
	 */
	public String getStartingLineNumber();
}
