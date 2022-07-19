package com.thejays.pebblemod.worldgen;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModGenerationConfig {

//    private static final int PEBBLE_TRIES = 2;

//
//    public static ForgeConfigSpec.IntValue PEBBLE_TRIES;
//    public static ForgeConfigSpec.IntValue PEBBLE_XZ_SPREAD;
//    public static ForgeConfigSpec.IntValue PEBBLE_Y_SPREAD;

//    public static ForgeConfigSpec.;



    public static void registerCommonConfig(ForgeConfigSpec.Builder COMMON_BUILDER) {
        COMMON_BUILDER.comment("Settings for pebble generation").push("pebble");

//        PEBBLE_TRIES = COMMON_BUILDER.defineInRange("tries", 64, 1, 128);
//        PEBBLE_XZ_SPREAD = COMMON_BUILDER.defineInRange("xz_spread", 7, 1, 7);
//        PEBBLE_Y_SPREAD = COMMON_BUILDER.defineInRange("y_spread", 3, 1, 3);

//        PEBBLE_AMMOUNT = COMMON_BUILDER.defineInRange("pebbleAmount", 3, 1, Integer.MAX_VALUE);

    }

}
