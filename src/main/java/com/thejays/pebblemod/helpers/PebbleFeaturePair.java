package com.thejays.pebblemod.helpers;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.RegistryObject;

public record PebbleFeaturePair(RegistryObject<Block> blockRegistryObject,
                                Holder<PlacedFeature> placedFeatureHolder) {




}
