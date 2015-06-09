package org.rpgleparser.api.LFLD;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


/**
 * An example of how to extend the QUSLFLD class to do some arbitrary thing, in this case
 * writing the basics of a DDS source member from the metadata returned.
 * @author Eric N. Wilson
 *
 */
public class ObjectListToArrayList extends QUSLFLD {
	
	private ArrayList<FLDLoutputFormat> theList = new ArrayList<FLDLoutputFormat>();
	
	public static void main(String[] args){
		ObjectListToArrayList myobj = new ObjectListToArrayList();
		myobj.setAs400ToConnectTo("DEV400");
		myobj.setAs400UserName("EWILSON");
		myobj.setFileLib("INATSTDTA");
		myobj.setFileName("INWCTLP");
		myobj.setRecordFormat("INWCTLR");
		myobj.setUserSpaceLib("EWILSON");
		myobj.setUserSpaceName("GARBAGE");
		myobj.setDesiredFormat(FLDL0100_FORMAT);
		myobj.setPerformOverrides(false);
		myobj.setUserSpaceDescription("Temporary User Space");
		myobj.setUserSpaceInitialSize(2048);
		myobj.dowork();
		
		String sequenceNumber = "";
		char formType = 'A';
		String garbage = "";
		char recordType = 'R';
		char isReferemce = ' ';
		// Try to show an example of recovering DDS source from a file object. This is by no means complete but serves
		// an illustrative purpose
		System.out.println(StringUtils.rightPad(sequenceNumber, 5) + formType + StringUtils.rightPad(garbage, 10) + recordType + " " + StringUtils.rightPad(myobj.recordFormat, 10) );
		for (FLDLoutputFormat o : myobj.theList){
			if (o instanceof FLDL0100){
				recordType = ' ';
				FLDL0100 temp = (FLDL0100) o;
				System.out.print(StringUtils.rightPad(sequenceNumber, 5));
				System.out.print(formType);
				System.out.print( StringUtils.rightPad(garbage, 10));
				System.out.print("  ");
				System.out.print( StringUtils.rightPad(temp.internalFieldName, 10));
				System.out.print(isReferemce);
				if (temp.dataType.equalsIgnoreCase("A")){
					System.out.print(StringUtils.leftPad(temp.fieldLengthInBytes.toString(), 5));
				} else if (temp.dataType.equalsIgnoreCase("P") || temp.dataType.equalsIgnoreCase("S") || temp.dataType.equalsIgnoreCase("B")){
					System.out.print(StringUtils.leftPad(temp.digits.toString(), 5));

				} else if (temp.dataType.equalsIgnoreCase("L") || temp.dataType.equalsIgnoreCase("T") || temp.dataType.equalsIgnoreCase("Z")){
					System.out.print(StringUtils.leftPad(" ", 5));

				} else {
					System.out.print(StringUtils.leftPad(" ", 5));
				}
				System.out.print(temp.dataType);
				
				if (temp.dataType.equalsIgnoreCase("P") || temp.dataType.equalsIgnoreCase("S") || temp.dataType.equalsIgnoreCase("B")){
					System.out.print(StringUtils.leftPad(temp.decimalPositions.toString(), 2));

				}else {
					System.out.print("  ");
				}
				
				System.out.print(temp.use);
				
				System.out.print("      ");
				if (temp.dataType.equalsIgnoreCase("A")){
					System.out.print("CCSID(" + temp.fieldDataCCSID.toString() + ")");
				}
			}
			System.out.println();
		}
		System.exit(0);
	}

	@Override
	protected void registerCallback() {
		theListHandler.registerCallback(this);
	}

	@Override
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
		
		theList.add(wrkVal);
		return true;
	}

}
