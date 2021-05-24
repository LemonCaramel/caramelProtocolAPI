package moe.caramel.protocolversionapi;

import org.bukkit.plugin.java.JavaPlugin;
import us.myles.ViaVersion.api.bukkit.API;

public final class Main extends JavaPlugin {

    public static API api;
    public static int serverVersion;

    @Override
    public void onEnable() {
        api = new API(this);
        try {
            serverVersion = this.getServer().getUnsafe().getProtocolVersion();
        } catch (Exception ignored) {
            getServer().getScheduler().runTask(this, () -> { // Very Bad Design
                try {
                    serverVersion = (int) getObject(getServer(),
                            "getServer" /* DedicatedServer */,
                            "getServerPing" /* ServerPing */,
                            "getServerData" /* ServerData */,
                            "getProtocolVersion") /* Version */;
                } catch (NoSuchMethodException | IllegalAccessException | NumberFormatException |
                        ClassCastException | java.lang.reflect.InvocationTargetException exception) {
                    exception.printStackTrace();
                    getServer().shutdown();
                }
            });
        }
    }

    private Object getObject(Object object, String... methods)
            throws NoSuchMethodException, IllegalAccessException,
            java.lang.reflect.InvocationTargetException {
        for (String method : methods)
            object = object.getClass().getMethod(method).invoke(object);
        return object;
    }

}
