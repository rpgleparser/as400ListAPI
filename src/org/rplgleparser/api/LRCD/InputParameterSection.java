package org.rplgleparser.api.LRCD;

import java.io.Serializable;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * Implementation class for the Input Parameter Section of the QUSLRCD API. Currently not used 
 * in the main code but provided so you can take a byte[] from the user space and get the data
 * @author Eric N. Wilson
 *
 */

public class InputParameterSection implements IInputParameterSection, RCDLoutputFormat, Serializable{
	private static final long serialVersionUID = 4521620229406171438L;

	// Input Parameter Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) User space name
	protected transient AS400Text userSpaceNamex = new AS400Text(10);

	// 10 A CHAR(10) User space library name
	protected transient AS400Text userSpaceLibraryNamex = new AS400Text(10);

	// 20 14 CHAR(8) Format name
	protected transient AS400Text formatNameSpecifiedx = new AS400Text(10);
	// 28 1C CHAR(10) File name specified
	protected transient AS400Text fileNameSpecifiedx = new AS400Text(10);
	// 38 26 CHAR(10) File library name specified
	protected transient AS400Text fileLibraryNameSpecifiedx = new AS400Text(10);
	// 48 30 CHAR(1) Override processing
	protected transient AS400Text overrideProcessingSpecifiedx = new AS400Text(1);
	protected transient AS400DataType[] inputParameterSectiona = new AS400DataType[] {
			userSpaceNamex, 
			userSpaceLibraryNamex, 
			formatNameSpecifiedx,
			fileNameSpecifiedx, 
			fileLibraryNameSpecifiedx,
			overrideProcessingSpecifiedx 
			};
	protected transient AS400Structure inputParameterSectionx = new AS400Structure(
			inputParameterSectiona);

	protected String userSpaceName;

	protected String userSpaceLibraryName;

	protected String formatNameSpecified;

	protected String fileNameSpecified;

	protected String fileLibraryNameSpecified;

	protected String overrideProcessingSpecified;
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputParameterSection other = (InputParameterSection) obj;
		if (fileLibraryNameSpecified == null) {
			if (other.fileLibraryNameSpecified != null)
				return false;
		} else if (!fileLibraryNameSpecified
				.equals(other.fileLibraryNameSpecified))
			return false;
		if (fileNameSpecified == null) {
			if (other.fileNameSpecified != null)
				return false;
		} else if (!fileNameSpecified.equals(other.fileNameSpecified))
			return false;
		if (formatNameSpecified == null) {
			if (other.formatNameSpecified != null)
				return false;
		} else if (!formatNameSpecified.equals(other.formatNameSpecified))
			return false;
		if (overrideProcessingSpecified == null) {
			if (other.overrideProcessingSpecified != null)
				return false;
		} else if (!overrideProcessingSpecified
				.equals(other.overrideProcessingSpecified))
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
	public <T extends RCDLoutputFormat> T fromByteArray(byte[] input) {
		// TODO Auto-generated method stub
		return ((T) new InputParameterSection(input));
	}
	/**
	 * @return the fileLibraryNameSpecified
	 */
	public String getFileLibraryNameSpecified() {
		return fileLibraryNameSpecified;
	}
	/**
	 * @return the fileNameSpecified
	 */
	public String getFileNameSpecified() {
		return fileNameSpecified;
	}
	/**
	 * @return the formatNameSpecified
	 */
	public String getFormatNameSpecified() {
		return formatNameSpecified;
	}
	/**
	 * @return the overrideProcessingSpecified
	 */
	public String getOverrideProcessingSpecified() {
		return overrideProcessingSpecified;
	}
	
	/**
	 * @return the userSpaceLibraryName
	 */
	public String getUserSpaceLibraryName() {
		return userSpaceLibraryName;
	}

	/**
	 * @return the userSpaceName
	 */
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
		sb.append("UserSpace Name: " + userSpaceName.trim());
		sb.append(" UserSpace Libary: " + userSpaceLibraryName.trim()); 
		sb.append(" Format Name Specified: " + formatNameSpecified.trim());
		sb.append(" File Name Specified: " + fileNameSpecified.trim());
		sb.append(" File Library Specified: " + fileLibraryNameSpecified.trim());
		sb.append(" Override Processing Specified: " + overrideProcessingSpecified.trim());
		return sb.toString();
	}
	

}
