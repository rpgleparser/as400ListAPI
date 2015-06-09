package org.rpgleparser.api.OBJL;

import java.io.Serializable;

import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400Structure;

/**
 * Implementation class for the Authority Control Format of the QUSLOBJ API. Currently not used 
 * in the main code but provided so you can take a byte[] from the user space and get the data
 * @author Eric N. Wilson
 *
 */
public class AuthorityControlFormat implements IAuthorityControlFormat, OBJLoutputFormat, Serializable{
	private static final long serialVersionUID = 2563546748840116787L;
	//
	// Authority Control Format
	//
	// The following shows the format of the authority control parameter. For
	// detailed descriptions of the fields in the table, see Field Descriptions.
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 BINARY(4) Length of authority control format
	protected transient AS400Bin4 lengthOfAuthorityControlFormatx = new AS400Bin4();
	// 4 4 BINARY(4) Call level
	protected transient AS400Bin4 callLevelx = new AS400Bin4();

	// 8 8 BINARY(4) Displacement to object authorities
	protected transient AS400Bin4 displacementToObjectAuthoritiesx = new AS400Bin4();

	// 12 C BINARY(4) Number of object authorities
	protected transient AS400Bin4 numberOfObjectAuthoritiesx = new AS400Bin4();

	// 16 10 BINARY(4) Displacement to library authorities
	protected transient AS400Bin4 displacementToLibraryAuthoritiesx = new AS400Bin4();

	// 20 14 BINARY(4) Number of library authorities
	protected transient AS400Bin4 numberOfLibraryAuthoritiesx = new AS400Bin4();

	// 24 18 BINARY(4) Reserved
	protected transient AS400Bin4 reservedAuthControlFormatx = new AS400Bin4();

	protected transient AS400DataType[] authorityControlFormata = new AS400DataType[] {
			lengthOfAuthorityControlFormatx, 
			callLevelx,
			displacementToObjectAuthoritiesx, 
			numberOfObjectAuthoritiesx,
			displacementToLibraryAuthoritiesx, 
			numberOfLibraryAuthoritiesx,
			reservedAuthControlFormatx 
			};

	protected transient AS400Structure authorityControlFormatx = new AS400Structure(
			authorityControlFormata);
	protected Integer reservedAuthControlFormat;
	protected Integer numberOfLibraryAuthorities;
	protected Integer displacementToLibraryAuthorities;
	protected Integer numberOfObjectAuthorities;
	protected Integer displacementToObjectAuthorities;
	protected Integer callLevel;
	protected Integer lengthOfAuthorityControlFormat;

	// ARRAY(*) of CHAR(10) Object authorities
	// ARRAY(*) of CHAR(10) Library authorities

	public AuthorityControlFormat(){
		// Default Constructor
	}

	public AuthorityControlFormat(byte[] input){
		Object[] o = (Object[]) authorityControlFormatx.toObject(input);
		lengthOfAuthorityControlFormat = (Integer)o[0]; 
		callLevel = (Integer)o[1];
		displacementToObjectAuthorities = (Integer)o[2]; 
		numberOfObjectAuthorities = (Integer)o[3];
		displacementToLibraryAuthorities = (Integer)o[4];
		numberOfLibraryAuthorities = (Integer)o[5];
		reservedAuthControlFormat = (Integer)o[6]; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorityControlFormat other = (AuthorityControlFormat) obj;
		if (callLevel == null) {
			if (other.callLevel != null)
				return false;
		} else if (!callLevel.equals(other.callLevel))
			return false;
		if (displacementToLibraryAuthorities == null) {
			if (other.displacementToLibraryAuthorities != null)
				return false;
		} else if (!displacementToLibraryAuthorities
				.equals(other.displacementToLibraryAuthorities))
			return false;
		if (displacementToObjectAuthorities == null) {
			if (other.displacementToObjectAuthorities != null)
				return false;
		} else if (!displacementToObjectAuthorities
				.equals(other.displacementToObjectAuthorities))
			return false;
		if (lengthOfAuthorityControlFormat == null) {
			if (other.lengthOfAuthorityControlFormat != null)
				return false;
		} else if (!lengthOfAuthorityControlFormat
				.equals(other.lengthOfAuthorityControlFormat))
			return false;
		if (numberOfLibraryAuthorities == null) {
			if (other.numberOfLibraryAuthorities != null)
				return false;
		} else if (!numberOfLibraryAuthorities
				.equals(other.numberOfLibraryAuthorities))
			return false;
		if (numberOfObjectAuthorities == null) {
			if (other.numberOfObjectAuthorities != null)
				return false;
		} else if (!numberOfObjectAuthorities
				.equals(other.numberOfObjectAuthorities))
			return false;
		if (reservedAuthControlFormat == null) {
			if (other.reservedAuthControlFormat != null)
				return false;
		} else if (!reservedAuthControlFormat
				.equals(other.reservedAuthControlFormat))
			return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T extends OBJLoutputFormat> T fromByteArray(byte[] input) {
		return ((T) new AuthorityControlFormat(input));
	}

	public Integer getCallLevel() {
		return callLevel;
	}

	public Integer getDisplacementToLibraryAuthorities() {
		return displacementToLibraryAuthorities;
	}

	public Integer getDisplacementToObjectAuthorities() {
		return displacementToObjectAuthorities;
	}

	public Integer getLengthOfAuthorityControlFormat() {
		return lengthOfAuthorityControlFormat;
	}

	public Integer getNumberOfLibraryAuthorities() {
		return numberOfLibraryAuthorities;
	}

	public Integer getNumberOfObjectAuthorities() {
		return numberOfObjectAuthorities;
	}

	public Integer getReservedAuthControlFormat() {
		return reservedAuthControlFormat;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Length of Authority Control Format: " + lengthOfAuthorityControlFormat.toString());
		sb.append("Call Level: " + callLevel.toString());
		sb.append("Displacement to Object Authorities: "+ displacementToObjectAuthorities.toString());
		sb.append("Number of Object Authorities: "+ numberOfObjectAuthorities.toString());
		sb.append("Displacement to Library Authorities: "+ displacementToLibraryAuthorities.toString()); 
		sb.append("Number of Library Authorities: "+numberOfLibraryAuthorities.toString());
		sb.append("Reserved (Authority Control Format): "+ reservedAuthControlFormat.toString());
		return sb.toString();
	}

}
