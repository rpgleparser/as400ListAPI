package org.rplgleparser.api.LRCD;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * Implementation class for the header section of the QUSLRCD API. Currently not used 
 * in the main code but provided so you can take a byte[] from the user space and get the data
 * @author Eric N. Wilson
 *
 */

public class HeaderSection implements RCDLoutputFormat, IHeaderSection, Serializable {
	private static final long serialVersionUID = 1846046530937239306L;
	// Header Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) File name used
	private AS400Text fileNameUsedx = new AS400Text(10);
	// 10 A CHAR(10) File library name used
	private AS400Text fileLibraryNameUsedx = new AS400Text(10);
	// 20 14 CHAR(10) File type
	private AS400Text fileTypex = new AS400Text(10);
	// 30 1E CHAR(50) File text description
	private AS400Text fileTextDescriptionx = new AS400Text(50);
	// 80 50 BINARY(4) File text description CCSID
	private AS400Bin4 fileTextDescriptionCCSIDx = new AS400Bin4();
	// 84 54 CHAR (13) File creation date
	private AS400Text fileCreationDatex = new AS400Text(13);
	private AS400DataType[] headerSectiona = new AS400DataType[] { 
			fileNameUsedx,
			fileLibraryNameUsedx, 
			fileTypex, 
			fileTextDescriptionx,
			fileTextDescriptionCCSIDx, 
			fileCreationDatex 
			};
	private AS400Structure headerSectionx = new AS400Structure(headerSectiona);
	private String fileNameUsed;
	private String fileLibraryNameUsed;
	private String fileType;
	private String fileTextDescription;
	private Integer fileTextDescriptionCCSID;
	private String fileCreationDate;
	
	public HeaderSection(){
		// Default Constructor
	}
	
	public HeaderSection(byte[] input){
		Object[] o = (Object[]) headerSectionx.toObject(input);
		fileNameUsed = (String)o[0];
		fileLibraryNameUsed = (String)o[1]; 
		fileType = (String)o[2]; 
		fileTextDescription = (String)o[3];
		fileTextDescriptionCCSID = (Integer)o[4]; 
		fileCreationDate = (String)o[5];

	}
	
	@SuppressWarnings("unchecked")
	public <T extends RCDLoutputFormat> T fromByteArray(byte[] input) {
		// TODO Auto-generated method stub
		return ((T) new HeaderSection(input));
	}

	public String getFileNameUsed() {
		return fileNameUsed;
	}

	public String getFileLibraryNameUsed() {
		return fileLibraryNameUsed;
	}

	public String getFileType() {
		return fileType;
	}

	public String getFileTextDescription() {
		return fileTextDescription;
	}

	public Integer getFileTextDescriptionCCSID() {
		return fileTextDescriptionCCSID;
	}

	public String getFileCreationDate() {
		return fileCreationDate;
	}



}
