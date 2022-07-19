package com.thejays.pebblemod.helpers;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.ForgeRegistries;

public class PebbleGeneration {

    private GenerationStep.Decoration decorationType;
    private Biome.BiomeCategory[] biomeCategories;

    private ResourceKey<Level> level;

    public PebbleGeneration(GenerationStep.Decoration decorationType) {
        this.decorationType = decorationType;
    }

    public static PebbleGeneration create(GenerationStep.Decoration decorationType) {
        return new PebbleGeneration(decorationType);
    }


    public PebbleGeneration setBiomeCategories(Biome.BiomeCategory... biomeCategories) {
        this.biomeCategories = biomeCategories;
        return this;
    }


    public GenerationStep.Decoration getDecorationType() {
        return decorationType;
    }

    public Biome.BiomeCategory[] getBiomeCategories() {
        return biomeCategories;
    }


    public PebbleGeneration setLevel(ResourceKey<Level> level) {
        this.level = level;
        return this;
    }

    public ResourceKey<Level> getLevel() {
        return level == null ? Level.OVERWORLD : level;
    }
}
