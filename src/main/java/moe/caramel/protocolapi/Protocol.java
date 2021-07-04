package moe.caramel.protocolapi;

import java.util.SortedSet;
import java.util.TreeSet;

public enum Protocol {

    MINECRAFT_1_15_2(578, "1.15.2"),
    MINECRAFT_1_16(735, "1.16"),
    MINECRAFT_1_16_1(736, "1.16.1"),
    MINECRAFT_1_16_2(751, "1.16.2"),
    MINECRAFT_1_16_3(753, "1.16.3"),
    MINECRAFT_1_16_4(754, "1.16.4/5"),
    MINECRAFT_1_17(755, "1.17"),
    MINECRAFT_1_17_1(756, "1.17.1"),
    MINECRAFT_UNKNOWN(-1, "UNKNOWN");

    public final int number;
    public final String version;
    public static final Protocol STABLE = MINECRAFT_1_17;

    Protocol(int number, String version) {
        this.number = number;
        this.version = version;
    }

    public static SortedSet<Integer> getVersions() {
        SortedSet<Integer> list = new TreeSet<>();
        for (Protocol value : Protocol.values()) list.add(value.number);
        return list;
    }
}