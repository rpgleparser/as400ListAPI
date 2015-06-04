package org.rplgleparser.api.LFLD;

public interface FLDLoutputFormat {
	public  <T extends FLDLoutputFormat> T fromByteArray(byte[] input);

}
