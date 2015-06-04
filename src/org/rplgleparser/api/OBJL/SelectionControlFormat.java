package org.rplgleparser.api.OBJL;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;

public class SelectionControlFormat implements ISelectionControlFormat, OBJLoutputFormat {
	// Selection Control Format
	//
	// The following shows the format of the selection control parameter. For
	// detailed descriptions of the fields in the table, see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 BINARY(4) Length of selection control format
	protected transient AS400Bin4 lengthOfSelectionControlFormatx = new AS400Bin4();

	// 4 4 BINARY(4) Select or omit status value
	protected transient AS400Bin4 selectOrOmitStatusValuex = new AS400Bin4();

	// 8 8 BINARY(4) Displacement to statuses
	protected transient AS400Bin4 displacementToStatusesx = new AS400Bin4();

	// 12 C BINARY(4) Number of statuses
	protected transient AS400Bin4 numberOfStatusesx = new AS400Bin4();

	// 16 10 BINARY(4) Reserved
	protected transient AS400Bin4 reservedSelectionControlFormatx = new AS400Bin4();

	// ARRAY(*) of CHAR(1) Statuses
	//
	protected transient AS400DataType[] selectionControlFormata = new AS400DataType[] {
			lengthOfSelectionControlFormatx, 
			selectOrOmitStatusValuex,
			displacementToStatusesx, 
			numberOfStatusesx,
			reservedSelectionControlFormatx
			};

	protected transient AS400Structure selectionControlFormatx = new AS400Structure(
			selectionControlFormata);

	protected Integer reservedSelectionControlFormat;

	protected Integer numberOfStatuses;

	protected Integer displacementToStatuses;

	protected Integer selectOrOmitStatusValue;

	protected Integer lengthOfSelectionControlFormat;
	
	public SelectionControlFormat(){
		// Default Constructor
	}

	public SelectionControlFormat(byte[] input){
		Object[] o = (Object[]) selectionControlFormatx.toObject(input);
		lengthOfSelectionControlFormat = (Integer)o[0]; 
		selectOrOmitStatusValue = (Integer)o[0];
		displacementToStatuses = (Integer)o[0];
		numberOfStatuses = (Integer)o[0];
		reservedSelectionControlFormat = (Integer)o[0];
	}

	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new SelectionControlFormat(input));
	}

	public Integer getLengthOfSelectionControlFormat() {
		return lengthOfSelectionControlFormat;
	}

	public Integer getSelectOrOmitStatusValue() {
		return selectOrOmitStatusValue;
	}

	public Integer getDisplacementToStatuses() {
		return displacementToStatuses;
	}

	public Integer getNumberOfStatuses() {
		return numberOfStatuses;
	}

	public Integer getReservedSelectionControlFormat() {
		return reservedSelectionControlFormat;
	}


}
