package com.thejays.pebblemod.worldgen.feature.configurations;

import com.mojang.serialization.Codec;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PebbleFeatureConfiguration implements FeatureConfiguration {

    public static final Codec<PebbleFeatureConfiguration> CODEC = RecordCodecBuilder.create((p_191312_) -> p_191312_.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter((config) -> config.tries),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("xz_spread").orElse(7).forGetter((config) -> config.xzSpread),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("y_spread").orElse(3).forGetter((config) -> config.ySpread),
            PlacedFeature.CODEC.fieldOf("feature").forGetter((config) -> config.feature)
    ).apply(p_191312_, PebbleFeatureConfiguration::new));


    public int tries;
    public int xzSpread;
    public int ySpread;
    public Holder<PlacedFeature> feature;

    public PebbleFeatureConfiguration(int tries, int xzSpread, int ySpread, Holder<PlacedFeature> feature) {
        this.tries = tries;
        this.xzSpread = xzSpread;
        this.ySpread = ySpread;
        this.feature = feature;
    }

}