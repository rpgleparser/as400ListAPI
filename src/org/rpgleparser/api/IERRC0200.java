package org.rpgleparser.api;

public interface IERRC0200 {
	public Object[] getERRC0200j();

	public Integer getKey();

	public Integer getBytesProvided();

	public Integer getBytesAvailable();

	public String getExceptionID();

	public String getReservedERRC0200();

	public Integer getCCSIDoftheCharData();

	public Integer getOffsetToTheExceptionData();

	public Integer getLengthOfExceptionData();

}
