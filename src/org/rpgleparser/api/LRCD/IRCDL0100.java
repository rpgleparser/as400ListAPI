package org.rpgleparser.api.LRCD;

/**
 * Public interface of classes that implement the IBM QUSLRCD RCDL0100 interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */
public interface IRCDL0100 extends RCDLoutputFormat {
	public String getRecordFormatName();
}
