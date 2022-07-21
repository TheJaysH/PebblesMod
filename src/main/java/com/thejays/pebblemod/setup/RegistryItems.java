package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.items.PebbleItem;
import com.thejays.pebblemod.items.RockHammerItem;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class RegistryItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UtilReference.MOD_ID);


    public static final RegistryObject<Item> STONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.STONE_PEBBLE);
    public static final RegistryObject<Item> COBBLESTONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.COBBLESTONE_PEBBLE);
    public static final RegistryObject<Item> MOSSY_COBBLESTONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.MOSSY_COBBLESTONE_PEBBLE);
    public static final RegistryObject<Item> GRANITE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.GRANITE_PEBBLE);
    public static final RegistryObject<Item> ANDESITE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.ANDESITE_PEBBLE);
    public static final RegistryObject<Item> SANDSTONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.SANDSTONE_PEBBLE);
    public static final RegistryObject<Item> RED_SANDSTONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.RED_SANDSTONE_PEBBLE);
    public static final RegistryObject<Item> DIORITE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.DIORITE_PEBBLE);
    public static final RegistryObject<Item> DEEPSLATE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.DEEPSLATE_PEBBLE);
    public static final RegistryObject<Item> TUFF_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.TUFF_PEBBLE);
    public static final RegistryObject<Item> CALCITE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.CALCITE_PEBBLE);
    public static final RegistryObject<Item> NETHERRACK_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.NETHERRACK_PEBBLE);
    public static final RegistryObject<Item> BLACKSTONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.BLACKSTONE_PEBBLE);
    public static final RegistryObject<Item> END_STONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.END_STONE_PEBBLE);
    public static final RegistryObject<Item> GLOWSTONE_PEBBLE_ITEM = registerItemFromBlock(RegistryBlocks.GLOWSTONE_PEBBLE);

    public static final RegistryObject<Item> WOODEN_ROCK_HAMMER = ITEMS.register("wooden_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(256)));
    public static final RegistryObject<Item> STONE_ROCK_HAMMER = ITEMS.register("stone_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(512)));
    public static final RegistryObject<Item> IRON_ROCK_HAMMER = ITEMS.register("iron_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(1024)));
    public static final RegistryObject<Item> DIAMOND_ROCK_HAMMER = ITEMS.register("diamond_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(2048)));
    public static final RegistryObject<Item> SAND_PILE = ITEMS.register("sand_pile", () -> new Item(getItemProperties()));

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static <B extends Block> RegistryObject<Item> registerItemFromBlock(@NotNull RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new PebbleItem(block.get(), getItemProperties()));
    }

    public static List<RegistryObject<Item>> getPebbleItems() {
        return ITEMS.getEntries()
                .stream()
                .filter((itemRegistryObject) -> itemRegistryObject.get() instanceof PebbleItem)
                .collect(Collectors.toList());
    }

    private static Item.Properties getItemProperties() {
        return new Item.Properties().tab(ModSetup.ITEM_GROUP);
    }
}
