package org.rpgleparser.api.OBJL;


/**
 * Use this interface when working with the OBJL0500 format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IOBJL0500 extends IOBJL0400, OBJLoutputFormat {
	/**
	 * @return the oBJL0400
	 */
	public IOBJL0400 getOBJL0400();
	/**
	 * @return the objectSavedDateAndTime
	 */
	public String getObjectSavedDateAndTime();
	/**
	 * @return the objectRestoredDateAndTime
	 */
	public String getObjectRestoredDateAndTime();
	/**
	 * @return the savedSize
	 */
	public Integer getSavedSize();
	/**
	 * @return the saveActiveDateAndTime
	 */
	public String getSaveActiveDateAndTime();
	/**
	 * @return the saveCommand
	 */
	public String getSaveCommand();
	/**
	 * @return the saveDevice
	 */
	public String getSaveDevice();
	/**
	 * @return the savedSizeMultiplier
	 */
	public Integer getSavedSizeMultiplier();
	/**
	 * @return the saveFileLibraryName
	 */
	public String getSaveFileLibraryName();
	/**
	 * @return the saveFileName
	 */
	public String getSaveFileName();
	/**
	 * @return the saveLabel
	 */
	public String getSaveLabel();

	/**
	 * @return the saveSequenceNumber
	 */
	public Integer getSaveSequenceNumber();

	/**
	 * @return the saveVolumeID
	 */
	public String getSaveVolumeID();
	/**
	 * @return the journalEntriesToBeOmitted
	 */
	public String getJournalEntriesToBeOmitted();
	/**
	 * @return the journalImages
	 */
	public String getJournalImages();
	/**
	 * @return the journalLibraryName
	 */
	public String getJournalLibraryName();
	/**
	 * @return the journalName
	 */
	public String getJournalName();

	/**
	 * @return the journalStartDateAndTime
	 */
	public String getJournalStartDateAndTime();
	/**
	 * @return the journalStatus
	 */
	public String getJournalStatus();
	/**
	 * @return the remoteJournalFilter
	 */
	public String getRemoteJournalFilter();
	/**
	 * @return the reservedOBJL0500
	 */
	public String getReservedOBJL0500();
}
