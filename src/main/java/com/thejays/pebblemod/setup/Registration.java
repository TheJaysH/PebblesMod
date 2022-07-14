package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class Registration {

    //TODO: this needs to be done via some sort of config file
    public static final String[] BLOCKS_TO_CONVERT = {
            "minecraft:stone",
            "minecraft:cobblestone",
            "minecraft:granite",
            "minecraft:sandstone",
            "minecraft:diorite",
            "minecraft:deepslate",
    };

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UtilReference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UtilReference.MOD_ID);

    //public static final RegistryObject<Block> COBBLESTONE_PEBBLE = BLOCKS.register("cobblestone_pebble", () -> new PebbleBlock(PEBBLE_PROPERTIES, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:cobblestone"))));
    //public static final RegistryObject<Item> COBBLESTONE_PEBBLE_ITEM = fromBlock(COBBLESTONE_PEBBLE);


    public static void init() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);

        registerPebbles();
    }

    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);
    public static final Block.Properties PEBBLE_PROPERTIES = Block.Properties.of(Material.STONE)
            .noOcclusion()
            .strength(0.1f)
            .noCollission()
            .sound(SoundType.STONE);


    public static <B extends Block> RegistryObject<Item> fromBlock(@NotNull RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }

    public static void registerPebbles() {
        for (var resourcePath : BLOCKS_TO_CONVERT) {
            var resourceLocation = new ResourceLocation(resourcePath);
            var pebbleName = resourcePath.substring(resourcePath.indexOf(':') + 1) + "_pebble";

            var registryObjectBlock = BLOCKS.register(pebbleName, () -> new PebbleBlock(PEBBLE_PROPERTIES, ForgeRegistries.BLOCKS.getValue(resourceLocation)));
            var registryObjectItem = fromBlock(registryObjectBlock);
        }
    }

    public static List<RegistryObject<Block>> getPebbleBlocks() {
        return BLOCKS.getEntries().stream().filter((blockRegistryObject) -> blockRegistryObject.get() instanceof PebbleBlock).collect(Collectors.toList());
    }

    public static List<RegistryObject<Item>> getPebbleItems() {

        return ITEMS.getEntries().stream().filter((itemRegistryObject) -> Block.byItem(itemRegistryObject.get().asItem()) instanceof PebbleBlock).collect(Collectors.toList());
    }
}
