package de.crafttogether.common.plugin;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BungeePluginInformation implements PluginInformation {

    private final Plugin plugin;

    public BungeePluginInformation(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public InputStream getResourceFromJar(String byName) {
        return plugin.getResourceAsStream(byName);
    }

    @Override
    public File getDataFolder() {
        return plugin.getDataFolder();
    }

    @Override
    public String getName() { return plugin.getDescription().getName(); }

    @Override
    public List<String> getAuthors() {
        List<String> authors = new ArrayList<>();
        authors.add(plugin.getDescription().getAuthor());
        return authors;
    }

    @Override
    public String getDescription() {
        return plugin.getDescription().getDescription();
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String getBuild() {
        InputStream inputStream = plugin.getResourceAsStream("bungee.yml");

        if (inputStream == null)
            return null;

        Configuration pluginDescription = ConfigurationProvider.getProvider(YamlConfiguration.class).load(inputStream);
        return pluginDescription.get("build") == null ? "unkown" : String.valueOf(pluginDescription.get("build"));
    }
}
