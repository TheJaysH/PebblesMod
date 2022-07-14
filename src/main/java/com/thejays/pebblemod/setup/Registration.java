package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.utils.UtilReference;
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

public class Registration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UtilReference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UtilReference.MOD_ID);

    public static void init() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }

    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);
    public static final Block.Properties PEBBLE_PROPERTIES = Block.Properties.of(Material.STONE)
            .noOcclusion()
            .strength(0.1f)
            .noCollission()
            .sound(SoundType.STONE);


    public static final RegistryObject<Block> PEBBLE = BLOCKS.register("pebble", () -> new PebbleBlock(PEBBLE_PROPERTIES, Blocks.COBBLESTONE));
    public static final RegistryObject<Item> PEBBLE_ITEM = fromBlock(PEBBLE);

    public static <B extends Block> RegistryObject<Item> fromBlock(@NotNull RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }

}
