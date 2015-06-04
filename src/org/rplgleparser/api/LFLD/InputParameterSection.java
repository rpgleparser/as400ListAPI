package org.rplgleparser.api.LFLD;

import java.io.Serializable;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class InputParameterSection implements IInputParameterSection, FLDLoutputFormat, Serializable{
	/**
	 * 
	 */
	protected static final long serialVersionUID = -3510681956799462293L;
	// Input Parameter Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) User space name
	protected transient AS400Text userSpaceNameSpecifiedx = new AS400Text(10);
	// 10 A CHAR(10) User space library name
	protected transient AS400Text userSpaceLibraryNamex = new AS400Text(10);

	// 20 14 CHAR(8) Format name
	protected transient AS400Text formatNameSpecifiedx = new AS400Text(8);
	// 28 1C CHAR(10) File name specified
	protected transient AS400Text fileNameSpecifiedx = new AS400Text(10);
	// 38 26 CHAR(10) File library name specified
	protected transient AS400Text fileLibraryNameSpecifiedx = new AS400Text(10);
	// 48 30 CHAR(10) Record format name specified
	protected transient AS400Text recordFormatNameSpecifiedx = new AS400Text(10);
	// 58 3A CHAR(1) Override processing
	protected transient AS400Text overrideProcessingSpecifiedx = new AS400Text(1);
	protected transient AS400DataType[] inputParameterSectiona = new AS400DataType[] {
			userSpaceNameSpecifiedx, 
			userSpaceLibraryNamex, 
			formatNameSpecifiedx,
			fileNameSpecifiedx, 
			fileLibraryNameSpecifiedx,
			recordFormatNameSpecifiedx, 
			overrideProcessingSpecifiedx 
			};
	protected transient AS400Structure inputParameterSectionx = new AS400Structure(
			inputParameterSectiona);
	protected String userSpaceNameSpecified;
	protected String userSpaceLibraryName;
	protected String formatNameSpecified;
	protected String fileNameSpecified;
	protected String fileLibraryNameSpecified;
	protected String recordFormatNameSpecified;
	protected String overrideProcessingSpecified;

	public InputParameterSection(){
		// Default constructor
	}
	
	public InputParameterSection(byte[] input){
		Object[] o = (Object[]) inputParameterSectionx.toObject(input);
		userSpaceNameSpecified = (String)o[0];
		userSpaceLibraryName = (String)o[1];
		formatNameSpecified = (String)o[2];
		fileNameSpecified = (String)o[3];
		fileLibraryNameSpecified = (String)o[4];
		recordFormatNameSpecified = (String)o[5];
		overrideProcessingSpecified = (String)o[6];
	}

	public String getUserSpaceNameSpecified() {
		return userSpaceNameSpecified;
	}

	public String getUserSpaceLibraryName() {
		return userSpaceLibraryName;
	}

	public String getFormatNameSpecified() {
		return formatNameSpecified;
	}

	public String getFileNameSpecified() {
		return fileNameSpecified;
	}

	public String getFileLibraryNameSpecified() {
		return fileLibraryNameSpecified;
	}

	public String getRecordFormatNameSpecified() {
		return recordFormatNameSpecified;
	}

	public String getOverrideProcessingSpecified() {
		return overrideProcessingSpecified;
	}

	@SuppressWarnings("unchecked")
	public <T extends FLDLoutputFormat> T fromByteArray(byte[] input) {
		return (T) new InputParameterSection(input);
	}

}
