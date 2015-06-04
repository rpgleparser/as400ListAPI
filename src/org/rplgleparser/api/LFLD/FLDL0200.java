package org.rplgleparser.api.LFLD;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLFLD FLDL0200 format.
 * @author Eric N. Wilson
 *
 */

public class FLDL0200 extends FLDL0100 implements IFLDL0200, FLDLoutputFormat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2857415563833218986L;

	//
	// FLDL0200 List Data Section
	//
	// dir
	// Offset Type Field
	// Dec Hex
	// 0 0 BINARY(4) Length of FLDL0200 format
	protected transient AS400Bin4 lengthOfFLDL0200Formatx = new AS400Bin4();

	// 4 4 BINARY(4) Displacement to default value
	protected transient AS400Bin4 displacementToDefaultValuex = new AS400Bin4();

	// 8 8 BINARY(4) Length of default value
	protected transient AS400Bin4 lengthOfDefaultValuex = new AS400Bin4();
	// 12 C All fields defined by FLDL0100 format
	// * * CHAR(*) Default value
	protected transient AS400DataType[] FLDL0200a = new AS400DataType[] { 
			lengthOfFLDL0200Formatx,
			displacementToDefaultValuex, 
			lengthOfDefaultValuex, 
			
			fieldNamex,
			dataTypex, usex, outputBufferPositionx, inputBufferPositionx,
			fieldLengthInBytesx, digitsx, decimalPositionsx, fieldTextDescriptionx,
			editCodex, editWordLengthx, editWordx, columnHeading1x, columnHeading2x,
			columnHeading3x, internalFieldNamex, alternativeFieldNamex,
			lengthOfAlternativeFieldNamex, numberOfDBCSCharactersx,
			nullValuesAllowedx, hostVariableIndicatorx, dateAndTimeFormatx,
			dateAndTimeSeparatorx, variableLengthFieldIndicatorx,
			fieldTextDescriptionCCSIDx, fieldDataCCSIDx,
			fieldColumnHeadingsCCSIDx, fieldEditWordsCCSIDx,
			ucs2DisplayedFieldLengthx, fieldDataEncodingSchemex,
			maximumLargeObjectFieldLengthx, padLengthForLargeObjectx,
			lengthOfUserDefinedTypeNamex, userDefinedTypeNamex,
			userDefinedTypeLibraryNamex, datalinkLinkControlx, datalinkIntegrityx,
			datalinkReadPermissionx, datalinkWritePermissionx, datalinkRecoveryx,
			datalinkUnlinkControlx, displayOrPrintRowNumberx,
			displayOrPrintColumnNumberx, rowidColumnx, identityColumnx,
			generatedByx, identityColumnCyclex, identityColumnOriginalStartWithx,
			identityColumnCurrentStartWithx, identityColumnIncrementByx,
			identityColumnMinValuex, identityColumnMaxValuex,
			identityColumnCachex, identityColumnOrderx, implicitlyHiddenx,
			rowChangeTimestampGeneratedx, fieldProcedureProgramNamex,
			fieldProcedureLibraryNamex, reservedFLDL0100x };
	protected transient AS400Structure FLDL0200x = new AS400Structure(FLDL0200a);

	protected Integer lengthOfFLDL0200Format;

	protected Integer displacementToDefaultValue;

	protected Integer lengthOfDefaultValue;
	
	public FLDL0200(){
		// Default Constructor
	}
	
	public FLDL0200(byte[] input){
		Object[] o = (Object[]) FLDL0200x.toObject(input);
		lengthOfFLDL0200Format = (Integer)o[0];
		displacementToDefaultValue = (Integer)o[1]; 
		lengthOfDefaultValue = (Integer)o[2]; 

		fieldName = (String)o[3]; 
		dataType = (String)o[4]; 
		use = (String)o[5];
		outputBufferPosition = (Integer)o[6];
		inputBufferPosition = (Integer)o[7]; 
		fieldLengthInBytes = (Integer)o[8];
		digits = (Integer)o[9];
		decimalPositions = (Integer)o[10]; 
		fieldTextDescription = (String)o[11]; 
		editCode = (String)o[12];
		editWordLength = (Integer)o[13];
		editWord = (String)o[14];
		columnHeading1 = (String)o[15];
		columnHeading2 = (String)o[16];
		columnHeading3 = (String)o[17];
		internalFieldName = (String)o[18];
		alternativeFieldName = (String)o[19];
		lengthOfAlternativeFieldName = (Integer)o[20];
		numberOfDBCSCharacters = (Integer)o[21];
		nullValuesAllowed = (String)o[22];
		hostVariableIndicator = (String)o[23];
		dateAndTimeFormat = (String)o[24];
		dateAndTimeSeparator = (String)o[25];
		variableLengthFieldIndicator = (String)o[26];
		fieldTextDescriptionCCSID = (Integer)o[27];
		fieldDataCCSID = (Integer)o[28];
		fieldColumnHeadingsCCSID = (Integer)o[29]; 
		fieldEditWordsCCSID = (Integer)o[30];
		ucs2DisplayedFieldLength = (Integer)o[31];
		fieldDataEncodingScheme = (Integer)o[32];
		maximumLargeObjectFieldLength = (Integer)o[33];
		padLengthForLargeObject = (Integer)o[34];
		lengthOfUserDefinedTypeName = (Integer)o[35];
		userDefinedTypeName = (String)o[36];
		userDefinedTypeLibraryName = (String)o[37];
		datalinkLinkControl = (String)o[38];
		datalinkIntegrity = (String)o[39];
		datalinkReadPermission = (String)o[40];
		datalinkWritePermission = (String)o[41];
		datalinkRecovery = (String)o[42];
		datalinkUnlinkControl = (String)o[43];
		displayOrPrintRowNumber = (Integer)o[44];
		displayOrPrintColumnNumber = (Integer)o[45];
		rowidColumn = (String)o[46];
		identityColumn = (String)o[47];
		generatedBy = (String)o[48];
		identityColumnCycle = (String)o[49];
		identityColumnOriginalStartWith = (BigDecimal)o[50];
		identityColumnCurrentStartWith = (BigDecimal)o[51]; 
		identityColumnIncrementBy = (Integer)o[52];
		identityColumnMinValue = (BigDecimal)o[53];
		identityColumnMaxValue = (BigDecimal)o[54];
		identityColumnCache = (Integer)o[55];
		identityColumnOrder = (String)o[56];
		implicitlyHidden = (String)o[57];
		rowChangeTimestampGenerated = (String)o[58];
		fieldProcedureProgramName = (String)o[59];
		fieldProcedureLibraryName = (String)o[60];
		reservedFLDL0100 = (String)o[61];
	}
	
	@Override
	public <T extends FLDLoutputFormat> T fromByteArray(byte[] input) {
		// TODO Auto-generated method stub
		return ((T) new FLDL0200(input));
	}
	/**
	 * @return the displacementToDefaultValue
	 */
	public Integer getDisplacementToDefaultValue() {
		return displacementToDefaultValue;
	}
	/**
	 * @return the lengthOfDefaultValue
	 */
	public Integer getLengthOfDefaultValue() {
		return lengthOfDefaultValue;
	}

	/**
	 * @return the lengthOfFLDL0200Format
	 */
	public Integer getLengthOfFLDL0200Format() {
		return lengthOfFLDL0200Format;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}

	/**
	 * @param displacementToDefaultValue the displacementToDefaultValue to set
	 */
	public void setDisplacementToDefaultValue(Integer displacementToDefaultValue) {
		this.displacementToDefaultValue = displacementToDefaultValue;
	}

	/**
	 * @param lengthOfDefaultValue the lengthOfDefaultValue to set
	 */
	public void setLengthOfDefaultValue(Integer lengthOfDefaultValue) {
		this.lengthOfDefaultValue = lengthOfDefaultValue;
	}

	/**
	 * @param lengthOfFLDL0200Format the lengthOfFLDL0200Format to set
	 */
	public void setLengthOfFLDL0200Format(Integer lengthOfFLDL0200Format) {
		this.lengthOfFLDL0200Format = lengthOfFLDL0200Format;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Length of FLD0200Format: " + lengthOfFLDL0200Format.toString());
		sb.append(" Displacement to Default Value: " + displacementToDefaultValue.toString()); 
		sb.append(" Length of Default Value: " + lengthOfDefaultValue.toString()); 
		sb.append(" Field Name: " + fieldName.trim()); 
		sb.append(" Data Type: " + dataType.trim()); 
		sb.append(" Use: " + use.trim());
		sb.append(" Output Buffer Position: " + outputBufferPosition.toString());
		sb.append(" Input Buffer Position: "  + inputBufferPosition.toString()); 
		sb.append(" Field length in Bytes: " + fieldLengthInBytes.toString());
		sb.append(" Digits: " + digits.toString());
		sb.append(" Decimal Positions: " + decimalPositions.toString()); 
		sb.append(" Field Text Description: " + fieldTextDescription.trim()); 
		sb.append(" Edit Code: " + editCode.trim());
		sb.append(" Edit Word Length: " +  editWordLength.toString());
		sb.append(" Edit Word: " + editWord.trim());
		sb.append(" Column Heading 1: " + columnHeading1.trim());
		sb.append(" Column Heading 2: " + columnHeading2.trim());
		sb.append(" Column Heading 3: " + columnHeading3.trim());
		sb.append(" Internal Field Name: " + internalFieldName.trim());
		sb.append(" Alternative Field Name: " + alternativeFieldName.trim());
		sb.append(" Length of Alternative Field Name: " + lengthOfAlternativeFieldName.toString());
		sb.append(" Number of DBCS Characters: " + numberOfDBCSCharacters.toString());
		sb.append(" Null Values Allowed: " + nullValuesAllowed.trim());
		sb.append(" Host Variable Indicator: " + hostVariableIndicator.trim());
		sb.append(" Date And Time Format: " + dateAndTimeFormat.trim());
		sb.append(" Date And Time Separator: " + dateAndTimeSeparator.trim());
		sb.append(" Variable Length Field Indicator: " + variableLengthFieldIndicator.trim());
		sb.append(" Field Text Description CCSID: " + fieldTextDescriptionCCSID.toString());;
		sb.append(" Field Data CCSID: " + fieldDataCCSID.toString());
		sb.append(" Field Column Headings CCSID: " + fieldColumnHeadingsCCSID.toString()); 
		sb.append(" Field Edit Word CCSID: " + fieldEditWordsCCSID.toString());
		sb.append(" UCS2 Displayed Field Length: " + ucs2DisplayedFieldLength.toString());
		sb.append(" Field Data Encoding Scheme: " + fieldDataEncodingScheme.toString());
		sb.append(" Maximum Large Object Field Length: " + maximumLargeObjectFieldLength.toString());
		sb.append(" Pad Length For Large Object: " + padLengthForLargeObject.toString());
		sb.append(" Length of User Defined Type Name: " + lengthOfUserDefinedTypeName.toString());
		sb.append(" User Defined Type Name: " + userDefinedTypeName.trim());
		sb.append(" User Defined Type Library Name: " + userDefinedTypeLibraryName.trim());
		sb.append(" Datalink Link Control: " + datalinkLinkControl.trim());
		sb.append(" Datalink Integrity: " + datalinkIntegrity.trim());
		sb.append(" Datalink Read Permission: " + datalinkReadPermission.trim());
		sb.append(" Datalink Write Permission: " + datalinkWritePermission.trim());
		sb.append(" Datalink Recovery: " + datalinkRecovery.trim());
		sb.append(" Datalink Unlink Control: " + datalinkUnlinkControl.trim());
		sb.append(" Display or Print Row Number: " + displayOrPrintRowNumber.toString());
		sb.append(" Display or Print Column Number: " + displayOrPrintColumnNumber.toString());
		sb.append(" Rowid Column: " + rowidColumn.trim());
		sb.append(" Identity Column: " + identityColumn.trim());
		sb.append(" Generated By: " + generatedBy.trim());
		sb.append(" Identity Column Cycle: " + identityColumnCycle.trim());
		sb.append(" Identity Column Original Start With: " + identityColumnOriginalStartWith.toString());
		sb.append(" Identity Column Current Start With: " + identityColumnCurrentStartWith.toString()); 
		sb.append(" Identity Column Increment By: " + identityColumnIncrementBy.toString());
		sb.append(" Identity Column Min Value: " + identityColumnMinValue.toString());
		sb.append(" Identity Column Max Value: " + identityColumnMaxValue.toString());
		sb.append(" Identity Column Cache: " + identityColumnCache.toString());
		sb.append(" Identity Column Order: " + identityColumnOrder.trim());
		sb.append(" Implicitly Hidden: " + implicitlyHidden.trim());
		sb.append(" Row Change Timestamp Generated: " + rowChangeTimestampGenerated.trim());
		sb.append(" Field Procedure Program Name: " + fieldProcedureProgramName.trim());
		sb.append(" Field Procedure Library Name: " + fieldProcedureLibraryName.trim());
		sb.append(" reserved (FLDL0100): " + reservedFLDL0100.trim());

		return sb.toString();
	}


}
