package org.rpgleparser.api.LFLD;

import java.math.BigDecimal;

/**
 * Public interface of classes that implement the IBM QUSLFLD FLDL0100 interface. 
 * Allows read only access to all the data type values.
 * @author Eric N. Wilson
 *
 */
public interface IFLDL0100 {
	/**
	 * @return the fieldName
	 */
	public String getFieldName();

	/**
	 * @return the dataType
	 */
	public String getDataType();

	/**
	 * @return the use
	 */
	public String getUse();
	/**
	 * @return the outputBufferPosition
	 */
	public Integer getOutputBufferPosition();

	/**
	 * @return the inputBufferPosition
	 */
	public Integer getInputBufferPosition();

	/**
	 * @return the fieldLengthInBytes
	 */
	public Integer getFieldLengthInBytes();

	/**
	 * @return the digits
	 */
	public Integer getDigits();

	/**
	 * @return the decimalPositions
	 */
	public Integer getDecimalPositions();

	/**
	 * @return the fieldTextDescription
	 */
	public String getFieldTextDescription();

	/**
	 * @return the editCode
	 */
	public String getEditCode();

	/**
	 * @return the editWordLength
	 */
	public Integer getEditWordLength();

	/**
	 * @return the editWord
	 */
	public String getEditWord();

	/**
	 * @return the columnHeading1
	 */
	public String getColumnHeading1();

	/**
	 * @return the columnHeading2
	 */
	public String getColumnHeading2();

	/**
	 * @return the columnHeading3
	 */
	public String getColumnHeading3();

	/**
	 * @return the internalFieldName
	 */
	public String getInternalFieldName();

	/**
	 * @return the alternativeFieldName
	 */
	public String getAlternativeFieldName();

	/**
	 * @return the lengthOfAlternativeFieldName
	 */
	public Integer getLengthOfAlternativeFieldName();

	/**
	 * @return the numberOfDBCSCharacters
	 */
	public Integer getNumberOfDBCSCharacters();

	/**
	 * @return the nullValuesAllowed
	 */
	public String getNullValuesAllowed();

	/**
	 * @return the hostVariableIndicator
	 */
	public String getHostVariableIndicator();

	/**
	 * @return the dateAndTimeFormat
	 */
	public String getDateAndTimeFormat();
	/**
	 * @return the dateAndTimeSeparator
	 */
	public String getDateAndTimeSeparator();

	/**
	 * @return the variableLengthFieldIndicator
	 */
	public String getVariableLengthFieldIndicator();

	/**
	 * @return the fieldTextDescriptionCCSID
	 */
	public Integer getFieldTextDescriptionCCSID();

	/**
	 * @return the fieldDataCCSID
	 */
	public Integer getFieldDataCCSID();

	/**
	 * @return the fieldColumnHeadingsCCSID
	 */
	public Integer getFieldColumnHeadingsCCSID();

	/**
	 * @return the fieldEditWordsCCSID
	 */
	public Integer getFieldEditWordsCCSID();

	/**
	 * @return the ucs2DisplayedFieldLength
	 */
	public Integer getUcs2DisplayedFieldLength();

	/**
	 * @return the fieldDataEncodingScheme
	 */
	public Integer getFieldDataEncodingScheme();

	/**
	 * @return the maximumLargeObjectFieldLength
	 */
	public Integer getMaximumLargeObjectFieldLength();

	/**
	 * @return the padLengthForLargeObject
	 */
	public Integer getPadLengthForLargeObject();

	/**
	 * @return the lengthOfUserDefinedTypeName
	 */
	public Integer getLengthOfUserDefinedTypeName();

	/**
	 * @return the userDefinedTypeName
	 */
	public String getUserDefinedTypeName();

	/**
	 * @return the userDefinedTypeLibraryName
	 */
	public String getUserDefinedTypeLibraryName();

	/**
	 * @return the datalinkLinkControl
	 */
	public String getDatalinkLinkControl();

	/**
	 * @return the datalinkIntegrity
	 */
	public String getDatalinkIntegrity();

	/**
	 * @return the datalinkReadPermission
	 */
	public String getDatalinkReadPermission();

	/**
	 * @return the datalinkWritePermission
	 */
	public String getDatalinkWritePermission();

	/**
	 * @return the datalinkRecovery
	 */
	public String getDatalinkRecovery();

	/**
	 * @return the datalinkUnlinkControl
	 */
	public String getDatalinkUnlinkControl();

	/**
	 * @return the displayOrPrintRowNumber
	 */
	public Integer getDisplayOrPrintRowNumber();

	/**
	 * @return the displayOrPrintColumnNumber
	 */
	public Integer getDisplayOrPrintColumnNumber();

	/**
	 * @return the rowidColumn
	 */
	public String getRowidColumn();

	/**
	 * @return the identityColumn
	 */
	public String getIdentityColumn();

	/**
	 * @return the generatedBy
	 */
	public String getGeneratedBy();

	/**
	 * @return the identityColumnCycle
	 */
	public String getIdentityColumnCycle();

	/**
	 * @return the identityColumnOriginalStartWith
	 */
	public BigDecimal getIdentityColumnOriginalStartWith();

	/**
	 * @return the identityColumnCurrentStartWith
	 */
	public BigDecimal getIdentityColumnCurrentStartWith();

	/**
	 * @return the identityColumnIncrementBy
	 */
	public Integer getIdentityColumnIncrementBy();

	/**
	 * @return the identityColumnMinValue
	 */
	public BigDecimal getIdentityColumnMinValue();

	/**
	 * @return the identityColumnMaxValue
	 */
	public BigDecimal getIdentityColumnMaxValue();

	/**
	 * @return the identityColumnCache
	 */
	public Integer getIdentityColumnCache();

	/**
	 * @return the identityColumnOrder
	 */
	public String getIdentityColumnOrder();

	/**
	 * @return the implicitlyHidden
	 */
	public String getImplicitlyHidden();

	/**
	 * @return the rowChangeTimestampGenerated
	 */
	public String getRowChangeTimestampGenerated();

	/**
	 * @return the fieldProcedureProgramName
	 */
	public String getFieldProcedureProgramName();

	/**
	 * @return the fieldProcedureLibraryName
	 */
	public String getFieldProcedureLibraryName();

	/**
	 * @return the reservedFLDL0100
	 */
	public String getReservedFLDL0100();

}
