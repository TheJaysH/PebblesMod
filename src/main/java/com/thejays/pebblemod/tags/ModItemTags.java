package com.thejays.pebblemod.tags;

import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {

    public static final TagKey<Item> ALL_PEBBLES = register("pebble/item/all");

    public static final TagKey<Item> MAKES_SAND_PEBBLES = register("pebble/item/makes_sand");

    public static final TagKey<Item> GLOWSTONE_PEBBLES = register("pebble/item/glowstone");
    public static final TagKey<Item> NETHER_PEBBLES = register("pebble/item/nether");

    public static final TagKey<Item> COBBLE_PEBBLES = register("pebble/item/cobble");

    private static TagKey<Item> register(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(UtilReference.MOD_ID, name));
    }

}
