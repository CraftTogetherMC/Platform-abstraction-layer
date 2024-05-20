package de.crafttogether.common.plugin;

import de.crafttogether.common.plugin.scheduling.RunnableFactory;
import de.crafttogether.common.plugin.server.Listeners;
import de.crafttogether.common.plugin.server.PluginLogger;

public interface PlatformAbstractionLayer {

    Platform getPlatformType();

    PluginLogger getPluginLogger();

    Listeners getListeners();

    RunnableFactory getRunnableFactory();

    PluginInformation getPluginInformation();

    default boolean isBukkit() {
        return getPlatformType().equals(Platform.BUKKIT);
    }

    default boolean isBungeeCord() {
        return getPlatformType().equals(Platform.BUNGEECORD);
    }

    default boolean isVelocity() {
        return getPlatformType().equals(Platform.VELOCITY);
    }
}
