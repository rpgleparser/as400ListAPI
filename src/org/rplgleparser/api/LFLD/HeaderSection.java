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
	protected static final long serialVersionUID = 1555175653749243967L;

	// Header Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) File name used
	protected transient AS400Text fileNameUsedx = new AS400Text(10);

	// 10 A CHAR(10) File library name used
	protected transient AS400Text fileLibraryNameUsedx = new AS400Text(10);

	// 20 14 CHAR(10) File type
	protected transient AS400Text fileTypex = new AS400Text(10);
	// 30 1E CHAR(10) Record format name used
	protected transient AS400Text recordFormatNameUsedx = new AS400Text(10);
	// 40 28 BINARY(4) Record length
	protected transient AS400Bin4 recordLengthx = new AS400Bin4();
	// 44 2C CHAR(13) Record format ID
	protected transient AS400Text recordFormatIDx = new AS400Text(13);
	// 57 39 CHAR(50) Record text description
	protected transient AS400Text recordTextDescriptionx = new AS400Text(50);
	// 107 6B CHAR(1) Reserved
	protected transient AS400Text reservedHeaderSectionx = new AS400Text(1);
	// 108 6C BINARY(4) Record text description CCSID
	protected transient AS400Bin4 recordTextDescriptionCCSIDx = new AS400Bin4();
	// 112 70 CHAR(1) Variable length fields in format indicator
	protected transient AS400Text variableLengthFieldsInFormatIndicatorx = new AS400Text(1);
	// 113 71 CHAR(1) Graphic fields indicator
	protected transient AS400Text graphicFieldsIndicatorx = new AS400Text(1);
	// 114 72 CHAR(1) Date and time fields indicator
	protected transient AS400Text dateAndTimeFieldsIndicatorx = new AS400Text(1);
	// 115 73 CHAR(1) Null-capable fields indicator
	protected transient AS400Text nullCapableFieldsIndicatorx = new AS400Text(1);
	protected transient AS400DataType[] headerSectiona = new AS400DataType[] { 
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
	protected transient AS400Structure headerSectionx = new AS400Structure(headerSectiona);

	protected String fileNameUsed;

	protected String fileLibraryNameUsed;

	protected String fileType;

	protected String recordFormatNameUsed;

	protected Integer recordLength;

	protected String recordFormatID;

	protected String recordTextDescription;

	protected String reservedHeaderSection;

	protected Integer recordTextDescriptionCCSID;

	protected String variableLengthFieldsInFormatIndicator;

	protected String graphicFieldsIndicator;

	protected String dateAndTimeFieldsIndicator;

	protected String nullCapableFieldsIndicator;
	
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeaderSection other = (HeaderSection) obj;
		if (dateAndTimeFieldsIndicator == null) {
			if (other.dateAndTimeFieldsIndicator != null)
				return false;
		} else if (!dateAndTimeFieldsIndicator
				.equals(other.dateAndTimeFieldsIndicator))
			return false;
		if (fileLibraryNameUsed == null) {
			if (other.fileLibraryNameUsed != null)
				return false;
		} else if (!fileLibraryNameUsed.equals(other.fileLibraryNameUsed))
			return false;
		if (fileNameUsed == null) {
			if (other.fileNameUsed != null)
				return false;
		} else if (!fileNameUsed.equals(other.fileNameUsed))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (graphicFieldsIndicator == null) {
			if (other.graphicFieldsIndicator != null)
				return false;
		} else if (!graphicFieldsIndicator.equals(other.graphicFieldsIndicator))
			return false;
		if (nullCapableFieldsIndicator == null) {
			if (other.nullCapableFieldsIndicator != null)
				return false;
		} else if (!nullCapableFieldsIndicator
				.equals(other.nullCapableFieldsIndicator))
			return false;
		if (recordFormatID == null) {
			if (other.recordFormatID != null)
				return false;
		} else if (!recordFormatID.equals(other.recordFormatID))
			return false;
		if (recordFormatNameUsed == null) {
			if (other.recordFormatNameUsed != null)
				return false;
		} else if (!recordFormatNameUsed.equals(other.recordFormatNameUsed))
			return false;
		if (recordLength == null) {
			if (other.recordLength != null)
				return false;
		} else if (!recordLength.equals(other.recordLength))
			return false;
		if (recordTextDescription == null) {
			if (other.recordTextDescription != null)
				return false;
		} else if (!recordTextDescription.equals(other.recordTextDescription))
			return false;
		if (recordTextDescriptionCCSID == null) {
			if (other.recordTextDescriptionCCSID != null)
				return false;
		} else if (!recordTextDescriptionCCSID
				.equals(other.recordTextDescriptionCCSID))
			return false;
		if (reservedHeaderSection == null) {
			if (other.reservedHeaderSection != null)
				return false;
		} else if (!reservedHeaderSection.equals(other.reservedHeaderSection))
			return false;
		if (variableLengthFieldsInFormatIndicator == null) {
			if (other.variableLengthFieldsInFormatIndicator != null)
				return false;
		} else if (!variableLengthFieldsInFormatIndicator
				.equals(other.variableLengthFieldsInFormatIndicator))
			return false;
		return true;
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

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" File Name Used: " + fileNameUsed.trim());
		sb.append(" File Library Name Used: " + fileLibraryNameUsed.trim()); 
		sb.append(" File Type Used: " + fileType.trim()); 
		sb.append(" Record Format Name Used: " + recordFormatNameUsed.trim()); 
		sb.append(" Record Length: " + recordLength.toString());
		sb.append(" Record Format ID: " + recordFormatID.trim()); 
		sb.append(" Record Text Description: " + recordTextDescription.trim()); 
		sb.append(" Reserved (Header Section): " + reservedHeaderSection.trim());
		sb.append(" Record Text Description CCSID: " + recordTextDescriptionCCSID.toString()); 
		sb.append(" Variable Length Fields in Format Indicator: " + variableLengthFieldsInFormatIndicator.trim());
		sb.append(" Graphic Fields Indicator: " + graphicFieldsIndicator.toString()); 
		sb.append(" Date and Time Fields Indicator: " + dateAndTimeFieldsIndicator.trim());
		sb.append(" Null Capable Fields Indicator: " + nullCapableFieldsIndicator.trim());
		return sb.toString();
	}

}
