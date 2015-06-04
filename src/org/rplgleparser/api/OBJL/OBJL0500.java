package org.rplgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

public class OBJL0500 extends OBJL0400 implements IOBJL0500,
		OBJLoutputFormat, Serializable {

	private static final long serialVersionUID = -4230722141009096457L;

	// OBJL0500 List Data Section
	//
	// The following information is returned in the list data section of the
	// OBJL0500 format. For detailed descriptions of the fields in the table,
	// see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 Everything from the OBJL0400 format
	// 324 144 CHAR(8) Object saved date and time
	protected transient AS400Text objectSavedDateAndTimex = new AS400Text(8);

	// 332 14C CHAR(8) Object restored date and time
	protected transient AS400Text objectRestoredDateAndTimex = new AS400Text(8);

	// 340 154 BINARY(4) Saved size
	protected transient AS400Bin4 savedSizex = new AS400Bin4();

	// 344 158 BINARY(4) Saved size multiplier
	protected transient AS400Bin4 savedSizeMultiplierx = new AS400Bin4();

	// 348 15C BINARY(4) Save sequence number
	protected transient AS400Bin4 saveSequenceNumberx = new AS400Bin4();

	// 352 160 CHAR(10) Save command
	protected transient AS400Text saveCommandx = new AS400Text(10);

	// 362 16A CHAR(71) Save volume ID
	protected transient AS400Text saveVolumeIDx = new AS400Text(71);

	// 433 1B1 CHAR(10) Save device
	protected transient AS400Text saveDevicex = new AS400Text(10);

	// 443 1BB CHAR(10) Save file name
	protected transient AS400Text saveFileNamex = new AS400Text(10);

	// 453 1C5 CHAR(10) Save file library name
	protected transient AS400Text saveFileLibraryNamex = new AS400Text(10);

	// 463 1CF CHAR(17) Save label
	protected transient AS400Text saveLabelx = new AS400Text(17);

	// 480 1E0 CHAR(8) Save active date and time
	protected transient AS400Text saveActiveDateAndTimex = new AS400Text(8);

	// 488 1E8 CHAR(1) Journal status
	protected transient AS400Text journalStatusx = new AS400Text(1);

	// 489 1E9 CHAR(10) Journal name
	protected transient AS400Text journalNamex = new AS400Text(10);

	// 499 1F3 CHAR(10) Journal library name
	protected transient AS400Text journalLibraryNamex = new AS400Text(10);

	// 509 1FD CHAR(1) Journal images
	protected transient AS400Text journalImagesx = new AS400Text(1);

	// 510 1FE CHAR(1) Journal entries to be omitted
	protected transient AS400Text journalEntriesToBeOmittedx = new AS400Text(1);

	// 511 1FF CHAR(8) Journal start date and time
	protected transient AS400Text journalStartDateAndTimex = new AS400Text(8);

	// Start of change519 207 CHAR(1) Remote journal filterEnd of change
	protected transient AS400Text remoteJournalFilterx = new AS400Text(1);

	// Start of change520 208 CHAR(12) ReservedEnd of change
	protected transient AS400Text reservedOBJL0500x = new AS400Text(12);

	protected transient AS400DataType[] OBJL0500a = new AS400DataType[] {
			objectNameUsedx, objectLibraryNameUsedx, objectTypeUsedx,
			informationStatusx, extendedObjectAttributex, textDescriptionx,
			userDefinedAttributex, reservedOBJL0200x, objectASPNumberx,
			objectOwnerx, objectDomainx, creationDateAndTimex,
			changeDateAndTimex, storagex, objectCompressionStatusx,
			allowChangeByProgramx, changedByProgramx, objectAuditingValuex,
			digitallySignedx, digitallySignedBySystemTrustedSourcex,
			digitallySignedMoreThanOncex, reservedOBJL0300x, libraryASPNumberx,
			sourceFileNamex, sourceFileLibraryNamex, sourceFileMemberNamex,
			sourceFileUpdatedDateAndTimex, creatorUserProfilex,
			systemWhereObjectWasCreatedx, systemLevelx, compilerx,
			objectLevelx, userChangedx, licensedProgramx, programTemporaryFixx,
			authorizedProgramAnalysisReportx, primaryGroupx, reservedOBJL0400x,
			optimumSpaceAlignmentx, primaryAssociatedSpaceSizex,
			reservedOBJL04002x,
			objectSavedDateAndTimex, 
			objectRestoredDateAndTimex, 
			savedSizex,
			savedSizeMultiplierx, 
			saveSequenceNumberx, 
			saveCommandx,
			saveVolumeIDx, 
			saveDevicex, 
			saveFileNamex, 
			saveFileLibraryNamex,
			saveLabelx, 
			saveActiveDateAndTimex, 
			journalStatusx, 
			journalNamex,
			journalLibraryNamex, 
			journalImagesx, 
			journalEntriesToBeOmittedx,
			journalStartDateAndTimex, 
			remoteJournalFilterx, 
			reservedOBJL0500x };

	protected transient AS400Structure OBJL0500x = new AS400Structure(OBJL0500a);

	protected String objectSavedDateAndTime;

	protected String objectRestoredDateAndTime;

	protected Integer savedSize;

	protected String saveActiveDateAndTime;

	protected String saveCommand;

	protected String saveDevice;

	protected Integer savedSizeMultiplier;

	protected String saveFileLibraryName;

	protected String saveFileName;

	protected String saveLabel;

	protected Integer saveSequenceNumber;

	protected String saveVolumeID;

	protected String journalEntriesToBeOmitted;

	protected String journalImages;

	protected String journalLibraryName;

	protected String journalName;

	protected String journalStartDateAndTime;

	protected String journalStatus;

	protected String remoteJournalFilter;

	protected String reservedOBJL0500;

	public OBJL0500() {
		// default constructor
	}

	public OBJL0500(byte[] input){
		Object[] o = (Object[])OBJL0500x.toObject(input);
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
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new OBJL0500(input));
	}

	public IOBJL0400 getOBJL0400() {
		OBJL0400 result = new OBJL0400();
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

	public String getObjectSavedDateAndTime() {
		return objectSavedDateAndTime;
	}

	public String getObjectRestoredDateAndTime() {
		return objectRestoredDateAndTime;
	}

	public Integer getSavedSize() {
		return savedSize;
	}

	public String getSaveActiveDateAndTime() {
		return saveActiveDateAndTime;
	}

	public String getSaveCommand() {
		return saveCommand;
	}

	public String getSaveDevice() {
		return saveDevice;
	}

	public Integer getSavedSizeMultiplier() {
		return savedSizeMultiplier;
	}

	public String getSaveFileLibraryName() {
		return saveFileLibraryName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public String getSaveLabel() {
		return saveLabel;
	}

	public Integer getSaveSequenceNumber() {
		return saveSequenceNumber;
	}

	public String getSaveVolumeID() {
		return saveVolumeID;
	}

	public String getJournalEntriesToBeOmitted() {
		return journalEntriesToBeOmitted;
	}

	public String getJournalImages() {
		return journalImages;
	}

	public String getJournalLibraryName() {
		return journalLibraryName;
	}

	public String getJournalName() {
		return journalName;
	}

	public String getJournalStartDateAndTime() {
		return journalStartDateAndTime;
	}

	public String getJournalStatus() {
		return journalStatus;
	}

	public String getRemoteJournalFilter() {
		return remoteJournalFilter;
	}

	public String getReservedOBJL0500() {
		return reservedOBJL0500;
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

		return sb.toString();
	}

}
