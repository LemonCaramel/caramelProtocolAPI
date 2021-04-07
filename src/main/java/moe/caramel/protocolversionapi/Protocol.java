package moe.caramel.protocolversionapi;

import java.util.SortedSet;
import java.util.TreeSet;

public enum Protocol {

    MINECRAFT_1_12_2(340), // 1.12.2
    MINECRAFT_1_13_2(404), // 1.13.2
    MINECRAFT_1_14_4(498), // 1.14.4
    MINECRAFT_1_15_2(578), // 1.15.2
    MINECRAFT_1_16_3(753), // 1.16.3
    MINECRAFT_1_16_4(754), // 1.16.4/5
    MINECRAFT_1_17(755), // 1.17
    MINECRAFT_UNKNOWN(-1); // UNKNOWN

    public final int number;
    public static final Protocol STABLE = MINECRAFT_1_16_3;

    Protocol(int number) {
        this.number = number;
    }

    public static SortedSet<Integer> getVersions() {
        SortedSet<Integer> list = new TreeSet<>();
        for (Protocol value : Protocol.values()) list.add(value.number);
        return list;
    }

}
