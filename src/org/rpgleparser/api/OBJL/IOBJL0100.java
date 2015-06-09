package org.rpgleparser.api.OBJL;

/**
 * Use this interface when working with the OBJL0100 format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IOBJL0100  extends OBJLoutputFormat{
	/**
	 * @return the objectLibraryNameUsed
	 */
	public String getObjectLibraryNameUsed();
	/**
	 * @return the objectNameUsed
	 */
	public String getObjectNameUsed();
	/**
	 * @return the objectTypeUsed
	 */
	public String getObjectTypeUsed();
}
