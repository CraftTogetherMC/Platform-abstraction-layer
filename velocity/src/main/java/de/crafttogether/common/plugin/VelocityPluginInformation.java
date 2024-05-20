package de.crafttogether.common.plugin;

import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VelocityPluginInformation implements PluginInformation {

    private final Object plugin;
    private final File dataFolder;

    private final Logger logger;

    public VelocityPluginInformation(Object plugin, File dataFolder, Logger logger) {
        this.plugin = plugin;
        this.dataFolder = dataFolder;
        this.logger = logger;
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
    public File getJarFile() {
        String fileName = plugin.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        File file = new File(getDataFolder(), fileName);
        return file.exists() ? file : null;
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

    @Override
    public String getBuild() {
        InputStream inputStream = plugin.getClass().getResourceAsStream("/velocity.yml");

        if (inputStream == null) {
            logger.atWarn().log("velocity.yml not found");
            return "unkown";
        }

        Yaml yaml = new Yaml();
        Map<String, Object> obj = yaml.load(inputStream);

        if (!obj.containsKey("build")) {
            logger.atWarn().log("Unable to retrieve build-number");
            return "unkown";
        }

        return String.valueOf(obj.get("build"));
    }
}
