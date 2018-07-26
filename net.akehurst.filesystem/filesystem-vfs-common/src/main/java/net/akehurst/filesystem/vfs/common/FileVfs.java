package net.akehurst.filesystem.vfs.common;

import java.io.InputStream;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import net.akehurst.filesystem.api.FilesystemException;
import net.akehurst.filesystem.api.readonly.FileReadOnly;

public class FileVfs extends DirectoryEntryVfs implements FileReadOnly {

	public static FileReadOnly create(final FileObject fo) {
		return new FileVfs(fo);
	}

	protected FileVfs(final FileObject fo) {
		super(fo);
	}

	@Override
	public InputStream inputStream() {
		try {
			final InputStream is = this.fo.getContent().getInputStream();
			return is;
		} catch (final FileSystemException e) {
			throw new FilesystemException("inputStream", e);
		}

	}

}
