package org.rpgleparser.api;

import java.io.Serializable;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class LFMT0300 extends LFMT0100 implements ILFMT0300, Serializable {
	private static final long serialVersionUID = 9024440349948972869L;

	// Generic header format 0300
	// Format 0300 is for the list APIs that are called as procedures exported
	// from ILE service programs (*SRVPGM).
	/** 0 0 Everything from the 0100 format */
	/** 192 C0 CHAR(256) API entry point name */
	protected transient AS400Text apiEntryPointNamex = new AS400Text(256);

	/** 448 1C0 CHAR(128) Reserved */
	protected transient AS400Text reservedLFMT0300x = new AS400Text(128);

	protected transient AS400DataType[] LFMT0300a = new AS400DataType[] { 
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
			reservedLFMT0100x, 
			apiEntryPointNamex, 
			reservedLFMT0300x 
			};

	protected transient AS400Structure LFMT0300x = new AS400Structure(LFMT0300a);

	private String apiEntryPointName;

	private String reservedLFMT0300;

	public LFMT0300(){
		//Default constructor
	}
	
	public LFMT0300(byte[] input){
		Object[] o = (Object[]) LFMT0300x.toObject(input);
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
		apiEntryPointName = (String)o[21]; 
		reservedLFMT0300 = (String)o[22];
	}

	public AS400Structure getLFMT0300x() {
		return LFMT0300x;
	}

	public String getApiEntryPointName() {
		return apiEntryPointName;
	}

	public String getReservedLFMT0300() {
		return reservedLFMT0300;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
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
		sb.append(" API Entry Point Name: " + apiEntryPointName.trim()); 
		sb.append(" Reserved (LFMT0300): " + reservedLFMT0300.trim());
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LFMT0300 other = (LFMT0300) obj;
		if (apiEntryPointName == null) {
			if (other.apiEntryPointName != null)
				return false;
		} else if (!apiEntryPointName.equals(other.apiEntryPointName))
			return false;
		if (reservedLFMT0300 == null) {
			if (other.reservedLFMT0300 != null)
				return false;
		} else if (!reservedLFMT0300.equals(other.reservedLFMT0300))
			return false;
		return true;
	}

	
}
