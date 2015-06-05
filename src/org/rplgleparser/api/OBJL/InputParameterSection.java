package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * Implementation class for the Input Parameter Section of the QUSLOBJ API. Currently not used 
 * in the main code but provided so you can take a byte[] from the user space and get the data
 * @author Eric N. Wilson
 *
 */
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputParameterSection other = (InputParameterSection) obj;
		if (ASPDeviceName == null) {
			if (other.ASPDeviceName != null)
				return false;
		} else if (!ASPDeviceName.equals(other.ASPDeviceName))
			return false;
		if (ASPSearchType == null) {
			if (other.ASPSearchType != null)
				return false;
		} else if (!ASPSearchType.equals(other.ASPSearchType))
			return false;
		if (callLevelSpecified == null) {
			if (other.callLevelSpecified != null)
				return false;
		} else if (!callLevelSpecified.equals(other.callLevelSpecified))
			return false;
		if (displacementToLibraryAuthorities == null) {
			if (other.displacementToLibraryAuthorities != null)
				return false;
		} else if (!displacementToLibraryAuthorities
				.equals(other.displacementToLibraryAuthorities))
			return false;
		if (displacementToObjectAuthorities == null) {
			if (other.displacementToObjectAuthorities != null)
				return false;
		} else if (!displacementToObjectAuthorities
				.equals(other.displacementToObjectAuthorities))
			return false;
		if (displacementToStatuses == null) {
			if (other.displacementToStatuses != null)
				return false;
		} else if (!displacementToStatuses.equals(other.displacementToStatuses))
			return false;
		if (errorCodeBytesProvided == null) {
			if (other.errorCodeBytesProvided != null)
				return false;
		} else if (!errorCodeBytesProvided.equals(other.errorCodeBytesProvided))
			return false;
		if (formatName == null) {
			if (other.formatName != null)
				return false;
		} else if (!formatName.equals(other.formatName))
			return false;
		if (lengthOfAuthorityControlFormatSpecified == null) {
			if (other.lengthOfAuthorityControlFormatSpecified != null)
				return false;
		} else if (!lengthOfAuthorityControlFormatSpecified
				.equals(other.lengthOfAuthorityControlFormatSpecified))
			return false;
		if (lengthOfAuxillaryStoragePoolControlFormat == null) {
			if (other.lengthOfAuxillaryStoragePoolControlFormat != null)
				return false;
		} else if (!lengthOfAuxillaryStoragePoolControlFormat
				.equals(other.lengthOfAuxillaryStoragePoolControlFormat))
			return false;
		if (lengthOfSelectionControlFormat == null) {
			if (other.lengthOfSelectionControlFormat != null)
				return false;
		} else if (!lengthOfSelectionControlFormat
				.equals(other.lengthOfSelectionControlFormat))
			return false;
		if (numberOfLibraryAuthorities == null) {
			if (other.numberOfLibraryAuthorities != null)
				return false;
		} else if (!numberOfLibraryAuthorities
				.equals(other.numberOfLibraryAuthorities))
			return false;
		if (numberOfObjectAuthorities == null) {
			if (other.numberOfObjectAuthorities != null)
				return false;
		} else if (!numberOfObjectAuthorities
				.equals(other.numberOfObjectAuthorities))
			return false;
		if (numberOfStatuses == null) {
			if (other.numberOfStatuses != null)
				return false;
		} else if (!numberOfStatuses.equals(other.numberOfStatuses))
			return false;
		if (objectLibraryNameSpecified == null) {
			if (other.objectLibraryNameSpecified != null)
				return false;
		} else if (!objectLibraryNameSpecified
				.equals(other.objectLibraryNameSpecified))
			return false;
		if (objectNameSpecified == null) {
			if (other.objectNameSpecified != null)
				return false;
		} else if (!objectNameSpecified.equals(other.objectNameSpecified))
			return false;
		if (objectTypeSpecified == null) {
			if (other.objectTypeSpecified != null)
				return false;
		} else if (!objectTypeSpecified.equals(other.objectTypeSpecified))
			return false;
		if (reservedInputParameterSection == null) {
			if (other.reservedInputParameterSection != null)
				return false;
		} else if (!reservedInputParameterSection
				.equals(other.reservedInputParameterSection))
			return false;
		if (selectOrOmitStatusValue == null) {
			if (other.selectOrOmitStatusValue != null)
				return false;
		} else if (!selectOrOmitStatusValue
				.equals(other.selectOrOmitStatusValue))
			return false;
		if (userSpaceLibraryName == null) {
			if (other.userSpaceLibraryName != null)
				return false;
		} else if (!userSpaceLibraryName.equals(other.userSpaceLibraryName))
			return false;
		if (userSpaceName == null) {
			if (other.userSpaceName != null)
				return false;
		} else if (!userSpaceName.equals(other.userSpaceName))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new InputParameterSection(input));
	}

	public String getASPDeviceName() {
		return ASPDeviceName;
	}

	public String getASPSearchType() {
		return ASPSearchType;
	}

	public Integer getCallLevelSpecified() {
		return callLevelSpecified;
	}

	public Integer getDisplacementToLibraryAuthorities() {
		return displacementToLibraryAuthorities;
	}

	public Integer getDisplacementToObjectAuthoritiesz() {
		return displacementToObjectAuthorities;
	}

	public Integer getDisplacementToStatuses() {
		return displacementToStatuses;
	}

	public Integer getErrorCodeBytesProvided() {
		return errorCodeBytesProvided;
	}

	public String getFormatName() {
		return formatName;
	}

	public Integer getLengthOfAuthorityControlFormatSpecified() {
		return lengthOfAuthorityControlFormatSpecified;
	}

	public Integer getLengthOfAuxillaryStoragePoolControlFormat() {
		return lengthOfAuxillaryStoragePoolControlFormat;
	}

	public Integer getLengthOfSelectionControlFormat() {
		return lengthOfSelectionControlFormat;
	}

	public Integer getNumberOfLibraryAuthorities() {
		return numberOfLibraryAuthorities;
	}

	public Integer getNumberOfObjectAuthorities() {
		return numberOfObjectAuthorities;
	}

	public Integer getNumberOfStatuses() {
		return numberOfStatuses;
	}

	public String getObjectLibraryNameSpecified() {
		return objectLibraryNameSpecified;
	}

	public String getObjectNameSpecified() {
		return objectNameSpecified;
	}

	public String getObjectTypeSpecified() {
		return objectTypeSpecified;
	}

	public String getReservedInputParameterSection() {
		return reservedInputParameterSection;
	}

	public Integer getSelectOrOmitStatusValue() {
		return selectOrOmitStatusValue;
	}

	public String getUserSpaceLibraryName() {
		return userSpaceLibraryName;
	}

	public String getUserSpaceName() {
		return userSpaceName;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" User Space Name: "+ userSpaceName.trim()); 
		sb.append(" User Space Library Name: " + userSpaceLibraryName.trim());
		sb.append(" Format Name: " + formatName.trim());
		sb.append(" Object Name Specified: " + objectNameSpecified.trim());
		sb.append(" Object Library Name Specified: " + objectLibraryNameSpecified.trim());
		sb.append(" Object Type Specified: "+ objectTypeSpecified.trim());
		sb.append(" Reserved (Input Parameter Section): " + reservedInputParameterSection.toString());
		sb.append(" Error Code Bytes Provided: " + errorCodeBytesProvided.toString());
		sb.append(" Length of Authority Control Format Specified: " + lengthOfAuthorityControlFormatSpecified.toString());
		sb.append(" Call Level Specified: " + callLevelSpecified.toString());
		sb.append(" Displacement to Object Authorities: " + displacementToObjectAuthorities.toString());
		sb.append(" Number of Object Authorities: " + numberOfObjectAuthorities.toString());
		sb.append(" Displacement to Library Authorities: " + displacementToLibraryAuthorities.toString());
		sb.append(" Number of Library Authorities: " + numberOfLibraryAuthorities.toString());
		sb.append(" Length of Selection Control Format: " + lengthOfSelectionControlFormat.toString());
		sb.append(" Select or Omit Status Value: " + selectOrOmitStatusValue.toString());
		sb.append(" Displacement To Statuses: " + displacementToStatuses.toString());
		sb.append(" Number of Statuses: " + numberOfStatuses.toString());
		sb.append(" Length of ASP Control Format: " + lengthOfAuxillaryStoragePoolControlFormat.toString());
		sb.append(" ASP Device Name: " + ASPDeviceName.trim());
		sb.append(" ASP Search Type: " + ASPSearchType.trim());

		return sb.toString();
	}

}
