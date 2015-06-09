package org.rpgleparser.api.OBJL;

/**
 * Use this interface when working with the OBJL0200 format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IOBJL0200 extends IOBJL0100, OBJLoutputFormat {
	/**
	 * @return the oBJL0100
	 */
	public IOBJL0100 getOBJL0100();
	/**
	 * @return the informationStatus
	 */
	public String getInformationStatus();
	/**
	 * @return the extendedObjectAttribute
	 */
	public String getExtendedObjectAttribute();
	/**
	 * @return the textDescription
	 */
	public String getTextDescription();
	/**
	 * @return the userDefinedAttribute
	 */
	public String getUserDefinedAttribute();
	/**
	 * @return the reservedOBJL0200
	 */
	public String getReservedOBJL0200();

}
