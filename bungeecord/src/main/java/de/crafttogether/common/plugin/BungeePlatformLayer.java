package de.crafttogether.common.plugin;

import de.crafttogether.common.plugin.server.JavaUtilPluginLogger;
import de.crafttogether.common.plugin.server.Listeners;
import de.crafttogether.common.plugin.server.PluginLogger;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Plugin;
import de.crafttogether.common.plugin.scheduling.BungeeRunnableFactory;
import de.crafttogether.common.plugin.scheduling.RunnableFactory;
import de.crafttogether.common.plugin.server.BungeeListeners;

public class BungeePlatformLayer implements PlatformAbstractionLayer {

    private final Plugin plugin;

    private PluginLogger pluginLogger;
    private Listeners listeners;
    private RunnableFactory runnableFactory;
    private PluginInformation pluginInformation;

    public BungeePlatformLayer(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Platform getPlatformType() {
        return Platform.BUNGEECORD;
    }

    @Override
    public PluginLogger getPluginLogger() {
        if (pluginLogger == null) {
            String pluginName = plugin.getDescription().getName();
            pluginLogger = new JavaUtilPluginLogger(
                    plugin.getLogger(),
                    coloredMessage -> plugin.getProxy().getConsole()
                            .sendMessage(new ComponentBuilder().append("[" + pluginName + "] ").appendLegacy(coloredMessage).create())
            );
        }
        return pluginLogger;
    }

    @Override
    public Listeners getListeners() {
        if (listeners == null) listeners = new BungeeListeners(plugin);
        return listeners;
    }

    @Override
    public RunnableFactory getRunnableFactory() {
        if (runnableFactory == null) runnableFactory = new BungeeRunnableFactory(plugin);
        return runnableFactory;
    }

    @Override
    public PluginInformation getPluginInformation() {
        if (pluginInformation == null) pluginInformation = new BungeePluginInformation(plugin);
        return pluginInformation;
    }

}
