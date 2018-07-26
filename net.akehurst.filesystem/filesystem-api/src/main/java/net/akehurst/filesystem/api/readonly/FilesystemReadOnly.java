package net.akehurst.filesystem.api.readonly;

import net.akehurst.filesystem.api.DirectoryEntry;

public interface FilesystemReadOnly {

	/**
	 *
	 * resolve (find) a directory entry with the given path from the root of the filesystem.
	 *
	 * @param path
	 * @return
	 */
	DirectoryEntry resolveEntry(String path);

}
