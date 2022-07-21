package com.thejays.pebblemod.worldgen;

import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.RegistryBlocks;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;

public class ModGeneration {

    public static void registerConfiguredFeatures() {

        ModGenerationFeatures.registerConfiguredFeatures();

    }


//    public static Holder<PlacedFeature> getFeature(Collection<RegistryObject<PebbleFeaturePair>> registryObjects, RegistryObject<Block> blockRegistryObject) {
//
//        for (var item : registryObjects) {
//
//            var pair = item.get();
//            var blockObject = pair.blockRegistryObject();
//
//            var block = blockObject.get();
//
//            if (block == blockRegistryObject.get())
//                return pair.placedFeatureHolder();
//        }
//
//        return null;
//    }

    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {

        var pebbles = RegistryBlocks.getPebbleBlocks();
        var features = ModGenerationFeatures.placedFeatures;
//        var features = Registration.PLACED_FEATURES.getEntries();

        for (var pebble : pebbles) {

            var pebbleBlock = (PebbleBlock) pebble.get();
            var pebbleConfig = pebbleBlock.getPebbleConfig();
            var pebbleGenerationConfig = pebbleConfig.getPebbleGeneration();

//            var feature = getFeature(features, pebble);
//
//            if (feature == null)
//                continue;
//
            if (!features.containsKey(pebble))
                continue;
//
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
