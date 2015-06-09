package org.rpgleparser.api.LRCD;

import java.util.ArrayList;

import org.rpgleparser.api.OBJL.OBJLoutputFormat;

/**
 * This class serves as a trivial example of how to extend the QUSLRCD class and use the
 * data for a given purpose. Here we have tried to keep it simple and just stick the entries
 * into an ArrayList
 * @author Eric N. Wilson
 *
 */
public class ObjectListToArrayList extends QUSLRCD {
	public static void main(String[] args) {
		ObjectListToArrayList myobj = new ObjectListToArrayList();
		myobj.setAs400ToConnectTo("DEV400");
		myobj.setAs400UserName("EWILSON");
		myobj.setRequestedFormat(RCDL0100_FORMAT);
		myobj.setUserSpaceLibrary("EWILSON");
		myobj.setUserSpaceName("GARBAGE");
		myobj.setSearchLibrayName("INDEVEXC");
		myobj.setSearchFileName("IND034");
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
		if (requestedFormat.equals(RCDL0100_FORMAT)){
			workVar = (OBJLoutputFormat) new RCDL0100(listEntry);
		} else if (requestedFormat.equals(RCDL0200_FORMAT)){
			workVar = (OBJLoutputFormat) new RCDL0200(listEntry);
		} else if (requestedFormat.equals(RCDL0300_FORMAT)){
			workVar = (OBJLoutputFormat) new RCDL0300(listEntry);
		} else {
			return false;
		}
		
		theList.add(workVar);
		return true;
	}

	@Override
	protected void registerCallback() {
		theListHandler.registerCallback(this);
	}

}
