package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class InputParameterSection implements IInputParameterSection, OBJLoutputFormat, Serializable{
	protected static final long serialVersionUID = 4621724070806721581L;

	// Input Parameter Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) User space name
	protected transient AS400Text userSpaceNamex = new AS400Text(10);

	// 10 A CHAR(10) User space library name
	protected transient AS400Text userSpaceLibraryNamex = new AS400Text(10);

	// 20 14 CHAR(8) Format name
	protected transient AS400Text formatNamex = new AS400Text(8);

	// 28 1C CHAR(10) Object name specified
	protected transient AS400Text objectNameSpecifiedx = new AS400Text(10);

	// 38 26 CHAR(10) Object library name specified
	protected transient AS400Text objectLibraryNameSpecifiedx = new AS400Text(10);

	// 48 30 CHAR(10) Object type specified
	protected transient AS400Text objectTypeSpecifiedx = new AS400Text(10);

	// 58 3A CHAR(2) Reserved
	protected transient AS400Text reservedInputParameterSectionx = new AS400Text(2);

	// 60 3C BINARY(4) Error code bytes provided
	protected transient AS400Bin4 errorCodeBytesProvidedx = new AS400Bin4();

	// 64 40 BINARY(4) Length of authority control format
	protected transient AS400Bin4 lengthOfAuthorityControlFormatx = new AS400Bin4();

	// 68 44 BINARY(4) Call level
	protected transient AS400Bin4 callLevelx = new AS400Bin4();

	// 72 48 BINARY(4) Displacement to object authorities
	protected transient AS400Bin4 displacementToObjectAuthoritiesx = new AS400Bin4();

	// 76 4C BINARY(4) Number of object authorities
	protected transient AS400Bin4 numberOfObjectAuthoritiesx = new AS400Bin4();

	// 80 50 BINARY(4) Displacement to library authorities
	protected transient AS400Bin4 displacementToLibraryAuthoritiesx = new AS400Bin4();

	// 84 54 BINARY(4) Number of library authorities
	protected transient AS400Bin4 numberOfLibraryAuthoritiesx = new AS400Bin4();

	// 88 58 BINARY(4) Length of selection control format
	protected transient AS400Bin4 lengthOfSelectionControlFormatx = new AS400Bin4();

	// 92 5C BINARY(4) Select or omit status value
	protected transient AS400Bin4 selectOrOmitStatusValuex = new AS400Bin4();

	// 96 60 BINARY(4) Displacement to statuses
	protected transient AS400Bin4 displacementToStatusesx = new AS400Bin4();

	// 100 64 BINARY(4) Number of statuses
	protected transient AS400Bin4 numberOfStatusesx = new AS400Bin4();

	// 104 68 BINARY(4) Length of auxiliary storage pool (ASP) control format
	protected transient AS400Bin4 lengthOfASPControlFormatx = new AS400Bin4();

	// 108 6C CHAR(10) Auxiliary storage pool (ASP) device name
	protected transient AS400Text ASPDeviceNamex = new AS400Text(10);

	// 118 76 CHAR(10) Auxiliary storage pool (ASP) search type
	protected transient AS400Text ASPSearchTypex = new AS400Text(10);

	protected transient AS400DataType[] inputParameterSectiona = new AS400DataType[] {
			userSpaceNamex, 
			userSpaceLibraryNamex, 
			formatNamex,
			objectNameSpecifiedx, 
			objectLibraryNameSpecifiedx,
			objectTypeSpecifiedx, 
			reservedInputParameterSectionx,
			errorCodeBytesProvidedx, 
			lengthOfAuthorityControlFormatx,
			callLevelx, 
			displacementToObjectAuthoritiesx,
			numberOfObjectAuthoritiesx, 
			displacementToLibraryAuthoritiesx,
			numberOfLibraryAuthoritiesx, 
			lengthOfSelectionControlFormatx,
			selectOrOmitStatusValuex,
			displacementToStatusesx, 
			numberOfStatusesx,
			lengthOfASPControlFormatx, 
			ASPDeviceNamex, 
			ASPSearchTypex 
			};

	protected transient AS400Structure InputParameterSectionx = new AS400Structure(inputParameterSectiona);
	
	protected String ASPSearchType;
	// ARRAY(*) of CHAR(10) Object authorities
	// ARRAY(*) of CHAR(10) Library authorities
	// ARRAY(*) of CHAR(1) Statuses

	protected String ASPDeviceName;

	protected Integer lengthOfAuxillaryStoragePoolControlFormat;

	protected Integer numberOfStatuses;

	protected Integer displacementToStatuses;

	protected Integer selectOrOmitStatusValue;

	protected Integer lengthOfSelectionControlFormat;

	protected Integer numberOfLibraryAuthorities;

	protected Integer displacementToLibraryAuthorities;

	protected Integer numberOfObjectAuthorities;

	protected Integer displacementToObjectAuthorities;

	protected Integer callLevelSpecified;

	protected Integer lengthOfAuthorityControlFormatSpecified;

	protected Integer errorCodeBytesProvided;

	protected String reservedInputParameterSection;

	protected String objectTypeSpecified;

	protected String objectLibraryNameSpecified;

	protected String objectNameSpecified;

	protected String formatName;

	protected String userSpaceLibraryName;

	protected String userSpaceName;

	public InputParameterSection(){
		//Default constructor
	}
	
	public InputParameterSection(byte[] input){
		Object[] o = (Object[])InputParameterSectionx.toObject(input);
		userSpaceName = (String)o[0]; 
		userSpaceLibraryName = (String)o[1];
		formatName = (String)o[2];
		objectNameSpecified = (String)o[3];
		objectLibraryNameSpecified = (String)o[4];
		objectTypeSpecified = (String)o[5];
		reservedInputParameterSection = (String)o[6];
		errorCodeBytesProvided = (Integer)o[7];
		lengthOfAuthorityControlFormatSpecified = (Integer)o[8];
		callLevelSpecified = (Integer)o[9];
		displacementToObjectAuthorities = (Integer)o[10];
		numberOfObjectAuthorities = (Integer)o[11];
		displacementToLibraryAuthorities = (Integer)o[12];
		numberOfLibraryAuthorities = (Integer)o[13];
		lengthOfSelectionControlFormat = (Integer)o[14];
		selectOrOmitStatusValue = (Integer)o[15];
		displacementToStatuses = (Integer)o[16];
		numberOfStatuses = (Integer)o[17];
		lengthOfAuxillaryStoragePoolControlFormat = (Integer)o[18];
		ASPDeviceName = (String)o[19];
		ASPSearchType = (String)o[20];
	}
	
	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new InputParameterSection(input));
	}

	public String getUserSpaceName() {
		return userSpaceName;
	}

	public String getUserSpaceLibraryName() {
		return userSpaceLibraryName;
	}

	public String getFormatName() {
		return formatName;
	}

	public String getObjectNameSpecified() {
		return objectNameSpecified;
	}

	public String getObjectLibraryNameSpecified() {
		return objectLibraryNameSpecified;
	}

	public String getObjectTypeSpecified() {
		return objectTypeSpecified;
	}

	public String getReservedInputParameterSection() {
		return reservedInputParameterSection;
	}

	public Integer getErrorCodeBytesProvided() {
		return errorCodeBytesProvided;
	}

	public Integer getLengthOfAuthorityControlFormatSpecified() {
		return lengthOfAuthorityControlFormatSpecified;
	}

	public Integer getCallLevelSpecified() {
		return callLevelSpecified;
	}

	public Integer getDisplacementToObjectAuthoritiesz() {
		return displacementToObjectAuthorities;
	}

	public Integer getNumberOfObjectAuthorities() {
		return numberOfObjectAuthorities;
	}

	public Integer getDisplacementToLibraryAuthorities() {
		return displacementToLibraryAuthorities;
	}

	public Integer getNumberOfLibraryAuthorities() {
		return numberOfLibraryAuthorities;
	}

	public Integer getLengthOfSelectionControlFormat() {
		return lengthOfSelectionControlFormat;
	}

	public Integer getSelectOrOmitStatusValue() {
		return selectOrOmitStatusValue;
	}

	public Integer getDisplacementToStatuses() {
		return displacementToStatuses;
	}

	public Integer getNumberOfStatuses() {
		return numberOfStatuses;
	}

	public Integer getLengthOfAuxillaryStoragePoolControlFormat() {
		return lengthOfAuxillaryStoragePoolControlFormat;
	}

	public String getASPDeviceName() {
		return ASPDeviceName;
	}

	public String getASPSearchType() {
		return ASPSearchType;
	}

}
