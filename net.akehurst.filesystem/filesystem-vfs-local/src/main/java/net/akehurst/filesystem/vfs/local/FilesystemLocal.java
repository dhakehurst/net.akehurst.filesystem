package net.akehurst.filesystem.vfs.local;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.VFS;

import net.akehurst.filesystem.api.FilesystemException;
import net.akehurst.filesystem.api.readwrite.FilesystemReadWrite;
import net.akehurst.filesystem.vfs.common.FilesystemVfsAbstract;

public class FilesystemLocal extends FilesystemVfsAbstract implements FilesystemReadWrite {

	public static FilesystemReadWrite create(final String path) {
		try {
			final FileObject fsRoot = VFS.getManager().resolveFile(path);
			return new FilesystemLocal(fsRoot);
		} catch (final FileSystemException e) {
			throw new FilesystemException("Unable to create Local Filesystem", e);
		}
	}

	protected FilesystemLocal(final FileObject fsRoot) {
		super(fsRoot);
	}
}
