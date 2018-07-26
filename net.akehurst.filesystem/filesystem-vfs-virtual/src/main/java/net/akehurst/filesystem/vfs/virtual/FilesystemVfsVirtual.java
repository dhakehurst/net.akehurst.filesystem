package net.akehurst.filesystem.vfs.virtual;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.VFS;

import net.akehurst.filesystem.api.DirectoryEntry;
import net.akehurst.filesystem.api.FilesystemException;
import net.akehurst.filesystem.api.virtual.FilesystemVirtual;
import net.akehurst.filesystem.vfs.common.DirectoryEntryVfs;
import net.akehurst.filesystem.vfs.common.FilesystemVfsAbstract;

public class FilesystemVfsVirtual extends FilesystemVfsAbstract implements FilesystemVirtual {

	public static FilesystemVfsVirtual create() {
		FileObject fsRoot;
		try {
			fsRoot = VFS.getManager().createVirtualFileSystem("vfs://");
			return new FilesystemVfsVirtual(fsRoot);
		} catch (final FileSystemException e) {
			throw new FilesystemException("Unable to create Virtual Filesystem", e);
		}

	}

	protected FilesystemVfsVirtual(final FileObject fsRoot) {
		super(fsRoot);
	}

	@Override
	public DirectoryEntry addJunction(final String path, final DirectoryEntry entry) {
		try {
			final FileObject fo = ((DirectoryEntryVfs) entry).getVfsFileObject();
			this.getFsRoot().getFileSystem().addJunction(path, fo);
			final FileObject newFo = this.getFsRoot().getFileSystem().resolveFile(path);
			if (newFo.exists()) {
				return DirectoryEntryVfs.create(newFo);
			} else {
				throw new FilesystemException("Failed to addJunction", null);
			}
		} catch (final FileSystemException e) {
			throw new FilesystemException("addJunction", e);
		}
	}
}
