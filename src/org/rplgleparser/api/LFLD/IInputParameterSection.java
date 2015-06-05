package org.rplgleparser.api.LFLD;

/**
 * Public interface of classes that implement the IBM QUSLFLD Input Parameter Section interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */
public interface IInputParameterSection {
	public String getUserSpaceNameSpecified();

	public String getUserSpaceLibraryName();

	public String getFormatNameSpecified();

	public String getFileNameSpecified();

	public String getFileLibraryNameSpecified();

	public String getRecordFormatNameSpecified();

	public String getOverrideProcessingSpecified();

}
