package org.rplgleparser.api.LRCD;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class HeaderSection {
	// Header Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) File name used
	private AS400Text fileNameUsed = new AS400Text(10);
	// 10 A CHAR(10) File library name used
	private AS400Text fileLibraryNameUsed = new AS400Text(10);
	// 20 14 CHAR(10) File type
	private AS400Text fileType = new AS400Text(10);
	// 30 1E CHAR(50) File text description
	private AS400Text fileTextDescription = new AS400Text(50);
	// 80 50 BINARY(4) File text description CCSID
	private AS400Bin4 fileTextDescriptionCCSID = new AS400Bin4();
	// 84 54 CHAR (13) File creation date
	private AS400Text fileCreationDate = new AS400Text(13);
	private AS400DataType[] headerSectiona = new AS400DataType[] { fileNameUsed,
			fileLibraryNameUsed, fileType, fileTextDescription,
			fileTextDescriptionCCSID, fileCreationDate };
	private AS400Structure headerSection = new AS400Structure(headerSectiona);



}
