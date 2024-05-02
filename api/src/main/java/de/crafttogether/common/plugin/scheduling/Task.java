package de.crafttogether.common.plugin.scheduling;

public interface Task {

    boolean isGameThread();

    void cancel();

}
