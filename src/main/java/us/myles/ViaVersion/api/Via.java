package us.myles.ViaVersion.api;

import java.util.SortedSet;
import java.util.UUID;

@Deprecated
public final class Via<T> implements ViaAPI<T> {

    private static final ViaAPI<?> INSTANCE = new Via();

    @Deprecated
    public static ViaAPI<?> getAPI() {
        return INSTANCE;
    }

    @Override
    public int getPlayerVersion(T player) {
        return com.viaversion.viaversion.api.Via.getAPI().getPlayerVersion(player);
    }

    @Override
    public int getPlayerVersion(UUID uuid) {
        return com.viaversion.viaversion.api.Via.getAPI().getPlayerVersion(uuid);
    }

    @Override
    public boolean isInjected(UUID uuid) {
        return com.viaversion.viaversion.api.Via.getAPI().isInjected(uuid);
    }

    @Override
    public String getVersion() {
        return com.viaversion.viaversion.api.Via.getAPI().getVersion();
    }

    @Override
    public SortedSet<Integer> getSupportedVersions() {
        return com.viaversion.viaversion.api.Via.getAPI().getSupportedVersions();
    }

    @Override
    public SortedSet<Integer> getFullSupportedVersions() {
        return com.viaversion.viaversion.api.Via.getAPI().getFullSupportedVersions();
    }
}
