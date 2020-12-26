package us.myles.ViaVersion.api.bukkit;

import io.netty.buffer.ByteBuf;
import moe.caramel.protocolversionapi.Main;
import moe.caramel.protocolversionapi.constant.Constants;
import moe.caramel.protocolversionapi.constant.ProtocolNumber;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import us.myles.ViaVersion.api.ViaAPI;

import java.util.*;

public class FakeAPI implements ViaAPI<Player> {

    private final Main plugin;
    private final int version;

    public FakeAPI(Main plugin) {
        this.plugin = plugin;
        this.version = ProtocolNumber.getNumber(plugin.getServer().getBukkitVersion().split("-")[0]);
    }

    @Override
    public int getPlayerVersion(Player player) {
        return player.isOnline() ? versionFilter(player.getProtocolVersion()) : version;
    }

    @Override
    public int getPlayerVersion(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        return player == null ? version : versionFilter(player.getProtocolVersion());
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean isInjected(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        return player != null && player.getProtocolVersion() != version;
    }

    @Override
    public void sendRawPacket(Player player, ByteBuf packet) {
        // TODO We don't need it now.
        plugin.getLogger().warning("Ignore: sendRawPacket <Player>");
    }

    @Override
    public void sendRawPacket(UUID uuid, ByteBuf packet) {
        // TODO We don't need it now.
        plugin.getLogger().warning("Ignore: sendRawPacket <UUID>");
    }

    @Override
    public SortedSet<Integer> getSupportedVersions() {
        return ProtocolNumber.getSupportedVersions();
    }

    public boolean isProtocolSupport() {
        return false;
    }


    /**
     * Snapshot client cannot be used with most AntiCheat plugins.
     *
     * @return returns the lowest version of the value
     */
    private int versionFilter(int protocol) {
        return Math.min(protocol, Constants.LATEST_STABLE_PROTOCOL);
    }

}
