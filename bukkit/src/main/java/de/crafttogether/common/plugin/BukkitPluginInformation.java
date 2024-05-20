package de.crafttogether.common.plugin;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class BukkitPluginInformation implements PluginInformation {

    private final JavaPlugin plugin;

    public BukkitPluginInformation(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public InputStream getResourceFromJar(String byName) {
        return plugin.getResource(byName);
    }

    @Override
    public File getJarFile() {
        String fileName = plugin.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        plugin.getLogger().warning(fileName);
        File file = new File(fileName);
        return file.exists() ? file : null;
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

    @Override
    public String getBuild() {
        InputStream inputStream = plugin.getResource("plugin.yml");

        if (inputStream == null)
            return null;

        Configuration pluginDescription = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
        return pluginDescription.get("build") == null ? "unkown" : String.valueOf(pluginDescription.get("build"));
    }
}
