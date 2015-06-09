package org.rplgleparser.api;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class LFMT0100 implements ILFMT0100, Serializable{
	// Format 0100 is for the list APIs that are called as programs (*PGMs).
	/** 0 0 CHAR(64) User area */
	protected transient AS400Text userAreax = new AS400Text(64);
	/** 64 40 BINARY(4) Size of generic header */
	protected transient AS400Bin4 sizeOfGenericHeaderx = new AS400Bin4();
	/** 68 44 CHAR(4) Structure's release and level */
	protected transient AS400Text structureReleaseAndLevelx = new AS400Text(4);
	/** 72 48 CHAR(8) Format name */
	protected transient AS400Text formatNamex = new AS400Text(8);
	/** 80 50 CHAR(10) API used */
	protected transient AS400Text apiUsedx = new AS400Text(10);
	/** 90 5A CHAR(13) Date and time created */
	protected transient AS400Text dateAndTimeCreatedx = new AS400Text(13);
	/** 103 67 CHAR(1) Information status */
	protected transient AS400Text informationStatusx = new AS400Text(1);
	/** 104 68 BINARY(4) Size of user space used */
	protected transient AS400Bin4 sizeOfUserSpaceUsedx = new AS400Bin4();
	/** 108 6C BINARY(4) Offset to input parameter section */
	protected transient AS400Bin4 offsetToInputParameterSectionx = new AS400Bin4();
	/** 112 70 BINARY(4) Size of input parameter section */
	protected transient AS400Bin4 sizeOfInputParameterSectionx = new AS400Bin4();
	/** 116 74 BINARY(4) Offset to header section */
	protected transient AS400Bin4 offsetToHeaderSectionx = new AS400Bin4();
	/** 120 78 BINARY(4) Size of header section */
	protected transient AS400Bin4 sizeOfHeaderSectionx = new AS400Bin4();
	/** 124 7C BINARY(4) Offset to list data section */
	protected transient AS400Bin4 offsetToListDataSectionx = new AS400Bin4();
	/** 128 80 BINARY(4) Size of list data section */
	protected transient AS400Bin4 sizeOfListDataSectionx = new AS400Bin4();
	/** 132 84 BINARY(4) Number of list entries */
	protected transient AS400Bin4 numberOfListEntriesx = new AS400Bin4();
	/** 136 88 BINARY(4) Size of each entry */
	protected transient AS400Bin4 sizeOfEachEntryx = new AS400Bin4();
	/** 140 8C BINARY(4) CCSID of data in the list entries */
	protected transient AS400Bin4 CCSIDofDataInTheListEntriesx = new AS400Bin4();
	/** 144 90 CHAR(2) Country or region ID */
	protected transient AS400Text countryOrRegionIDx = new AS400Text(2);
	/** 146 92 CHAR(3) Language ID */
	protected transient AS400Text languageIDx = new AS400Text(3);
	/** 149 95 CHAR(1) Subsetted list indicator */
	protected transient AS400Text subsettedListIndicatorx = new AS400Text(1);
	/** 150 96 CHAR(42) Reserved */
	protected transient AS400Text reservedLFMT0100x = new AS400Text(42);

	protected transient AS400DataType[] LFMT0100a = new AS400DataType[] { 
			userAreax,
			sizeOfGenericHeaderx, 
			structureReleaseAndLevelx, 
			formatNamex, 
			apiUsedx,
			dateAndTimeCreatedx, 
			informationStatusx, 
			sizeOfUserSpaceUsedx,
			offsetToInputParameterSectionx, 
			sizeOfInputParameterSectionx,
			offsetToHeaderSectionx, 
			sizeOfHeaderSectionx,
			offsetToListDataSectionx, 
			sizeOfListDataSectionx,
			numberOfListEntriesx, 
			sizeOfEachEntryx, 
			CCSIDofDataInTheListEntriesx,
			countryOrRegionIDx, 
			languageIDx, 
			subsettedListIndicatorx,
			reservedLFMT0100x
			};
	
	protected transient AS400Structure LFMT0100x = new AS400Structure(LFMT0100a);
	protected String userArea;
	protected Integer sizeOfGenericHeader;
	protected String structureReleaseAndLevel;
	protected String formatName;
	protected String apiUsed;
	protected String dateAndTimeCreated;
	protected String informationStatus;
	protected Integer sizeOfUserSpaceUsed;
	protected Integer offsetToInputParameterSection;
	protected Integer sizeOfInputParameterSection;
	protected Integer offsetToHeaderSection;
	protected Integer sizeOfHeaderSection;
	protected Integer offsetToListDataSection;
	protected Integer sizeOfListDataSection;
	protected Integer numberOfListEntries;
	protected Integer sizeOfEachEntry;
	protected Integer CCSIDofDataInTheListEntries;
	protected String countryOrRegionID;
	protected String languageID;
	protected String subsettedListIndicator;
	protected String reservedLFMT0100;

	public LFMT0100(){
		//Default constructor
	}
	
	public LFMT0100(byte[] input){
		Object[] o = (Object[]) LFMT0100x.toObject(input);
		userArea = (String)o[0];
		sizeOfGenericHeader = (Integer)o[1];
		structureReleaseAndLevel = (String)o[2];
		formatName = (String)o[3];
		apiUsed = (String)o[4];
		dateAndTimeCreated = (String)o[5];
		informationStatus = (String)o[6];
		sizeOfUserSpaceUsed = (Integer)o[7];
		offsetToInputParameterSection = (Integer)o[8];
		sizeOfInputParameterSection = (Integer)o[9];
		offsetToHeaderSection = (Integer)o[10];
		sizeOfHeaderSection = (Integer)o[11];
		offsetToListDataSection = (Integer)o[12];
		sizeOfListDataSection = (Integer)o[13];
		numberOfListEntries = (Integer)o[14];
		sizeOfEachEntry = (Integer)o[15];
		CCSIDofDataInTheListEntries = (Integer)o[16];
		countryOrRegionID = (String)o[17];
		languageID = (String)o[18];
		subsettedListIndicator = (String)o[19];
		reservedLFMT0100 = (String)o[20];
	}

	public AS400Structure getLFMT0100x() {
		return LFMT0100x;
	}

	public String getUserArea() {
		return userArea;
	}

	public Integer getSizeOfGenericHeader() {
		return sizeOfGenericHeader;
	}

	public String getStructureReleaseAndLevel() {
		return structureReleaseAndLevel;
	}

	public String getFormatName() {
		return formatName;
	}

	public String getApiUsed() {
		return apiUsed;
	}

	public String getDateAndTimeCreated() {
		return dateAndTimeCreated;
	}

	public String getInformationStatus() {
		return informationStatus;
	}

	public Integer getSizeOfUserSpaceUsed() {
		return sizeOfUserSpaceUsed;
	}

	public Integer getOffsetToInputParameterSection() {
		return offsetToInputParameterSection;
	}

	public Integer getSizeOfInputParameterSection() {
		return sizeOfInputParameterSection;
	}

	public Integer getOffsetToHeaderSection() {
		return offsetToHeaderSection;
	}

	public Integer getSizeOfHeaderSection() {
		return sizeOfHeaderSection;
	}

	public Integer getOffsetToListDataSection() {
		return offsetToListDataSection;
	}

	public Integer getSizeOfListDataSection() {
		return sizeOfListDataSection;
	}

	public Integer getNumberOfListEntries() {
		return numberOfListEntries;
	}

	public Integer getSizeOfEachEntry() {
		return sizeOfEachEntry;
	}

	public Integer getCCSIDofDataInTheListEntries() {
		return CCSIDofDataInTheListEntries;
	}

	public String getCountryOrRegionID() {
		return countryOrRegionID;
	}

	public String getLanguageID() {
		return languageID;
	}

	public String getSubsettedListIndicator() {
		return subsettedListIndicator;
	}

	public String getReservedLFMT0100() {
		return reservedLFMT0100;
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
		LFMT0100 other = (LFMT0100) obj;
		if (CCSIDofDataInTheListEntries == null) {
			if (other.CCSIDofDataInTheListEntries != null)
				return false;
		} else if (!CCSIDofDataInTheListEntries
				.equals(other.CCSIDofDataInTheListEntries))
			return false;
		if (apiUsed == null) {
			if (other.apiUsed != null)
				return false;
		} else if (!apiUsed.equals(other.apiUsed))
			return false;
		if (countryOrRegionID == null) {
			if (other.countryOrRegionID != null)
				return false;
		} else if (!countryOrRegionID.equals(other.countryOrRegionID))
			return false;
		if (dateAndTimeCreated == null) {
			if (other.dateAndTimeCreated != null)
				return false;
		} else if (!dateAndTimeCreated.equals(other.dateAndTimeCreated))
			return false;
		if (formatName == null) {
			if (other.formatName != null)
				return false;
		} else if (!formatName.equals(other.formatName))
			return false;
		if (informationStatus == null) {
			if (other.informationStatus != null)
				return false;
		} else if (!informationStatus.equals(other.informationStatus))
			return false;
		if (languageID == null) {
			if (other.languageID != null)
				return false;
		} else if (!languageID.equals(other.languageID))
			return false;
		if (numberOfListEntries == null) {
			if (other.numberOfListEntries != null)
				return false;
		} else if (!numberOfListEntries.equals(other.numberOfListEntries))
			return false;
		if (offsetToHeaderSection == null) {
			if (other.offsetToHeaderSection != null)
				return false;
		} else if (!offsetToHeaderSection.equals(other.offsetToHeaderSection))
			return false;
		if (offsetToInputParameterSection == null) {
			if (other.offsetToInputParameterSection != null)
				return false;
		} else if (!offsetToInputParameterSection
				.equals(other.offsetToInputParameterSection))
			return false;
		if (offsetToListDataSection == null) {
			if (other.offsetToListDataSection != null)
				return false;
		} else if (!offsetToListDataSection
				.equals(other.offsetToListDataSection))
			return false;
		if (reservedLFMT0100 == null) {
			if (other.reservedLFMT0100 != null)
				return false;
		} else if (!reservedLFMT0100.equals(other.reservedLFMT0100))
			return false;
		if (sizeOfEachEntry == null) {
			if (other.sizeOfEachEntry != null)
				return false;
		} else if (!sizeOfEachEntry.equals(other.sizeOfEachEntry))
			return false;
		if (sizeOfGenericHeader == null) {
			if (other.sizeOfGenericHeader != null)
				return false;
		} else if (!sizeOfGenericHeader.equals(other.sizeOfGenericHeader))
			return false;
		if (sizeOfHeaderSection == null) {
			if (other.sizeOfHeaderSection != null)
				return false;
		} else if (!sizeOfHeaderSection.equals(other.sizeOfHeaderSection))
			return false;
		if (sizeOfInputParameterSection == null) {
			if (other.sizeOfInputParameterSection != null)
				return false;
		} else if (!sizeOfInputParameterSection
				.equals(other.sizeOfInputParameterSection))
			return false;
		if (sizeOfListDataSection == null) {
			if (other.sizeOfListDataSection != null)
				return false;
		} else if (!sizeOfListDataSection.equals(other.sizeOfListDataSection))
			return false;
		if (sizeOfUserSpaceUsed == null) {
			if (other.sizeOfUserSpaceUsed != null)
				return false;
		} else if (!sizeOfUserSpaceUsed.equals(other.sizeOfUserSpaceUsed))
			return false;
		if (structureReleaseAndLevel == null) {
			if (other.structureReleaseAndLevel != null)
				return false;
		} else if (!structureReleaseAndLevel
				.equals(other.structureReleaseAndLevel))
			return false;
		if (subsettedListIndicator == null) {
			if (other.subsettedListIndicator != null)
				return false;
		} else if (!subsettedListIndicator.equals(other.subsettedListIndicator))
			return false;
		if (userArea == null) {
			if (other.userArea != null)
				return false;
		} else if (!userArea.equals(other.userArea))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" User Area: " + userArea.trim());
		sb.append(" Size of Generic Header: " + sizeOfGenericHeader.toString());
		sb.append(" Structure Release and Level: " + structureReleaseAndLevel.trim());
		sb.append(" Format Name: " + formatName.trim());
		sb.append(" API Used: " + apiUsed.trim());
		sb.append(" Date and Time Created: " + dateAndTimeCreated.trim());
		sb.append(" Information Status: " + informationStatus.trim());
		sb.append(" Size of User Space Used: " + sizeOfUserSpaceUsed.toString());
		sb.append(" Offset to Input Parameter Section: " + offsetToInputParameterSection.toString());
		sb.append(" Size of Input Parameter Section: " + sizeOfInputParameterSection.toString());
		sb.append(" Offset to Header Section: " + offsetToHeaderSection.toString());
		sb.append(" Size of Header Section: " + sizeOfHeaderSection.toString());
		sb.append(" Offset to List Data Section: " + offsetToListDataSection.toString());
		sb.append(" Size of List Data Section: " + sizeOfListDataSection.toString());
		sb.append(" Number of List Entries: " + numberOfListEntries.toString());
		sb.append(" Size of Each Entry: " + sizeOfEachEntry.toString());
		sb.append(" CCSID of Data in the List Entries: " + CCSIDofDataInTheListEntries.toString());
		sb.append(" Country or Region ID: " + countryOrRegionID.trim());
		sb.append(" Language ID: " + languageID.trim());
		sb.append(" Subsetted List Indicator: " + subsettedListIndicator.trim());
		sb.append(" Reserved (LFMT0100): " + reservedLFMT0100.trim());

		return sb.toString();
	}
	
	
}
