package org.rpgleparser.api;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400SecurityException;
import com.ibm.as400.access.CommandCall;
import com.ibm.as400.access.ErrorCompletingRequestException;
import com.ibm.as400.access.Job;
import com.ibm.as400.access.JobDescription;
import com.ibm.as400.access.ObjectDoesNotExistException;
import com.ibm.as400.access.ProgramCall;

/**
 * This class handles the modification of a library list. Needs to have a valid
 * connection to the AS400. The Job must be set by passing in a job object or by
 * passing in a program call object.
 * 
 * @author Eric N. Wilson
 *
 */
public class LibraryList {

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
			// printWorkingLibraryList(myList);
			// System.out.println();

			myList.removeLibraryListEntry("ewilson2");

			// printWorkingLibraryList(myList);
			// System.out.println();
			myList.commit();

			myList.refreshFromServer();
			// printWorkingLibraryList(myList);
			// System.out.println();

			myList.addEntryAfter("EWILSON", "EWILSON2");
			// printWorkingLibraryList(myList);
			// System.out.println();
			myList.commit();

			myList.refreshFromServer();
			// printWorkingLibraryList(myList);
			// System.out.println();

			System.exit(0);

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (AS400SecurityException e) {
			e.printStackTrace();
		} catch (ErrorCompletingRequestException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ObjectDoesNotExistException e) {
			e.printStackTrace();
		}

	}

	private static void printWorkingLibraryList(LibraryList myList) {
		for (String s : myList.workingLibraryList) {
			System.out.print(s + ". ");
		}
	}

	private ArrayList<String> previousLibraryList = new ArrayList<String>();
	private ArrayList<String> workingLibraryList = new ArrayList<String>();
	private Job managedJob;
	private AS400 theAS400 = new AS400();

	private ProgramCall pc = new ProgramCall();

	private CommandCall cc = new CommandCall();

	public LibraryList() {
		// Default constructor

	}

	public LibraryList(Job job) throws AS400SecurityException,
			ErrorCompletingRequestException, InterruptedException, IOException,
			ObjectDoesNotExistException {
		previousLibraryList.addAll(Arrays.asList(job.getUserLibraryList()));
		workingLibraryList.addAll(previousLibraryList);
		managedJob = job;
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

	/**
	 * Adds an entry after the entry specified in the referenceEntry parameter
	 * 
	 * @param referenceEntry
	 *            The entry to be used to position into the list
	 * @param entry
	 *            The name of the library to be added to the list
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
	 * Adds an entry before the entry specified in the referenceEntry parameter
	 * 
	 * @param referenceEntry
	 *            The entry to be used to position into the list
	 * @param entry
	 *            The name of the library to be added to the list
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
	 * Add an entry to the end of the library list
	 * 
	 * @param entry
	 *            The name of the library to be added to the list
	 */
	public void addLibraryListEntry(String entry) {
		// Only add an entry if it does not already exist
		if (!workingLibraryList.contains(entry.toUpperCase())) {
			workingLibraryList.add(entry.toUpperCase());
		}

	}

	/**
	 * Commit the changes to the library list to the job and the previous
	 * library list
	 * 
	 * @throws PropertyVetoException
	 *             percolated up from IBM API
	 * @throws InterruptedException
	 *             percolated up from IBM API
	 * @throws IOException
	 *             percolated up from IBM API
	 * @throws ErrorCompletingRequestException
	 *             percolated up from IBM API
	 * @throws AS400SecurityException
	 *             percolated up from IBM API
	 */
	public void commit() throws PropertyVetoException, AS400SecurityException,
			ErrorCompletingRequestException, IOException, InterruptedException {
		StringBuilder sb = new StringBuilder();
		// System.out.println(managedJob.getUser() + "/" + managedJob.getName()
		// + "/" + managedJob.getNumber());
		// System.out.println(cc.getServerJob().getUser() + "/" +
		// cc.getServerJob().getName() + "/" + cc.getServerJob().getNumber());
		// System.out.println(pc.getServerJob().getUser() + "/" +
		// pc.getServerJob().getName() + "/" + pc.getServerJob().getNumber());
		sb.append("CHGLIBL LIBL(");
		for (String s : workingLibraryList) {
			sb.append(" " + s);
		}
		sb.append(")");
		cc.setCommand(sb.toString());
		cc.run();

	}

	/**
	 * Returns the job that is being managed by this object
	 * 
	 * @return the managedJob
	 */
	public Job getManagedJob() {
		return managedJob;
	}

	public AS400 getTheAS400() {
		return theAS400;
	}

	/**
	 * Refreshes the internal lists from the AS400
	 * 
	 * @throws AS400SecurityException
	 *             percolated up from IBM API
	 * @throws ErrorCompletingRequestException
	 *             percolated up from IBM API
	 * @throws InterruptedException
	 *             percolated up from IBM API
	 * @throws IOException
	 *             percolated up from IBM API
	 * @throws ObjectDoesNotExistException
	 *             percolated up from IBM API
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

	/**
	 * Remove an entry from the working library list
	 * 
	 * @param entry
	 *            The name of the library to be added to the list
	 */
	public void removeLibraryListEntry(String entry) {
		workingLibraryList.remove(entry.toUpperCase());

	}

	/**
	 * Reset the working library list to the contents of the previous library
	 * list
	 */
	public void rollback() {
		workingLibraryList.clear();
		workingLibraryList.addAll(previousLibraryList);
	}

	public void setAS400(AS400 AS400) {
		this.theAS400 = AS400;
	}

	public void setLibraryList(JobDescription jobd)
			throws PropertyVetoException, AS400SecurityException,
			ErrorCompletingRequestException, IOException, InterruptedException {
		setLibraryList(Arrays.asList(jobd.getInitialLibraryList()));
	}

	/**
	 * Sets the library list using a list of Strings.
	 * 
	 * @param desiredLibl
	 *            A list of strings containing the libraries in the order they
	 *            should be in the managed job
	 * @throws PropertyVetoException
	 *             percolated up from IBM API
	 * @throws AS400SecurityException
	 *             percolated up from IBM API
	 * @throws ErrorCompletingRequestException
	 *             percolated up from IBM API
	 * @throws IOException
	 *             percolated up from IBM API
	 * @throws InterruptedException
	 *             percolated up from IBM API
	 */
	public void setLibraryList(List<String> desiredLibl)
			throws PropertyVetoException, AS400SecurityException,
			ErrorCompletingRequestException, IOException, InterruptedException {
		workingLibraryList.clear();
		workingLibraryList.addAll(desiredLibl);
		commit();

	}

	/**
	 * Set the library list based on the initial library list of a given job
	 * description
	 * 
	 * @param jobDescriptionLib
	 *            Library that the job description resides in
	 * @param jobDescriptionName
	 *            The name of the job description
	 * @throws PropertyVetoException
	 *             percolated up from IBM API
	 * @throws AS400SecurityException
	 *             percolated up from IBM API
	 * @throws ErrorCompletingRequestException
	 *             percolated up from IBM API
	 * @throws IOException
	 *             percolated up from IBM API
	 * @throws InterruptedException
	 *             percolated up from IBM API
	 */
	public void setLibraryList(String jobDescriptionLib,
			String jobDescriptionName) throws PropertyVetoException,
			AS400SecurityException, ErrorCompletingRequestException,
			IOException, InterruptedException {
		JobDescription jobd = new JobDescription(theAS400, jobDescriptionLib,
				jobDescriptionName);
		setLibraryList(Arrays.asList(jobd.getInitialLibraryList()));
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
}
