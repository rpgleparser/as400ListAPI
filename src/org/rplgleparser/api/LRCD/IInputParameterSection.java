package org.rplgleparser.api.LRCD;

/**
 * Use this interface when working with the userspace input parameter section of the QUSLRCD API
 * @author Eric N. Wilson
 *
 */
public interface IInputParameterSection {
	/**
	 * @return the userSpaceName
	 */
	public String getUserSpaceName();
	/**
	 * @return the userSpaceLibraryName
	 */
	public String getUserSpaceLibraryName();
	/**
	 * @return the formatNameSpecified
	 */
	public String getFormatNameSpecified();
	/**
	 * @return the fileNameSpecified
	 */
	public String getFileNameSpecified();
	/**
	 * @return the fileLibraryNameSpecified
	 */
	public String getFileLibraryNameSpecified();
	/**
	 * @return the overrideProcessingSpecified
	 */
	public String getOverrideProcessingSpecified();

}
