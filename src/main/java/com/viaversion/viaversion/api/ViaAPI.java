package com.viaversion.viaversion.api;

import java.util.SortedSet;
import java.util.UUID;

public interface ViaAPI<T> {

    default int apiVersion() {
        return 1;
    }

    // #getServerVersion();

    int getPlayerVersion(T player);

    int getPlayerVersion(UUID uuid);

    boolean isInjected(UUID uuid);

    default String getVersion() {
        return org.bukkit.plugin.java.JavaPlugin
                .getPlugin(moe.caramel.protocolapi.Main.class)
                .getDescription().getVersion();
    }

    SortedSet<Integer> getSupportedVersions();

    SortedSet<Integer> getFullSupportedVersions();
}