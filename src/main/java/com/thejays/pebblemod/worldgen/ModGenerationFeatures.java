package com.thejays.pebblemod.worldgen;

import com.ibm.icu.impl.Pair;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.utils.UtilReference;
import com.thejays.pebblemod.worldgen.feature.PebbleFeature;
import com.thejays.pebblemod.worldgen.feature.configurations.PebbleFeatureConfiguration;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ModGenerationFeatures {

    public static final HashMap<RegistryObject<Block>, Holder<PlacedFeature>> placedFeatures = new HashMap<>();

    public static void registerConfiguredFeatures() {

        var pebbles = Registration.getPebbleBlocks();

        for (var pebble : pebbles) {
            var feature = registerFeature(pebble);
            placedFeatures.put(pebble, feature);
        }

    }


    public static Holder<PlacedFeature> registerFeature(RegistryObject<Block> block) {

        var pebbleBlock = (PebbleBlock) block.get();
        var pebbleConfig = pebbleBlock.getPebbleConfig();
        var pebbleGenerationConfig = pebbleConfig.getPebbleGeneration();
        var config = new PebbleFeatureConfiguration(64, 6, 2, getPlacedFeatureHolder(block));

        var configuredFeature = FeatureUtils.register(
                block.get().getRegistryName().getPath(),
                Registration.PEBBLE_DEFAULT.get(),
                config
        );

        var placementFeature = PlacementUtils.register(
                block.get().getRegistryName().getPath(),
                configuredFeature,
                NoiseThresholdCountPlacement.of(-0.8D, 15, 4),
                RarityFilter.onAverageOnceEvery(32),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                new ModBiomeFilter(key -> key.equals(pebbleGenerationConfig.getLevel())));

        return placementFeature;
    }

    private static SimpleBlockConfiguration getSimpleBlockConfiguration(RegistryObject<Block> block) {
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
                        block.get().defaultBlockState(),
                        List.of(
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 3),
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 4)
                        ),
                        List.of(
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 1),
                                ModGenerationBlockStates.getPebbleBlockState(block.get(), 2)
                        )
                )
        );
    }

    private static Holder<PlacedFeature> getPlacedFeatureHolder(RegistryObject<Block> block) {
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
