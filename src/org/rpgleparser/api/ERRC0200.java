package org.rpgleparser.api;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class ERRC0200 implements IERRC0200, Serializable{
	private static final long serialVersionUID = -3876935331888150006L;
	// Format ERRC0200
	// Table 2. Format ERRC0200 for the error code parameter
	/** 0 0 INPUT BINARY(4) Key */
	protected transient AS400Bin4 keyx = new AS400Bin4();
	/** 4 4 INPUT BINARY(4) Bytes provided */
	protected transient AS400Bin4 bytesProvidedx = new AS400Bin4();
	/** 8 8 OUTPUT BINARY(4) Bytes available */
	protected transient AS400Bin4 bytesAvailablex = new AS400Bin4();
	/** 12 C OUTPUT CHAR(7) Exception ID */
	protected transient AS400Text exceptionIDx = new AS400Text(7);
	/** 19 13 OUTPUT CHAR(1) Reserved */
	protected transient AS400Text reservedERRC0200x = new AS400Text(1);
	/** 20 14 OUTPUT BINARY(4) CCSID of the CCHAR data */
	protected transient AS400Bin4 CCSIDoftheCharDatax = new AS400Bin4();
	/** 24 18 OUTPUT BINARY(4) Offset to the exception data */
	protected transient AS400Bin4 offsetToTheExceptionDatax = new AS400Bin4();
	/** 28 1C OUTPUT BINARY(4) Length of the exception data */
	protected transient AS400Bin4 lengthOfExceptionDatax = new AS400Bin4();
	/** OUTPUT CHAR(*) Exception data */

	protected transient AS400DataType[] ERRC0200a = new AS400DataType[] { 
			keyx,
			bytesProvidedx, 
			bytesAvailablex, 
			exceptionIDx, 
			reservedERRC0200x,
			CCSIDoftheCharDatax, 
			offsetToTheExceptionDatax,
			lengthOfExceptionDatax
			};

	protected transient AS400Structure ERRC0200x = new AS400Structure(ERRC0200a);
	protected transient Object[] ERRC0200j = new Object[] { new Integer(0),
			ERRC0200x.getByteLength(), new Integer(0), " ", " ",
			new Integer(0), new Integer(0), new Integer(0) };
	protected Integer key;
	protected Integer bytesProvided;
	protected Integer bytesAvailable;
	protected String exceptionID;
	protected String reservedERRC0200;
	protected Integer CCSIDoftheCharData;
	protected Integer offsetToTheExceptionData;
	protected Integer lengthOfExceptionData;
	
	public ERRC0200(){
		//Default constructor
	}
	
	public ERRC0200(byte[] input){
		Object[] o = (Object[]) ERRC0200x.toObject(input);
		key = (Integer)o[0];
		bytesProvided = (Integer)o[1];
		bytesAvailable = (Integer)o[2];
		exceptionID = (String)o[3];
		reservedERRC0200 = (String)o[4];
		CCSIDoftheCharData = (Integer)o[5];
		offsetToTheExceptionData = (Integer)o[6];
		lengthOfExceptionData = (Integer)o[7];
	}

	public Object[] getERRC0200j() {
		return ERRC0200j;
	}

	public Integer getKey() {
		return key;
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

	public String getReservedERRC0200() {
		return reservedERRC0200;
	}

	public Integer getCCSIDoftheCharData() {
		return CCSIDoftheCharData;
	}

	public Integer getOffsetToTheExceptionData() {
		return offsetToTheExceptionData;
	}

	public Integer getLengthOfExceptionData() {
		return lengthOfExceptionData;
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
		ERRC0200 other = (ERRC0200) obj;
		if (CCSIDoftheCharData == null) {
			if (other.CCSIDoftheCharData != null)
				return false;
		} else if (!CCSIDoftheCharData.equals(other.CCSIDoftheCharData))
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
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (lengthOfExceptionData == null) {
			if (other.lengthOfExceptionData != null)
				return false;
		} else if (!lengthOfExceptionData.equals(other.lengthOfExceptionData))
			return false;
		if (offsetToTheExceptionData == null) {
			if (other.offsetToTheExceptionData != null)
				return false;
		} else if (!offsetToTheExceptionData
				.equals(other.offsetToTheExceptionData))
			return false;
		if (reservedERRC0200 == null) {
			if (other.reservedERRC0200 != null)
				return false;
		} else if (!reservedERRC0200.equals(other.reservedERRC0200))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Key: " + key.toString());
		sb.append(" Bytes Provided: " + bytesProvided.toString());
		sb.append(" Bytes Available: " + bytesAvailable.toString());
		sb.append(" Exception ID: " + exceptionID.trim());
		sb.append(" Reserved (ERRC0200): " + reservedERRC0200.trim());
		sb.append(" CCSID of the Character Data: " + CCSIDoftheCharData.toString());
		sb.append(" Offset To the Exception Data: " + offsetToTheExceptionData.toString());
		sb.append(" Length of Exception Data: " +lengthOfExceptionData.toString());
		return sb.toString();
	}
	
	

}
