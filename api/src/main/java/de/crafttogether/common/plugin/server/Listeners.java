package de.crafttogether.common.plugin.server;

public interface Listeners {

    void registerListener(Object listener);

    void unregisterListener(Object listener);

    void unregisterListeners();

}
