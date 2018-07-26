package net.akehurst.filesystem.vfs.common;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import net.akehurst.filesystem.api.DirectoryEntry;
import net.akehurst.filesystem.api.FilesystemException;
import net.akehurst.filesystem.api.readonly.FilesystemReadOnly;

abstract public class FilesystemVfsAbstract implements FilesystemReadOnly {

	private final FileObject fsRoot;

	protected FilesystemVfsAbstract(final FileObject fsRoot) {
		this.fsRoot = fsRoot;
	}

	public FileObject getFsRoot() {
		return this.fsRoot;
	}

	// --- ---
	@Override
	public DirectoryEntry resolveEntry(final String path) {
		FileObject fo;
		try {
			fo = this.fsRoot.resolveFile(path);
			return DirectoryEntryVfs.create(fo);
		} catch (final FileSystemException e) {
			throw new FilesystemException("resolveEntry", e);
		}

	}

}
