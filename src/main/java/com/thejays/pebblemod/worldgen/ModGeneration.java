package com.thejays.pebblemod.worldgen;

import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;

public class ModGeneration {

    public static void registerConfiguredFeatures() {

        ModGenerationFeatures.registerConfiguredFeatures();



    }



    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {

        var pebbles = Registration.getPebbleBlocks();
        var features = ModGenerationFeatures.placedFeatures;

        for(var pebble : pebbles){

            var pebbleBlock = (PebbleBlock)pebble.get();
            var pebbleConfig = pebbleBlock.getPebbleConfig();
            var pebbleGenerationConfig = pebbleConfig.getPebbleGeneration();

            var feature = features.get(pebble);


//            event.getGeneration().addFeature()
//
            if (Arrays.stream(pebbleGenerationConfig.getBiomeCategories()).anyMatch((biome) -> event.getCategory() == biome)){

                event.getGeneration().addFeature(pebbleGenerationConfig.getDecorationType(), feature);



            }


        }


    }




}
