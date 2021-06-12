package us.myles.ViaVersion.api;

import java.util.SortedSet;
import java.util.UUID;

@Deprecated
public interface ViaAPI<T> {

    int getPlayerVersion(T player);

    int getPlayerVersion(UUID uuid);

    @Deprecated
    default boolean isPorted(UUID uuid) {
        return isInjected(uuid);
    }

    boolean isInjected(UUID uuid);

    String getVersion();

    SortedSet<Integer> getSupportedVersions();

    SortedSet<Integer> getFullSupportedVersions();
}
