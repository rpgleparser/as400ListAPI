package org.rplgleparser.api.LRCD;

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
