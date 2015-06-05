package org.rplgleparser.api.OBJL;

/**
 * Use this interface when working with the OBJL0700 format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IOBJL0700 extends IOBJL0600, OBJLoutputFormat{
	/**
	 * @return the oBJL0600
	 */
	public IOBJL0600 getOBJL0600();
	/**
	 * @return the objectSize
	 */
	public Integer getObjectSize();
	/**
	 * @return the objectSizeMultiplier
	 */
	public Integer getObjectSizeMultiplier();
	/**
	 * @return the objectOverflowedASPIndicator
	 */
	public String getObjectOverflowedASPIndicator();
	/**
	 * @return the objectASPGroupName
	 */
	public String getObjectASPGroupName();
	/**
	 * @return the libraryASPGroupName
	 */
	public String getLibraryASPGroupName();
	/**
	 * @return the startingJournalReceiverLibraryASPDeviceName
	 */
	public String getStartingJournalReceiverLibraryASPDeviceName();
	/**
	 * @return the startingJournalReceiverLibraryASPGroupName
	 */
	public String getStartingJournalReceiverLibraryASPGroupName();
	/**
	 * @return the startingJournalReceiverLibraryName
	 */
	public String getStartingJournalReceiverLibraryName();
	/**
	 * @return the startingJournalReceiverNameForApply
	 */
	public String getStartingJournalReceiverNameForApply();
	/**
	 * @return the reservedOBJL0700
	 */
	public String getReservedOBJL0700();
}
