package org.rpgleparser.api.OBJL;

/**
 * Use this interface when working with the OBJL0600 format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IOBJL0600  extends IOBJL0500, OBJLoutputFormat{
	/**
	 * @return the oBJL0500
	 */
	public IOBJL0500 getOBJL0500();
	/**
	 * @return the lastUsedDateAndTime
	 */
	public String getLastUsedDateAndTime();
	/**
	 * @return the resetDateAndTime
	 */
	public String getResetDateAndTime();
	/**
	 * @return the daysUsedCount
	 */
	public Integer getDaysUsedCount();
	/**
	 * @return the usageInformationUpdated
	 */
	public String getUsageInformationUpdated();
	/**
	 * @return the objectASPDeviceName
	 */
	public String getObjectASPDeviceName();
	/**
	 * @return the libraryASPDeviceName
	 */
	public String getLibraryASPDeviceName();
	/**
	 * @return the reservedOBJL0600
	 */
	public String getReservedOBJL0600();

	

	
	
	
	
}
