package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.utils.UtilReference;
import com.thejays.pebblemod.worldgen.feature.PebbleFeature;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;

public class RegistryFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, UtilReference.MOD_ID);

    public static RegistryObject<Feature<SimpleBlockConfiguration>> STONE_PEBBLE_FEATURE = FEATURES.register("stone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.STONE, Blocks.ANDESITE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> COBBLESTONE_PEBBLE_FEATURE = FEATURES.register("cobblestone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.STONE, Blocks.MOSSY_COBBLESTONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> MOSSY_COBBLESTONE_PEBBLE_FEATURE = FEATURES.register("mossy_cobblestone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.MOSS_BLOCK, Blocks.MOSSY_COBBLESTONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> GRANITE_PEBBLE_FEATURE = FEATURES.register("granite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.GRANITE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> DIORITE_PEBBLE_FEATURE = FEATURES.register("diorite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.DIORITE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> ANDESITE_PEBBLE_FEATURE = FEATURES.register("andesite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.ANDESITE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> SANDSTONE_PEBBLE_FEATURE = FEATURES.register("sandstone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.SAND, Blocks.SANDSTONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> RED_SANDSTONE_PEBBLE_FEATURE = FEATURES.register("red_sandstone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.RED_SAND, Blocks.RED_SANDSTONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> DEEPSLATE_PEBBLE_FEATURE = FEATURES.register("deepslate_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.DEEPSLATE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> TUFF_PEBBLE_FEATURE = FEATURES.register("tuff_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.DEEPSLATE, Blocks.TUFF)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> CALCITE_PEBBLE_FEATURE = FEATURES.register("calcite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.CALCITE, Blocks.TUFF)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> NETHERRACK_PEBBLE_FEATURE = FEATURES.register("netherrack_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.NETHERRACK, Blocks.SOUL_SAND, Blocks.SOUL_SAND, Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> BLACKSTONE_PEBBLE_FEATURE = FEATURES.register("blackstone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.BLACKSTONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> END_STONE_PEBBLE_FEATURE = FEATURES.register("end_stone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.END_STONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> GLOWSTONE_PEBBLE_FEATURE = FEATURES.register("glowstone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC));

    private static final HashMap<RegistryObject<Block>, RegistryObject<Feature<SimpleBlockConfiguration>>> BLOCK_TO_FEATURE = new HashMap<>() {{
        put(RegistryBlocks.STONE_PEBBLE, STONE_PEBBLE_FEATURE);
        put(RegistryBlocks.COBBLESTONE_PEBBLE, COBBLESTONE_PEBBLE_FEATURE);
        put(RegistryBlocks.MOSSY_COBBLESTONE_PEBBLE, MOSSY_COBBLESTONE_PEBBLE_FEATURE);
        put(RegistryBlocks.GRANITE_PEBBLE, GRANITE_PEBBLE_FEATURE);
        put(RegistryBlocks.DIORITE_PEBBLE, DIORITE_PEBBLE_FEATURE);
        put(RegistryBlocks.ANDESITE_PEBBLE, ANDESITE_PEBBLE_FEATURE);
        put(RegistryBlocks.SANDSTONE_PEBBLE, SANDSTONE_PEBBLE_FEATURE);
        put(RegistryBlocks.RED_SANDSTONE_PEBBLE, RED_SANDSTONE_PEBBLE_FEATURE);
        put(RegistryBlocks.DEEPSLATE_PEBBLE, DEEPSLATE_PEBBLE_FEATURE);
        put(RegistryBlocks.TUFF_PEBBLE, TUFF_PEBBLE_FEATURE);
        put(RegistryBlocks.CALCITE_PEBBLE, CALCITE_PEBBLE_FEATURE);
        put(RegistryBlocks.NETHERRACK_PEBBLE, NETHERRACK_PEBBLE_FEATURE);
        put(RegistryBlocks.BLACKSTONE_PEBBLE, BLACKSTONE_PEBBLE_FEATURE);
        put(RegistryBlocks.END_STONE_PEBBLE, END_STONE_PEBBLE_FEATURE);
        put(RegistryBlocks.GLOWSTONE_PEBBLE, GLOWSTONE_PEBBLE_FEATURE);
    }};

    public static void init() {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static Feature<SimpleBlockConfiguration> getFeature(RegistryObject<Block> blockRegistryObject) {
        if (!BLOCK_TO_FEATURE.containsKey(blockRegistryObject))
            throw new IndexOutOfBoundsException("Unable map block to feature");

        return BLOCK_TO_FEATURE.get(blockRegistryObject).get();
    }
}
