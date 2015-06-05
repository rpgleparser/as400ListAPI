package org.rplgleparser.api.LRCD;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLRCD RCDL0300 format.
 * @author Eric N. Wilson
 *
 */
public class RCDL0300 extends RCDL0100 implements IRCDL0300, RCDLoutputFormat, Serializable{
	/**
	 * 
	 */
	protected static final long serialVersionUID = 7936763514312691357L;
	// RCDL0300 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) Record format name
	// 10 A CHAR(2) Lowest response indicator
	protected transient AS400Text lowestResponseIndicatorx = new AS400Text(2);
	// 12 C BINARY(4) Buffer size
	protected transient AS400Bin4 bufferSizex = new AS400Bin4();
	// 16 10 CHAR(20) Record format type
	protected transient AS400Text recordFormatTypex = new AS400Text(20);
	// 36 24 CHAR(1) Starting line number
	protected transient AS400Text startingLineNumberx = new AS400Text(1);
	// 37 25 CHAR(1) Separate indicator area present
	protected transient AS400Text separateIndicatorAreaPresentx = new AS400Text(1);
	
	protected transient AS400DataType[] RCDL0300a = new AS400DataType[] { 
			recordFormatNamex,
			lowestResponseIndicatorx, 
			bufferSizex, 
			recordFormatTypex,
			startingLineNumberx, 
			separateIndicatorAreaPresentx
			};
	
	protected transient AS400Structure RCDL0300x = new AS400Structure(RCDL0300a);

	protected String lowestResponseIndicator;

	protected Integer bufferSize;

	protected String recordFormatType;

	protected String startingLineNumber;

	protected String separateIndicatorAreaPresent;
	public RCDL0300(){
		// default constructor
	}
	public RCDL0300(byte[] input){
		Object[] o = (Object[]) RCDL0300x.toObject(input);
		recordFormatName = (String)o[0];
		lowestResponseIndicator = (String)o[1]; 
		bufferSize = (Integer)o[2]; 
		recordFormatType = (String)o[3];
		startingLineNumber = (String)o[4]; 
		separateIndicatorAreaPresent = (String)o[5];

	}
	/* (non-Javadoc)
	 * @see org.rplgleparser.api.LRCD.RCDL0100#fromByteArray(byte[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends RCDLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new RCDL0300(input));
	}
	/**
	 * @return the bufferSize
	 */
	public Integer getBufferSize() {
		return bufferSize;
	}
	/**
	 * @return the lowestResponseIndicator
	 */
	public String getLowestResponseIndicator() {
		return lowestResponseIndicator;
	}
	
	/**
	 * @return the recordFormatType
	 */
	public String getRecordFormatType() {
		return recordFormatType;
	}
	
	/**
	 * @return the separateIndicatorAreaPresent
	 */
	public String getSeparateIndicatorAreaPresent() {
		return separateIndicatorAreaPresent;
	}

	/**
	 * @return the startingLineNumber
	 */
	public String getStartingLineNumber() {
		return startingLineNumber;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Record Format Name: " + recordFormatName.trim());
		sb.append(" Lowest Response Indicator: " + lowestResponseIndicator.trim()); 
		sb.append(" Buffer Size: " + bufferSize.toString()); 
		sb.append(" Record Format Type: " + recordFormatType.toString());
		sb.append(" Starting Line Number: " + startingLineNumber.trim()); 
		sb.append(" Separate Indicator Area Present: " + separateIndicatorAreaPresent.trim());

		return sb.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RCDL0300 other = (RCDL0300) obj;
		if (bufferSize == null) {
			if (other.bufferSize != null)
				return false;
		} else if (!bufferSize.equals(other.bufferSize))
			return false;
		if (lowestResponseIndicator == null) {
			if (other.lowestResponseIndicator != null)
				return false;
		} else if (!lowestResponseIndicator
				.equals(other.lowestResponseIndicator))
			return false;
		if (recordFormatType == null) {
			if (other.recordFormatType != null)
				return false;
		} else if (!recordFormatType.equals(other.recordFormatType))
			return false;
		if (separateIndicatorAreaPresent == null) {
			if (other.separateIndicatorAreaPresent != null)
				return false;
		} else if (!separateIndicatorAreaPresent
				.equals(other.separateIndicatorAreaPresent))
			return false;
		if (startingLineNumber == null) {
			if (other.startingLineNumber != null)
				return false;
		} else if (!startingLineNumber.equals(other.startingLineNumber))
			return false;
		return true;
	}


}
