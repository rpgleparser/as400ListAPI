package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * Implementation class for the ASP Control Format of the QUSLOBJ API. Currently not used 
 * in the main code but provided so you can take a byte[] from the user space and get the data
 * @author Eric N. Wilson
 *
 */
public class ASPControlFormat implements IASPControlFormat, OBJLoutputFormat, Serializable{

	protected static final long serialVersionUID = -2601558064253374549L;

	// Auxiliary Storage Pool (ASP) Control Format
	//
	// The following shows the format of the auxiliary storage pool (ASP)
	// control parameter. This parameter is used to define the auxiliary storage
	// pools (ASPs) to search. For detailed descriptions of the fields in the
	// table, see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 BINARY(4) Length of auxiliary storage pool (ASP) control format
	protected transient AS400Bin4 lengthOfAuxillaryStoragePoolControlFormatx = new AS400Bin4();

	// 4 4 CHAR(10) Auxiliary storage pool (ASP) device name
	protected transient AS400Text ASPDeviceNamex = new AS400Text(10);

	// 14 E CHAR(10) Auxiliary storage pool (ASP) search type
	protected transient AS400Text ASPSearchTypex = new AS400Text(10);

	protected transient AS400DataType[] ASPControlFormata = new AS400DataType[] {
			lengthOfAuxillaryStoragePoolControlFormatx, ASPDeviceNamex,
			ASPSearchTypex };

	protected transient AS400Structure ASPControlFormatx = new AS400Structure(
			ASPControlFormata);

	protected Integer lengthOfASPControlFormat;

	protected String ASPDeviceName;

	protected String ASPSearchType;

public ASPControlFormat(){
	// Default constructor
}
public ASPControlFormat(byte[] input){
	Object[] o = (Object[]) ASPControlFormatx.toObject(input);
	lengthOfASPControlFormat = (Integer)o[0];
	ASPDeviceName = (String)o[1];
	ASPSearchType = (String)o[2];
}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ASPControlFormat other = (ASPControlFormat) obj;
		if (ASPDeviceName == null) {
			if (other.ASPDeviceName != null)
				return false;
		} else if (!ASPDeviceName.equals(other.ASPDeviceName))
			return false;
		if (ASPSearchType == null) {
			if (other.ASPSearchType != null)
				return false;
		} else if (!ASPSearchType.equals(other.ASPSearchType))
			return false;
		if (lengthOfASPControlFormat == null) {
			if (other.lengthOfASPControlFormat != null)
				return false;
		} else if (!lengthOfASPControlFormat
				.equals(other.lengthOfASPControlFormat))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new ASPControlFormat(input));
	}

	public String getASPDeviceName() {
		return ASPDeviceName;
	}
	public String getASPSearchType() {
		return ASPSearchType;
	}
	public Integer getLengthOfASPControlFormat() {
		return lengthOfASPControlFormat;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Length of ASP Control Format: " +lengthOfASPControlFormat.toString());
		sb.append("ASP Device Name: "+ ASPDeviceName.trim());
		sb.append("ASP Search Type: "+ ASPSearchType.trim());
		return sb.toString();
	}

}
