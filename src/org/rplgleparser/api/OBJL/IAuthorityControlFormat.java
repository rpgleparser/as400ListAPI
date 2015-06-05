package org.rplgleparser.api.OBJL;

/**
 * Use this interface when working with the Authority Control Format of the QUSLOBJ API
 * @author Eric N. Wilson
 *
 */
public interface IAuthorityControlFormat {
	/**
	 * @return the lengthOfAuthorityControlFormat
	 */
	public Integer getLengthOfAuthorityControlFormat();
	/**
	 * @return the callLevel
	 */
	public Integer getCallLevel();
	/**
	 * @return the displacementToObjectAuthorities
	 */
	public Integer getDisplacementToObjectAuthorities();
	/**
	 * @return the numberOfObjectAuthorities
	 */
	public Integer getNumberOfObjectAuthorities();
	/**
	 * @return the displacementToLibraryAuthorities
	 */
	public Integer getDisplacementToLibraryAuthorities();
	/**
	 * @return the numberOfLibraryAuthorities
	 */
	public Integer getNumberOfLibraryAuthorities();
	/**
	 * @return the reservedAuthControlFormat
	 */
	public Integer getReservedAuthControlFormat();
}
