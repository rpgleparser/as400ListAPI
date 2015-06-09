package org.rpgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLOBJ OBJL0600 format.
 * @author Eric N. Wilson
 *
 */
public class OBJL0600 extends OBJL0500 implements IOBJL0600, OBJLoutputFormat, Serializable{
	private static final long serialVersionUID = 2493507646818808790L;

	// OBJL0600 List Data Section
	//
	// The following information is returned in the list data section of the
	// OBJL0600 format. For detailed descriptions of the fields in the table,
	// see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 Everything from the OBJL0500 format
	// 532 214 CHAR(8) Last-used date and time
	protected transient AS400Text lastUsedDateAndTimex = new AS400Text(8);

	// 540 21C CHAR(8) Reset date and time
	protected transient AS400Text resetDateAndTimex = new AS400Text(8);

	// 548 224 BINARY(4) Days-used count
	protected transient AS400Bin4 daysUsedCountx = new AS400Bin4();

	// 552 228 CHAR(1) Usage information updated
	protected transient AS400Text usageInformationUpdatedx = new AS400Text(1);

	// 553 229 CHAR(10) Object auxiliary storage pool (ASP) device name
	protected transient AS400Text objectASPDeviceNamex = new AS400Text(10);

	// 563 233 CHAR(10) Library auxiliary storage pool (ASP) device name
	protected transient AS400Text libraryASPDeviceNamex = new AS400Text(10);

	// 573 23D CHAR(3) Reserved
	protected transient AS400Text reservedOBJL0600x = new AS400Text(3);

	protected transient AS400DataType[] OBJL0600a = new AS400DataType[] { objectNameUsedx,
			objectLibraryNameUsedx, objectTypeUsedx, informationStatusx,
			extendedObjectAttributex, textDescriptionx, userDefinedAttributex,
			reservedOBJL0200x, objectASPNumberx, objectOwnerx, objectDomainx,
			creationDateAndTimex, changeDateAndTimex, storagex,
			objectCompressionStatusx, allowChangeByProgramx, changedByProgramx,
			objectAuditingValuex, digitallySignedx,
			digitallySignedBySystemTrustedSourcex, digitallySignedMoreThanOncex,
			reservedOBJL0300x, libraryASPNumberx, sourceFileNamex,
			sourceFileLibraryNamex, sourceFileMemberNamex,
			sourceFileUpdatedDateAndTimex, creatorUserProfilex,
			systemWhereObjectWasCreatedx, systemLevelx, compilerx, objectLevelx,
			userChangedx, licensedProgramx, programTemporaryFixx,
			authorizedProgramAnalysisReportx, primaryGroupx, reservedOBJL0400x,
			optimumSpaceAlignmentx, primaryAssociatedSpaceSizex,
			reservedOBJL04002x, objectSavedDateAndTimex,
			objectRestoredDateAndTimex, savedSizex, savedSizeMultiplierx,
			saveSequenceNumberx, saveCommandx, saveVolumeIDx, saveDevicex,
			saveFileNamex, saveFileLibraryNamex, saveLabelx,
			saveActiveDateAndTimex, journalStatusx, journalNamex,
			journalLibraryNamex, journalImagesx, journalEntriesToBeOmittedx,
			journalStartDateAndTimex, remoteJournalFilterx, reservedOBJL0500x,
			
			lastUsedDateAndTimex, 
			resetDateAndTimex, 
			daysUsedCountx,
			usageInformationUpdatedx, 
			objectASPDeviceNamex, 
			libraryASPDeviceNamex,
			reservedOBJL0600x 
			};

	protected transient AS400Structure OBJL0600x = new AS400Structure(OBJL0600a);

	protected String reservedOBJL0600;

	protected String libraryASPDeviceName;

	protected String objectASPDeviceName;

	protected String usageInformationUpdated;

	protected Integer daysUsedCount;

	protected String resetDateAndTime;

	protected String lastUsedDateAndTime;

	public OBJL0600(){
		//Default constructor
	}
	
	public OBJL0600(byte[] input){
		Object[] o = (Object[])OBJL0600x.toObject(input);
		ObjectNameUsed = (String)o[0];
		objectLibraryNameUsed = (String)o[1];
		ObjectTypeUsed = (String)o[2];
		InformationStatus = (String)o[3]; 
		ExtendedObjectAttribute = (String)o[4]; 
		TextDescription = (String)o[5];
		UserDefinedAttribute = (String)o[6]; 
		reservedOBJL0200 = (String)o[7];
		objectASPNumber = (Integer)o[8];
		objectOwner = (String)o[9];
		objectDomain = (String)o[10];
		creationDateAndTime = (String)o[11];
		changeDateAndTime = (String)o[12];
		storage = (String)o[13];
		objectCompressionStatus = (String)o[14]; 
		allowChangeByProgram = (String)o[15];
		changedByProgram = (String)o[16];
		objectAuditingValue = (String)o[17]; 
		digitallySigned = (String)o[18];
		digitallySignedBySystemTrustedSource = (String)o[19]; 
		digitallySignedMoreThanOnce = (String)o[20];
		reservedOBJL0300 = (String)o[21];
		libraryASPNumber = (Integer)o[22];
		sourceFileName = (String)o[23];
		sourceFileLibraryName  = (String)o[24];
		sourceFileMemberName = (String)o[25];
		sourceFileUpdatedDateAndTime  = (String)o[26];
		creatorUserProfile = (String)o[27];
		systemWhereObjectWasCreated  = (String)o[28];
		systemLevel  = (String)o[29];
		compiler  = (String)o[30];
		objectLevel = (String)o[31];
		userChanged  = (String)o[32];
		licensedProgram  = (String)o[33];
		programTemporaryFix = (String)o[34];
		authorizedProgramAnalysisReport  = (String)o[35];
		primaryGroup  = (String)o[36];
		reservedOBJL0400 = (String)o[37];
		optimumSpaceAlignment  = (String)o[38];
		PrimaryAssociatedSpaceSize = (Integer)o[39];
		reservedOBJL04002 = (String)o[40];
		objectSavedDateAndTime  = (String)o[41];
		objectRestoredDateAndTime = (String)o[42]; 
		savedSize = (Integer)o[43];
		savedSizeMultiplier = (Integer)o[44];
		saveSequenceNumber = (Integer)o[45];
		saveCommand = (String)o[46];
		saveVolumeID = (String)o[47]; 
		saveDevice = (String)o[48];
		saveFileName = (String)o[49];
		saveFileLibraryName = (String)o[50];
		saveLabel = (String)o[51];
		saveActiveDateAndTime = (String)o[52];
		journalStatus = (String)o[53];
		journalName = (String)o[54];
		journalLibraryName = (String)o[55];
		journalImages = (String)o[56];
		journalEntriesToBeOmitted = (String)o[57];
		journalStartDateAndTime = (String)o[58];
		remoteJournalFilter = (String)o[59];
		reservedOBJL0500 = (String)o[60];
		lastUsedDateAndTime  = (String)o[61];
		resetDateAndTime = (String)o[62]; 
		daysUsedCount = (Integer)o[63];
		usageInformationUpdated = (String)o[64];
		objectASPDeviceName = (String)o[65];
		libraryASPDeviceName = (String)o[66];
		reservedOBJL0600 = (String)o[67];

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new OBJL0600(input));
	}


	public IOBJL0500 getOBJL0500() {
		OBJL0500 result = new OBJL0500();
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
		result.objectASPNumber = objectASPNumber;
		result.objectOwner = objectOwner;
		result.objectDomain = objectDomain;
		result.creationDateAndTime = creationDateAndTime;
		result.changeDateAndTime = changeDateAndTime;
		result.storage = storage;
		result.objectCompressionStatus = objectCompressionStatus; 
		result.allowChangeByProgram = allowChangeByProgram;
		result.changedByProgram = changedByProgram;
		result.objectAuditingValue = objectAuditingValue; 
		result.digitallySigned = digitallySigned;
		result.digitallySignedBySystemTrustedSource = digitallySignedBySystemTrustedSource; 
		result.digitallySignedMoreThanOnce = digitallySignedMoreThanOnce;
		result.reservedOBJL0300 = reservedOBJL0300;
		result.libraryASPNumber = libraryASPNumber;
		result.sourceFileName = sourceFileName;
		result.sourceFileLibraryName  = sourceFileLibraryName;
		result.sourceFileMemberName = sourceFileMemberName;
		result.sourceFileUpdatedDateAndTime  = sourceFileUpdatedDateAndTime;
		result.creatorUserProfile = creatorUserProfile;
		result.systemWhereObjectWasCreated  = systemWhereObjectWasCreated;
		result.systemLevel  = systemLevel;
		result.compiler  = compiler;
		result.objectLevel = objectLevel;
		result.userChanged  = userChanged;
		result.licensedProgram  = licensedProgram;
		result.programTemporaryFix = programTemporaryFix;
		result.authorizedProgramAnalysisReport  = authorizedProgramAnalysisReport;
		result.primaryGroup  = primaryGroup;
		result.reservedOBJL0400 = reservedOBJL0400;
		result.optimumSpaceAlignment  = optimumSpaceAlignment;
		result.PrimaryAssociatedSpaceSize = PrimaryAssociatedSpaceSize;
		result.reservedOBJL04002 = reservedOBJL04002;
		
		return result;
	}

	public String getLastUsedDateAndTime() {
		return lastUsedDateAndTime;
	}

	public String getResetDateAndTime() {
		return resetDateAndTime;
	}

	public Integer getDaysUsedCount() {
		return daysUsedCount;
	}

	public String getUsageInformationUpdated() {
		return usageInformationUpdated;
	}

	public String getObjectASPDeviceName() {
		return objectASPDeviceName;
	}

	public String getLibraryASPDeviceName() {
		return libraryASPDeviceName;
	}

	public String getReservedOBJL0600() {
		return reservedOBJL0600;
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
		sb.append(" Object ASP Number: " + objectASPNumber.toString());
		sb.append(" Object Owner: " + objectOwner.trim());
		sb.append(" Object Domain: " + objectDomain.trim());
		sb.append(" Creation Date & Time: " + creationDateAndTime.trim());
		sb.append(" Change Date & Time: " + changeDateAndTime.trim());
		sb.append(" Storage: " + storage.trim());
		sb.append(" Object Compression Status: " + objectCompressionStatus.trim()); 
		sb.append(" Allow Change By Program: " + allowChangeByProgram.trim());
		sb.append(" Changed by Program: " + changedByProgram.trim());
		sb.append(" Object Auditing Value: " + objectAuditingValue.trim()); 
		sb.append(" Digitally Signed: " + digitallySigned.trim());
		sb.append(" Digitally Signed By System Trusted Source: " + digitallySignedBySystemTrustedSource.trim()); 
		sb.append(" Digitally Signed More Than Once: " + digitallySignedMoreThanOnce.trim());
		sb.append(" Reserved (OBJL0300): " + reservedOBJL0300.trim());
		sb.append(" Library ASP Number: " + libraryASPNumber.toString());
		sb.append(" Source File Name: " + sourceFileName.trim());
		sb.append(" Source File Library: " + sourceFileLibraryName.trim());
		sb.append(" Source File Member: " + sourceFileMemberName.trim());
		sb.append(" Source File Updated Date And Time: " + sourceFileUpdatedDateAndTime.trim());
		sb.append(" Creator User Profile: " +  creatorUserProfile.trim());
		sb.append(" System Where Object Was Created: " + systemWhereObjectWasCreated.trim());
		sb.append(" System Level: " + systemLevel.trim());
		sb.append(" Compiler: " + compiler.trim());
		sb.append(" Object Level: " + objectLevel.trim());
		sb.append(" User Change: " + userChanged.trim());
		sb.append(" Licensed Program: " + licensedProgram.trim());
		sb.append(" Program Temporary Fix: " + programTemporaryFix.trim());
		sb.append(" Authorized Program Analysis Report: " + authorizedProgramAnalysisReport.trim());
		sb.append(" Primary Group: " + primaryGroup.trim());
		sb.append(" Reserved (OBJL0400): " + reservedOBJL0400.trim());
		sb.append(" Optimum Space Alignment: " + optimumSpaceAlignment.trim());
		sb.append(" Primary Associated Space Size: " + PrimaryAssociatedSpaceSize.toString());
		sb.append(" Reserved 2 (OBJL0400): " + reservedOBJL04002.trim());
		sb.append(" Object Saved Date And Time: "+ objectSavedDateAndTime.trim());
		sb.append(" Object Restored Date And Time: " + objectRestoredDateAndTime.trim()); 
		sb.append(" Saved Size: " + savedSize.toString());
		sb.append(" Saved Size Multiplier: " + savedSizeMultiplier.toString());
		sb.append(" Save Sequence Number: " + saveSequenceNumber.toString());
		sb.append(" Save Command: " + saveCommand.trim());
		sb.append(" Save Volume ID: " +  saveVolumeID.trim()); 
		sb.append(" Save Device: " +  saveDevice.trim());
		sb.append(" Save File Name: " + saveFileName.trim());
		sb.append(" Save File Library: " + saveFileLibraryName.trim());
		sb.append(" Save Label: " +  saveLabel.trim());
		sb.append(" Save While Active Date And Time: " + saveActiveDateAndTime.trim());
		sb.append(" Journal Status: " + journalStatus.trim());
		sb.append(" Journal Name: " + journalName.trim());
		sb.append(" Journal Library: " + journalLibraryName.trim());
		sb.append(" Journal Images: " + journalImages.trim());
		sb.append(" Journal Entries To Be Omitted: " + journalEntriesToBeOmitted.trim());
		sb.append(" Journal Start Date And Time: " + journalStartDateAndTime.trim());
		sb.append(" Remote Journal Filter: " + remoteJournalFilter.trim());
		sb.append(" Reserved (OBJL0500): " + reservedOBJL0500.trim());
		sb.append(" Last Used Date And Time: " + lastUsedDateAndTime.trim());
		sb.append(" Reset Date And Time: " + resetDateAndTime.trim()); 
		sb.append(" Days Used Count: " + daysUsedCount.toString());
		sb.append(" Usage Information Updated: " + usageInformationUpdated.trim());
		sb.append(" Object ASP Device Name: " + objectASPDeviceName.trim());
		sb.append(" Library ASP Device Name: " + libraryASPDeviceName.trim());
		sb.append(" Reserved (OBJL0600): " + reservedOBJL0600.trim());

		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OBJL0600 other = (OBJL0600) obj;
		if (daysUsedCount == null) {
			if (other.daysUsedCount != null)
				return false;
		} else if (!daysUsedCount.equals(other.daysUsedCount))
			return false;
		if (lastUsedDateAndTime == null) {
			if (other.lastUsedDateAndTime != null)
				return false;
		} else if (!lastUsedDateAndTime.equals(other.lastUsedDateAndTime))
			return false;
		if (libraryASPDeviceName == null) {
			if (other.libraryASPDeviceName != null)
				return false;
		} else if (!libraryASPDeviceName.equals(other.libraryASPDeviceName))
			return false;
		if (objectASPDeviceName == null) {
			if (other.objectASPDeviceName != null)
				return false;
		} else if (!objectASPDeviceName.equals(other.objectASPDeviceName))
			return false;
		if (reservedOBJL0600 == null) {
			if (other.reservedOBJL0600 != null)
				return false;
		} else if (!reservedOBJL0600.equals(other.reservedOBJL0600))
			return false;
		if (resetDateAndTime == null) {
			if (other.resetDateAndTime != null)
				return false;
		} else if (!resetDateAndTime.equals(other.resetDateAndTime))
			return false;
		if (usageInformationUpdated == null) {
			if (other.usageInformationUpdated != null)
				return false;
		} else if (!usageInformationUpdated
				.equals(other.usageInformationUpdated))
			return false;
		return true;
	}

}
