package org.rpgleparser.api.OBJL;

/**
 * Use this interface when working with the OBJL0400 format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IOBJL0400 extends IOBJL0300, OBJLoutputFormat {
	/**
	 * @return the oBJL0300
	 */
	public IOBJL0300 getOBJL0300();
	/**
	 * @return the sourceFileLibraryName
	 */
	public String getSourceFileLibraryName();
	/**
	 * @return the sourceFileMemberName
	 */
	public String getSourceFileMemberName();
	/**
	 * @return the sourceFileName
	 */
	public String getSourceFileName();
	/**
	 * @return the sourceFileUpdatedDateAndTime
	 */
	public String getSourceFileUpdatedDateAndTime();
	/**
	 * @return the creatorUserProfile
	 */
	public String getCreatorUserProfile();
	/**
	 * @return the systemWhereObjectWasCreated
	 */
	public String getSystemWhereObjectWasCreated();
	/**
	 * @return the systemLevel
	 */
	public String getSystemLevel();
	/**
	 * @return the compiler
	 */
	public String getCompiler();
	/**
	 * @return the objectLevel
	 */
	public String getObjectLevel();
	/**
	 * @return the userChanged
	 */
	public String getUserChanged();
	/**
	 * @return the licensedProgram
	 */
	public String getLicensedProgram();
	/**
	 * @return the programTemporaryFix
	 */
	public String getProgramTemporaryFix();

	/**
	 * @return the authorizedProgramAnalysisReport
	 */
	public String getAuthorizedProgramAnalysisReport();
	/**
	 * @return the primaryGroup
	 */
	public String getPrimaryGroup();
	/**
	 * @return the reservedOBJL0400
	 */
	public String getReservedOBJL0400();
	/**
	 * @return the optimumSpaceAlignment
	 */
	public String getOptimumSpaceAlignment();
	/**
	 * @return the primaryAssociatedSpaceSize
	 */
	public Integer getPrimaryAssociatedSpaceSize();
	/**
	 * @return the reservedOBJL04002
	 */
	public String getReservedOBJL04002();
}
