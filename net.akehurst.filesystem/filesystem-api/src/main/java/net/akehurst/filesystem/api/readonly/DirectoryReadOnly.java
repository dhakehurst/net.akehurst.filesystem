package net.akehurst.filesystem.api.readonly;

import net.akehurst.filesystem.api.DirectoryEntry;

public interface DirectoryReadOnly extends DirectoryEntry {

	DirectoryEntry entries();

}
