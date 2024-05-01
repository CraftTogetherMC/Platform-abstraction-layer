package net.playeranalytics.plugin;

import com.velocitypowered.api.plugin.Plugin;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VelocityPluginInformation implements PluginInformation {

    private final Object plugin;
    private final File dataFolder;

    public VelocityPluginInformation(Object plugin, File dataFolder) {
        this.plugin = plugin;
        this.dataFolder = dataFolder;
    }

    @Override
    public InputStream getResourceFromJar(String byName) {
        return getClass().getResourceAsStream("/" + byName);
    }

    @Override
    public File getDataFolder() {
        return dataFolder;
    }

    @Override
    public String getName() {
        return plugin.getClass().getAnnotation(Plugin.class).name();
    }

    @Override
    public String getDescription() {
        return plugin.getClass().getAnnotation(Plugin.class).description();
    }

    @Override
    public List<String> getAuthors() {
        return new ArrayList<>(Arrays.asList(plugin.getClass().getAnnotation(Plugin.class).authors()));
    }

    @Override
    public String getVersion() {
        return plugin.getClass().getAnnotation(Plugin.class).version();
    }
}
