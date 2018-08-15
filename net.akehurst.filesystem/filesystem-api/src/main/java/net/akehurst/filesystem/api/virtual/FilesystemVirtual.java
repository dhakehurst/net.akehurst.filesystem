package net.akehurst.filesystem.api.virtual;

import net.akehurst.filesystem.api.DirectoryEntry;
import net.akehurst.filesystem.api.readwrite.FilesystemReadWrite;

public interface FilesystemVirtual extends FilesystemReadWrite {

	/**
	 *
	 * @param path
	 *            the path to a directory entry in this (virtual filesystem) that will be created.
	 * @param entry
	 *            an entry in a different filesystem to add as a juction
	 * @return the new DirectoryEntry added
	 */
	DirectoryEntry addJunction(String path, DirectoryEntry entry);

}
