package com.thejays.pebblemod.worldgen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;

public class ModGenerationFeatures {

    public static final HashMap<RegistryObject<Block>, Holder<PlacedFeature>> placedFeatures = new HashMap<>();

    public static void registerConfiguredFeatures() {
        var pebbles = Registration.getPebbleBlocks();
        PebbleMod.LOGGER.warn("Adding pebble feature configs: " + pebbles.stream().count());
        for (var pebble : pebbles) {

//            Registration.PLACED_FEATURES.register(pebble.get().getRegistryName().getPath() + "_placed_feature", () -> new PebbleFeaturePair(pebble, registerFeature(pebble)));

            placedFeatures.put(pebble, registerFeature(pebble));
        }
    }

    public static Holder<PlacedFeature> registerFeature(RegistryObject<Block> block) {

        var pebbleBlock = (PebbleBlock) block.get();
        var pebbleConfig = pebbleBlock.getPebbleConfig();
        var pebbleGenerationConfig = pebbleConfig.getPebbleGeneration();
//        var config = new RandomPatchConfiguration(128, 8, 2, getPlacedFeatureHolder(block));
        var config = new SimpleBlockConfiguration(BlockStateProvider.simple(block.get()));


        var feature = Registration.BLOCK_TO_FEATURE.get(block);

        var configuredFeature = FeatureUtils.register(
                block.get().getRegistryName().getPath(),
                Feature.RANDOM_PATCH,
                FeatureUtils.simpleRandomPatchConfiguration(64, PlacementUtils.onlyWhenEmpty(feature.get(), config))
        );
        var placementFeature = PlacementUtils.register(
                block.get().getRegistryName().getPath(),
                configuredFeature,
                NoiseThresholdCountPlacement.of(-0.8D, 5, 10),
                InSquarePlacement.spread(),
//                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                new ModBiomeFilter(key -> key.equals(pebbleGenerationConfig.getLevel()))
        );
        PebbleMod.LOGGER.warn("returning feature for: " + block.get().getRegistryName());
        return placementFeature;
    }

    private static SimpleBlockConfiguration getSimpleBlockConfiguration(RegistryObject<Block> block) {
        var pebbleBlock = (PebbleBlock) block.get();
        var parentBlock = pebbleBlock.getPebbleConfig().getParentBlock();
        return new SimpleBlockConfiguration(
                new NoiseThresholdProvider(
                        2345L,
                        new NormalNoise.NoiseParameters(
                                0,
                                1.0D
                        ),
                        0.005F,
                        -0.8F,
                        0.55555556F,
                        block.get().defaultBlockState(),
                        List.of(
                                parentBlock.defaultBlockState()
                        ),
                        List.of(
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 1),
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 2),
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 3),
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 4)

                        )
                )
        );
    }

    private static Holder<PlacedFeature> getPlacedFeatureHolder(RegistryObject<Block> block) {
        return PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, getSimpleBlockConfiguration(block));
    }

}
