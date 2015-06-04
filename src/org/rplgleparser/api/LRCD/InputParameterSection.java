package org.rplgleparser.api.LRCD;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class InputParameterSection implements IInputParameterSection, RCDLoutputFormat{
	// Input Parameter Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) User space name
	protected AS400Text userSpaceNamex = new AS400Text(10);

	// 10 A CHAR(10) User space library name
	protected AS400Text userSpaceLibraryNamex = new AS400Text(10);

	// 20 14 CHAR(8) Format name
	protected AS400Text formatNameSpecifiedx = new AS400Text(10);
	// 28 1C CHAR(10) File name specified
	protected AS400Text fileNameSpecifiedx = new AS400Text(10);
	// 38 26 CHAR(10) File library name specified
	protected AS400Text fileLibraryNameSpecifiedx = new AS400Text(10);
	// 48 30 CHAR(1) Override processing
	protected AS400Text overrideProcessingSpecifiedx = new AS400Text(1);
	protected AS400DataType[] inputParameterSectiona = new AS400DataType[] {
			userSpaceNamex, 
			userSpaceLibraryNamex, 
			formatNameSpecifiedx,
			fileNameSpecifiedx, 
			fileLibraryNameSpecifiedx,
			overrideProcessingSpecifiedx 
			};
	protected AS400Structure inputParameterSectionx = new AS400Structure(
			inputParameterSectiona);

	protected String userSpaceName;

	protected String userSpaceLibraryName;

	protected String formatNameSpecified;

	protected String fileNameSpecified;

	protected String fileLibraryNameSpecified;

	protected String overrideProcessingSpecified;
	/**
	 * @return the userSpaceName
	 */
	public String getUserSpaceName() {
		return userSpaceName;
	}
	/**
	 * @return the userSpaceLibraryName
	 */
	public String getUserSpaceLibraryName() {
		return userSpaceLibraryName;
	}
	/**
	 * @return the formatNameSpecified
	 */
	public String getFormatNameSpecified() {
		return formatNameSpecified;
	}
	/**
	 * @return the fileNameSpecified
	 */
	public String getFileNameSpecified() {
		return fileNameSpecified;
	}
	/**
	 * @return the fileLibraryNameSpecified
	 */
	public String getFileLibraryNameSpecified() {
		return fileLibraryNameSpecified;
	}
	/**
	 * @return the overrideProcessingSpecified
	 */
	public String getOverrideProcessingSpecified() {
		return overrideProcessingSpecified;
	}
	public InputParameterSection(){
		// Default Constructor
	}
	public InputParameterSection(byte[] input){
		Object[] o = (Object[]) inputParameterSectionx.toObject(input);
		userSpaceName = (String)o[0];
		userSpaceLibraryName = (String)o[1]; 
		formatNameSpecified = (String)o[2];
		fileNameSpecified = (String)o[3];
		fileLibraryNameSpecified = (String)o[4];
		overrideProcessingSpecified = (String)o[5];
	}
	public <T extends RCDLoutputFormat> T fromByteArray(byte[] input) {
		// TODO Auto-generated method stub
		return ((T) new InputParameterSection(input));
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UserSpace Name: " + userSpaceName.trim());
		sb.append(" UserSpace Libary: " + userSpaceLibraryName.trim()); 
		sb.append(" Format Name Specified: " + formatNameSpecified.trim());
		sb.append(" File Name Specified: " + fileNameSpecified.trim());
		sb.append(" File Library Specified: " + fileLibraryNameSpecified.trim());
		sb.append(" Override Processing Specified: " + overrideProcessingSpecified.trim());
		return sb.toString();
	}
	

}
