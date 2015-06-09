package org.rpgleparser.api;
/**
 * Every class that wishes to be notified of entries in a user space must implement this interface
 * @author Eric N. Wilson
 *
 */
public interface ListApiCallback {
	
	/**
	 * This method is called by the ListApiProvider for each list entry encountered
	 * @param listEntry this is the byte array that is read out from the user space
	 * @return true if you wish to continue getting list entries or false if you are done
	 */
	boolean processEntry(byte[] listEntry); 

}
