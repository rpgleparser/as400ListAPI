package org.rpgleparser.api.LFLD;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;

/**
 * A data transfer object with conversion capabilities from AS400 Byte[]. 
 * This one implements the data format described in the QUSLFLD FLDL0300 format.
 * @author Eric N. Wilson
 *
 */
public class FLDL0300 implements IFLDL0300, FLDLoutputFormat, Serializable {
	protected static final long serialVersionUID = 7196237050044789530L;

	//
	// FLDL0300 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 BINARY(4) Length of FLDL0300 format
	protected transient AS400Bin4 lengthOfFLD0300Formatx = new AS400Bin4();

	// 4 4 BINARY(4) Displacement to all fields defined by FLDL0100 format
	protected transient AS400Bin4 displacementToAllFieldsDefinedByFLD0100Formatx = new AS400Bin4();

	// 8 8 BINARY(4) Displacement to alternative field name
	protected transient AS400Bin4 displacementToAlternativeFieldNamex = new AS400Bin4();
	// 12 C BINARY(4) Displacement to default value
	protected transient AS400Bin4 displacementToDefaultValuex = new AS400Bin4();
	// 16 10 BINARY(4) Length of default value
	protected transient AS400Bin4 lengthOfDefaultValuex = new AS400Bin4();
	// * * All fields defined by FLDL0100 format
	// * * CHAR(*) Alternative field name (long)
	// * * CHAR(*) Default value
	protected transient AS400DataType[] FLDL0300a = new AS400DataType[] { 
			lengthOfFLD0300Formatx,
			displacementToAllFieldsDefinedByFLD0100Formatx,
			displacementToAlternativeFieldNamex,
			displacementToDefaultValuex,
			lengthOfDefaultValuex 
			};
	protected transient AS400Structure FLDL0300x = new AS400Structure(FLDL0300a);

	protected Integer lengthOfFLD0300Format;

	protected Integer displacementToAllFieldsDefinedByFLD0100Format;

	protected Integer displacementToAlternativeFieldName;
	
	protected Integer displacementToDefaultValue;

	protected Integer lengthOfDefaultValue;
	

	public FLDL0300(){
		// Default Constructor
	}
	
	public FLDL0300(byte[] input){
		Object[] o = (Object[]) FLDL0300x.toObject(input);	
		lengthOfFLD0300Format = (Integer)o[0];
		displacementToAllFieldsDefinedByFLD0100Format = (Integer)o[1]; 
		displacementToAlternativeFieldName = (Integer)o[2];
		displacementToDefaultValue = (Integer)o[3];
		lengthOfDefaultValue = (Integer)o[4];
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FLDL0300 other = (FLDL0300) obj;
		if (displacementToAllFieldsDefinedByFLD0100Format == null) {
			if (other.displacementToAllFieldsDefinedByFLD0100Format != null)
				return false;
		} else if (!displacementToAllFieldsDefinedByFLD0100Format
				.equals(other.displacementToAllFieldsDefinedByFLD0100Format))
			return false;
		if (displacementToAlternativeFieldName == null) {
			if (other.displacementToAlternativeFieldName != null)
				return false;
		} else if (!displacementToAlternativeFieldName
				.equals(other.displacementToAlternativeFieldName))
			return false;
		if (displacementToDefaultValue == null) {
			if (other.displacementToDefaultValue != null)
				return false;
		} else if (!displacementToDefaultValue
				.equals(other.displacementToDefaultValue))
			return false;
		if (lengthOfDefaultValue == null) {
			if (other.lengthOfDefaultValue != null)
				return false;
		} else if (!lengthOfDefaultValue.equals(other.lengthOfDefaultValue))
			return false;
		if (lengthOfFLD0300Format == null) {
			if (other.lengthOfFLD0300Format != null)
				return false;
		} else if (!lengthOfFLD0300Format.equals(other.lengthOfFLD0300Format))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends FLDLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new FLDL0300(input));
	}

	/**
	 * @return the displacementToAllFieldsDefinedByFLD0100Format
	 */
	public Integer getDisplacementToAllFieldsDefinedByFLD0100Format() {
		return displacementToAllFieldsDefinedByFLD0100Format;
	}

	/**
	 * @return the displacementToAlternativeFieldName
	 */
	public Integer getDisplacementToAlternativeFieldName() {
		return displacementToAlternativeFieldName;
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
	 * @return the lengthOfFLD0300Format
	 */
	public Integer getLengthOfFLD0300Format() {
		return lengthOfFLD0300Format;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Length of FLDL0300 Format: " + lengthOfFLD0300Format.toString());
		sb.append(" Displacement to All Fields defined by FLDL0100 Format: " + displacementToAllFieldsDefinedByFLD0100Format.toString()); 
		sb.append(" Displacement to Alternative Field Name: " + displacementToAlternativeFieldName.toString());
		sb.append(" Displacement to Default Value: " + displacementToDefaultValue.toString());
		sb.append(" Length of Default Value: " + lengthOfDefaultValue.toString());

		return sb.toString();
	}
}
