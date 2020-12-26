package moe.caramel.protocolversionapi;

import org.bukkit.plugin.java.JavaPlugin;
import us.myles.ViaVersion.api.bukkit.FakeAPI;

public final class Main extends JavaPlugin {

    public static FakeAPI fakeAPI;

    @Override
    public void onEnable() {
        fakeAPI = new FakeAPI(this);
    }

}
