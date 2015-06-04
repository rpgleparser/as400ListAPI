package org.rplgleparser.api.LFLD;


/**
 * A marker interface used to generically handle all the FLDL* interfaces
 * @author Eric N. Wilson
 *
 */
public interface FLDLoutputFormat {
	public  <T extends FLDLoutputFormat> T fromByteArray(byte[] input);

}
