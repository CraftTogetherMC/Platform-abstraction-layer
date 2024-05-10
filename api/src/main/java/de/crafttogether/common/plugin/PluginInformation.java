package de.crafttogether.common.plugin;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

public interface PluginInformation {

    InputStream getResourceFromJar(String byName);

    File getDataFolder();

    default Path getDataDirectory() {
        return getDataFolder().toPath();
    }


    String getName();
    String getDescription();
    List<String> getAuthors();

    String getVersion();
    String getBuild();
}
