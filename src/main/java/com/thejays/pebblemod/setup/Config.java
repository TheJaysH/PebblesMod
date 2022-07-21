package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.worldgen.ModGenerationConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;

public class Config {

    public static ForgeConfigSpec.IntValue PEBBLE_DAMAGE;

    public static void register(){
        registerCommonConfigs();
    }

    private static void registerCommonConfigs() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        ModGenerationConfig.registerCommonConfig(COMMON_BUILDER);
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.CLIENT, COMMON_BUILDER.build());
    }
}
