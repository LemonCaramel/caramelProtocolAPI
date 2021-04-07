package us.myles.ViaVersion.api;

import moe.caramel.protocolversionapi.Main;
import org.bukkit.entity.Player;

public class Via {

    public static ViaAPI<Player> getAPI() {
        return Main.api;
    }

}
