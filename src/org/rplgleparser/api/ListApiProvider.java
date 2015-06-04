package org.rplgleparser.api;


/**
 * Classes implementing this interface are intended to go through the entries in 
 * a user space invoking all the registered ListApiCallback implementers
 * @author Eric N. Wilson
 *
 */
public interface ListApiProvider {
	void registerCallback(ListApiCallback theClass);
	void deregisterCallback(ListApiCallback theClass);

}
