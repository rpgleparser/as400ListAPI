package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class OBJL0200 extends OBJL0100 implements IOBJL0200, OBJLoutputFormat, Serializable{

	private static final long serialVersionUID = 4298231844551639933L;
	protected String objectLibraryNameUsed;
	protected String ObjectNameUsed;
	protected String ObjectTypeUsed;
	protected String InformationStatus;
	protected String ExtendedObjectAttribute;
	protected String TextDescription;
	protected String UserDefinedAttribute;
	protected String getReservedOBJL0200;
	// OBJL0200 List Data Section
	//
	// The following information is returned in the list data section of the
	// OBJL0200 format. For detailed descriptions of the fields in the table,
	// see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 Everything from the OBJL0100 format
	// 30 1E CHAR(1) Information status
	protected transient AS400Text informationStatusx = new AS400Text(1);

	// 31 1F CHAR(10) Extended object attribute
	protected transient AS400Text extendedObjectAttributex = new AS400Text(10);

	// 41 29 CHAR(50) Text description
	protected transient AS400Text textDescriptionx = new AS400Text(50);

	// 91 5B CHAR(10) User-defined attribute
	protected transient AS400Text userDefinedAttributex = new AS400Text(10);

	// 101 65 CHAR(7) Reserved
	protected transient AS400Text reservedOBJL0200x = new AS400Text(7);

	protected transient AS400DataType[] OBJL0200a = new AS400DataType[] { objectNameUsedx,
			objectLibraryNameUsedx, objectTypeUsedx, informationStatusx,
			extendedObjectAttributex, textDescriptionx, userDefinedAttributex,
			reservedOBJL0200x };

	protected transient AS400Structure OBJL0200x = new AS400Structure(OBJL0200a);
	protected String reservedOBJL0200;

	public OBJL0200(){
		// Default constructor
	}
	public OBJL0200(byte[] input){
		Object[] o = (Object[])OBJL0200x.toObject(input);
		ObjectNameUsed = (String)o[0];
		objectLibraryNameUsed = (String)o[1];
		ObjectTypeUsed = (String)o[2];
		InformationStatus = (String)o[3]; 
		ExtendedObjectAttribute = (String)o[4]; 
		TextDescription = (String)o[5];
		UserDefinedAttribute = (String)o[6]; 
		reservedOBJL0200 = (String)o[7];
		
	}

	@Override
	public String getObjectLibraryNameUsed() {
		return objectLibraryNameUsed;
	}

	@Override
	public String getObjectNameUsed() {
		return ObjectNameUsed;
	}

	@Override
	public String getObjectTypeUsed() {
		return ObjectTypeUsed;
	}

	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new OBJL0200(input));
	}

	public IOBJL0100 getOBJL0100() {
		OBJL0100 result = new OBJL0100();
		result.ObjectNameUsed = ObjectNameUsed;
		result.objectLibraryNameUsed = objectLibraryNameUsed;
		result.ObjectTypeUsed = ObjectTypeUsed;
		return result;
	}

	public String getInformationStatus() {
		return InformationStatus;
	}

	public String getExtendedObjectAttribute() {
		return ExtendedObjectAttribute;
	}

	public String getTextDescription() {
		return TextDescription;
	}

	public String getUserDefinedAttribute() {
		return UserDefinedAttribute;
	}

	public String getReservedOBJL0200() {
		return reservedOBJL0200;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Object Name: " + ObjectNameUsed.trim() );
		sb.append(" Object Library: " + objectLibraryNameUsed.trim());
		sb.append(" Object Type: " + ObjectTypeUsed.trim());
		sb.append(" Information Status: " + InformationStatus.trim()); 
		sb.append(" Extended Object Attribute: " + ExtendedObjectAttribute.trim()); 
		sb.append(" Text Description: " + TextDescription.trim());
		sb.append(" User Defined Attribute: " + UserDefinedAttribute.trim()); 
		sb.append(" Reserved (OBJL0200): " + reservedOBJL0200.trim());

		return sb.toString();
	}

}
