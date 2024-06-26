package de.crafttogether.common.plugin;

import com.velocitypowered.api.proxy.ProxyServer;
import de.crafttogether.common.plugin.scheduling.RunnableFactory;
import de.crafttogether.common.plugin.scheduling.VelocityRunnableFactory;
import de.crafttogether.common.plugin.server.Listeners;
import de.crafttogether.common.plugin.server.PluginLogger;
import de.crafttogether.common.plugin.server.VelocityListeners;
import de.crafttogether.common.plugin.server.VelocityPluginLogger;
import org.slf4j.Logger;

import java.nio.file.Path;

public class VelocityPlatformLayer implements PlatformAbstractionLayer {

    private final Object plugin;
    private final ProxyServer proxy;
    private final Logger logger;
    private final Path dataFolderPath;

    private PluginLogger pluginLogger;
    private Listeners listeners;
    private RunnableFactory runnableFactory;
    private PluginInformation pluginInformation;

    public VelocityPlatformLayer(Object plugin, ProxyServer proxy, Logger logger, Path dataFolderPath) {
        this.plugin = plugin;
        this.proxy = proxy;
        this.logger = logger;
        this.dataFolderPath = dataFolderPath;
    }

    @Override
    public Platform getPlatformType() {
        return Platform.VELOCITY;
    }

    @Override
    public PluginLogger getPluginLogger() {
        if (pluginLogger == null) pluginLogger = new VelocityPluginLogger(logger);
        return pluginLogger;
    }

    @Override
    public Listeners getListeners() {
        if (listeners == null) listeners = new VelocityListeners(plugin, proxy);
        return listeners;
    }

    @Override
    public RunnableFactory getRunnableFactory() {
        if (runnableFactory == null) runnableFactory = new VelocityRunnableFactory(plugin, proxy);
        return runnableFactory;
    }

    @Override
    public PluginInformation getPluginInformation() {
        if (pluginInformation == null) {
            pluginInformation = new VelocityPluginInformation(plugin, dataFolderPath.toFile(), logger);
        }
        return pluginInformation;
    }

}
