package org.rplgleparser.api.LRCD;

import java.io.Serializable;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class RCDL0100 implements RCDLoutputFormat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1554734690899430727L;
	// RCDL0100 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) Record format name
	protected AS400Text recordFormatNamex = new AS400Text(10);
	protected AS400DataType[] RCDL0100a = new AS400DataType[] { recordFormatNamex };
	protected AS400Structure RCDL0100x = new AS400Structure(RCDL0100a);
	protected String recordFormatName;
	
	/**
	 * @return the recordFormatName
	 */
	public String getRecordFormatName() {
		return recordFormatName;
	}

	public RCDL0100() {
		// Default Constructor
	}
	
	public RCDL0100(byte[] input){
		Object[] o = (Object[]) RCDL0100x.toObject(input);
		recordFormatName = (String)o[0];
		}
	
	public <T extends RCDLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new RCDL0100(input));
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		return "Record Format Name: " + recordFormatName.trim();
	}

}
