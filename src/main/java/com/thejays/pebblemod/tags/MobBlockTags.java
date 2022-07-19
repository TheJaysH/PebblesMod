package com.thejays.pebblemod.tags;

import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class MobBlockTags {

    public static final TagKey<Block> ALL_PEBBLES = bind("pebble/block/all");

    private static TagKey<Block> bind(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(UtilReference.MOD_ID, name));
    }

}
