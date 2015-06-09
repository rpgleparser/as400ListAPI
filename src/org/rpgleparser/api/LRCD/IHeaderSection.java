package org.rpgleparser.api.LRCD;

/**
 * Use this interface when working with the userspace header section of the QUSLRCD API
 * @author Eric N. Wilson
 *
 */
public interface IHeaderSection {
	public String getFileNameUsed();

	public String getFileLibraryNameUsed();

	public String getFileType();

	public String getFileTextDescription();

	public Integer getFileTextDescriptionCCSID();

	public String getFileCreationDate();

}
