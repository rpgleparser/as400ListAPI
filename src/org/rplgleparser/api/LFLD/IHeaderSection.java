package org.rplgleparser.api.LFLD;

/**
 * Public interface of classes that implement the IBM QUSLFLD Header Section interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */
public interface IHeaderSection {
	public String getDateAndTimeFieldsIndicator();

	public String getFileLibraryNameUsed();

	public String getFileNameUsed();

	public String getFileType();

	public String getGraphicFieldsIndicator();

	public String getNullCapableFieldsIndicator();

	public String getRecordFormatID();

	public String getRecordFormatNameUsed();

	public Integer getRecordLength();

	public String getRecordTextDescription();

	public Integer getRecordTextDescriptionCCSID();

	public String getReservedHeaderSection();

	public String getVariableLengthFieldsInFormatIndicator();
}
