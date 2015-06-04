package org.rplgleparser.api;


public interface ListApiProvider {
	void registerCallback(ListApiCallback theClass);
	void deregisterCallback(ListApiCallback theClass);

}
