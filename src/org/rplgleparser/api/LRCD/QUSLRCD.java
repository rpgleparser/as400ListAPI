package org.rplgleparser.api.LRCD;

import java.beans.PropertyVetoException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.rplgleparser.api.AS400ListAPI;
import org.rplgleparser.api.ListApiCallback;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;

public class QUSLRCD implements ListApiCallback {
	public static final String RCDL0100_FORMAT = "RCDL0100";
	
	public static final String RCDL0200_FORMAT = "RCDL0200";

	public static final String RCDL0300_FORMAT = "RCDL0300";

	public static void main(String[] args) {
		QUSLRCD myobj = new QUSLRCD();
		myobj.setAs400ToConnectTo("DEV400");
		myobj.setAs400UserName("EWILSON");
		myobj.setRequestedFormat(RCDL0100_FORMAT);
		myobj.setRequestOverrideProcessing(false);
		myobj.setSearchFileName("INWCTLP");
		myobj.setSearchLibrayName("INATSTDTA");
		myobj.setUserSpaceLibrary("EWILSON");
		myobj.setUserSpaceName("GARBAGE");
		myobj.setUserSpaceDescription("Temp Userspace");
		myobj.setUserSpaceSize(1024);
		myobj.dowork();
		System.exit(0);
	}

	protected String requestedFormat;

	protected AS400ListAPI theListHandler = new AS400ListAPI();

	protected String userSpaceLibrary;

	protected String userSpaceName;

	protected String searchFileName;

	protected String searchLibrayName;

	protected boolean requestOverrideProcessing;

	protected String as400ToConnectTo;

	protected String as400UserName;

	protected String as400UserPassword = null;

	// List Record Formats (QUSLRCD) API
	//
	//
	// Required Parameter Group:
	//
	// 1 Qualified user space name Input Char(20)
	protected AS400Text qualSpaceName = new AS400Text(20);

	// 2 Format name Input Char(8)
	protected AS400Text formatName = new AS400Text(8);

	// 3 Qualified file name Input Char(20)
	protected AS400Text qualFileName = new AS400Text(20);

	// 4 Override processing Input Char(1)
	protected AS400Text overrideProcessing = new AS400Text(1);

	//
	// Optional Parameter Group:
	//
	// 5 Error code I/O Char(*)
	protected AS400Structure ERRC0100 = theListHandler.ERRC0100;

	protected ProgramCall pc;
	protected int userSpaceSize;
	protected String userSpaceDescription;

	protected void createUserSpace() throws AS400SecurityException,
	ErrorCompletingRequestException, InterruptedException, IOException,
	ObjectDoesNotExistException, PropertyVetoException {
System.out.println("Creating User Space");
// Create the user space
theListHandler.createUserSpace(userSpaceLibrary, userSpaceName,
		userSpaceSize, userSpaceDescription);
}
	
	protected void dowork() {
		try {
			prepareConnection();
			createUserSpace();
			registerCallback();
			prepareProgramCall();

			// Run the program.
			if (pc.run() != true) {
				// Report failure.
				System.out.println("Program failed!");
				// Show the messages.
				AS400Message[] messagelist = pc.getMessageList();
				for (int i = 0; i < messagelist.length; ++i) {
					// Show each message.
					System.out.println(messagelist[i]);
				}

			} else {
				theListHandler.readUserSpace();
			}

			System.out.println("Deleting User Space");
			theListHandler.deleteUserSpace();
			theListHandler.deregisterCallback(this);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErrorCompletingRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the as400ToConnectTo
	 */
	public String getAs400ToConnectTo() {
		return as400ToConnectTo;
	}
	/**
	 * @return the as400UserName
	 */
	public String getAs400UserName() {
		return as400UserName;
	}
	/**
	 * @return the as400UserPassword
	 */
	public String getAs400UserPassword() {
		return as400UserPassword;
	}
	/**
	 * @return the overrideProcessing
	 */
	public AS400Text getOverrideProcessing() {
		return overrideProcessing;
	}
	/**
	 * @return the pc
	 */
	public ProgramCall getPc() {
		return pc;
	}
	/**
	 * @return the requestedFormat
	 */
	public String getRequestedFormat() {
		return requestedFormat;
	}
	/**
	 * @return the searchFileName
	 */
	public String getSearchFileName() {
		return searchFileName;
	}
	/**
	 * @return the searchLibrayName
	 */
	public String getSearchLibrayName() {
		return searchLibrayName;
	}


	// 5 Error Code I/O Char(*)

	/**
	 * @return the theListHandler
	 */
	public AS400ListAPI getTheListHandler() {
		return theListHandler;
	}
	/**
	 * @return the userSpaceDescription
	 */
	public String getUserSpaceDescription() {
		return userSpaceDescription;
	}
	/**
	 * @return the userSpaceLibrary
	 */
	public String getUserSpaceLibrary() {
		return userSpaceLibrary;
	}
	/**
	 * @return the userSpaceName
	 */
	public String getUserSpaceName() {
		return userSpaceName;
	}
	/**
	 * @return the userSpaceSize
	 */
	public int getUserSpaceSize() {
		return userSpaceSize;
	}
	/**
	 * @return the requestOverrideProcessing
	 */
	public boolean isRequestOverrideProcessing() {
		return requestOverrideProcessing;
	}
	protected void prepareConnection() throws PropertyVetoException {
		AS400 theSystem = theListHandler.getTheSystem();
		pc = theListHandler.getPc();
		theSystem.setSystemName("DEV400");
		theSystem.setUserId("EWILSON");
	}
	protected void prepareProgramCall() throws PropertyVetoException {
		// Call the list API
//			 Required Parameter Group:
//
//				 1	Qualified user space name	Input	Char(20)
//				 2	Format name	Input	Char(8)
//				 3	Qualified file name	Input	Char(20)
//				 4	Override processing	Input	Char(1)
//
//				   Optional Parameter Group:
//
//				 5	Error code	I/O	Char(*)
		
		String programName = "/QSYS.LIB/QUSLRCD.PGM";
		String uspName = StringUtils.rightPad(userSpaceName, 10)
				+ StringUtils.rightPad(userSpaceLibrary, 10);
		String searchName = StringUtils.rightPad(searchFileName, 10)
				+ StringUtils.rightPad(searchLibrayName, 10);
		ProgramParameter[] parameterList = new ProgramParameter[5];
		parameterList[0] = new ProgramParameter(qualSpaceName.toBytes(uspName));
		parameterList[1] = new ProgramParameter(formatName.toBytes(requestedFormat));
		parameterList[2] = new ProgramParameter(qualFileName.toBytes(searchName));
		String toOverride;
		if (requestOverrideProcessing){
			toOverride = "1";
		} else {
			toOverride = "0";
		}
		parameterList[3] = new ProgramParameter(overrideProcessing.toBytes(toOverride));
		parameterList[4] = new ProgramParameter(
				ERRC0100.toBytes(theListHandler.ERRC0100j));
		parameterList[4].setOutputDataLength(ERRC0100.getByteLength());

		pc.setProgram(programName, parameterList);
	}

	public boolean processEntry(byte[] listEntry) {
		RCDLoutputFormat workVar;
		if (requestedFormat.equals(RCDL0100_FORMAT)){
			workVar = new RCDL0100(listEntry);
		} else if (requestedFormat.equals(RCDL0200_FORMAT)){
			workVar = new RCDL0200(listEntry);
		} else if (requestedFormat.equals(RCDL0300_FORMAT)){
			workVar = new RCDL0300(listEntry);
		} else {
			return false;
		}
		
		System.out.println(workVar.toString());
		return true;
	}

	protected void registerCallback() {
		theListHandler.registerCallback(this);
	}

	/**
	 * @param as400ToConnectTo the as400ToConnectTo to set
	 */
	public void setAs400ToConnectTo(String as400ToConnectTo) {
		this.as400ToConnectTo = as400ToConnectTo;
	}

	/**
	 * @param as400UserName the as400UserName to set
	 */
	public void setAs400UserName(String as400UserName) {
		this.as400UserName = as400UserName;
	}

	/**
	 * @param as400UserPassword the as400UserPassword to set
	 */
	public void setAs400UserPassword(String as400UserPassword) {
		this.as400UserPassword = as400UserPassword;
	}
	
	/**
	 * @param overrideProcessing the overrideProcessing to set
	 */
	public void setOverrideProcessing(AS400Text overrideProcessing) {
		this.overrideProcessing = overrideProcessing;
	}

	/**
	 * @param requestedFormat the requestedFormat to set
	 */
	public void setRequestedFormat(String requestedFormat) {
		this.requestedFormat = requestedFormat;
	}

	/**
	 * @param requestOverrideProcessing the requestOverrideProcessing to set
	 */
	public void setRequestOverrideProcessing(boolean requestOverrideProcessing) {
		this.requestOverrideProcessing = requestOverrideProcessing;
	}

	/**
	 * @param searchFileName the searchFileName to set
	 */
	public void setSearchFileName(String searchFileName) {
		this.searchFileName = searchFileName;
	}

	/**
	 * @param searchLibrayName the searchLibrayName to set
	 */
	public void setSearchLibrayName(String searchLibrayName) {
		this.searchLibrayName = searchLibrayName;
	}

	/**
	 * @param userSpaceDescription the userSpaceDescription to set
	 */
	public void setUserSpaceDescription(String userSpaceDescription) {
		this.userSpaceDescription = userSpaceDescription;
	}

	/**
	 * @param userSpaceLibrary the userSpaceLibrary to set
	 */
	public void setUserSpaceLibrary(String userSpaceLibrary) {
		this.userSpaceLibrary = userSpaceLibrary;
	}

	/**
	 * @param userSpaceName the userSpaceName to set
	 */
	public void setUserSpaceName(String userSpaceName) {
		this.userSpaceName = userSpaceName;
	}

	/**
	 * @param userSpaceSize the userSpaceSize to set
	 */
	public void setUserSpaceSize(int userSpaceSize) {
		this.userSpaceSize = userSpaceSize;
	}
}
