package com.thejays.pebblemod.worldgen;

import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.worldgen.feature.configurations.PebbleFeatureConfiguration;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;

public class ModGenerationFeatures {


    public static HashMap<RegistryObject<Block>, Holder<PlacedFeature>> placedFeatures;


    public static void registerConfiguredFeatures() {

        placedFeatures = new HashMap<>();

        var pebbles = Registration.getPebbleBlocks();

        for (var pebble : pebbles) {

            var pebbleBlock = (PebbleBlock) pebble.get();
            var pebbleConfig = pebbleBlock.getPebbleConfig();
            var pebbleGenerationConfig = pebbleConfig.getPebbleGeneration();


            var config = new PebbleFeatureConfiguration(64, 6, 2, getPlacedFeatureHolder(pebble.get()));



            var configuredFeature = FeatureUtils.register(
                    pebble.get().getRegistryName().getPath(),
                    Registration.PEBBLE_DEFAULT.get(),
                    config
            );

            var placementFeature = PlacementUtils.register(
                    pebble.get().getRegistryName().getPath(),
                    configuredFeature,
                    NoiseThresholdCountPlacement.of(-0.8D, 15, 4),
                    RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    new ModBiomeFilter(key -> key.equals(pebbleGenerationConfig.getLevel())));


            placedFeatures.put(pebble, placementFeature);
        }

    }


    private static SimpleBlockConfiguration getSimpleBlockConfiguration(Block block) {
        return new SimpleBlockConfiguration(
                new NoiseThresholdProvider(
                        2345L,
                        new NormalNoise.NoiseParameters(
                                0,
                                1.0D
                        ),
                        0.005F,
                        -0.8F,
                        0.33333334F,
                        block.defaultBlockState(),
                        List.of(
                                ModGenerationBlockStates.getPebbleBlockState(block, 3),
                                ModGenerationBlockStates.getPebbleBlockState(block, 4)
                        ),
                        List.of(
                                ModGenerationBlockStates.getPebbleBlockState(block, 1),
                                ModGenerationBlockStates.getPebbleBlockState(block, 2)
                        )
                )
        );
    }

    private static Holder<PlacedFeature> getPlacedFeatureHolder(Block block) {
        return PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, getSimpleBlockConfiguration(block));
    }


//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PEBBLE_PLAIN = FeatureUtils.register(
//            "pebble_plain",
//            Feature.FLOWER,
//            new RandomPatchConfiguration(
//                    64,
//                    6,
//                    2,
//                    PlacementUtils.onlyWhenEmpty(
//                            Feature.SIMPLE_BLOCK,
//                            new SimpleBlockConfiguration(
//                                    new NoiseThresholdProvider(
//                                            2345L,
//                                            new NormalNoise.NoiseParameters(
//                                                    0,
//                                                    1.0D
//                                            ),
//                                            0.005F,
//                                            -0.8F,
//                                            0.33333334F,
//                                            Registration.COBBLESTONE_PEBBLE.get().defaultBlockState(),
//                                            List.of(
//                                                    ModGenerationBlockStates.getPebbleBlockState(Registration.COBBLESTONE_PEBBLE.get(), 3),
//                                                    ModGenerationBlockStates.getPebbleBlockState(Registration.COBBLESTONE_PEBBLE.get(), 4)
//                                            ),
//                                            List.of(
//                                                    ModGenerationBlockStates.getPebbleBlockState(Registration.COBBLESTONE_PEBBLE.get(), 1),
//                                                    ModGenerationBlockStates.getPebbleBlockState(Registration.COBBLESTONE_PEBBLE.get(), 2)
//                                            )
//                                    )
//                            )
//                    )
//
//            )
//    );


    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }
}
