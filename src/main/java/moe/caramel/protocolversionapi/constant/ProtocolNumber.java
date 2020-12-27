package moe.caramel.protocolversionapi.constant;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public enum ProtocolNumber {

    MINECRAFT_1_12_2("1.12.2", 340),
    MINECRAFT_1_13("1.13", 393),
    MINECRAFT_1_13_1("1.13.1", 401),
    MINECRAFT_1_13_2("1.13.2", 404),
    MINECRAFT_1_14("1.14", 477),
    MINECRAFT_1_14_1("1.14.1", 480),
    MINECRAFT_1_14_2("1.14.2", 485),
    MINECRAFT_1_14_3("1.14.3", 490),
    MINECRAFT_1_14_4("1.14.4", 498),
    MINECRAFT_1_15("1.15", 573),
    MINECRAFT_1_15_1("1.15.1", 575),
    MINECRAFT_1_15_2("1.15.2", 578),
    MINECRAFT_1_16("1.16", 735),
    MINECRAFT_1_16_1("1.16.1", 736),
    MINECRAFT_1_16_2("1.16.2", 751),
    MINECRAFT_1_16_3("1.16.3", 753),
    MINECRAFT_1_16_4("1.16.4", 754),
    MINECRAFT_1_17("1.17", 755),
    UNKNOWN("UNKNOWN", 340);

    private final String version;
    private final int number;

    ProtocolNumber(String version, int number) {
        this.version = version;
        this.number = number;
    }

    public String getVersion() {
        return this.version;
    }

    public static int getNumber(Plugin plugin, String version) {
        for (ProtocolNumber value : ProtocolNumber.values())
            if (value.getVersion().equals(version)) return value.number;
        // Generally, this situation does not occur.
        plugin.getLogger().warning("You are using an unsupported server version. [" + version + "]");
        return ProtocolNumber.UNKNOWN.number;
    }

    public static SortedSet<Integer> getSupportedVersions() {
        List<Integer> list = new ArrayList<>();
        for (ProtocolNumber value : ProtocolNumber.values()) list.add(value.number);
        return Collections.unmodifiableSortedSet(new TreeSet<>(list));
    }

}
