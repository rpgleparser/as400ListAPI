package org.rpgleparser.api;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.UserSpace;
/**
 * This class manages the movement through a user space, calling the user's function per entry. 
 * <ul>
 * <li> 
 * The user is responsible to call the iSeries API using the UserSpace that is created here
 * </li>
 * <li>
 * The user must also register the class that implements the ListApiCallback interface
 * </li>
 * <li>
 * If the user chooses to stop processing the list they should return false from the callback function
 * </li>
 * </ul>  
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
	
	private AS400Bin4 payloadLength = new AS400Bin4();
	private AS400 theSystem = new AS400();

	private ProgramCall pc = new ProgramCall();

	private List<listenerEntry> notifyList = new ArrayList<listenerEntry>();

	public AS400ListAPI() {
		try {
			pc.setSystem(theSystem);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public AS400ListAPI(AS400 as400){
		theSystem = as400;
		try {
			pc.setSystem(theSystem);
		} catch (PropertyVetoException e) {
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

		LFMT0100 lfmt0100 = new LFMT0100();
		
		byte[] payload = new byte[lfmt0100.getLFMT0100x().getByteLength()];
		int bytesRead = myUserSpace.read(payload, 0);
		boolean doMore = true;
		// First get the generic header to get the location, number and size
		// of the list entries
		lfmt0100 = new LFMT0100(payload);

		int currentOffset = lfmt0100.getOffsetToListDataSection().intValue();
		int listEntryCount = lfmt0100.getNumberOfListEntries().intValue();
		int entrySize = lfmt0100.getSizeOfEachEntry().intValue();
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