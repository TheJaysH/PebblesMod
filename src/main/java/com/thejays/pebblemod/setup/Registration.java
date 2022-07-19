package com.thejays.pebblemod.setup;

import com.mojang.serialization.Codec;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.helpers.PebbleConfig;
import com.thejays.pebblemod.helpers.PebbleGeneration;
import com.thejays.pebblemod.items.PebbleItem;
import com.thejays.pebblemod.items.RockHammerItem;
import com.thejays.pebblemod.utils.UtilReference;
import com.thejays.pebblemod.worldgen.feature.PebbleFeature;
import com.thejays.pebblemod.worldgen.feature.configurations.PebbleFeatureConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
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


    public static final Block.Properties PEBBLE_PROPERTIES = Block.Properties.of(Material.STONE)
            .noOcclusion()
            .strength(0.1f)
            .noCollission()
            .sound(SoundType.STONE);


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UtilReference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UtilReference.MOD_ID);

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, UtilReference.MOD_ID);
//    public static final DeferredRegister<Feature<?>> PLACEMENT_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, UtilReference.MOD_ID);



    public static RegistryObject<PebbleFeature> PEBBLE_DEFAULT = FEATURES.register("pebble", () -> new PebbleFeature(PebbleFeatureConfiguration.CODEC));



    public static final RegistryObject<Block> STONE_PEBBLE = registerPebbleBlock("stone_pebble", PebbleConfig.create("minecraft:stone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.PLAINS)));
    public static final RegistryObject<Block> COBBLESTONE_PEBBLE = registerPebbleBlock("cobblestone_pebble", PebbleConfig.create("minecraft:cobblestone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.PLAINS)));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_PEBBLE = registerPebbleBlock("mossy_cobblestone_pebble", PebbleConfig.create("minecraft:mossy_cobblestone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.SWAMP)));
    public static final RegistryObject<Block> GRANITE_PEBBLE = registerPebbleBlock("granite_pebble", PebbleConfig.create("minecraft:granite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.TAIGA, Biome.BiomeCategory.EXTREME_HILLS)));
    public static final RegistryObject<Block> SANDSTONE_PEBBLE = registerPebbleBlock("sandstone_pebble", PebbleConfig.create("minecraft:sandstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.BEACH, Biome.BiomeCategory.DESERT)));
    public static final RegistryObject<Block> DIORITE_PEBBLE = registerPebbleBlock("diorite_pebble", PebbleConfig.create("minecraft:diorite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.PLAINS)));
    public static final RegistryObject<Block> DEEPSLATE_PEBBLE = registerPebbleBlock("deepslate_pebble", PebbleConfig.create("minecraft:deepslate", PebbleGeneration.create(GenerationStep.Decoration.UNDERGROUND_DECORATION).setBiomeCategories(Biome.BiomeCategory.UNDERGROUND)));
    public static final RegistryObject<Block> CALCITE_PEBBLE = registerPebbleBlock("calcite_pebble", PebbleConfig.create("minecraft:calcite", PebbleGeneration.create(GenerationStep.Decoration.UNDERGROUND_DECORATION).setBiomeCategories(Biome.BiomeCategory.UNDERGROUND)));
    public static final RegistryObject<Block> NETHERRACK_PEBBLE = registerPebbleBlock("netherrack_pebble", PebbleConfig.create("minecraft:netherrack", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.NETHER).setLevel(Level.NETHER)));
    public static final RegistryObject<Block> BLACKSTONE_PEBBLE = registerPebbleBlock("blackstone_pebble", PebbleConfig.create("minecraft:blackstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.NETHER).setLevel(Level.NETHER)));
    public static final RegistryObject<Block> END_STONE_PEBBLE = registerPebbleBlock("end_stone_pebble", PebbleConfig.create("minecraft:end_stone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.THEEND).setLevel(Level.END)));


    public static final RegistryObject<Item> COBBLESTONE_PEBBLE_ITEM = registerItemFromBlock(COBBLESTONE_PEBBLE);
    public static final RegistryObject<Item> MOSSY_COBBLESTONE_PEBBLE_ITEM = registerItemFromBlock(MOSSY_COBBLESTONE_PEBBLE);
    public static final RegistryObject<Item> GRANITE_PEBBLE_ITEM = registerItemFromBlock(GRANITE_PEBBLE);
    public static final RegistryObject<Item> SANDSTONE_PEBBLE_ITEM = registerItemFromBlock(SANDSTONE_PEBBLE);
    public static final RegistryObject<Item> DIORITE_PEBBLE_ITEM = registerItemFromBlock(DIORITE_PEBBLE);
    public static final RegistryObject<Item> DEEPSLATE_PEBBLE_ITEM = registerItemFromBlock(DEEPSLATE_PEBBLE);
    public static final RegistryObject<Item> CALCITE_PEBBLE_ITEM = registerItemFromBlock(CALCITE_PEBBLE);
    public static final RegistryObject<Item> NETHERRACK_PEBBLE_ITEM = registerItemFromBlock(NETHERRACK_PEBBLE);
    public static final RegistryObject<Item> BLACKSTONE_PEBBLE_ITEM = registerItemFromBlock(BLACKSTONE_PEBBLE);
    public static final RegistryObject<Item> END_STONE_PEBBLE_ITEM = registerItemFromBlock(END_STONE_PEBBLE);

    public static final RegistryObject<Item> WOODEN_ROCK_HAMMER = ITEMS.register("wooden_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(256)));
    public static final RegistryObject<Item> STONE_ROCK_HAMMER = ITEMS.register("stone_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(512)));
    public static final RegistryObject<Item> IRON_ROCK_HAMMER = ITEMS.register("iron_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(1024)));
    public static final RegistryObject<Item> DIAMOND_ROCK_HAMMER = ITEMS.register("diamond_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(2048)));
    public static final RegistryObject<Item> SAND_PILE = ITEMS.register("sand_pile", () -> new Item(getItemProperties()));


    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }


    public static <B extends Block> RegistryObject<Item> registerItemFromBlock(@NotNull RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new PebbleItem(block.get(), getItemProperties()));
    }

    public static RegistryObject<Block> registerPebbleBlock(String name, PebbleConfig pebbleConfig) {
        return BLOCKS.register(name, () -> PebbleBlock.create(PEBBLE_PROPERTIES, pebbleConfig));
    }


    public static List<RegistryObject<Block>> getPebbleBlocks() {
        return BLOCKS.getEntries()
                .stream()
                .filter((blockRegistryObject) -> blockRegistryObject.get() instanceof PebbleBlock)
                .collect(Collectors.toList());
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
