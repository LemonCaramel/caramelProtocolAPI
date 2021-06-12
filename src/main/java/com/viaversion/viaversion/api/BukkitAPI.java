package com.viaversion.viaversion.api;

import moe.caramel.protocolapi.Protocol;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.SortedSet;
import java.util.UUID;

public final class BukkitAPI implements ViaAPI<Player> {

    private final int serverProtocol;

    protected BukkitAPI() {
        this.serverProtocol = Bukkit.getUnsafe().getProtocolVersion();
    }

    @Override
    public int getPlayerVersion(Player player) {
        return (player != null && player.isOnline()) ? this.filter(player.getProtocolVersion()) : this.serverProtocol; // It should return -1 in the future.
    }

    @Override
    public int getPlayerVersion(UUID uuid) {
        return this.getPlayerVersion(Bukkit.getPlayer(uuid));
    }

    @Override
    public boolean isInjected(UUID uuid) {
        return getPlayerVersion(uuid) != this.serverProtocol;
    }

    @Override
    public SortedSet<Integer> getSupportedVersions() {
        return Protocol.getVersions();
    }

    @Override
    public SortedSet<Integer> getFullSupportedVersions() {
        return Protocol.getVersions();
    }

    public boolean isProtocolSupport() {
        return false;
    }

    /**
     * Snapshot client cannot be used with most AntiCheat plugins.
     *
     * @return returns the lowest version of the value
     */
    private int filter(int protocol) {
        return Math.min(protocol, Protocol.STABLE.number);
    }
}
