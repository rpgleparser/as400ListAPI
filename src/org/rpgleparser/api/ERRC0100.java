package org.rpgleparser.api;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class ERRC0100 implements IERRC0100, Serializable {

	protected static final long serialVersionUID = -2607744170677503147L;

	// Format xERRC0100
	// Table 1. Format xERRC0100 for the error code parameter
	/** 0 0 INPUT BINARY(4) Bytes provided */
	protected transient AS400Bin4 bytesProvidedx = new AS400Bin4();

	/** 4 4 OUTPUT BINARY(4) Bytes available */
	protected transient AS400Bin4 bytesAvailablex = new AS400Bin4();

	/** 8 8 OUTPUT CHAR(7) Exception ID */
	protected transient AS400Text exceptionIDx = new AS400Text(7);

	/** 15 F OUTPUT CHAR(1) Reserved */
	protected transient AS400Text ERRC0100Reservedx = new AS400Text(1);
	/** 16 10 OUTPUT CHAR(*) Exception data */

	protected transient AS400DataType[] ERRC0100a = new AS400DataType[] { 
			bytesProvidedx,
			bytesAvailablex, 
			exceptionIDx, 
			ERRC0100Reservedx 
			};
	protected transient AS400Structure ERRC0100x = new AS400Structure(ERRC0100a);
	protected Object[] ERRC0100j = new Object[] { ERRC0100x.getByteLength(), new Integer(0),
			" ", " " };

	protected Integer bytesProvided;

	protected Integer bytesAvailable;

	protected String exceptionID;

	protected String ERRC0100Reserved;
	
	public ERRC0100(){
		// Default Constructor
	}
	
	public ERRC0100(byte[] input){
		Object[] o = (Object[]) ERRC0100x.toObject(input);
		bytesProvided = (Integer)o[0];
		bytesAvailable = (Integer)o[1]; 
		exceptionID = (String)o[2]; 
		ERRC0100Reserved = (String)o[3];
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERRC0100 other = (ERRC0100) obj;
		if (ERRC0100Reserved == null) {
			if (other.ERRC0100Reserved != null)
				return false;
		} else if (!ERRC0100Reserved.equals(other.ERRC0100Reserved))
			return false;
		if (bytesAvailable == null) {
			if (other.bytesAvailable != null)
				return false;
		} else if (!bytesAvailable.equals(other.bytesAvailable))
			return false;
		if (bytesProvided == null) {
			if (other.bytesProvided != null)
				return false;
		} else if (!bytesProvided.equals(other.bytesProvided))
			return false;
		if (exceptionID == null) {
			if (other.exceptionID != null)
				return false;
		} else if (!exceptionID.equals(other.exceptionID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bytes Provided: " + bytesProvided.toString());
		sb.append("Bytes Available: " + bytesAvailable.toString()); 
		sb.append("Exception ID: " + exceptionID.trim()); 
		sb.append("Reserved (xERRC0100): " + ERRC0100Reserved.trim());
		return sb.toString();
	}

	public Object[] getERRC0100j() {
		return ERRC0100j;
	}

	public Integer getBytesProvided() {
		return bytesProvided;
	}

	public Integer getBytesAvailable() {
		return bytesAvailable;
	}

	public String getExceptionID() {
		return exceptionID;
	}

	public String getERRC0100Reserved() {
		return ERRC0100Reserved;
	}

	public AS400Structure getERRC0100x() {
		return ERRC0100x;
	}

}
