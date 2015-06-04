package org.rplgleparser.api.LFLD;

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

/**
 * This is the main workhorse class for calling the QUSLFLD API. Example of usage is
 * in the main() method
 * @author Eric N. Wilson
 *
 */
public class QUSLFLD implements ListApiCallback {

	public static void main(String[] args) {
		QUSLFLD myobj = new QUSLFLD();
		myobj.setAs400ToConnectTo("DEV400");
		myobj.setAs400UserName("EWILSON");
		myobj.setFileLib("INATSTDTA");
		myobj.setFileName("INWCTLP");
		myobj.setRecordFormat("INWCTLR");
		myobj.setUserSpaceLib("EWILSON");
		myobj.setUserSpaceName("GARBAGE");
		myobj.setDesiredFormat(FLDL0100_FORMAT);
		myobj.dowork();
		System.exit(0);
	}

	protected AS400ListAPI theListHandler = new AS400ListAPI();

	public static final String FLDL0100_FORMAT = "FLDL0100";
	public static final String FLDL0200_FORMAT = "FLDL0200";
	public static final String FLDL0300_FORMAT = "FLDL0300";
	
	protected String userSpaceName;
	protected String userSpaceLib;
	protected String fileName;
	protected String fileLib;
	protected String recordFormat;
	protected String desiredFormat;
	protected boolean performOverrides;
	protected String as400ToConnectTo;
	protected String as400UserName;
	protected String as400UserPassword;
	protected int userSpaceInitialSize = 1024;
	protected String userSpaceDescription = "";

	
	// List Fields (QUSLFLD) API
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
	// 4 Record format name Input Char(10)
	protected AS400Text recordFormatName = new AS400Text(10);
	// 5 Override processing Input Char(1)
	protected AS400Text overrideProcessing = new AS400Text(1);
	//
	// Optional Parameter:
	//
	// 6 Error code I/O Char(*)
	protected AS400Structure ERRC0100 = theListHandler.ERRC0100;
	//
	//

	protected ProgramCall pc;

	
	//
	//
	protected void dowork() {
		try {
			prepareConnection();
			registerCallback();
			createUserSpace();
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
	protected void registerCallback() {
		theListHandler.registerCallback(this);
	}
	protected void createUserSpace() throws AS400SecurityException,
			ErrorCompletingRequestException, InterruptedException, IOException,
			ObjectDoesNotExistException, PropertyVetoException {
		theListHandler.createUserSpace(userSpaceLib, userSpaceName, userSpaceInitialSize, userSpaceDescription);
	}
	protected void prepareProgramCall() throws PropertyVetoException {
		// List Fields (QUSLFLD) API
		//
		//
		// Required Parameter Group:
		//
		// 1 Qualified user space name Input Char(20)
		// 2 Format name Input Char(8)
		// 3 Qualified file name Input Char(20)
		// 4 Record format name Input Char(10)
		// 5 Override processing Input Char(1)
		//
		// Optional Parameter:
		//
		// 6 Error code I/O Char(*)

		String programName = "/QSYS.LIB/QUSLFLD.PGM";
		String uspName = StringUtils.rightPad(userSpaceName, 10)
				+ StringUtils.rightPad(userSpaceLib, 10);
		String searchName = StringUtils.rightPad(fileName, 10)
				+ StringUtils.rightPad(fileLib, 10);
		ProgramParameter[] parameterList = new ProgramParameter[6];
		parameterList[0] = new ProgramParameter(
				qualSpaceName.toBytes(uspName));
		parameterList[1] = new ProgramParameter(
				formatName.toBytes(desiredFormat));
		parameterList[2] = new ProgramParameter(
				qualFileName.toBytes(searchName));
		parameterList[3] = new ProgramParameter(
				recordFormatName.toBytes(recordFormat));
		if (performOverrides){
			parameterList[4] = new ProgramParameter(
					overrideProcessing.toBytes("1"));
		} else {
			parameterList[4] = new ProgramParameter(
					overrideProcessing.toBytes("0"));
		}
		parameterList[5] = new ProgramParameter(
				ERRC0100.toBytes(theListHandler.ERRC0100j));
		parameterList[4].setOutputDataLength(ERRC0100.getByteLength());

		pc.setProgram(programName, parameterList);
	}
	protected void prepareConnection() throws PropertyVetoException {
		AS400 theSystem = theListHandler.getTheSystem();
		theSystem.setSystemName(as400ToConnectTo);
		theSystem.setUserId(as400UserName);
		if (as400UserPassword != null){
			theSystem.setPassword(as400UserPassword);
		}
		pc = theListHandler.getPc();
		System.out.println("Creating User Space");
	}
	/**
	 * @return the fileLib
	 */
	public String getFileLib() {
		return fileLib;
	}
	/**
	 * @return the fileMember
	 */
	public String getFileMember() {
		return recordFormat;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @return the userSpaceLib
	 */
	public String getUserSpaceLib() {
		return userSpaceLib;
	}
	/**
	 * @return the userSpaceName
	 */
	public String getUserSpaceName() {
		return userSpaceName;
	}
	public boolean processEntry(byte[] input) {
		FLDLoutputFormat wrkVal = null;
		if (desiredFormat.equalsIgnoreCase(FLDL0100_FORMAT)){
			wrkVal = new FLDL0100(input);
		} else if (desiredFormat.equalsIgnoreCase(FLDL0200_FORMAT)){
			wrkVal = new FLDL0200(input);
		} else if (desiredFormat.equalsIgnoreCase(FLDL0300_FORMAT)){
			wrkVal = new FLDL0300(input);
		} else {
			return false;
		}
		System.out.println(wrkVal.toString());
		return true;
	}
	/**
	 * @param fileLib the fileLib to set
	 */
	public void setFileLib(String fileLib) {
		this.fileLib = fileLib;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @param fileMember the fileMember to set
	 */
	public void setRecordFormat(String recordFormat) {
		this.recordFormat = recordFormat;
	}
	/**
	 * @param userSpaceLib the userSpaceLib to set
	 */
	public void setUserSpaceLib(String userSpaceLib) {
		this.userSpaceLib = userSpaceLib;
	}
	/**
	 * @param userSpaceName the userSpaceName to set
	 */
	public void setUserSpaceName(String userSpaceName) {
		this.userSpaceName = userSpaceName;
	}
	/**
	 * @return the as400ToConnectTo
	 */
	public String getAs400ToConnectTo() {
		return as400ToConnectTo;
	}
	/**
	 * @param as400ToConnectTo the as400ToConnectTo to set
	 */
	public void setAs400ToConnectTo(String as400ToConnectTo) {
		this.as400ToConnectTo = as400ToConnectTo;
	}
	/**
	 * @return the as400UserName
	 */
	public String getAs400UserName() {
		return as400UserName;
	}
	/**
	 * @param as400UserName the as400UserName to set
	 */
	public void setAs400UserName(String as400UserName) {
		this.as400UserName = as400UserName;
	}
	/**
	 * @return the as400UserPassword
	 */
	public String getAs400UserPassword() {
		return as400UserPassword;
	}
	/**
	 * @param as400UserPassword the as400UserPassword to set
	 */
	public void setAs400UserPassword(String as400UserPassword) {
		this.as400UserPassword = as400UserPassword;
	}
	/**
	 * @return the userSpaceInitialSize
	 */
	public int getUserSpaceInitialSize() {
		return userSpaceInitialSize;
	}
	/**
	 * @param userSpaceInitialSize the userSpaceInitialSize to set
	 */
	public void setUserSpaceInitialSize(int userSpaceInitialSize) {
		this.userSpaceInitialSize = userSpaceInitialSize;
	}
	/**
	 * @return the userSpaceDescription
	 */
	public String getUserSpaceDescription() {
		return userSpaceDescription;
	}
	/**
	 * @param userSpaceDescription the userSpaceDescription to set
	 */
	public void setUserSpaceDescription(String userSpaceDescription) {
		this.userSpaceDescription = userSpaceDescription;
	}
	/**
	 * @return the desiredFormat
	 */
	public String getDesiredFormat() {
		return desiredFormat;
	}
	/**
	 * @param desiredFormat the desiredFormat to set
	 */
	public void setDesiredFormat(String desiredFormat) {
		this.desiredFormat = desiredFormat;
	}
	/**
	 * @return the performOverrides
	 */
	public boolean isPerformOverrides() {
		return performOverrides;
	}
	/**
	 * @param performOverrides the performOverrides to set
	 */
	public void setPerformOverrides(boolean performOverrides) {
		this.performOverrides = performOverrides;
	}
	/**
	 * @return the overrideProcessing
	 */
	public AS400Text getOverrideProcessing() {
		return overrideProcessing;
	}
	/**
	 * @param overrideProcessing the overrideProcessing to set
	 */
	public void setOverrideProcessing(AS400Text overrideProcessing) {
		this.overrideProcessing = overrideProcessing;
	}
	/**
	 * @return the theListHandler
	 */
	public AS400ListAPI getTheListHandler() {
		return theListHandler;
	}
	/**
	 * @return the recordFormat
	 */
	public String getRecordFormat() {
		return recordFormat;
	}
	/**
	 * @return the pc
	 */
	public ProgramCall getPc() {
		return pc;
	}

}
