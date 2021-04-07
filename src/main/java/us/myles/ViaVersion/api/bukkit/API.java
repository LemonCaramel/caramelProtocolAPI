package us.myles.ViaVersion.api.bukkit;

import moe.caramel.protocolversionapi.Main;
import moe.caramel.protocolversionapi.Protocol;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import us.myles.ViaVersion.api.ViaAPI;

import java.util.SortedSet;
import java.util.UUID;

public class API implements ViaAPI<Player> {

    private final Main plugin;

    public API(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public int getPlayerVersion(Player player) {
        return (player != null && player.isOnline()) ?
                filter(player.getProtocolVersion()) : Main.serverVersion;
    }

    @Override
    public int getPlayerVersion(UUID uuid) {
        return getPlayerVersion(Bukkit.getPlayer(uuid));
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean isInjected(UUID uuid) {
        return getPlayerVersion(uuid) != Main.serverVersion;
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
