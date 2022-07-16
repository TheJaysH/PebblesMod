package com.thejays.pebblemod.tags;

import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {

    public static final TagKey<Item> ALL_PEBBLES = bind("pebble/all");
    public static final TagKey<Item> COBBLE_PEBBLES = bind("pebble/cobble");

    private static TagKey<Item> bind(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(UtilReference.MOD_ID, name));
    }

}
