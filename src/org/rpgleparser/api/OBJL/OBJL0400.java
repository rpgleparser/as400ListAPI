package org.rpgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLOBJ OBJL0400 format.
 * @author Eric N. Wilson
 *
 */
public class OBJL0400 extends OBJL0300 implements IOBJL0400, OBJLoutputFormat, Serializable{
	private static final long serialVersionUID = -7803755660096246332L;

	// OBJL0400 List Data Section
	//
	// The following information is returned in the list data section of the
	// OBJL0400 format. For detailed descriptions of the fields in the table,
	// see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 Everything from the OBJL0300 format
	// 172 AC CHAR(10) Source file name
	protected transient AS400Text sourceFileNamex = new AS400Text(10);

	// 182 B6 CHAR(10) Source file library name
	protected transient AS400Text sourceFileLibraryNamex = new AS400Text(10);

	// 192 C0 CHAR(10) Source file member name
	protected transient AS400Text sourceFileMemberNamex = new AS400Text(10);

	// 202 CA CHAR(13) Source file updated date and time
	protected transient AS400Text sourceFileUpdatedDateAndTimex = new AS400Text(13);

	// 215 D7 CHAR(10) Creator's user profile
	protected transient AS400Text creatorUserProfilex = new AS400Text(10);

	// 225 E1 CHAR(8) System where object was created
	protected transient AS400Text systemWhereObjectWasCreatedx = new AS400Text(8);

	// 233 E9 CHAR(9) System level
	protected transient AS400Text systemLevelx = new AS400Text(9);

	// 242 F2 CHAR(16) Compiler
	protected transient AS400Text compilerx = new AS400Text(16);

	// 258 102 CHAR(8) Object level
	protected transient AS400Text objectLevelx = new AS400Text(8);

	// 266 10A CHAR(1) User changed
	protected transient AS400Text userChangedx = new AS400Text(1);

	// 267 10B CHAR(16) Licensed program
	protected transient AS400Text licensedProgramx = new AS400Text(16);

	// 283 11B CHAR(10) Program temporary fix (PTF)
	protected transient AS400Text programTemporaryFixx = new AS400Text(10);

	// 293 125 CHAR(10) Authorized program analysis report (APAR)
	protected transient AS400Text authorizedProgramAnalysisReportx = new AS400Text(10);

	// 303 12F CHAR(10) Primary group
	protected transient AS400Text primaryGroupx = new AS400Text(10);

	// 313 139 CHAR(2) Reserved
	protected transient AS400Text reservedOBJL0400x = new AS400Text(2);

	// 315 13B CHAR(1) Optimum space alignment
	protected transient AS400Text optimumSpaceAlignmentx = new AS400Text(1);

	// 316 13C BINARY(4) Primary associated space size
	protected transient AS400Bin4 primaryAssociatedSpaceSizex = new AS400Bin4();

	// 320 140 CHAR(4) Reserved
	protected transient AS400Text reservedOBJL04002x = new AS400Text(4);

	protected transient AS400DataType[] OBJL0400a = new AS400DataType[] { objectNameUsedx,
			objectLibraryNameUsedx, objectTypeUsedx, informationStatusx,
			extendedObjectAttributex, textDescriptionx, userDefinedAttributex,
			reservedOBJL0200x, objectASPNumberx, objectOwnerx, objectDomainx,
			creationDateAndTimex, changeDateAndTimex, storagex,
			objectCompressionStatusx, allowChangeByProgramx, changedByProgramx,
			objectAuditingValuex, digitallySignedx,
			digitallySignedBySystemTrustedSourcex, digitallySignedMoreThanOncex,
			reservedOBJL0300x, libraryASPNumberx, 
			
			sourceFileNamex,
			sourceFileLibraryNamex, 
			sourceFileMemberNamex,
			sourceFileUpdatedDateAndTimex, 
			creatorUserProfilex,
			systemWhereObjectWasCreatedx, 
			systemLevelx, 
			compilerx, 
			objectLevelx,
			userChangedx, 
			licensedProgramx, 
			programTemporaryFixx,
			authorizedProgramAnalysisReportx, 
			primaryGroupx, 
			reservedOBJL0400x,
			optimumSpaceAlignmentx, 
			primaryAssociatedSpaceSizex,
			reservedOBJL04002x 
			};

	protected transient AS400Structure OBJL0400x = new AS400Structure(OBJL0400a);

	protected String sourceFileLibraryName;

	protected String sourceFileMemberName;

	protected String sourceFileName;

	protected String sourceFileUpdatedDateAndTime;

	protected String creatorUserProfile;

	protected String systemWhereObjectWasCreated;

	protected String systemLevel;

	protected String compiler;

	protected String objectLevel;

	protected String userChanged;

	protected String licensedProgram;

	protected String programTemporaryFix;

	protected String authorizedProgramAnalysisReport;

	protected String primaryGroup;

	protected String reservedOBJL0400;

	protected String optimumSpaceAlignment;

	protected Integer PrimaryAssociatedSpaceSize;

	protected String reservedOBJL04002;

	public OBJL0400(){
		//Default constructor
	}
	public OBJL0400(byte[] input){
		Object[] o =(Object[]) OBJL0400x.toObject(input);
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
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OBJL0400 other = (OBJL0400) obj;
		if (PrimaryAssociatedSpaceSize == null) {
			if (other.PrimaryAssociatedSpaceSize != null)
				return false;
		} else if (!PrimaryAssociatedSpaceSize
				.equals(other.PrimaryAssociatedSpaceSize))
			return false;
		if (authorizedProgramAnalysisReport == null) {
			if (other.authorizedProgramAnalysisReport != null)
				return false;
		} else if (!authorizedProgramAnalysisReport
				.equals(other.authorizedProgramAnalysisReport))
			return false;
		if (compiler == null) {
			if (other.compiler != null)
				return false;
		} else if (!compiler.equals(other.compiler))
			return false;
		if (creatorUserProfile == null) {
			if (other.creatorUserProfile != null)
				return false;
		} else if (!creatorUserProfile.equals(other.creatorUserProfile))
			return false;
		if (licensedProgram == null) {
			if (other.licensedProgram != null)
				return false;
		} else if (!licensedProgram.equals(other.licensedProgram))
			return false;
		if (objectLevel == null) {
			if (other.objectLevel != null)
				return false;
		} else if (!objectLevel.equals(other.objectLevel))
			return false;
		if (optimumSpaceAlignment == null) {
			if (other.optimumSpaceAlignment != null)
				return false;
		} else if (!optimumSpaceAlignment.equals(other.optimumSpaceAlignment))
			return false;
		if (primaryGroup == null) {
			if (other.primaryGroup != null)
				return false;
		} else if (!primaryGroup.equals(other.primaryGroup))
			return false;
		if (programTemporaryFix == null) {
			if (other.programTemporaryFix != null)
				return false;
		} else if (!programTemporaryFix.equals(other.programTemporaryFix))
			return false;
		if (reservedOBJL0400 == null) {
			if (other.reservedOBJL0400 != null)
				return false;
		} else if (!reservedOBJL0400.equals(other.reservedOBJL0400))
			return false;
		if (reservedOBJL04002 == null) {
			if (other.reservedOBJL04002 != null)
				return false;
		} else if (!reservedOBJL04002.equals(other.reservedOBJL04002))
			return false;
		if (sourceFileLibraryName == null) {
			if (other.sourceFileLibraryName != null)
				return false;
		} else if (!sourceFileLibraryName.equals(other.sourceFileLibraryName))
			return false;
		if (sourceFileMemberName == null) {
			if (other.sourceFileMemberName != null)
				return false;
		} else if (!sourceFileMemberName.equals(other.sourceFileMemberName))
			return false;
		if (sourceFileName == null) {
			if (other.sourceFileName != null)
				return false;
		} else if (!sourceFileName.equals(other.sourceFileName))
			return false;
		if (sourceFileUpdatedDateAndTime == null) {
			if (other.sourceFileUpdatedDateAndTime != null)
				return false;
		} else if (!sourceFileUpdatedDateAndTime
				.equals(other.sourceFileUpdatedDateAndTime))
			return false;
		if (systemLevel == null) {
			if (other.systemLevel != null)
				return false;
		} else if (!systemLevel.equals(other.systemLevel))
			return false;
		if (systemWhereObjectWasCreated == null) {
			if (other.systemWhereObjectWasCreated != null)
				return false;
		} else if (!systemWhereObjectWasCreated
				.equals(other.systemWhereObjectWasCreated))
			return false;
		if (userChanged == null) {
			if (other.userChanged != null)
				return false;
		} else if (!userChanged.equals(other.userChanged))
			return false;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new OBJL0400(input));
	}

	public String getAuthorizedProgramAnalysisReport() {
		return authorizedProgramAnalysisReport;
	}

	public String getCompiler() {
		return compiler;
	}

	public String getCreatorUserProfile() {
		return creatorUserProfile;
	}

	public String getLicensedProgram() {
		return licensedProgram;
	}

	public String getObjectLevel() {
		return objectLevel;
	}

	public IOBJL0300 getOBJL0300() {
		OBJL0300 result = new OBJL0300();
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

		return result;
	}

	public String getOptimumSpaceAlignment() {
		return optimumSpaceAlignment;
	}

	public Integer getPrimaryAssociatedSpaceSize() {
		return PrimaryAssociatedSpaceSize;
	}

	public String getPrimaryGroup() {
		return primaryGroup;
	}

	public String getProgramTemporaryFix() {
		return programTemporaryFix;
	}

	public String getReservedOBJL0400() {
		return reservedOBJL0400;
	}

	public String getReservedOBJL04002() {
		return reservedOBJL04002;
	}

	public String getSourceFileLibraryName() {
		return sourceFileLibraryName;
	}

	public String getSourceFileMemberName() {
		return sourceFileMemberName;
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public String getSourceFileUpdatedDateAndTime() {
		return sourceFileUpdatedDateAndTime;
	}

	public String getSystemLevel() {
		return systemLevel;
	}

	public String getSystemWhereObjectWasCreated() {
		return systemWhereObjectWasCreated;
	}

	public String getUserChanged() {
		return userChanged;
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

		return sb.toString();
	}

}
