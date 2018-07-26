package net.akehurst.filesystem.vfs.jar;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.VFS;

import net.akehurst.filesystem.api.FilesystemException;
import net.akehurst.filesystem.api.readonly.FileReadOnly;
import net.akehurst.filesystem.api.readonly.FilesystemReadOnly;
import net.akehurst.filesystem.vfs.common.FileVfs;
import net.akehurst.filesystem.vfs.common.FilesystemVfsAbstract;

public class FilesystemJar extends FilesystemVfsAbstract implements FilesystemReadOnly {

	public static FilesystemReadOnly create(final FileReadOnly jarFileOnLocalFilesystem) {
		try {
			//TODO: can we get the jar from anywhere?
			final FileObject vfsJarFileOnLocalFilesystem = ((FileVfs) jarFileOnLocalFilesystem).getVfsFileObject();
			final FileObject fsRoot = VFS.getManager().createFileSystem(vfsJarFileOnLocalFilesystem);
			return new FilesystemJar(fsRoot);
		} catch (final Exception e) {
			throw new FilesystemException("Unable to create Jar Filesystem", e);
		}

	}

	protected FilesystemJar(final FileObject fsRoot) {
		super(fsRoot);
	}
}
