package net.akehurst.filesystem.api;

import net.akehurst.filesystem.api.readonly.DirectoryReadOnly;
import net.akehurst.filesystem.api.readonly.FileReadOnly;

public interface DirectoryEntry {

	boolean isFile();

	boolean isDirectory();

	boolean exists();

	FileReadOnly asFile();

	DirectoryReadOnly asDirectory();
}
