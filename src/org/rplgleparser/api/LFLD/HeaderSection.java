package org.rplgleparser.api.LFLD;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * Implementation class for the header section of the QUSLFLD api. Currently not used 
 * in the main code but provided so you can take a byte[] from the user space and get the data
 * @author Eric N. Wilson
 *
 */
public class HeaderSection implements IHeaderSection, FLDLoutputFormat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1555175653749243967L;

	// Header Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) File name used
	AS400Text fileNameUsedx = new AS400Text(10);

	// 10 A CHAR(10) File library name used
	AS400Text fileLibraryNameUsedx = new AS400Text(10);

	// 20 14 CHAR(10) File type
	AS400Text fileTypex = new AS400Text(10);
	// 30 1E CHAR(10) Record format name used
	AS400Text recordFormatNameUsedx = new AS400Text(10);
	// 40 28 BINARY(4) Record length
	AS400Bin4 recordLengthx = new AS400Bin4();
	// 44 2C CHAR(13) Record format ID
	AS400Text recordFormatIDx = new AS400Text(13);
	// 57 39 CHAR(50) Record text description
	AS400Text recordTextDescriptionx = new AS400Text(50);
	// 107 6B CHAR(1) Reserved
	AS400Text reservedHeaderSectionx = new AS400Text(1);
	// 108 6C BINARY(4) Record text description CCSID
	AS400Bin4 recordTextDescriptionCCSIDx = new AS400Bin4();
	// 112 70 CHAR(1) Variable length fields in format indicator
	AS400Text variableLengthFieldsInFormatIndicatorx = new AS400Text(1);
	// 113 71 CHAR(1) Graphic fields indicator
	AS400Text graphicFieldsIndicatorx = new AS400Text(1);
	// 114 72 CHAR(1) Date and time fields indicator
	AS400Text dateAndTimeFieldsIndicatorx = new AS400Text(1);
	// 115 73 CHAR(1) Null-capable fields indicator
	AS400Text nullCapableFieldsIndicatorx = new AS400Text(1);
	AS400DataType[] headerSectiona = new AS400DataType[] { 
			fileNameUsedx,
			fileLibraryNameUsedx, 
			fileTypex, 
			recordFormatNameUsedx, 
			recordLengthx,
			recordFormatIDx, 
			recordTextDescriptionx, 
			reservedHeaderSectionx,
			recordTextDescriptionCCSIDx, 
			variableLengthFieldsInFormatIndicatorx,
			graphicFieldsIndicatorx, 
			dateAndTimeFieldsIndicatorx,
			nullCapableFieldsIndicatorx 
			};
	AS400Structure headerSectionx = new AS400Structure(headerSectiona);

	private String fileNameUsed;

	private String fileLibraryNameUsed;

	private String fileType;

	private String recordFormatNameUsed;

	private Integer recordLength;

	private String recordFormatID;

	private String recordTextDescription;

	private String reservedHeaderSection;

	private Integer recordTextDescriptionCCSID;

	private String variableLengthFieldsInFormatIndicator;

	private String graphicFieldsIndicator;

	private String dateAndTimeFieldsIndicator;

	private String nullCapableFieldsIndicator;
	
	public HeaderSection(){
		// Default constructor	
	}
	
	public HeaderSection(byte[] input){
		Object[] o = (Object[]) headerSectionx.toObject(input);
		fileNameUsed = (String)o[0];
		fileLibraryNameUsed= (String)o[1]; 
		fileType= (String)o[2]; 
		recordFormatNameUsed= (String)o[3]; 
		recordLength= (Integer)o[4];
		recordFormatID= (String)o[5]; 
		recordTextDescription= (String)o[6]; 
		reservedHeaderSection= (String)o[7];
		recordTextDescriptionCCSID= (Integer)o[8]; 
		variableLengthFieldsInFormatIndicator= (String)o[9];
		graphicFieldsIndicator= (String)o[10]; 
		dateAndTimeFieldsIndicator= (String)o[11];
		nullCapableFieldsIndicator= (String)o[12];
	}

	@SuppressWarnings("unchecked")
	public <T extends FLDLoutputFormat> T fromByteArray(byte[] input) {
		return (T) new HeaderSection(input);
	}

	public String getDateAndTimeFieldsIndicator() {
		return dateAndTimeFieldsIndicator;
	}

	public String getFileLibraryNameUsed() {
		return fileLibraryNameUsed;
	}

	public String getFileNameUsed() {
		return fileNameUsed;
	}

	public String getFileType() {
		return fileType;
	}

	public String getGraphicFieldsIndicator() {
		return graphicFieldsIndicator;
	}

	public String getNullCapableFieldsIndicator() {
		return nullCapableFieldsIndicator;
	}

	public String getRecordFormatID() {
		return recordFormatID;
	}

	public String getRecordFormatNameUsed() {
		return recordFormatNameUsed;
	}

	public Integer getRecordLength() {
		return recordLength;
	}

	public String getRecordTextDescription() {
		return recordTextDescription;
	}

	public Integer getRecordTextDescriptionCCSID() {
		return recordTextDescriptionCCSID;
	}

	public String getReservedHeaderSection() {
		return reservedHeaderSection;
	}

	public String getVariableLengthFieldsInFormatIndicator() {
		return variableLengthFieldsInFormatIndicator;
	}

}
