package com.viaversion.viaversion.api;

public final class Via {

    private final static ViaAPI api = new BukkitAPI();

    public static ViaAPI getAPI() {
        return api;
    }
}
