package org.rpgleparser.api.OBJL;
/**
 * This is a marker interface that all the object list APIs implement so that they can be treated generically when needed
 * @author ewilson
 *
 */
public interface OBJLoutputFormat {
	public  <T extends OBJLoutputFormat> T fromByteArray(byte[] input);
}
