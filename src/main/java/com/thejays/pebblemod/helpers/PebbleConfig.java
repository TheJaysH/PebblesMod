package com.thejays.pebblemod.helpers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class PebbleConfig {

    private ResourceLocation parentResourceLocation;

    private PebbleGeneration pebbleGeneration;


    public PebbleConfig(String resourcePath,PebbleGeneration pebbleGeneration) {
        this.parentResourceLocation = new ResourceLocation(resourcePath);
        this.pebbleGeneration = pebbleGeneration;
    }

    public static PebbleConfig create(String resourcePath,PebbleGeneration pebbleGeneration){
        return new PebbleConfig(resourcePath, pebbleGeneration);
    }

    public ResourceLocation getParentResourceLocation(){
        return this.parentResourceLocation;
    }

    public Block getParentBlock(){
        return ForgeRegistries.BLOCKS.getValue(parentResourceLocation);
    }

    public PebbleGeneration getPebbleGeneration() {
        return this.pebbleGeneration;
    }
}
