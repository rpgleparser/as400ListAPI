package org.rpgleparser.api.OBJL;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;

/**
 * Implementation class for the Selection Control Format of the QUSLOBJ API. Currently not used 
 * in the main code but provided so you can take a byte[] from the user space and get the data
 * @author Eric N. Wilson
 *
 */
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectionControlFormat other = (SelectionControlFormat) obj;
		if (displacementToStatuses == null) {
			if (other.displacementToStatuses != null)
				return false;
		} else if (!displacementToStatuses.equals(other.displacementToStatuses))
			return false;
		if (lengthOfSelectionControlFormat == null) {
			if (other.lengthOfSelectionControlFormat != null)
				return false;
		} else if (!lengthOfSelectionControlFormat
				.equals(other.lengthOfSelectionControlFormat))
			return false;
		if (numberOfStatuses == null) {
			if (other.numberOfStatuses != null)
				return false;
		} else if (!numberOfStatuses.equals(other.numberOfStatuses))
			return false;
		if (reservedSelectionControlFormat == null) {
			if (other.reservedSelectionControlFormat != null)
				return false;
		} else if (!reservedSelectionControlFormat
				.equals(other.reservedSelectionControlFormat))
			return false;
		if (selectOrOmitStatusValue == null) {
			if (other.selectOrOmitStatusValue != null)
				return false;
		} else if (!selectOrOmitStatusValue
				.equals(other.selectOrOmitStatusValue))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new SelectionControlFormat(input));
	}

	public Integer getDisplacementToStatuses() {
		return displacementToStatuses;
	}

	public Integer getLengthOfSelectionControlFormat() {
		return lengthOfSelectionControlFormat;
	}

	public Integer getNumberOfStatuses() {
		return numberOfStatuses;
	}

	public Integer getReservedSelectionControlFormat() {
		return reservedSelectionControlFormat;
	}

	public Integer getSelectOrOmitStatusValue() {
		return selectOrOmitStatusValue;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Length of Selection Control Format: " + lengthOfSelectionControlFormat.toString()); 
		sb.append(" Select or Omit Status Value: " + selectOrOmitStatusValue.toString());
		sb.append(" Displacement To Statuses: " + displacementToStatuses.toString());
		sb.append(" Number of Statuses: " + numberOfStatuses.toString());
		sb.append(" Reserved (Selection Control Format): " + reservedSelectionControlFormat.toString());
		return sb.toString();
	}


}
