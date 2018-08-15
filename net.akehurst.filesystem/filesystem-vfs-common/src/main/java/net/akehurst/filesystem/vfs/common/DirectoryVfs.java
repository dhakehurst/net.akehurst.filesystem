package net.akehurst.filesystem.vfs.common;

import org.apache.commons.vfs2.FileObject;

import net.akehurst.filesystem.api.DirectoryEntry;
import net.akehurst.filesystem.api.readonly.DirectoryReadOnly;

public class DirectoryVfs extends DirectoryEntryVfs implements DirectoryReadOnly {

    public static DirectoryReadOnly create(final FileObject fo) {
        return new DirectoryVfs(fo);
    }

    protected DirectoryVfs(final FileObject fo) {
        super(fo);
    }

    @Override
    public DirectoryEntry entries() {
        // TODO Auto-generated method stub
        return null;
    }

}
