package com.thejays.pebblemod.worldgen;

import com.ibm.icu.impl.Pair;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;

public class ModGeneration {

    public static void registerConfiguredFeatures() {

        ModGenerationFeatures.registerConfiguredFeatures();


    }


    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {

        var pebbles = Registration.getPebbleBlocks();
        var features = ModGenerationFeatures.placedFeatures;
//        var features = Registration.PLACED_FEATURES.getEntries();

        for (var pebble : pebbles) {

            var pebbleBlock = (PebbleBlock) pebble.get();
            var pebbleConfig = pebbleBlock.getPebbleConfig();
            var pebbleGenerationConfig = pebbleConfig.getPebbleGeneration();


            if (!features.containsKey(pebble))
                continue;

            var feature = features.get(pebble);


//            if (features.stream().noneMatch((pair) -> pair.get().first.equals(pebble)))
//                continue;
//
//            var feature = features.stream().filter((pair) -> pair.get().first.equals(pebble)).findFirst().get().get().second;

            if (Arrays.stream(pebbleGenerationConfig.getBiomeCategories()).anyMatch((biome) -> event.getCategory() == biome)) {
                event.getGeneration().addFeature(pebbleGenerationConfig.getDecorationType(), feature);
            }
        }
    }




}
