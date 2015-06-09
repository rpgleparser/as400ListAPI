package org.rplgleparser.api;

/**
 * Interface for interacting with an ERRC0100 object
 * @author Eric N. Wilson
 *
 */
public interface IERRC0100 {
	
	/**
	 * An initializer for the bare bones ERRC0100 object
	 * @return An object array that can be used to initialize an ERRC0100 object
	 */
	public Object[] getERRC0100j();

	/**
	 * Returns the size in bytes of the ERRC0100 structure passed to the iSeries
	 * @return Number of bytes provided
	 */
	public Integer getBytesProvided();

	/**
	 * Returns the number of bytes available in the structure returned from the iSeries
	 * @return Number of bytes available
	 */
	public Integer getBytesAvailable();

	/**
	 * Get the exception ID (message ID) returned by the iSeries
	 * @return Exception ID (Message ID) 
	 */
	public String getExceptionID();

	/**
	 * Get the reserved space
	 * @return Reserved space
	 */
	public String getERRC0100Reserved();

}
