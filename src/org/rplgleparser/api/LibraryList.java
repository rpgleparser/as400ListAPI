package org.rplgleparser.api;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.CommandCall;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.Job;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;

/**
 * This class handles the modification of a library list. 
 * Needs to have a valid connection to the AS400. 
 * @author Eric N. Wilson
 *
 */
public class LibraryList {
	private ArrayList<String> previousLibraryList = new ArrayList<String>();
	private ArrayList<String> workingLibraryList = new ArrayList<String>();
	private Job managedJob;
	private AS400 theAS400 = new AS400();
	private ProgramCall pc = new ProgramCall();
	private CommandCall cc = new CommandCall();

	public static void main(String[] args) {
		LibraryList myList = new LibraryList();
		myList.theAS400 = new AS400();
		try {
			myList.theAS400.setUserId("EWILSON");
			myList.theAS400.setSystemName("DEV400");
			myList.pc.setSystem(myList.theAS400);
			myList.cc.setSystem(myList.theAS400);
			myList.setManagedJob(myList.pc.getServerJob());

			myList.refreshFromServer();
//			printWorkingLibraryList(myList);
//			System.out.println();
			
			myList.removeLibraryListEntry("ewilson2");
			
//			printWorkingLibraryList(myList);
//			System.out.println();
			myList.commit();

			myList.refreshFromServer();
//			printWorkingLibraryList(myList);
//			System.out.println();

			myList.addEntryAfter("EWILSON", "EWILSON2");
//			printWorkingLibraryList(myList);
//			System.out.println();
			myList.commit();

			myList.refreshFromServer();
//			printWorkingLibraryList(myList);
//			System.out.println();

			System.exit(0);
			
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErrorCompletingRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void printWorkingLibraryList(LibraryList myList) {
		for (String s : myList.workingLibraryList){
			System.out.print(s+ ". ");
		}
	}

	public LibraryList() {
		// Default constructor

	}

	public LibraryList(ProgramCall pc) throws AS400SecurityException,
			ErrorCompletingRequestException, InterruptedException, IOException,
			ObjectDoesNotExistException {
		previousLibraryList.addAll(Arrays.asList(pc.getServerJob()
				.getUserLibraryList()));
		workingLibraryList.addAll(previousLibraryList);
		managedJob = pc.getServerJob();
		theAS400 = pc.getSystem();
		this.pc = pc;
		this.cc.setThreadSafe(false);

	}

	public LibraryList(Job job) throws AS400SecurityException,
			ErrorCompletingRequestException, InterruptedException, IOException,
			ObjectDoesNotExistException {
		previousLibraryList.addAll(Arrays.asList(job.getUserLibraryList()));
		workingLibraryList.addAll(previousLibraryList);
		managedJob = job;
	}

	/**
	 * Add an entry to the end of the library list
	 * 
	 * @param entry
	 */
	public void addLibraryListEntry(String entry) {
		// Only add an entry if it does not already exist
		if (!workingLibraryList.contains(entry.toUpperCase())) {
			workingLibraryList.add(entry.toUpperCase());
		}

	}

	/**
	 * Remove an entry from the working library list
	 * 
	 * @param entry
	 */
	public void removeLibraryListEntry(String entry) {
		workingLibraryList.remove(entry.toUpperCase());

	}

	/**
	 * Adds an entry before the entry specified in the referenceEntry parameter
	 * 
	 * @param referenceEntry
	 * @param entry
	 */
	public void addEntryBefore(String referenceEntry, String entry) {
		if (!workingLibraryList.contains(entry.toUpperCase())) {
			int index = workingLibraryList
					.indexOf(referenceEntry.toUpperCase());
			if (index == -1) {
				// Maybe throw an exception here???
			}
			if (index <= 1) {
				workingLibraryList.add(0, entry.toUpperCase());
			} else {
				index -= 1;
				workingLibraryList.add(index, entry.toUpperCase());
			}
		}
	}

	/**
	 * Adds an entry after the entry specified in the referenceEntry parameter
	 * 
	 * @param referenceEntry
	 * @param entry
	 */
	public void addEntryAfter(String referenceEntry, String entry) {
		if (!workingLibraryList.contains(entry.toUpperCase())) {
			int index = workingLibraryList
					.indexOf(referenceEntry.toUpperCase());
			if (index == -1) {
				// Maybe throw an exception here???
			}
			if (index == workingLibraryList.size()) {
				workingLibraryList.add(entry.toUpperCase());
			} else {
				index += 1;
				workingLibraryList.add(index, entry.toUpperCase());
			}
		}

	}

	/**
	 * Commit the changes to the library list to the job and the previous
	 * library list
	 * 
	 * @throws PropertyVetoException
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ErrorCompletingRequestException
	 * @throws AS400SecurityException
	 */
	public void commit() throws PropertyVetoException, AS400SecurityException,
			ErrorCompletingRequestException, IOException, InterruptedException {
		StringBuilder sb = new StringBuilder();
//		System.out.println(managedJob.getUser() + "/" + managedJob.getName() + "/" + managedJob.getNumber());
//		System.out.println(cc.getServerJob().getUser() + "/" + cc.getServerJob().getName() + "/" + cc.getServerJob().getNumber());
//		System.out.println(pc.getServerJob().getUser() + "/" + pc.getServerJob().getName() + "/" + pc.getServerJob().getNumber());
		sb.append("CHGLIBL LIBL(");
		for (String s : workingLibraryList) {
			sb.append(" " + s);
		}
		sb.append(")");
		cc.setCommand(sb.toString());
		cc.run();

	}

	/**
	 * Reset the working library list to the contents of the previous library
	 * list
	 */
	public void rollback() {
		workingLibraryList.clear();
		workingLibraryList.addAll(previousLibraryList);
	}

	/**
	 * Returns the job that is being managed by this object
	 * 
	 * @return the managedJob
	 */
	public Job getManagedJob() {
		return managedJob;
	}

	/**
	 * Set the job being managed to a job of your choosing
	 * 
	 * @param managedJob
	 *            the managedJob to set
	 */
	public void setManagedJob(Job managedJob) {
		this.managedJob = managedJob;
	}

	/**
	 * Refreshes the internal lists from the AS400
	 * 
	 * @throws AS400SecurityException
	 * @throws ErrorCompletingRequestException
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ObjectDoesNotExistException
	 */
	public void refreshFromServer() throws AS400SecurityException,
			ErrorCompletingRequestException, InterruptedException, IOException,
			ObjectDoesNotExistException {
		managedJob.loadInformation();
		previousLibraryList.clear();
		previousLibraryList.addAll(Arrays.asList(managedJob
				.getUserLibraryList()));
		workingLibraryList.clear();
		workingLibraryList.addAll(previousLibraryList);

	}
}
