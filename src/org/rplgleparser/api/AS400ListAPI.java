package org.rplgleparser.api;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.UserSpace;
/**
 * This class manages the movement through a user space, calling the user's function per entry. 
 * <li> The user is responsible to call the iSeries API using the UserSpace that is created here
 * <li> The user must also register the class that implements the ListApiCallback interface
 * <li> If the user chooses to stop processing the list they should return false from the callback function  
 * @author Eric N. Wilson
 *
 */
public class AS400ListAPI implements ListApiProvider {

	private class listenerEntry {
		private ListApiCallback theListener;
		private boolean isListening;

		public listenerEntry(ListApiCallback inCallback, boolean isListening) {
			this.theListener = inCallback;
			this.isListening = isListening;
		}
	}

	private UserSpace myUserSpace = new UserSpace();
	// Format 0100 is for the list APIs that are called as programs (*PGMs).
	/** 0 0 CHAR(64) User area */
	private AS400Text userArea = new AS400Text(64);
	/** 64 40 BINARY(4) Size of generic header */
	private AS400Bin4 sizeOfGenericHeader = new AS400Bin4();
	/** 68 44 CHAR(4) Structure's release and level */
	private AS400Text structureReleaseAndLevel = new AS400Text(4);
	/** 72 48 CHAR(8) Format name */
	private AS400Text formatName = new AS400Text(8);
	/** 80 50 CHAR(10) API used */
	private AS400Text apiUsed = new AS400Text(10);
	/** 90 5A CHAR(13) Date and time created */
	private AS400Text dateAndTimeCreated = new AS400Text(13);
	/** 103 67 CHAR(1) Information status */
	private AS400Text informationStatus = new AS400Text(1);
	/** 104 68 BINARY(4) Size of user space used */
	private AS400Bin4 sizeOfUserSpaceUsed = new AS400Bin4();
	/** 108 6C BINARY(4) Offset to input parameter section */
	private AS400Bin4 offsetToInputParameterSection = new AS400Bin4();
	/** 112 70 BINARY(4) Size of input parameter section */
	private AS400Bin4 sizeOfInputParameterSection = new AS400Bin4();
	/** 116 74 BINARY(4) Offset to header section */
	private AS400Bin4 offsetToHeaderSection = new AS400Bin4();
	/** 120 78 BINARY(4) Size of header section */
	private AS400Bin4 sizeOfHeaderSection = new AS400Bin4();
	/** 124 7C BINARY(4) Offset to list data section */
	private AS400Bin4 offsetToListDataSection = new AS400Bin4();

	private Integer offsetToListDataSectionj = new Integer(0);
	/** 128 80 BINARY(4) Size of list data section */
	private AS400Bin4 sizeOfListDataSection = new AS400Bin4();
	/** 132 84 BINARY(4) Number of list entries */
	private AS400Bin4 numberOfListEntries = new AS400Bin4();

	private Integer numberOfListEntriesj = new Integer(0);
	/** 136 88 BINARY(4) Size of each entry */
	private AS400Bin4 sizeOfEachEntry = new AS400Bin4();

	private Integer sizeOfEachEntryj = new Integer(0);
	/** 140 8C BINARY(4) CCSID of data in the list entries */
	private AS400Bin4 CCSIDofDataInTheListEntries = new AS400Bin4();
	/** 144 90 CHAR(2) Country or region ID */
	private AS400Text countryOrRegionID = new AS400Text(2);
	/** 146 92 CHAR(3) Language ID */
	private AS400Text languageID = new AS400Text(3);
	/** 149 95 CHAR(1) Subsetted list indicator */
	private AS400Text subsettedListIndicator = new AS400Text(1);
	
	/** 150 96 CHAR(42) Reserved */
	private AS400Text reservedLFMT0100 = new AS400Text(42);

	private AS400DataType[] LFMT0100a = new AS400DataType[] { userArea,
			sizeOfGenericHeader, structureReleaseAndLevel, formatName, apiUsed,
			dateAndTimeCreated, informationStatus, sizeOfUserSpaceUsed,
			offsetToInputParameterSection, sizeOfInputParameterSection,
			offsetToHeaderSection, sizeOfHeaderSection,
			offsetToListDataSection, sizeOfListDataSection,
			numberOfListEntries, sizeOfEachEntry, CCSIDofDataInTheListEntries,
			countryOrRegionID, languageID, subsettedListIndicator,
			reservedLFMT0100 };
	
	private AS400Structure LFMT0100 = new AS400Structure(LFMT0100a);
	
	private AS400Bin4 payloadLength = new AS400Bin4();
	// Generic header format 0300
	// Format 0300 is for the list APIs that are called as procedures exported
	// from ILE service programs (*SRVPGM).
	/** 0 0 Everything from the 0100 format */
	/** 192 C0 CHAR(256) API entry point name */
	private AS400Text apiEntryPointName = new AS400Text(256);

	/** 448 1C0 CHAR(128) Reserved */
	private AS400Text reservedLFMT0300 = new AS400Text(128);

	private AS400DataType[] LFMT0300a = new AS400DataType[] { userArea,
			sizeOfGenericHeader, structureReleaseAndLevel, formatName, apiUsed,
			dateAndTimeCreated, informationStatus, sizeOfUserSpaceUsed,
			offsetToInputParameterSection, sizeOfInputParameterSection,
			offsetToHeaderSection, sizeOfHeaderSection,
			offsetToListDataSection, sizeOfListDataSection,
			numberOfListEntries, sizeOfEachEntry, CCSIDofDataInTheListEntries,
			countryOrRegionID, languageID, subsettedListIndicator,
			reservedLFMT0100, apiEntryPointName, reservedLFMT0300 };

	private AS400Structure LFMT0300 = new AS400Structure(LFMT0300a);
	// Format ERRC0100
	// Table 1. Format ERRC0100 for the error code parameter
	/** 0 0 INPUT BINARY(4) Bytes provided */
	private AS400Bin4 bytesProvided = new AS400Bin4();

	/** 4 4 OUTPUT BINARY(4) Bytes available */
	private AS400Bin4 bytesAvailable = new AS400Bin4();

	/** 8 8 OUTPUT CHAR(7) Exception ID */
	private AS400Text exceptionID = new AS400Text(7);

	/** 15 F OUTPUT CHAR(1) Reserved */
	private AS400Text ERRC0100Reserved = new AS400Text(1);
	/** 16 10 OUTPUT CHAR(*) Exception data */

	private AS400DataType[] ERRC0100a = new AS400DataType[] { bytesProvided,
			bytesAvailable, exceptionID, ERRC0100Reserved };
	public AS400Structure ERRC0100 = new AS400Structure(ERRC0100a);
	public Object[] ERRC0100j = new Object[] { new Integer(16), new Integer(0),
			" ", "" };
	// Format ERRC0200
	// Table 2. Format ERRC0200 for the error code parameter
	/** 0 0 INPUT BINARY(4) Key */
	private AS400Bin4 key = new AS400Bin4();
	/** 4 4 INPUT BINARY(4) Bytes provided */
	private AS400Bin4 bytesProvided0200 = new AS400Bin4();
	/** 8 8 OUTPUT BINARY(4) Bytes available */
	private AS400Bin4 bytesAvailable0200 = new AS400Bin4();

	/** 12 C OUTPUT CHAR(7) Exception ID */
	private AS400Text exceptionID0200 = new AS400Text(7);
	/** 19 13 OUTPUT CHAR(1) Reserved */
	private AS400Text reserved0200 = new AS400Text(1);
	/** 20 14 OUTPUT BINARY(4) CCSID of the CCHAR data */
	private AS400Bin4 CCSIDoftheCharData = new AS400Bin4();
	/** 24 18 OUTPUT BINARY(4) Offset to the exception data */
	private AS400Bin4 offsetToTheExceptionData = new AS400Bin4();
	/** 28 1C OUTPUT BINARY(4) Length of the exception data */
	private AS400Bin4 lengthOfExceptionData = new AS400Bin4();
	/** OUTPUT CHAR(*) Exception data */

	private AS400DataType[] ERRC0200a = new AS400DataType[] { key,
			bytesProvided0200, bytesAvailable0200, exceptionID0200,
			reserved0200, CCSIDoftheCharData, offsetToTheExceptionData,
			lengthOfExceptionData };

	private AS400Structure ERRC0200 = new AS400Structure(ERRC0200a);
	private AS400 theSystem = new AS400();

	private ProgramCall pc = new ProgramCall();

	private List<listenerEntry> notifyList = new ArrayList<listenerEntry>();

	public AS400ListAPI() {
		try {
			pc.setSystem(theSystem);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createUserSpace(String library, String name, int size,
			String description) throws AS400SecurityException,
			ErrorCompletingRequestException, InterruptedException, IOException,
			ObjectDoesNotExistException, PropertyVetoException {
		myUserSpace.setSystem(theSystem);
//		myUserSpace.setAutoExtendible(true);
		myUserSpace.setMustUseProgramCall(true);
		myUserSpace.setPath("/QSYS.LIB/" + library.trim() + ".LIB/"
				+ name.trim() + ".USRSPC");
		myUserSpace
				.create(size, true, "CONTROL", (byte) 0, description, "*ALL");
	}

	public void deleteUserSpace()
			throws AS400SecurityException, ErrorCompletingRequestException,
			InterruptedException, IOException, ObjectDoesNotExistException {
		myUserSpace.delete();
	}

	public void deregisterCallback(ListApiCallback theClass) {
		for (int i = 0; i < notifyList.size(); i++) {
			if (notifyList.get(i).theListener == theClass) {
				notifyList.remove(i);
			}
		}
	}

	/**
	 * @return the pc
	 */
	public ProgramCall getPc() {
		return pc;
	}

	/**
	 * @return the theSystem
	 */
	public AS400 getTheSystem() {
		return theSystem;
	}

	/**
	 * @return the myUserSpace
	 */
	public UserSpace getUserSpace() {
		return myUserSpace;
	}
	
	private boolean isAnyoneListening() {
		boolean result = false;
		for (listenerEntry c : notifyList) {
			if (c.isListening) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void readUserSpace()
			throws PropertyVetoException, AS400SecurityException,
			ErrorCompletingRequestException, IOException, InterruptedException,
			ObjectDoesNotExistException {

		byte[] payload = new byte[LFMT0100.getByteLength()];
		int bytesRead = myUserSpace.read(payload, 0);
		boolean doMore = true;
		// First get the generic header to get the location, number and size
		// of the list entries
		Object[] o = (Object[]) LFMT0100.toObject(payload);

		offsetToListDataSectionj = (Integer) o[12];
		numberOfListEntriesj = (Integer) o[14];
		sizeOfEachEntryj = (Integer) o[15];

		int currentOffset = offsetToListDataSectionj.intValue();
		int listEntryCount = numberOfListEntriesj.intValue();
		int entrySize = sizeOfEachEntryj.intValue();
		boolean fixedLength = true;
		
		if (entrySize == 0){
			// Special handling for variable length entries
			// All Variable length sections have the length encoded in the first 4 bytes
			fixedLength = false;
			payload = new byte[payloadLength.getByteLength()];
			myUserSpace.read(payload, currentOffset);
			entrySize = payloadLength.toInt(payload);
			
		}
		payload = new byte[entrySize];
		
		
		for (int i = 0; i < listEntryCount; i++) {
			if (!fixedLength){
				payload = new byte[payloadLength.getByteLength()];
				myUserSpace.read(payload, currentOffset);
				entrySize = payloadLength.toInt(payload);
				payload = new byte[entrySize];
			}
			myUserSpace.read(payload, currentOffset);
			for (listenerEntry c : notifyList) {
				if (c.isListening) {
					doMore = c.theListener.processEntry(payload);
					if (!doMore) {
						c.isListening = doMore;
					}
				}
			}
			if (isAnyoneListening()) {

			} else {
				break;
			}
			currentOffset += entrySize;

		}		
		return;
	}

	public void registerCallback(ListApiCallback theClass) {
		boolean found = false;
		for (listenerEntry c : notifyList) {
			if (c.theListener == theClass) {
				found = true;
				break;
			}
		}
		if (found == false) {
			notifyList.add(new listenerEntry(theClass, true));
		}
	}

	/**
	 * @param pc
	 *            the pc to set
	 */
	public void setPc(ProgramCall pc) {
		this.pc = pc;
	}

	/**
	 * @param theSystem
	 *            the theSystem to set
	 */
	public void setTheSystem(AS400 theSystem) {
		this.theSystem = theSystem;
	}


}