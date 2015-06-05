package org.rplgleparser.api.LFLD;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400PackedDecimal;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLFLD FLDL0100 format.
 * @author Eric N. Wilson
 *
 */
public class FLDL0100 implements IFLDL0100, FLDLoutputFormat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8983687946970274978L;

	// FLDL0100 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) Field name
	protected transient AS400Text fieldNamex = new AS400Text(10);

	// 10 A CHAR(1) Data type
	protected transient AS400Text dataTypex = new AS400Text(1);

	// 11 B CHAR(1) Use
	protected transient AS400Text usex = new AS400Text(1);
	// 12 C BINARY(4) Output buffer position
	protected transient AS400Bin4 outputBufferPositionx = new AS400Bin4();
	// 16 10 BINARY(4) Input buffer position
	protected transient AS400Bin4 inputBufferPositionx = new AS400Bin4();
	// 20 14 BINARY(4) Field length in bytes
	protected transient AS400Bin4 fieldLengthInBytesx = new AS400Bin4();
	// 24 18 BINARY(4) Digits
	protected transient AS400Bin4 digitsx = new AS400Bin4();
	// 28 1C BINARY(4) Decimal position
	protected transient AS400Bin4 decimalPositionsx = new AS400Bin4();
	// 32 20 CHAR(50) Field text description
	protected transient AS400Text fieldTextDescriptionx = new AS400Text(50);
	// 82 52 CHAR(2) Edit code
	protected transient AS400Text editCodex = new AS400Text(2);
	// 84 54 BINARY(4) Edit word length
	protected transient AS400Bin4 editWordLengthx = new AS400Bin4();
	// 88 58 CHAR(64) Edit word
	protected transient AS400Text editWordx = new AS400Text(64);
	// 152 98 CHAR(20) Column heading 1
	protected transient AS400Text columnHeading1x = new AS400Text(20);
	// 172 AC CHAR(20) Column heading 2
	protected transient AS400Text columnHeading2x = new AS400Text(20);
	// 192 C0 CHAR(20) Column heading 3
	protected transient AS400Text columnHeading3x = new AS400Text(20);
	// 212 D4 CHAR(10) Internal field name
	protected transient AS400Text internalFieldNamex = new AS400Text(10);
	// 222 DE CHAR(30) Alternative field name
	protected transient AS400Text alternativeFieldNamex = new AS400Text(30);
	// 252 FC BINARY(4) Length of alternative field name
	protected transient AS400Bin4 lengthOfAlternativeFieldNamex = new AS400Bin4();
	// 256 100 BINARY(4) Number of DBCS characters
	protected transient AS400Bin4 numberOfDBCSCharactersx = new AS400Bin4();
	// 260 104 CHAR(1) Null values allowed
	protected transient AS400Text nullValuesAllowedx = new AS400Text(1);
	// 261 105 CHAR(1) Host variable indicator
	protected transient AS400Text hostVariableIndicatorx = new AS400Text(1);
	// 262 106 CHAR(4) Date and time format
	protected transient AS400Text dateAndTimeFormatx = new AS400Text(4);
	// 266 10A CHAR(1) Date and time separator
	protected transient AS400Text dateAndTimeSeparatorx = new AS400Text(1);
	// 267 10B CHAR(1) Variable length field indicator (overlay for MI mapping)
	protected transient AS400Text variableLengthFieldIndicatorx = new AS400Text(1);
	// 268 10C BINARY(4) Field text description CCSID
	protected transient AS400Bin4 fieldTextDescriptionCCSIDx = new AS400Bin4();
	// 272 110 BINARY(4) Field data CCSID
	protected transient AS400Bin4 fieldDataCCSIDx = new AS400Bin4();
	// 276 114 BINARY(4) Field column headings CCSID
	protected transient AS400Bin4 fieldColumnHeadingsCCSIDx = new AS400Bin4();
	// 280 118 BINARY(4) Field edit words CCSID
	protected transient AS400Bin4 fieldEditWordsCCSIDx = new AS400Bin4();
	// 284 11C BINARY(4) UCS-2 displayed field length
	protected transient AS400Bin4 ucs2DisplayedFieldLengthx = new AS400Bin4();
	// 288 120 BINARY(4) Field data encoding scheme
	protected transient AS400Bin4 fieldDataEncodingSchemex = new AS400Bin4();
	// 292 124 BINARY(4) Maximum large object field length
	protected transient AS400Bin4 maximumLargeObjectFieldLengthx = new AS400Bin4();
	// 296 128 BINARY(4) Pad length for large object
	protected transient AS400Bin4 padLengthForLargeObjectx = new AS400Bin4();
	// 300 12C BINARY(4) Length of user-defined type name
	protected transient AS400Bin4 lengthOfUserDefinedTypeNamex = new AS400Bin4();
	// 304 130 CHAR(128) User-defined type name
	protected transient AS400Text userDefinedTypeNamex = new AS400Text(128);
	// 432 1B0 CHAR(10) User-defined type library name
	protected transient AS400Text userDefinedTypeLibraryNamex = new AS400Text(10);
	// 442 1BA CHAR(1) Datalink link control
	protected transient AS400Text datalinkLinkControlx = new AS400Text(1);
	// 443 1BB CHAR(1) Datalink integrity
	protected transient AS400Text datalinkIntegrityx = new AS400Text(1);
	// 444 1BC CHAR(1) Datalink read permission
	protected transient AS400Text datalinkReadPermissionx = new AS400Text(1);
	// 445 1BD CHAR(1) Datalink write permission
	protected transient AS400Text datalinkWritePermissionx = new AS400Text(1);
	// 446 1BE CHAR(1) Datalink recovery
	protected transient AS400Text datalinkRecoveryx = new AS400Text(1);
	// 447 1BF CHAR(1) Datalink unlink control
	protected transient AS400Text datalinkUnlinkControlx = new AS400Text(1);
	// 448 1C0 BINARY(4) Display or print row number
	protected transient AS400Bin4 displayOrPrintRowNumberx = new AS400Bin4();
	// 452 1C4 BINARY(4) Display or print column number
	protected transient AS400Bin4 displayOrPrintColumnNumberx = new AS400Bin4();
	// 456 1C8 CHAR(1) ROWID column
	protected transient AS400Text rowidColumnx = new AS400Text(1);
	// 457 1C9 CHAR(1) Identity column
	protected transient AS400Text identityColumnx = new AS400Text(1);
	// 458 1CA CHAR(1) GENERATED BY
	protected transient AS400Text generatedByx = new AS400Text(1);
	// 459 1CB CHAR(1) Identity column - CYCLE
	protected transient AS400Text identityColumnCyclex = new AS400Text(1);
	// 460 1CC DECIMAL(31,0) Identity column - Original START WITH
	protected transient AS400PackedDecimal identityColumnOriginalStartWithx = new AS400PackedDecimal(
			31, 0);
	// 476 1DC DECIMAL(31,0) Identity column - Current START WITH
	protected transient AS400PackedDecimal identityColumnCurrentStartWithx = new AS400PackedDecimal(
			31, 0);
	// 492 1EC BINARY(4) Identity column - INCREMENT BY
	protected transient AS400Bin4 identityColumnIncrementByx = new AS400Bin4();
	// 496 1F0 DECIMAL(31,0) Identity column - MINVALUE
	protected transient AS400PackedDecimal identityColumnMinValuex = new AS400PackedDecimal(
			31, 0);
	// 512 200 DECIMAL(31,0) Identity column - MAXVALUE
	protected transient AS400PackedDecimal identityColumnMaxValuex = new AS400PackedDecimal(
			31, 0);
	// 528 210 BINARY(4) Identity column - CACHE
	protected transient AS400Bin4 identityColumnCachex = new AS400Bin4();
	// 532 214 CHAR(1) Identity column - ORDER
	protected transient AS400Text identityColumnOrderx = new AS400Text(1);
	// 533 215 CHAR(1) Implicitly hidden
	protected transient AS400Text implicitlyHiddenx = new AS400Text(1);
	// 534 216 CHAR(1) Row change timestamp GENERATED
	protected transient AS400Text rowChangeTimestampGeneratedx = new AS400Text(1);
	// Start of change535 217 CHAR(10) Field Procedure program name
	protected transient AS400Text fieldProcedureProgramNamex = new AS400Text(10);
	// 545 221 CHAR(10) Field Procedure library name
	protected transient AS400Text fieldProcedureLibraryNamex = new AS400Text(10);
	// 555 22B CHAR(5)End of change Reserved
	protected transient AS400Text reservedFLDL0100x = new AS400Text(5);

	protected transient AS400DataType[] FLDL0100a = new AS400DataType[] { fieldNamex,
			dataTypex, usex, outputBufferPositionx, inputBufferPositionx,
			fieldLengthInBytesx, digitsx, decimalPositionsx,
			fieldTextDescriptionx, editCodex, editWordLengthx, editWordx,
			columnHeading1x, columnHeading2x, columnHeading3x,
			internalFieldNamex, alternativeFieldNamex,
			lengthOfAlternativeFieldNamex, numberOfDBCSCharactersx,
			nullValuesAllowedx, hostVariableIndicatorx, dateAndTimeFormatx,
			dateAndTimeSeparatorx, variableLengthFieldIndicatorx,
			fieldTextDescriptionCCSIDx, fieldDataCCSIDx,
			fieldColumnHeadingsCCSIDx, fieldEditWordsCCSIDx,
			ucs2DisplayedFieldLengthx, fieldDataEncodingSchemex,
			maximumLargeObjectFieldLengthx, padLengthForLargeObjectx,
			lengthOfUserDefinedTypeNamex, userDefinedTypeNamex,
			userDefinedTypeLibraryNamex, datalinkLinkControlx,
			datalinkIntegrityx, datalinkReadPermissionx,
			datalinkWritePermissionx, datalinkRecoveryx,
			datalinkUnlinkControlx, displayOrPrintRowNumberx,
			displayOrPrintColumnNumberx, rowidColumnx, identityColumnx,
			generatedByx, identityColumnCyclex,
			identityColumnOriginalStartWithx, identityColumnCurrentStartWithx,
			identityColumnIncrementByx, identityColumnMinValuex,
			identityColumnMaxValuex, identityColumnCachex,
			identityColumnOrderx, implicitlyHiddenx,
			rowChangeTimestampGeneratedx, fieldProcedureProgramNamex,
			fieldProcedureLibraryNamex, reservedFLDL0100x };

	protected transient AS400Structure FLDL0100x = new AS400Structure(FLDL0100a);

	protected String fieldName;

	protected String dataType;

	protected String use;

	protected Integer outputBufferPosition;

	protected Integer inputBufferPosition;

	protected Integer fieldLengthInBytes;

	protected Integer digits;

	protected Integer decimalPositions;

	protected String fieldTextDescription;

	protected String editCode;

	protected Integer editWordLength;

	protected String editWord;

	protected String columnHeading1;

	protected String columnHeading2;

	protected String columnHeading3;

	protected String internalFieldName;

	protected String alternativeFieldName;

	protected Integer lengthOfAlternativeFieldName;

	protected Integer numberOfDBCSCharacters;

	protected String nullValuesAllowed;

	protected String hostVariableIndicator;

	protected String dateAndTimeFormat;

	protected String dateAndTimeSeparator;

	protected String variableLengthFieldIndicator;

	protected Integer fieldTextDescriptionCCSID;

	protected Integer fieldDataCCSID;

	protected Integer fieldColumnHeadingsCCSID;

	protected Integer fieldEditWordsCCSID;

	protected Integer ucs2DisplayedFieldLength;

	protected Integer fieldDataEncodingScheme;

	protected Integer maximumLargeObjectFieldLength;

	protected Integer padLengthForLargeObject;

	protected Integer lengthOfUserDefinedTypeName;

	protected String userDefinedTypeName;

	protected String userDefinedTypeLibraryName;

	protected String datalinkLinkControl;

	protected String datalinkIntegrity;

	protected String datalinkReadPermission;

	protected String datalinkWritePermission;

	protected String datalinkRecovery;

	protected String datalinkUnlinkControl;

	protected Integer displayOrPrintRowNumber;

	protected Integer displayOrPrintColumnNumber;

	protected String rowidColumn;

	protected String identityColumn;

	protected String generatedBy;

	protected String identityColumnCycle;

	protected BigDecimal identityColumnOriginalStartWith;

	protected BigDecimal identityColumnCurrentStartWith;

	protected Integer identityColumnIncrementBy;

	protected BigDecimal identityColumnMinValue;

	protected BigDecimal identityColumnMaxValue;

	protected Integer identityColumnCache;

	protected String identityColumnOrder;

	protected String implicitlyHidden;

	protected String rowChangeTimestampGenerated;

	protected String fieldProcedureProgramName;

	protected String fieldProcedureLibraryName;

	protected String reservedFLDL0100;

	public FLDL0100() {
		// Default Constructor
	}

	public FLDL0100(byte[] input) {
		Object[] o = (Object[]) FLDL0100x.toObject(input);
		fieldName = (String) o[0];
		dataType = (String) o[1];
		use = (String) o[2];
		outputBufferPosition = (Integer) o[3];
		inputBufferPosition = (Integer) o[4];
		fieldLengthInBytes = (Integer) o[5];
		digits = (Integer) o[6];
		decimalPositions = (Integer) o[7];
		fieldTextDescription = (String) o[8];
		editCode = (String) o[9];
		editWordLength = (Integer) o[10];
		editWord = (String) o[11];
		columnHeading1 = (String) o[12];
		columnHeading2 = (String) o[13];
		columnHeading3 = (String) o[14];
		internalFieldName = (String) o[15];
		alternativeFieldName = (String) o[16];
		lengthOfAlternativeFieldName = (Integer) o[17];
		numberOfDBCSCharacters = (Integer) o[18];
		nullValuesAllowed = (String) o[19];
		hostVariableIndicator = (String) o[20];
		dateAndTimeFormat = (String) o[21];
		dateAndTimeSeparator = (String) o[22];
		variableLengthFieldIndicator = (String) o[23];
		fieldTextDescriptionCCSID = (Integer) o[24];
		fieldDataCCSID = (Integer) o[25];
		fieldColumnHeadingsCCSID = (Integer) o[26];
		fieldEditWordsCCSID = (Integer) o[27];
		ucs2DisplayedFieldLength = (Integer) o[28];
		fieldDataEncodingScheme = (Integer) o[29];
		maximumLargeObjectFieldLength = (Integer) o[30];
		padLengthForLargeObject = (Integer) o[31];
		lengthOfUserDefinedTypeName = (Integer) o[32];
		userDefinedTypeName = (String) o[33];
		userDefinedTypeLibraryName = (String) o[34];
		datalinkLinkControl = (String) o[35];
		datalinkIntegrity = (String) o[36];
		datalinkReadPermission = (String) o[37];
		datalinkWritePermission = (String) o[38];
		datalinkRecovery = (String) o[39];
		datalinkUnlinkControl = (String) o[40];
		displayOrPrintRowNumber = (Integer) o[41];
		displayOrPrintColumnNumber = (Integer) o[42];
		rowidColumn = (String) o[43];
		identityColumn = (String) o[44];
		generatedBy = (String) o[45];
		identityColumnCycle = (String) o[46];
		identityColumnOriginalStartWith = (BigDecimal) o[47];
		identityColumnCurrentStartWith = (BigDecimal) o[48];
		identityColumnIncrementBy = (Integer) o[49];
		identityColumnMinValue = (BigDecimal) o[50];
		identityColumnMaxValue = (BigDecimal) o[51];
		identityColumnCache = (Integer) o[52];
		identityColumnOrder = (String) o[53];
		implicitlyHidden = (String) o[54];
		rowChangeTimestampGenerated = (String) o[55];
		fieldProcedureProgramName = (String) o[56];
		fieldProcedureLibraryName = (String) o[57];
		reservedFLDL0100 = (String) o[58];

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FLDL0100 other = (FLDL0100) obj;
		if (alternativeFieldName == null) {
			if (other.alternativeFieldName != null)
				return false;
		} else if (!alternativeFieldName.equals(other.alternativeFieldName))
			return false;
		if (columnHeading1 == null) {
			if (other.columnHeading1 != null)
				return false;
		} else if (!columnHeading1.equals(other.columnHeading1))
			return false;
		if (columnHeading2 == null) {
			if (other.columnHeading2 != null)
				return false;
		} else if (!columnHeading2.equals(other.columnHeading2))
			return false;
		if (columnHeading3 == null) {
			if (other.columnHeading3 != null)
				return false;
		} else if (!columnHeading3.equals(other.columnHeading3))
			return false;
		if (dataType == null) {
			if (other.dataType != null)
				return false;
		} else if (!dataType.equals(other.dataType))
			return false;
		if (datalinkIntegrity == null) {
			if (other.datalinkIntegrity != null)
				return false;
		} else if (!datalinkIntegrity.equals(other.datalinkIntegrity))
			return false;
		if (datalinkLinkControl == null) {
			if (other.datalinkLinkControl != null)
				return false;
		} else if (!datalinkLinkControl.equals(other.datalinkLinkControl))
			return false;
		if (datalinkReadPermission == null) {
			if (other.datalinkReadPermission != null)
				return false;
		} else if (!datalinkReadPermission.equals(other.datalinkReadPermission))
			return false;
		if (datalinkRecovery == null) {
			if (other.datalinkRecovery != null)
				return false;
		} else if (!datalinkRecovery.equals(other.datalinkRecovery))
			return false;
		if (datalinkUnlinkControl == null) {
			if (other.datalinkUnlinkControl != null)
				return false;
		} else if (!datalinkUnlinkControl.equals(other.datalinkUnlinkControl))
			return false;
		if (datalinkWritePermission == null) {
			if (other.datalinkWritePermission != null)
				return false;
		} else if (!datalinkWritePermission
				.equals(other.datalinkWritePermission))
			return false;
		if (dateAndTimeFormat == null) {
			if (other.dateAndTimeFormat != null)
				return false;
		} else if (!dateAndTimeFormat.equals(other.dateAndTimeFormat))
			return false;
		if (dateAndTimeSeparator == null) {
			if (other.dateAndTimeSeparator != null)
				return false;
		} else if (!dateAndTimeSeparator.equals(other.dateAndTimeSeparator))
			return false;
		if (decimalPositions == null) {
			if (other.decimalPositions != null)
				return false;
		} else if (!decimalPositions.equals(other.decimalPositions))
			return false;
		if (digits == null) {
			if (other.digits != null)
				return false;
		} else if (!digits.equals(other.digits))
			return false;
		if (displayOrPrintColumnNumber == null) {
			if (other.displayOrPrintColumnNumber != null)
				return false;
		} else if (!displayOrPrintColumnNumber
				.equals(other.displayOrPrintColumnNumber))
			return false;
		if (displayOrPrintRowNumber == null) {
			if (other.displayOrPrintRowNumber != null)
				return false;
		} else if (!displayOrPrintRowNumber
				.equals(other.displayOrPrintRowNumber))
			return false;
		if (editCode == null) {
			if (other.editCode != null)
				return false;
		} else if (!editCode.equals(other.editCode))
			return false;
		if (editWord == null) {
			if (other.editWord != null)
				return false;
		} else if (!editWord.equals(other.editWord))
			return false;
		if (editWordLength == null) {
			if (other.editWordLength != null)
				return false;
		} else if (!editWordLength.equals(other.editWordLength))
			return false;
		if (fieldColumnHeadingsCCSID == null) {
			if (other.fieldColumnHeadingsCCSID != null)
				return false;
		} else if (!fieldColumnHeadingsCCSID
				.equals(other.fieldColumnHeadingsCCSID))
			return false;
		if (fieldDataCCSID == null) {
			if (other.fieldDataCCSID != null)
				return false;
		} else if (!fieldDataCCSID.equals(other.fieldDataCCSID))
			return false;
		if (fieldDataEncodingScheme == null) {
			if (other.fieldDataEncodingScheme != null)
				return false;
		} else if (!fieldDataEncodingScheme
				.equals(other.fieldDataEncodingScheme))
			return false;
		if (fieldEditWordsCCSID == null) {
			if (other.fieldEditWordsCCSID != null)
				return false;
		} else if (!fieldEditWordsCCSID.equals(other.fieldEditWordsCCSID))
			return false;
		if (fieldLengthInBytes == null) {
			if (other.fieldLengthInBytes != null)
				return false;
		} else if (!fieldLengthInBytes.equals(other.fieldLengthInBytes))
			return false;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (fieldProcedureLibraryName == null) {
			if (other.fieldProcedureLibraryName != null)
				return false;
		} else if (!fieldProcedureLibraryName
				.equals(other.fieldProcedureLibraryName))
			return false;
		if (fieldProcedureProgramName == null) {
			if (other.fieldProcedureProgramName != null)
				return false;
		} else if (!fieldProcedureProgramName
				.equals(other.fieldProcedureProgramName))
			return false;
		if (fieldTextDescription == null) {
			if (other.fieldTextDescription != null)
				return false;
		} else if (!fieldTextDescription.equals(other.fieldTextDescription))
			return false;
		if (fieldTextDescriptionCCSID == null) {
			if (other.fieldTextDescriptionCCSID != null)
				return false;
		} else if (!fieldTextDescriptionCCSID
				.equals(other.fieldTextDescriptionCCSID))
			return false;
		if (generatedBy == null) {
			if (other.generatedBy != null)
				return false;
		} else if (!generatedBy.equals(other.generatedBy))
			return false;
		if (hostVariableIndicator == null) {
			if (other.hostVariableIndicator != null)
				return false;
		} else if (!hostVariableIndicator.equals(other.hostVariableIndicator))
			return false;
		if (identityColumn == null) {
			if (other.identityColumn != null)
				return false;
		} else if (!identityColumn.equals(other.identityColumn))
			return false;
		if (identityColumnCache == null) {
			if (other.identityColumnCache != null)
				return false;
		} else if (!identityColumnCache.equals(other.identityColumnCache))
			return false;
		if (identityColumnCurrentStartWith == null) {
			if (other.identityColumnCurrentStartWith != null)
				return false;
		} else if (!identityColumnCurrentStartWith
				.equals(other.identityColumnCurrentStartWith))
			return false;
		if (identityColumnCycle == null) {
			if (other.identityColumnCycle != null)
				return false;
		} else if (!identityColumnCycle.equals(other.identityColumnCycle))
			return false;
		if (identityColumnIncrementBy == null) {
			if (other.identityColumnIncrementBy != null)
				return false;
		} else if (!identityColumnIncrementBy
				.equals(other.identityColumnIncrementBy))
			return false;
		if (identityColumnMaxValue == null) {
			if (other.identityColumnMaxValue != null)
				return false;
		} else if (!identityColumnMaxValue.equals(other.identityColumnMaxValue))
			return false;
		if (identityColumnMinValue == null) {
			if (other.identityColumnMinValue != null)
				return false;
		} else if (!identityColumnMinValue.equals(other.identityColumnMinValue))
			return false;
		if (identityColumnOrder == null) {
			if (other.identityColumnOrder != null)
				return false;
		} else if (!identityColumnOrder.equals(other.identityColumnOrder))
			return false;
		if (identityColumnOriginalStartWith == null) {
			if (other.identityColumnOriginalStartWith != null)
				return false;
		} else if (!identityColumnOriginalStartWith
				.equals(other.identityColumnOriginalStartWith))
			return false;
		if (implicitlyHidden == null) {
			if (other.implicitlyHidden != null)
				return false;
		} else if (!implicitlyHidden.equals(other.implicitlyHidden))
			return false;
		if (inputBufferPosition == null) {
			if (other.inputBufferPosition != null)
				return false;
		} else if (!inputBufferPosition.equals(other.inputBufferPosition))
			return false;
		if (internalFieldName == null) {
			if (other.internalFieldName != null)
				return false;
		} else if (!internalFieldName.equals(other.internalFieldName))
			return false;
		if (lengthOfAlternativeFieldName == null) {
			if (other.lengthOfAlternativeFieldName != null)
				return false;
		} else if (!lengthOfAlternativeFieldName
				.equals(other.lengthOfAlternativeFieldName))
			return false;
		if (lengthOfUserDefinedTypeName == null) {
			if (other.lengthOfUserDefinedTypeName != null)
				return false;
		} else if (!lengthOfUserDefinedTypeName
				.equals(other.lengthOfUserDefinedTypeName))
			return false;
		if (maximumLargeObjectFieldLength == null) {
			if (other.maximumLargeObjectFieldLength != null)
				return false;
		} else if (!maximumLargeObjectFieldLength
				.equals(other.maximumLargeObjectFieldLength))
			return false;
		if (nullValuesAllowed == null) {
			if (other.nullValuesAllowed != null)
				return false;
		} else if (!nullValuesAllowed.equals(other.nullValuesAllowed))
			return false;
		if (numberOfDBCSCharacters == null) {
			if (other.numberOfDBCSCharacters != null)
				return false;
		} else if (!numberOfDBCSCharacters.equals(other.numberOfDBCSCharacters))
			return false;
		if (outputBufferPosition == null) {
			if (other.outputBufferPosition != null)
				return false;
		} else if (!outputBufferPosition.equals(other.outputBufferPosition))
			return false;
		if (padLengthForLargeObject == null) {
			if (other.padLengthForLargeObject != null)
				return false;
		} else if (!padLengthForLargeObject
				.equals(other.padLengthForLargeObject))
			return false;
		if (reservedFLDL0100 == null) {
			if (other.reservedFLDL0100 != null)
				return false;
		} else if (!reservedFLDL0100.equals(other.reservedFLDL0100))
			return false;
		if (rowChangeTimestampGenerated == null) {
			if (other.rowChangeTimestampGenerated != null)
				return false;
		} else if (!rowChangeTimestampGenerated
				.equals(other.rowChangeTimestampGenerated))
			return false;
		if (rowidColumn == null) {
			if (other.rowidColumn != null)
				return false;
		} else if (!rowidColumn.equals(other.rowidColumn))
			return false;
		if (ucs2DisplayedFieldLength == null) {
			if (other.ucs2DisplayedFieldLength != null)
				return false;
		} else if (!ucs2DisplayedFieldLength
				.equals(other.ucs2DisplayedFieldLength))
			return false;
		if (use == null) {
			if (other.use != null)
				return false;
		} else if (!use.equals(other.use))
			return false;
		if (userDefinedTypeLibraryName == null) {
			if (other.userDefinedTypeLibraryName != null)
				return false;
		} else if (!userDefinedTypeLibraryName
				.equals(other.userDefinedTypeLibraryName))
			return false;
		if (userDefinedTypeName == null) {
			if (other.userDefinedTypeName != null)
				return false;
		} else if (!userDefinedTypeName.equals(other.userDefinedTypeName))
			return false;
		if (variableLengthFieldIndicator == null) {
			if (other.variableLengthFieldIndicator != null)
				return false;
		} else if (!variableLengthFieldIndicator
				.equals(other.variableLengthFieldIndicator))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends FLDLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new FLDL0100(input));
	}

	/**
	 * @return the alternativeFieldName
	 */
	public String getAlternativeFieldName() {
		return alternativeFieldName;
	}

	/**
	 * @return the columnHeading1
	 */
	public String getColumnHeading1() {
		return columnHeading1;
	}

	/**
	 * @return the columnHeading2
	 */
	public String getColumnHeading2() {
		return columnHeading2;
	}

	/**
	 * @return the columnHeading3
	 */
	public String getColumnHeading3() {
		return columnHeading3;
	}

	/**
	 * @return the datalinkIntegrity
	 */
	public String getDatalinkIntegrity() {
		return datalinkIntegrity;
	}

	/**
	 * @return the datalinkLinkControl
	 */
	public String getDatalinkLinkControl() {
		return datalinkLinkControl;
	}

	/**
	 * @return the datalinkReadPermission
	 */
	public String getDatalinkReadPermission() {
		return datalinkReadPermission;
	}

	/**
	 * @return the datalinkRecovery
	 */
	public String getDatalinkRecovery() {
		return datalinkRecovery;
	}

	/**
	 * @return the datalinkUnlinkControl
	 */
	public String getDatalinkUnlinkControl() {
		return datalinkUnlinkControl;
	}

	/**
	 * @return the datalinkWritePermission
	 */
	public String getDatalinkWritePermission() {
		return datalinkWritePermission;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @return the dateAndTimeFormat
	 */
	public String getDateAndTimeFormat() {
		return dateAndTimeFormat;
	}

	/**
	 * @return the dateAndTimeSeparator
	 */
	public String getDateAndTimeSeparator() {
		return dateAndTimeSeparator;
	}

	/**
	 * @return the decimalPositions
	 */
	public Integer getDecimalPositions() {
		return decimalPositions;
	}

	/**
	 * @return the digits
	 */
	public Integer getDigits() {
		return digits;
	}

	/**
	 * @return the displayOrPrintColumnNumber
	 */
	public Integer getDisplayOrPrintColumnNumber() {
		return displayOrPrintColumnNumber;
	}

	/**
	 * @return the displayOrPrintRowNumber
	 */
	public Integer getDisplayOrPrintRowNumber() {
		return displayOrPrintRowNumber;
	}

	/**
	 * @return the editCode
	 */
	public String getEditCode() {
		return editCode;
	}

	/**
	 * @return the editWord
	 */
	public String getEditWord() {
		return editWord;
	}

	/**
	 * @return the editWordLength
	 */
	public Integer getEditWordLength() {
		return editWordLength;
	}

	/**
	 * @return the fieldColumnHeadingsCCSID
	 */
	public Integer getFieldColumnHeadingsCCSID() {
		return fieldColumnHeadingsCCSID;
	}

	/**
	 * @return the fieldDataCCSID
	 */
	public Integer getFieldDataCCSID() {
		return fieldDataCCSID;
	}

	/**
	 * @return the fieldDataEncodingScheme
	 */
	public Integer getFieldDataEncodingScheme() {
		return fieldDataEncodingScheme;
	}

	/**
	 * @return the fieldEditWordsCCSID
	 */
	public Integer getFieldEditWordsCCSID() {
		return fieldEditWordsCCSID;
	}

	/**
	 * @return the fieldLengthInBytes
	 */
	public Integer getFieldLengthInBytes() {
		return fieldLengthInBytes;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @return the fieldProcedureLibraryName
	 */
	public String getFieldProcedureLibraryName() {
		return fieldProcedureLibraryName;
	}

	/**
	 * @return the fieldProcedureProgramName
	 */
	public String getFieldProcedureProgramName() {
		return fieldProcedureProgramName;
	}

	/**
	 * @return the fieldTextDescription
	 */
	public String getFieldTextDescription() {
		return fieldTextDescription;
	}

	/**
	 * @return the fieldTextDescriptionCCSID
	 */
	public Integer getFieldTextDescriptionCCSID() {
		return fieldTextDescriptionCCSID;
	}

	/**
	 * @return the generatedBy
	 */
	public String getGeneratedBy() {
		return generatedBy;
	}

	/**
	 * @return the hostVariableIndicator
	 */
	public String getHostVariableIndicator() {
		return hostVariableIndicator;
	}

	/**
	 * @return the identityColumn
	 */
	public String getIdentityColumn() {
		return identityColumn;
	}

	/**
	 * @return the identityColumnCache
	 */
	public Integer getIdentityColumnCache() {
		return identityColumnCache;
	}

	/**
	 * @return the identityColumnCurrentStartWith
	 */
	public BigDecimal getIdentityColumnCurrentStartWith() {
		return identityColumnCurrentStartWith;
	}

	/**
	 * @return the identityColumnCycle
	 */
	public String getIdentityColumnCycle() {
		return identityColumnCycle;
	}

	/**
	 * @return the identityColumnIncrementBy
	 */
	public Integer getIdentityColumnIncrementBy() {
		return identityColumnIncrementBy;
	}

	/**
	 * @return the identityColumnMaxValue
	 */
	public BigDecimal getIdentityColumnMaxValue() {
		return identityColumnMaxValue;
	}

	/**
	 * @return the identityColumnMinValue
	 */
	public BigDecimal getIdentityColumnMinValue() {
		return identityColumnMinValue;
	}

	/**
	 * @return the identityColumnOrder
	 */
	public String getIdentityColumnOrder() {
		return identityColumnOrder;
	}

	/**
	 * @return the identityColumnOriginalStartWith
	 */
	public BigDecimal getIdentityColumnOriginalStartWith() {
		return identityColumnOriginalStartWith;
	}

	/**
	 * @return the implicitlyHidden
	 */
	public String getImplicitlyHidden() {
		return implicitlyHidden;
	}

	/**
	 * @return the inputBufferPosition
	 */
	public Integer getInputBufferPosition() {
		return inputBufferPosition;
	}

	/**
	 * @return the internalFieldName
	 */
	public String getInternalFieldName() {
		return internalFieldName;
	}

	/**
	 * @return the lengthOfAlternativeFieldName
	 */
	public Integer getLengthOfAlternativeFieldName() {
		return lengthOfAlternativeFieldName;
	}

	/**
	 * @return the lengthOfUserDefinedTypeName
	 */
	public Integer getLengthOfUserDefinedTypeName() {
		return lengthOfUserDefinedTypeName;
	}

	/**
	 * @return the maximumLargeObjectFieldLength
	 */
	public Integer getMaximumLargeObjectFieldLength() {
		return maximumLargeObjectFieldLength;
	}

	/**
	 * @return the nullValuesAllowed
	 */
	public String getNullValuesAllowed() {
		return nullValuesAllowed;
	}

	/**
	 * @return the numberOfDBCSCharacters
	 */
	public Integer getNumberOfDBCSCharacters() {
		return numberOfDBCSCharacters;
	}

	/**
	 * @return the outputBufferPosition
	 */
	public Integer getOutputBufferPosition() {
		return outputBufferPosition;
	}

	/**
	 * @return the padLengthForLargeObject
	 */
	public Integer getPadLengthForLargeObject() {
		return padLengthForLargeObject;
	}

	/**
	 * @return the reservedFLDL0100
	 */
	public String getReservedFLDL0100() {
		return reservedFLDL0100;
	}

	/**
	 * @return the rowChangeTimestampGenerated
	 */
	public String getRowChangeTimestampGenerated() {
		return rowChangeTimestampGenerated;
	}

	/**
	 * @return the rowidColumn
	 */
	public String getRowidColumn() {
		return rowidColumn;
	}

	/**
	 * @return the ucs2DisplayedFieldLength
	 */
	public Integer getUcs2DisplayedFieldLength() {
		return ucs2DisplayedFieldLength;
	}

	/**
	 * @return the use
	 */
	public String getUse() {
		return use;
	}

	/**
	 * @return the userDefinedTypeLibraryName
	 */
	public String getUserDefinedTypeLibraryName() {
		return userDefinedTypeLibraryName;
	}

	/**
	 * @return the userDefinedTypeName
	 */
	public String getUserDefinedTypeName() {
		return userDefinedTypeName;
	}

	/**
	 * @return the variableLengthFieldIndicator
	 */
	public String getVariableLengthFieldIndicator() {
		return variableLengthFieldIndicator;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Field Name: " + fieldName.trim());
		sb.append(" Data Type: " + dataType.trim());
		sb.append(" Use: " + use.trim());
		sb.append(" Output Buffer Position: " + outputBufferPosition.toString());
		sb.append(" Input Buffer Position: " + inputBufferPosition.toString());
		sb.append(" Field length in Bytes: " + fieldLengthInBytes.toString());
		sb.append(" Digits: " + digits.toString());
		sb.append(" Decimal Positions: " + decimalPositions.toString());
		sb.append(" Field Text Description: " + fieldTextDescription.trim());
		sb.append(" Edit Code: " + editCode.trim());
		sb.append(" Edit Word Length: " + editWordLength.toString());
		sb.append(" Edit Word: " + editWord.trim());
		sb.append(" Column Heading 1: " + columnHeading1.trim());
		sb.append(" Column Heading 2: " + columnHeading2.trim());
		sb.append(" Column Heading 3: " + columnHeading3.trim());
		sb.append(" Internal Field Name: " + internalFieldName.trim());
		sb.append(" Alternative Field Name: " + alternativeFieldName.trim());
		sb.append(" Length of Alternative Field Name: "
				+ lengthOfAlternativeFieldName.toString());
		sb.append(" Number of DBCS Characters: "
				+ numberOfDBCSCharacters.toString());
		sb.append(" Null Values Allowed: " + nullValuesAllowed.trim());
		sb.append(" Host Variable Indicator: " + hostVariableIndicator.trim());
		sb.append(" Date And Time Format: " + dateAndTimeFormat.trim());
		sb.append(" Date And Time Separator: " + dateAndTimeSeparator.trim());
		sb.append(" Variable Length Field Indicator: "
				+ variableLengthFieldIndicator.trim());
		sb.append(" Field Text Description CCSID: "
				+ fieldTextDescriptionCCSID.toString());
		;
		sb.append(" Field Data CCSID: " + fieldDataCCSID.toString());
		sb.append(" Field Column Headings CCSID: "
				+ fieldColumnHeadingsCCSID.toString());
		sb.append(" Field Edit Word CCSID: " + fieldEditWordsCCSID.toString());
		sb.append(" UCS2 Displayed Field Length: "
				+ ucs2DisplayedFieldLength.toString());
		sb.append(" Field Data Encoding Scheme: "
				+ fieldDataEncodingScheme.toString());
		sb.append(" Maximum Large Object Field Length: "
				+ maximumLargeObjectFieldLength.toString());
		sb.append(" Pad Length For Large Object: "
				+ padLengthForLargeObject.toString());
		sb.append(" Length of User Defined Type Name: "
				+ lengthOfUserDefinedTypeName.toString());
		sb.append(" User Defined Type Name: " + userDefinedTypeName.trim());
		sb.append(" User Defined Type Library Name: "
				+ userDefinedTypeLibraryName.trim());
		sb.append(" Datalink Link Control: " + datalinkLinkControl.trim());
		sb.append(" Datalink Integrity: " + datalinkIntegrity.trim());
		sb.append(" Datalink Read Permission: " + datalinkReadPermission.trim());
		sb.append(" Datalink Write Permission: "
				+ datalinkWritePermission.trim());
		sb.append(" Datalink Recovery: " + datalinkRecovery.trim());
		sb.append(" Datalink Unlink Control: " + datalinkUnlinkControl.trim());
		sb.append(" Display or Print Row Number: "
				+ displayOrPrintRowNumber.toString());
		sb.append(" Display or Print Column Number: "
				+ displayOrPrintColumnNumber.toString());
		sb.append(" Rowid Column: " + rowidColumn.trim());
		sb.append(" Identity Column: " + identityColumn.trim());
		sb.append(" Generated By: " + generatedBy.trim());
		sb.append(" Identity Column Cycle: " + identityColumnCycle.trim());
		sb.append(" Identity Column Original Start With: "
				+ identityColumnOriginalStartWith.toString());
		sb.append(" Identity Column Current Start With: "
				+ identityColumnCurrentStartWith.toString());
		sb.append(" Identity Column Increment By: "
				+ identityColumnIncrementBy.toString());
		sb.append(" Identity Column Min Value: "
				+ identityColumnMinValue.toString());
		sb.append(" Identity Column Max Value: "
				+ identityColumnMaxValue.toString());
		sb.append(" Identity Column Cache: " + identityColumnCache.toString());
		sb.append(" Identity Column Order: " + identityColumnOrder.trim());
		sb.append(" Implicitly Hidden: " + implicitlyHidden.trim());
		sb.append(" Row Change Timestamp Generated: "
				+ rowChangeTimestampGenerated.trim());
		sb.append(" Field Procedure Program Name: "
				+ fieldProcedureProgramName.trim());
		sb.append(" Field Procedure Library Name: "
				+ fieldProcedureLibraryName.trim());
		sb.append(" reserved (FLDL0100): " + reservedFLDL0100.trim());

		return sb.toString();
	}

}
