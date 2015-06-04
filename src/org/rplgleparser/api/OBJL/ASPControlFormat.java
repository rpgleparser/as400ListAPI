package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class ASPControlFormat implements IASPControlFormat, OBJLoutputFormat, Serializable{

	private static final long serialVersionUID = -2601558064253374549L;

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
	private AS400Bin4 lengthOfAuxillaryStoragePoolControlFormatx = new AS400Bin4();

	// 4 4 CHAR(10) Auxiliary storage pool (ASP) device name
	private AS400Text ASPDeviceNamex = new AS400Text(10);

	// 14 E CHAR(10) Auxiliary storage pool (ASP) search type
	private AS400Text ASPSearchTypex = new AS400Text(10);

	private AS400DataType[] ASPControlFormata = new AS400DataType[] {
			lengthOfAuxillaryStoragePoolControlFormatx, ASPDeviceNamex,
			ASPSearchTypex };

	private AS400Structure ASPControlFormatx = new AS400Structure(
			ASPControlFormata);

	private Integer lengthOfASPControlFormat;

	private String ASPDeviceName;

	private String ASPSearchType;

public ASPControlFormat(){
	// Default constructor
}
public ASPControlFormat(byte[] input){
	Object[] o = (Object[]) ASPControlFormatx.toObject(input);
	lengthOfASPControlFormat = (Integer)o[0];
	ASPDeviceName = (String)o[1];
	ASPSearchType = (String)o[2];
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

}
