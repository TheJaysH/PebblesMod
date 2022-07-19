package com.thejays.pebblemod.worldgen;

import com.thejays.pebblemod.state.ModBlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ModGenerationBlockStates {


    public static BlockState getPebbleBlockState(Block block, int count){
        return block.defaultBlockState().setValue(ModBlockStateProperties.PEBBLES_1_4, Integer.valueOf(count));
    }




}
