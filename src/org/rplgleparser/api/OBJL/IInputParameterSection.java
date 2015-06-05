package org.rplgleparser.api.OBJL;

/**
 * Use this interface when working with the Input Parameter Section of the QUSLOBJ API
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
	 * @return the formatNamez
	 */
	public String getFormatName();
	/**
	 * @return the objectNameSpecified
	 */
	public String getObjectNameSpecified();
	/**
	 * @return the objectLibraryNameSpecified
	 */
	public String getObjectLibraryNameSpecified();
	/**
	 * @return the objectTypeSpecified
	 */
	public String getObjectTypeSpecified();

	/**
	 * @return the reservedInputParameterSection
	 */
	public String getReservedInputParameterSection();
	/**
	 * @return the errorCodeBytesProvided
	 */
	public Integer getErrorCodeBytesProvided();
	/**
	 * @return the lengthOfAuthorityControlFormatSpecified
	 */
	public Integer getLengthOfAuthorityControlFormatSpecified();
	/**
	 * @return the callLevel
	 */
	public Integer getCallLevelSpecified();
	/**
	 * @return the displacementToObjectAuthoritiesz
	 */
	public Integer getDisplacementToObjectAuthoritiesz();
	/**
	 * @return the numberOfObjectAuthorities
	 */
	public Integer getNumberOfObjectAuthorities();
	/**
	 * @return the displacementToLibraryAuthorities
	 */
	public Integer getDisplacementToLibraryAuthorities();
	/**
	 * @return the numberOfLibraryAuthorities
	 */
	public Integer getNumberOfLibraryAuthorities();
	/**
	 * @return the lengthOfSelectionControlFormat
	 */
	public Integer getLengthOfSelectionControlFormat();
	/**
	 * @return the selectOrOmitStatusValue
	 */
	public Integer getSelectOrOmitStatusValue();
	/**
	 * @return the displacementToStatuses
	 */
	public Integer getDisplacementToStatuses();
	/**
	 * @return the numberOfStatuses
	 */
	public Integer getNumberOfStatuses();
	/**
	 * @return the lengthOfAuxillaryStoragePoolControlFormat
	 */
	public Integer getLengthOfAuxillaryStoragePoolControlFormat();
	/**
	 * @return the aSPDeviceName
	 */
	public String getASPDeviceName();
	/**
	 * @return the aSPSearchType
	 */
	public String getASPSearchType();

	
}
