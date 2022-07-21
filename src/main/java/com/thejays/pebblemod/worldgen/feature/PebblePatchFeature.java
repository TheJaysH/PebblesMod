package com.thejays.pebblemod.worldgen.feature;

import com.mojang.serialization.Codec;
import com.thejays.pebblemod.PebbleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

import java.util.List;
import java.util.Random;

public class PebblePatchFeature extends Feature<RandomPatchConfiguration> {

    private List<Block> allowedBlocks;

    public PebblePatchFeature(Codec<RandomPatchConfiguration> codec, List<Block> allowedBlocks) {
        this(codec);
        this.allowedBlocks = allowedBlocks;
    }

    public PebblePatchFeature(Codec<RandomPatchConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
        RandomPatchConfiguration config = context.config();
        Random random = context.random();
        BlockPos blockpos = context.origin();
        WorldGenLevel worldgenlevel = context.level();
        boolean any = false;

        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int j = config.xzSpread() + 1;
        int k = config.ySpread() + 1;

        for (int l = 0; l < config.tries(); ++l) {

            int x = random.nextInt(j) - random.nextInt(j);
            int z = random.nextInt(j) - random.nextInt(j);
            int y = random.nextInt(k) - random.nextInt(k);

            mutableBlockPos.setWithOffset(blockpos, x, y, z);

            var blockBellow = worldgenlevel.getBlockState(mutableBlockPos.immutable().below());
            var isAllowed = !blockBellow.isAir() && blockBellow.canOcclude() && (allowedBlocks == null || allowedBlocks.contains(blockBellow.getBlock()));

            if (isAllowed && config.feature().value().place(worldgenlevel, context.chunkGenerator(), random, mutableBlockPos)) {
                any = true;
                PebbleMod.LOGGER.warn(mutableBlockPos.immutable().toShortString());
            }
        }

        return any;
    }

}
