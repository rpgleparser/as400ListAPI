package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class OBJL0700  extends OBJL0600 implements IOBJL0700, OBJLoutputFormat, Serializable{
	private static final long serialVersionUID = 5445605653804452062L;

	// OBJL0700 List Data Section
	//
	// The following information is returned in the list data section of the
	// OBJL0700 format. For detailed descriptions of the fields in the table,
	// see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 Everything from the OBJL0600 format
	// 576 240 BINARY(4) Object size
	protected transient AS400Bin4 objectSizex = new AS400Bin4();

	// 580 244 BINARY(4) Object size multiplier
	protected transient AS400Bin4 objectSizeMultiplierx = new AS400Bin4();

	// 584 248 CHAR(1) Object overflowed auxiliary storage pool (ASP) indicator
	protected transient AS400Text objectOverflowedASPIndicatorx = new AS400Text(1);

	// 585 249 CHAR(10) Object auxiliary storage pool (ASP) group name
	protected transient AS400Text objectASPGroupNamex = new AS400Text(10);

	// 595 253 CHAR(10) Library auxiliary storage pool (ASP) group name
	protected transient AS400Text libraryASPGroupNamex = new AS400Text(10);

	// 605 25D CHAR(10) Starting journal receiver name for apply
	protected transient AS400Text startingJournalReceiverNameForApplyx = new AS400Text(10);

	// 615 267 CHAR(10) Starting journal receiver library name
	protected transient AS400Text startingJournalReceiverLibraryNamex = new AS400Text(10);

	// 625 271 CHAR(10) Starting journal receiver library auxiliary storage pool
	// (ASP) device name
	protected transient AS400Text startingJournalReceiverLibraryASPDeviceNamex = new AS400Text(
			10);

	// 635 27B CHAR(10) Starting journal receiver library auxiliary storage pool
	// (ASP) group name
	protected transient AS400Text startingJournalReceiverLibraryASPGroupNamex = new AS400Text(
			10);
	// 645 285 CHAR(3) Reserved
	protected transient AS400Text reservedOBJL0700x = new AS400Text(3);
	
	protected transient AS400DataType[] OBJL0700a = new AS400DataType[] { objectNameUsedx,
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
			lastUsedDateAndTimex, resetDateAndTimex, daysUsedCountx,
			usageInformationUpdatedx, objectASPDeviceNamex, libraryASPDeviceNamex,
			reservedOBJL0600x,

			objectSizex, 
			objectSizeMultiplierx, 
			objectOverflowedASPIndicatorx,
			objectASPGroupNamex, 
			libraryASPGroupNamex,
			startingJournalReceiverNameForApplyx,
			startingJournalReceiverLibraryNamex,
			startingJournalReceiverLibraryASPDeviceNamex,
			startingJournalReceiverLibraryASPGroupNamex, 
			reservedOBJL0700x
			};
	
	protected transient AS400Structure OBJL0700x = new AS400Structure(OBJL0700a);

	protected String objectASPGroupName;

	protected String objectOverflowedASPIndicator;

	protected Integer objectSizeMultiplier;

	protected Integer objectSize;

	protected String reservedOBJL0700;

	protected String startingJournalReceiverNameForApply;

	protected String startingJournalReceiverLibraryName;

	protected String startingJournalReceiverLibraryASPGroupName;

	protected String startingJournalReceiverLibraryASPDeviceName;

	protected String libraryASPGroupName;
	
public OBJL0700(){
	//Default Constructor
}
public OBJL0700(byte[] input){
	Object[] o = (Object[])OBJL0700x.toObject(input);
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
	objectSize = (Integer)o[68];
	objectSizeMultiplier = (Integer)o[69];
	objectOverflowedASPIndicator = (String)o[70];
	objectASPGroupName = (String)o[71];
	libraryASPGroupName = (String)o[72];
	startingJournalReceiverNameForApply = (String)o[73];
	startingJournalReceiverLibraryName = (String)o[74];
	startingJournalReceiverLibraryASPDeviceName = (String)o[75];
	startingJournalReceiverLibraryASPGroupName = (String)o[76];
	reservedOBJL0700 = (String)o[77];

}

@SuppressWarnings("unchecked")
	@Override
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new OBJL0700(input));
	}

	public String getLibraryASPGroupName() {
		return libraryASPGroupName;
	}

	public String getObjectASPGroupName() {
		return objectASPGroupName;
	}

	public String getObjectOverflowedASPIndicator() {
		return objectOverflowedASPIndicator;
	}

	public Integer getObjectSize() {
		return objectSize;
	}

	public Integer getObjectSizeMultiplier() {
		return objectSizeMultiplier;
	}

	public IOBJL0600 getOBJL0600() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReservedOBJL0700() {
		return reservedOBJL0700;
	}

	public String getStartingJournalReceiverLibraryASPDeviceName() {
		return startingJournalReceiverLibraryASPDeviceName;
	}

	public String getStartingJournalReceiverLibraryASPGroupName() {
		return startingJournalReceiverLibraryASPGroupName;
	}

	public String getStartingJournalReceiverLibraryName() {
		return startingJournalReceiverLibraryName;
	}

	public String getStartingJournalReceiverNameForApply() {
		return startingJournalReceiverNameForApply;
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
		sb.append(" Object Size: " + objectSize.toString());
		sb.append(" Object Size Multiplier: " + objectSizeMultiplier.toString());
		sb.append(" Object Overflowed ASP Indicator: " + objectOverflowedASPIndicator.trim());
		sb.append(" Object ASP Group Name: " + objectASPGroupName.trim());
		sb.append(" Library ASP Group Name: " + libraryASPGroupName.trim());
		sb.append(" Starting Journal Receiver Name For Apply: " + startingJournalReceiverNameForApply.trim());
		sb.append(" Starting Journal Receiver Library: " + startingJournalReceiverLibraryName.trim());
		sb.append(" Starting Journal Receiver Library ASP Device Name: " + startingJournalReceiverLibraryASPDeviceName.trim());
		sb.append(" Starting Journal Receiver Library ASP Group Name: " + startingJournalReceiverLibraryASPGroupName.trim());
		sb.append(" Reserved (OBJL0700): " + reservedOBJL0700.trim());

		return sb.toString();
	}

}
