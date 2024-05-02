package de.crafttogether.common.plugin;

import net.md_5.bungee.api.plugin.Plugin;

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
}
