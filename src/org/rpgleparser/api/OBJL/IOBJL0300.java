package org.rpgleparser.api.OBJL;


/**
 * Use this interface when working with the OBJL0300 format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IOBJL0300 extends IOBJL0200, OBJLoutputFormat{
	/**
	 * @return the oBJL0200
	 */
	public IOBJL0200 getOBJL0200();
	/**
	 * @return the objectASPNumber
	 */
	public Integer getObjectASPNumber();
	/**
	 * @return the objectOwner
	 */
	public String getObjectOwner();
	/**
	 * @return the objectDomain
	 */
	public String getObjectDomain();
	/**
	 * @return the creationDateAndTime
	 */
	public String getCreationDateAndTime();
	/**
	 * @return the changeDateAndTime
	 */
	public String getChangeDateAndTime();
	/**
	 * @return the storage
	 */
	public String getStorage();
	/**
	 * @return the objectCompressionStatus
	 */
	public String getObjectCompressionStatus();
	/**
	 * @return the allowChangeByProgram
	 */
	public String getAllowChangeByProgram();
	/**
	 * @return the changedByProgram
	 */
	public String getChangedByProgram();
	/**
	 * @return the objectAuditingValue
	 */
	public String getObjectAuditingValue();
	/**
	 * @return the digitallySigned
	 */
	public String getDigitallySigned();
	/**
	 * @return the digitallySignedBySystemTrustedSource
	 */
	public String getDigitallySignedBySystemTrustedSource();
	/**
	 * @return the digitallySignedMoreThanOnce
	 */
	public String getDigitallySignedMoreThanOnce();
	/**
	 * @return the reservedOBJL0300
	 */
	public String getReservedOBJL0300();
	/**
	 * @return the libraryASPNumber
	 */
	public Integer getLibraryASPNumber();

}
