package com.thejays.pebblemod.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

import java.util.List;

import static com.thejays.pebblemod.state.ModBlockStateProperties.PEBBLES_1_4;


public class PebbleFeature extends Feature<SimpleBlockConfiguration> {


    private List<Block> allowedBlocks;

    public PebbleFeature(Codec<SimpleBlockConfiguration> codec, List<Block> allowedBlocks) {
        this(codec);
        this.allowedBlocks = allowedBlocks;
    }


    public PebbleFeature(Codec<SimpleBlockConfiguration> p_66808_) {
        super(p_66808_);
    }

    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> p_160341_) {
        SimpleBlockConfiguration simpleblockconfiguration = p_160341_.config();
        WorldGenLevel worldgenlevel = p_160341_.level();
        BlockPos blockpos = p_160341_.origin();
        BlockState blockstate = simpleblockconfiguration.toPlace().getState(p_160341_.random(), blockpos);

        var blockBellow = worldgenlevel.getBlockState(blockpos.below());
        var isAllowed = !blockBellow.isAir() && blockBellow.canOcclude() && (allowedBlocks == null || allowedBlocks.contains(blockBellow.getBlock()));

        if (isAllowed) {
            worldgenlevel.setBlock(blockpos, blockstate.setValue(PEBBLES_1_4, Integer.valueOf(p_160341_.random().nextInt(1, 5))), 2);
            return true;
        }

        return false;
    }
}