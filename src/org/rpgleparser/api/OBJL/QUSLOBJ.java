package org.rpgleparser.api.OBJL;

import java.beans.PropertyVetoException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.rpgleparser.api.AS400ListAPI;
import org.rpgleparser.api.ERRC0100;
import org.rpgleparser.api.ListApiCallback;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;

/**
 * This is the main workhorse class for calling the QUSLOBJ API. Example of
 * usage is in the main() method
 * 
 * @author Eric N. Wilson
 *
 */
public class QUSLOBJ implements ListApiCallback {
	public static final String OBJ0100_FORMAT = "OBJL0100";
	public static final String OBJ0200_FORMAT = "OBJL0200";
	public static final String OBJ0300_FORMAT = "OBJL0300";
	public static final String OBJ0400_FORMAT = "OBJL0400";
	public static final String OBJ0500_FORMAT = "OBJL0500";
	public static final String OBJ0600_FORMAT = "OBJL0600";
	public static final String OBJ0700_FORMAT = "OBJL0700";

	public static void main(String[] args) {
		QUSLOBJ myobj = new QUSLOBJ();
		myobj.setAs400ToConnectTo("DEV400");
		myobj.setAs400UserName("EWILSON");
		myobj.setDesiredFormat(OBJ0300_FORMAT);
		myobj.setUserSpaceLibrary("EWILSON");
		myobj.setUserSpaceName("GARBAGE");
		myobj.setSearchObjectLibrary("INDEVDTA");
		myobj.setSearchObjectName("C*");
		myobj.setSearchObjectType("*ALL");
		myobj.setUserSpaceSize(1024);
		myobj.setUserSpaceDescription("Some enchanted evening");
		myobj.dowork();
		System.exit(0);
	}

	/**
	 * @return the userSpaceLibrary
	 */
	public String getUserSpaceLibrary() {
		return userSpaceLibrary;
	}

	/**
	 * @param userSpaceLibrary
	 *            the userSpaceLibrary to set
	 */
	public void setUserSpaceLibrary(String userSpaceLibrary) {
		this.userSpaceLibrary = userSpaceLibrary;
	}

	/**
	 * @return the userSpaceName
	 */
	public String getUserSpaceName() {
		return userSpaceName;
	}

	/**
	 * @param userSpaceName
	 *            the userSpaceName to set
	 */
	public void setUserSpaceName(String userSpaceName) {
		this.userSpaceName = userSpaceName;
	}

	/**
	 * @return the searchObjectName
	 */
	public String getSearchObjectName() {
		return searchObjectName;
	}

	/**
	 * @param searchObjectName
	 *            the searchObjectName to set
	 */
	public void setSearchObjectName(String searchObjectName) {
		this.searchObjectName = searchObjectName;
	}

	/**
	 * @return the searchObjectLibrary
	 */
	public String getSearchObjectLibrary() {
		return searchObjectLibrary;
	}

	/**
	 * @param searchObjectLibrary
	 *            the searchObjectLibrary to set
	 */
	public void setSearchObjectLibrary(String searchObjectLibrary) {
		this.searchObjectLibrary = searchObjectLibrary;
	}

	/**
	 * @return the searchObjectType
	 */
	public String getSearchObjectType() {
		return searchObjectType;
	}

	/**
	 * @param searchObjectType
	 *            the searchObjectType to set
	 */
	public void setSearchObjectType(String searchObjectType) {
		this.searchObjectType = searchObjectType;
	}

	/**
	 * @return the as400ToConnectTo
	 */
	public String getAs400ToConnectTo() {
		return as400ToConnectTo;
	}

	/**
	 * @param as400ToConnectTo
	 *            the as400ToConnectTo to set
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
	 * @param as400UserName
	 *            the as400UserName to set
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
	 * @param as400UserPassword
	 *            the as400UserPassword to set
	 */
	public void setAs400UserPassword(String as400UserPassword) {
		this.as400UserPassword = as400UserPassword;
	}

	protected AS400ListAPI theListHandler = new AS400ListAPI();
	protected String userSpaceLibrary = "EWILSON";
	protected String userSpaceName = "GARBAGE";

	protected String searchObjectName = "*ALL";
	protected String searchObjectLibrary = "EWILSON";
	protected String searchObjectType = "*ALL";
	protected String as400ToConnectTo = "DEV400";
	protected String as400UserName;
	protected String as400UserPassword = null;
	// 5 Error Code I/O Char(*)
	protected ERRC0100 errc0100 = new ERRC0100();
	protected String desiredFormat;
	protected ProgramCall pc;
	protected int userSpaceSize;
	protected String userSpaceDescription;

	protected void dowork() {
		try {
			prepareConnection();
			regsiterCallback();
			createUserSpace();

			// Call the list API
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
			e.printStackTrace();
		} catch (AS400SecurityException e) {
			e.printStackTrace();
		} catch (ErrorCompletingRequestException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ObjectDoesNotExistException e) {
			e.printStackTrace();
		}
	}

	protected void prepareProgramCall() throws PropertyVetoException {
		String programName = "/QSYS.LIB/QUSLOBJ.PGM";
		AS400Text spaceName = new AS400Text(20);
		String uspName = StringUtils.rightPad(userSpaceName, 10)
				+ StringUtils.rightPad(userSpaceLibrary, 10);
		String searchName = StringUtils.rightPad(searchObjectName.trim(), 10)
				+ StringUtils.rightPad(searchObjectLibrary.trim(), 10);
		ProgramParameter[] parameterList = new ProgramParameter[5];
		parameterList[0] = new ProgramParameter(spaceName.toBytes(uspName));
		parameterList[1] = new ProgramParameter(
				new AS400Text(10).toBytes(desiredFormat));
		parameterList[2] = new ProgramParameter(
				new AS400Text(20).toBytes(searchName));
		parameterList[3] = new ProgramParameter(
				new AS400Text(10).toBytes(searchObjectType));
		parameterList[4] = new ProgramParameter(errc0100.getERRC0100x()
				.toBytes(errc0100.getERRC0100j()));
		parameterList[4].setOutputDataLength(errc0100.getERRC0100x()
				.getByteLength());

		pc.setProgram(programName, parameterList);
	}

	protected void createUserSpace() throws AS400SecurityException,
			ErrorCompletingRequestException, InterruptedException, IOException,
			ObjectDoesNotExistException, PropertyVetoException {
		System.out.println("Creating User Space");
		// Create the user space
		theListHandler.createUserSpace(userSpaceLibrary, userSpaceName,
				userSpaceSize, userSpaceDescription);
	}

	protected void regsiterCallback() {
		theListHandler.registerCallback(this);
	}

	protected void prepareConnection() throws PropertyVetoException {
		AS400 theSystem = theListHandler.getTheSystem();
		pc = theListHandler.getPc();
		theSystem.setSystemName(as400ToConnectTo);
		theSystem.setUserId(as400UserName);
		if (as400UserPassword != null) {
			theSystem.setPassword(as400UserPassword);
		}
	}

	/**
	 * @return the desiredFormat
	 */
	public String getDesiredFormat() {
		return desiredFormat;
	}

	/**
	 * @return the library
	 */
	public String getLibrary() {
		return userSpaceLibrary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return userSpaceName;
	}

	public boolean processEntry(byte[] listEntry) {
		OBJLoutputFormat workVar;
		if (desiredFormat.equalsIgnoreCase(OBJ0100_FORMAT)) {
			workVar = new OBJL0100(listEntry);
		} else if (desiredFormat.equalsIgnoreCase(OBJ0200_FORMAT)) {
			workVar = new OBJL0200(listEntry);
		} else if (desiredFormat.equalsIgnoreCase(OBJ0300_FORMAT)) {
			workVar = new OBJL0300(listEntry);
		} else if (desiredFormat.equalsIgnoreCase(OBJ0400_FORMAT)) {
			workVar = new OBJL0400(listEntry);
		} else if (desiredFormat.equalsIgnoreCase(OBJ0500_FORMAT)) {
			workVar = new OBJL0500(listEntry);
		} else if (desiredFormat.equalsIgnoreCase(OBJ0600_FORMAT)) {
			workVar = new OBJL0600(listEntry);
		} else if (desiredFormat.equalsIgnoreCase(OBJ0700_FORMAT)) {
			workVar = new OBJL0700(listEntry);
		} else {
			return false;
		}
		System.out.println(workVar.toString());
		return true;
	}

	/**
	 * @param desiredFormat
	 *            the desiredFormat to set
	 */
	public void setDesiredFormat(String desiredFormat) {
		this.desiredFormat = desiredFormat;
	}

	/**
	 * @return the userSpaceSize
	 */
	public int getUserSpaceSize() {
		return userSpaceSize;
	}

	/**
	 * @param userSpaceSize
	 *            the userSpaceSize to set
	 */
	public void setUserSpaceSize(int userSpaceSize) {
		this.userSpaceSize = userSpaceSize;
	}

	/**
	 * @return the userSpaceDescription
	 */
	public String getUserSpaceDescription() {
		return userSpaceDescription;
	}

	/**
	 * @param userSpaceDescription
	 *            the userSpaceDescription to set
	 */
	public void setUserSpaceDescription(String userSpaceDescription) {
		this.userSpaceDescription = userSpaceDescription;
	}

	/**
	 * @return the theListHandler
	 */
	public AS400ListAPI getTheListHandler() {
		return theListHandler;
	}

	/**
	 * @return the pc
	 */
	public ProgramCall getPc() {
		return pc;
	}
}
