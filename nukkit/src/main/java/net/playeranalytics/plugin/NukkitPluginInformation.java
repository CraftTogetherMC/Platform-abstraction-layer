package net.playeranalytics.plugin;

import cn.nukkit.plugin.PluginBase;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class NukkitPluginInformation implements PluginInformation {

    private final PluginBase plugin;

    public NukkitPluginInformation(PluginBase plugin) {
        this.plugin = plugin;
    }

    @Override
    public InputStream getResourceFromJar(String byName) {
        return plugin.getResource(byName);
    }

    @Override
    public File getDataFolder() {
        return plugin.getDataFolder();
    }

    @Override
    public String getName() {
        return plugin.getDescription().getName();
    }

    @Override
    public String getDescription() {
        return plugin.getDescription().getDescription();
    }

    @Override
    public List<String> getAuthors() {
        return plugin.getDescription().getAuthors();
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }
}
