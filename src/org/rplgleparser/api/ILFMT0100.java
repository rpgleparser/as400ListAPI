package org.rplgleparser.api;

import com.ibm.as400.access.AS400Structure;

public interface ILFMT0100 {
	public AS400Structure getLFMT0100x();

	public String getUserArea();

	public Integer getSizeOfGenericHeader();

	public String getStructureReleaseAndLevel();

	public String getFormatName();

	public String getApiUsed();

	public String getDateAndTimeCreated();

	public String getInformationStatus();

	public Integer getSizeOfUserSpaceUsed();

	public Integer getOffsetToInputParameterSection();

	public Integer getSizeOfInputParameterSection();

	public Integer getOffsetToHeaderSection();

	public Integer getSizeOfHeaderSection();

	public Integer getOffsetToListDataSection();

	public Integer getSizeOfListDataSection();

	public Integer getNumberOfListEntries();

	public Integer getSizeOfEachEntry();

	public Integer getCCSIDofDataInTheListEntries();

	public String getCountryOrRegionID();

	public String getLanguageID();

	public String getSubsettedListIndicator();

	public String getReservedLFMT0100();

}
