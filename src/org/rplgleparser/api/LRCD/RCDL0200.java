package org.rplgleparser.api.LRCD;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class RCDL0200 extends RCDL0100 implements IRCDL0200, RCDLoutputFormat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 942181025236716095L;
	// RCDL0200 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) Record format name
	// Use the field above
	// 10 A CHAR(13) Record format ID
	protected AS400Text recordFormatIDx = new AS400Text(13);
	// 23 17 CHAR(1) Reserved
	protected AS400Text reservedRCDL02001x = new AS400Text(1);

	// 24 18 BINARY(4) Record length
	protected AS400Bin4 recordLengthx = new AS400Bin4();
	// 28 1C BINARY(4) Number of fields
	protected AS400Bin4 numberOfFieldsx = new AS400Bin4();
	// 32 20 CHAR(50) Record text description
	protected AS400Text recordTextDescriptionx = new AS400Text(50);
	// 82 52 CHAR(2) Reserved
	protected AS400Text reservedRCDL02002x = new AS400Text(2);
	// 84 54 BINARY(4) Record text description CCSID
	protected AS400Bin4 recordTextDescriptionCCSIDx = new AS400Bin4();
	
	protected AS400DataType[] RCDL0200a = new AS400DataType[] { 
			recordFormatNamex,
			recordFormatIDx, 
			reservedRCDL02001x, 
			recordLengthx, 
			numberOfFieldsx,
			recordTextDescriptionx, 
			reservedRCDL02002x,
			recordTextDescriptionCCSIDx 
			};
	protected AS400Structure RCDL0200x = new AS400Structure(RCDL0200a);
	protected Integer recordTextDescriptionCCSID;
	protected String reservedRCDL02002;
	protected String recordTextDescription;
	protected Integer numberOfFields;
	protected Integer recordLength;
	protected String reservedRCDL02001;
	protected String recordFormatID;
	protected String recordFormatName;
	public RCDL0200(){
		// Default Constructor
	}
	public RCDL0200(byte[] input){
		Object[] o = (Object[]) RCDL0200x.toObject(input);
		recordFormatName = (String)o[0];
		recordFormatID = (String)o[1]; 
		reservedRCDL02001 = (String)o[2];
		recordLength = (Integer)o[3];
		numberOfFields = (Integer)o[4];
		recordTextDescription = (String)o[5];
		reservedRCDL02002 = (String)o[6];
		recordTextDescriptionCCSID = (Integer)o[7];
		
	}
	@Override
	public <T extends RCDLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new RCDL0200(input));
	}
	/**
	 * @return the numberOfFields
	 */
	public Integer getNumberOfFields() {
		return numberOfFields;
	}
	/**
	 * @return the recordFormatID
	 */
	public String getRecordFormatID() {
		return recordFormatID;
	}
	/**
	 * @return the recordLength
	 */
	public Integer getRecordLength() {
		return recordLength;
	}
	/**
	 * @return the recordTextDescription
	 */
	public String getRecordTextDescription() {
		return recordTextDescription;
	}

	/**
	 * @return the recordTextDescriptionCCSID
	 */
	public Integer getRecordTextDescriptionCCSID() {
		return recordTextDescriptionCCSID;
	}
	/**
	 * @return the reservedRCDL01001
	 */
	public String getReservedRCDL01001() {
		return reservedRCDL02001;
	}
	/**
	 * @return the reservedRCDL01002
	 */
	public String getReservedRCDL01002() {
		return reservedRCDL02002;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Record Format Name: " + recordFormatName.trim());
		sb.append(" Record Format ID: " + recordFormatID.trim()); 
		sb.append(" Reserved (RCDL0100): " + reservedRCDL02001.trim()); 
		sb.append(" Record Length: " + recordLength.toString()); 
		sb.append(" Number Of Fields: " + numberOfFields.toString());
		sb.append(" Record Text Description: " + recordTextDescription.trim()); 
		sb.append(" Reserved 2 (RCDL0200) " + reservedRCDL02002.trim());
		sb.append(" Record Text Description CCSID: " + recordTextDescriptionCCSID.toString()); 

		return sb.toString();
	}
}
