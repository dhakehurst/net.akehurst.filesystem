package net.akehurst.filesystem.vfs.common;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import net.akehurst.filesystem.api.DirectoryEntry;
import net.akehurst.filesystem.api.FilesystemException;
import net.akehurst.filesystem.api.readonly.DirectoryReadOnly;
import net.akehurst.filesystem.api.readonly.FileReadOnly;

public class DirectoryEntryVfs implements DirectoryEntry {

    public static DirectoryEntry create(final FileObject fo) {
        return new DirectoryEntryVfs(fo);
    }

    protected final FileObject fo;

    protected DirectoryEntryVfs(final FileObject fo) {
        this.fo = fo;
    }

    public FileObject getVfsFileObject() {
        return this.fo;
    }

    // --- DirectoryEntry ---

    @Override
    public boolean isFile() {
        try {
            return this.fo.isFile();
        } catch (final FileSystemException e) {
            throw new FilesystemException("isFile", e);
        }
    }

    @Override
    public boolean isDirectory() {
        try {
            return this.fo.isFolder();
        } catch (final FileSystemException e) {
            throw new FilesystemException("isDirectory", e);
        }
    }

    @Override
    public boolean exists() {
        try {
            return this.fo.exists();
        } catch (final FileSystemException e) {
            throw new FilesystemException("exists", e);
        }
    }

    @Override
    public FileReadOnly asFile() {
        if (this.isDirectory()) {
            throw new FilesystemException("not a File " + this.fo, null);
        } else {
            // if not exist(yet) or isDirectory
            return FileVfs.create(this.fo);
        }
    }

    @Override
    public DirectoryReadOnly asDirectory() {
        if (this.isFile()) {
            throw new FilesystemException("not a Directory " + this.fo, null);
        } else {
            // if not exist (yet) or isFile
            return DirectoryVfs.create(this.fo);
        }
    }

}
