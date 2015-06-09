package org.rpgleparser.api.LRCD;

import java.io.Serializable;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLRCD RCDL0100 format.
 * @author Eric N. Wilson
 *
 */
public class RCDL0100 implements IRCDL0100, RCDLoutputFormat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1554734690899430727L;
	// RCDL0100 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) Record format name
	protected transient AS400Text recordFormatNamex = new AS400Text(10);
	protected transient AS400DataType[] RCDL0100a = new AS400DataType[] { recordFormatNamex };
	protected transient AS400Structure RCDL0100x = new AS400Structure(RCDL0100a);
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
	
	@SuppressWarnings("unchecked")
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RCDL0100 other = (RCDL0100) obj;
		if (recordFormatName == null) {
			if (other.recordFormatName != null)
				return false;
		} else if (!recordFormatName.equals(other.recordFormatName))
			return false;
		return true;
	}

}
