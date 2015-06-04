package org.rplgleparser.api.LFLD;

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
