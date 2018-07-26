package net.akehurst.filesystem.api.readonly;

import java.io.InputStream;

import net.akehurst.filesystem.api.DirectoryEntry;

public interface FileReadOnly extends DirectoryEntry {

	InputStream inputStream();

}
