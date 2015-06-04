package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class OBJL0300 extends OBJL0200 implements IOBJL0300, OBJLoutputFormat, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5688079050460385438L;

	// OBJL0300 List Data Section
	//
	// The following information is returned in the list data section of the
	// OBJL0300 format. For detailed descriptions of the fields in the table,
	// see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 Everything from the OBJL0200 format
	// 108 6C BINARY(4) Object auxiliary storage pool (ASP) number
	protected transient AS400Bin4 objectASPNumberx = new AS400Bin4();

	// 112 70 CHAR(10) Object owner
	protected transient AS400Text objectOwnerx = new AS400Text(10);

	// 122 7A CHAR(2) Object domain
	protected transient AS400Text objectDomainx = new AS400Text(2);

	// 124 7C CHAR(8) Creation date and time
	protected transient AS400Text creationDateAndTimex = new AS400Text(8);

	// 132 84 CHAR(8) Change date and time
	protected transient AS400Text changeDateAndTimex = new AS400Text(8);

	// 140 8C CHAR(10) Storage
	protected transient AS400Text storagex = new AS400Text(10);

	// 150 96 CHAR(1) Object compression status
	protected transient AS400Text objectCompressionStatusx = new AS400Text(1);

	// 151 97 CHAR(1) Allow change by program
	protected transient AS400Text allowChangeByProgramx = new AS400Text(1);

	// 152 98 CHAR(1) Changed by program
	protected transient AS400Text changedByProgramx = new AS400Text(1);

	// 153 99 CHAR(10) Object auditing value
	protected transient AS400Text objectAuditingValuex = new AS400Text(10);

	// 163 A3 CHAR(1) Digitally signed
	protected transient AS400Text digitallySignedx = new AS400Text(1);

	// 164 A4 CHAR(1) Digitally signed by system-trusted source
	protected transient AS400Text digitallySignedBySystemTrustedSourcex = new AS400Text(1);

	// 165 A5 CHAR(1) Digitally signed more than once
	protected transient AS400Text digitallySignedMoreThanOncex = new AS400Text(1);

	// 166 A6 CHAR(2) Reserved
	protected transient AS400Text reservedOBJL0300x = new AS400Text(2);

	// 168 A8 BINARY(4) Library auxiliary storage pool (ASP) number
	protected transient AS400Bin4 libraryASPNumberx = new AS400Bin4();

	protected transient AS400DataType[] OBJL0300a = new AS400DataType[] {
			objectNameUsedx, objectLibraryNameUsedx, objectTypeUsedx,
			informationStatusx, extendedObjectAttributex, textDescriptionx,
			userDefinedAttributex, reservedOBJL0200x, objectASPNumberx,
			objectOwnerx, objectDomainx, creationDateAndTimex,
			changeDateAndTimex, storagex, objectCompressionStatusx,
			allowChangeByProgramx, changedByProgramx, objectAuditingValuex,
			digitallySignedx, digitallySignedBySystemTrustedSourcex,
			digitallySignedMoreThanOncex, reservedOBJL0300x, libraryASPNumberx };

	protected transient AS400Structure OBJL0300x = new AS400Structure(OBJL0300a);

	protected Integer objectASPNumber;
	protected String objectOwner;
	protected String objectDomain;
	protected String creationDateAndTime;
	protected String changeDateAndTime;
	protected String storage;
	protected String objectCompressionStatus;
	protected String allowChangeByProgram;
	protected String changedByProgram;
	protected String objectAuditingValue;
	protected String digitallySigned;
	protected String digitallySignedBySystemTrustedSource;
	protected String digitallySignedMoreThanOnce;
	protected String reservedOBJL0300;
	protected Integer libraryASPNumber;

	public OBJL0300() {
		// Default Constructor
	}

	public OBJL0300(byte[] input) {
		Object[] o = (Object[]) OBJL0300x.toObject(input);
		ObjectNameUsed = (String) o[0];
		objectLibraryNameUsed = (String) o[1];
		ObjectTypeUsed = (String) o[2];
		InformationStatus = (String) o[3];
		ExtendedObjectAttribute = (String) o[4];
		TextDescription = (String) o[5];
		UserDefinedAttribute = (String) o[6];
		reservedOBJL0200 = (String) o[7];
		objectASPNumber = (Integer) o[8];
		objectOwner = (String) o[9];
		objectDomain = (String) o[10];
		creationDateAndTime = (String) o[11];
		changeDateAndTime = (String) o[12];
		storage = (String) o[13];
		objectCompressionStatus = (String) o[14];
		allowChangeByProgram = (String) o[15];
		changedByProgram = (String) o[16];
		objectAuditingValue = (String) o[17];
		digitallySigned = (String) o[18];
		digitallySignedBySystemTrustedSource = (String) o[19];
		digitallySignedMoreThanOnce = (String) o[20];
		reservedOBJL0300 = (String) o[21];
		libraryASPNumber = (Integer) o[22];
	}

	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T)  new OBJL0300(input));
	}

	public IOBJL0200 getOBJL0200() {
		OBJL0200 result = new OBJL0200();
		result.ObjectNameUsed = ObjectNameUsed;
		result.objectLibraryNameUsed = objectLibraryNameUsed;
		result.ObjectTypeUsed = ObjectTypeUsed;
		result.ExtendedObjectAttribute = ExtendedObjectAttribute;
		result.InformationStatus = InformationStatus;
		result.objectLibraryNameUsed = objectLibraryNameUsed;
		result.ObjectNameUsed = ObjectNameUsed;
		result.ObjectTypeUsed = ObjectTypeUsed;
		result.TextDescription = TextDescription;
		result.UserDefinedAttribute = UserDefinedAttribute;
		result.reservedOBJL0200 = reservedOBJL0200;
		return result;
	}

	public Integer getObjectASPNumber() {
		return objectASPNumber;
	}

	public String getObjectOwner() {
		return objectOwner;
	}

	public String getObjectDomain() {
		return objectDomain;
	}

	public String getCreationDateAndTime() {
		return creationDateAndTime;
	}

	public String getChangeDateAndTime() {
		return changeDateAndTime;
	}

	public String getStorage() {
		return storage;
	}

	public String getObjectCompressionStatus() {
		return objectCompressionStatus;
	}

	public String getAllowChangeByProgram() {
		return allowChangeByProgram;
	}

	public String getChangedByProgram() {
		return changedByProgram;
	}

	public String getObjectAuditingValue() {
		return objectAuditingValue;
	}

	public String getDigitallySigned() {
		return digitallySigned;
	}

	public String getDigitallySignedBySystemTrustedSource() {
		return digitallySignedBySystemTrustedSource;
	}

	public String getDigitallySignedMoreThanOnce() {
		return digitallySignedMoreThanOnce;
	}

	public String getReservedOBJL0300() {
		return reservedOBJL0300;
	}

	public Integer getLibraryASPNumber() {
		return libraryASPNumber;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Object Name: " + ObjectNameUsed.trim());
		sb.append(" Object Library: " + objectLibraryNameUsed.trim());
		sb.append(" Object Type: " + ObjectTypeUsed.trim());
		sb.append(" Information Status: " + InformationStatus.trim());
		sb.append(" Extended Object Attribute: "
				+ ExtendedObjectAttribute.trim());
		sb.append(" Text Description: " + TextDescription.trim());
		sb.append(" User Defined Attribute: " + UserDefinedAttribute.trim());
		sb.append(" Reserved (OBJL0200): " + reservedOBJL0200.trim());
		sb.append(" Object ASP Number: " + objectASPNumber.toString());
		sb.append(" Object Owner: " + objectOwner.trim());
		sb.append(" Object Domain: " + objectDomain.trim());
		sb.append(" Creation Date & Time: " + creationDateAndTime.trim());
		sb.append(" Change Date & Time: " + changeDateAndTime.trim());
		sb.append(" Storage: " + storage.trim());
		sb.append(" Object Compression Status: "
				+ objectCompressionStatus.trim());
		sb.append(" Allow Change By Program: " + allowChangeByProgram.trim());
		sb.append(" Changed by Program: " + changedByProgram.trim());
		sb.append(" Object Auditing Value: " + objectAuditingValue.trim());
		sb.append(" Digitally Signed: " + digitallySigned.trim());
		sb.append(" Digitally Signed By System Trusted Source: "
				+ digitallySignedBySystemTrustedSource.trim());
		sb.append(" Digitally Signed More Than Once: "
				+ digitallySignedMoreThanOnce.trim());
		sb.append(" Reserved (OBJL0300): " + reservedOBJL0300.trim());
		sb.append(" Library ASP Number: " + libraryASPNumber.toString());

		return sb.toString();
	}


}
