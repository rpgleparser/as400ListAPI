package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLOBJ OBJL0100 format.
 * @author Eric N. Wilson
 *
 */
public class OBJL0100 implements IOBJL0100, OBJLoutputFormat, Serializable {
	private static final long serialVersionUID = 7868263426881998000L;
	// OBJL0100 List Data Section
	//
	// The following information is returned in the list data section of the
	// OBJL0100 format. For detailed descriptions of the fields in the table,
	// see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) Object name used
	protected transient AS400Text objectNameUsedx = new AS400Text(10);
	// 10 A CHAR(10) Object library name used
	protected transient AS400Text objectLibraryNameUsedx = new AS400Text(10);

	protected transient AS400Text objectTypeUsedx = new AS400Text(10);

	protected transient AS400DataType[] OBJL0100a = new AS400DataType[] { objectNameUsedx,
			objectLibraryNameUsedx, objectTypeUsedx };

	protected transient AS400Structure OBJL0100x = new AS400Structure(OBJL0100a);

	protected String objectLibraryNameUsed;

	protected String ObjectNameUsed;

	protected String ObjectTypeUsed;

	public OBJL0100(){
		//Default constructor
	}

	public OBJL0100(byte[] input){
		Object[] o = (Object[])OBJL0100x.toObject(input);
		this.ObjectNameUsed = (String)o[0];
		this.objectLibraryNameUsed = (String)o[1];
		this.ObjectTypeUsed = (String)o[2];
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OBJL0100 other = (OBJL0100) obj;
		if (ObjectNameUsed == null) {
			if (other.ObjectNameUsed != null)
				return false;
		} else if (!ObjectNameUsed.equals(other.ObjectNameUsed))
			return false;
		if (ObjectTypeUsed == null) {
			if (other.ObjectTypeUsed != null)
				return false;
		} else if (!ObjectTypeUsed.equals(other.ObjectTypeUsed))
			return false;
		if (objectLibraryNameUsed == null) {
			if (other.objectLibraryNameUsed != null)
				return false;
		} else if (!objectLibraryNameUsed.equals(other.objectLibraryNameUsed))
			return false;
		return true;
	}
	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new OBJL0100(input));
	}

	public String getObjectLibraryNameUsed() {
		return objectLibraryNameUsed;
	}


	public String getObjectNameUsed() {
		return ObjectNameUsed;
	}

	public String getObjectTypeUsed() {
		return ObjectTypeUsed;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Object Name: " + ObjectNameUsed.trim() );
		sb.append(" Object Library " + objectLibraryNameUsed.trim());
		sb.append(" Object Type " + ObjectTypeUsed.trim());
		return sb.toString();
	}

}
