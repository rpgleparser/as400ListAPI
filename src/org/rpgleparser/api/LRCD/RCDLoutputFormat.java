package org.rpgleparser.api.LRCD;

public interface RCDLoutputFormat {
	public  <T extends RCDLoutputFormat> T fromByteArray(byte[] input);

}
