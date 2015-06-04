package org.rplgleparser.api.LRCD;

import java.util.ArrayList;

import org.rplgleparser.api.OBJL.OBJLoutputFormat;

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

	@Override
	protected void registerCallback() {
		theListHandler.registerCallback(this);
	}

}
