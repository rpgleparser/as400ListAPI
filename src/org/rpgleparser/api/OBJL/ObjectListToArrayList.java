package org.rpgleparser.api.OBJL;

import java.util.ArrayList;

/**
 * This class serves as a trivial example of how to extend the QUSLRCD class and use the
 * data for a given purpose. Here we have tried to keep it simple and just stick the entries
 * into an ArrayList
 * @author Eric N. Wilson
 *
 */
public class ObjectListToArrayList extends QUSLOBJ  {
	public static void main(String[] args){
		ObjectListToArrayList myobj = new ObjectListToArrayList();
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
		for (OBJLoutputFormat o : myobj.theList){
			System.out.println(o.toString());
		}
		// Do this because of the stupid login dialog keeping threads open.
		System.exit(0);

	}
	
	private ArrayList<OBJLoutputFormat> theList = new ArrayList<OBJLoutputFormat>();
	
	

	/**
	 * @return the theList
	 */
	public ArrayList<OBJLoutputFormat> getTheList() {
		return theList;
	}

	@Override
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
		theList.add(workVar);
		return true;
	}



	@Override
	protected void regsiterCallback() {
		theListHandler.registerCallback(this);
	}

}
