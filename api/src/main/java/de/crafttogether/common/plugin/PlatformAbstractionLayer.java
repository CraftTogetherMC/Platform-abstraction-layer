package de.crafttogether.common.plugin;

import de.crafttogether.common.plugin.scheduling.RunnableFactory;
import de.crafttogether.common.plugin.server.Listeners;
import de.crafttogether.common.plugin.server.PluginLogger;

public interface PlatformAbstractionLayer {

    PluginLogger getPluginLogger();

    Listeners getListeners();

    RunnableFactory getRunnableFactory();

    PluginInformation getPluginInformation();

}
