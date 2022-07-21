package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.helpers.PebbleConfig;
import com.thejays.pebblemod.helpers.PebbleFeaturePair;
import com.thejays.pebblemod.helpers.PebbleGeneration;
import com.thejays.pebblemod.items.PebbleItem;
import com.thejays.pebblemod.items.RockHammerItem;
import com.thejays.pebblemod.utils.UtilReference;
import com.thejays.pebblemod.worldgen.feature.PebbleFeature;
import com.thejays.pebblemod.worldgen.feature.PebblePatchFeature;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
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
//    public static final DeferredRegister<PebbleFeaturePair> PLACED_FEATURES = DeferredRegister.create(new ResourceLocation(UtilReference.MOD_ID, "worldgen/placed_features"), UtilReference.MOD_ID);

    public static final ResourceKey PLACED_FEATURES_ID = ResourceKey.createRegistryKey(new ResourceLocation(UtilReference.MOD_ID, "placed_features"));

    public static final DeferredRegister<PebbleFeaturePair> PLACED_FEATURES = DeferredRegister.create(PLACED_FEATURES_ID, UtilReference.MOD_ID);

    public static RegistryObject<Feature<SimpleBlockConfiguration>> STONE_PEBBLE_FEATURE = FEATURES.register("stone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.STONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> COBBLESTONE_PEBBLE_FEATURE = FEATURES.register("cobblestone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.STONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> MOSSY_COBBLESTONE_PEBBLE_FEATURE = FEATURES.register("mossy_cobblestone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRASS_BLOCK, Blocks.STONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> GRANITE_PEBBLE_FEATURE = FEATURES.register("granite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.GRANITE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> DIORITE_PEBBLE_FEATURE = FEATURES.register("diorite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.DIORITE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> ANDESITE_PEBBLE_FEATURE = FEATURES.register("andesite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.GRAVEL, Blocks.ANDESITE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> SANDSTONE_PEBBLE_FEATURE = FEATURES.register("sandstone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.SAND, Blocks.SANDSTONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> DEEPSLATE_PEBBLE_FEATURE = FEATURES.register("deepslate_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.DEEPSLATE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> TUFF_PEBBLE_FEATURE = FEATURES.register("tuff_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.DEEPSLATE, Blocks.TUFF)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> CALCITE_PEBBLE_FEATURE = FEATURES.register("calcite_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.CALCITE, Blocks.TUFF)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> NETHERRACK_PEBBLE_FEATURE = FEATURES.register("netherrack_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.NETHERRACK)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> BLACKSTONE_PEBBLE_FEATURE = FEATURES.register("blackstone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.BLACKSTONE)));
    public static RegistryObject<Feature<SimpleBlockConfiguration>> END_STONE_PEBBLE_FEATURE = FEATURES.register("end_stone_pebble_feature", () -> new PebbleFeature(SimpleBlockConfiguration.CODEC, List.of(Blocks.END_STONE)));


    public static final RegistryObject<Block> STONE_PEBBLE = registerPebbleBlock("stone_pebble", PebbleConfig.create("minecraft:stone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> COBBLESTONE_PEBBLE = registerPebbleBlock("cobblestone_pebble", PebbleConfig.create("minecraft:cobblestone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_PEBBLE = registerPebbleBlock("mossy_cobblestone_pebble", PebbleConfig.create("minecraft:mossy_cobblestone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> GRANITE_PEBBLE = registerPebbleBlock("granite_pebble", PebbleConfig.create("minecraft:granite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> DIORITE_PEBBLE = registerPebbleBlock("diorite_pebble", PebbleConfig.create("minecraft:diorite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> ANDESITE_PEBBLE = registerPebbleBlock("andesite_pebble", PebbleConfig.create("minecraft:andesite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> SANDSTONE_PEBBLE = registerPebbleBlock("sandstone_pebble", PebbleConfig.create("minecraft:sandstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.BEACH, Biome.BiomeCategory.DESERT)));
    public static final RegistryObject<Block> DEEPSLATE_PEBBLE = registerPebbleBlock("deepslate_pebble", PebbleConfig.create("minecraft:deepslate", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> TUFF_PEBBLE = registerPebbleBlock("tuff_pebble", PebbleConfig.create("minecraft:tuff", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> CALCITE_PEBBLE = registerPebbleBlock("calcite_pebble", PebbleConfig.create("minecraft:calcite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> NETHERRACK_PEBBLE = registerPebbleBlock("netherrack_pebble", PebbleConfig.create("minecraft:netherrack", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.NETHER).setLevel(Level.NETHER)));
    public static final RegistryObject<Block> BLACKSTONE_PEBBLE = registerPebbleBlock("blackstone_pebble", PebbleConfig.create("minecraft:blackstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.NETHER).setLevel(Level.NETHER)));
    public static final RegistryObject<Block> END_STONE_PEBBLE = registerPebbleBlock("end_stone_pebble", PebbleConfig.create("minecraft:end_stone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setBiomeCategories(Biome.BiomeCategory.THEEND).setLevel(Level.END)));


    public static final RegistryObject<Item> STONE_PEBBLE_ITEM = registerItemFromBlock(STONE_PEBBLE);
    public static final RegistryObject<Item> COBBLESTONE_PEBBLE_ITEM = registerItemFromBlock(COBBLESTONE_PEBBLE);
    public static final RegistryObject<Item> MOSSY_COBBLESTONE_PEBBLE_ITEM = registerItemFromBlock(MOSSY_COBBLESTONE_PEBBLE);
    public static final RegistryObject<Item> GRANITE_PEBBLE_ITEM = registerItemFromBlock(GRANITE_PEBBLE);
    public static final RegistryObject<Item> ANDESITE_PEBBLE_ITEM = registerItemFromBlock(ANDESITE_PEBBLE);
    public static final RegistryObject<Item> SANDSTONE_PEBBLE_ITEM = registerItemFromBlock(SANDSTONE_PEBBLE);
    public static final RegistryObject<Item> DIORITE_PEBBLE_ITEM = registerItemFromBlock(DIORITE_PEBBLE);
    public static final RegistryObject<Item> DEEPSLATE_PEBBLE_ITEM = registerItemFromBlock(DEEPSLATE_PEBBLE);
    public static final RegistryObject<Item> TUFF_PEBBLE_ITEM = registerItemFromBlock(TUFF_PEBBLE);
    public static final RegistryObject<Item> CALCITE_PEBBLE_ITEM = registerItemFromBlock(CALCITE_PEBBLE);
    public static final RegistryObject<Item> NETHERRACK_PEBBLE_ITEM = registerItemFromBlock(NETHERRACK_PEBBLE);
    public static final RegistryObject<Item> BLACKSTONE_PEBBLE_ITEM = registerItemFromBlock(BLACKSTONE_PEBBLE);
    public static final RegistryObject<Item> END_STONE_PEBBLE_ITEM = registerItemFromBlock(END_STONE_PEBBLE);

    public static final RegistryObject<Item> WOODEN_ROCK_HAMMER = ITEMS.register("wooden_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(256)));
    public static final RegistryObject<Item> STONE_ROCK_HAMMER = ITEMS.register("stone_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(512)));
    public static final RegistryObject<Item> IRON_ROCK_HAMMER = ITEMS.register("iron_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(1024)));
    public static final RegistryObject<Item> DIAMOND_ROCK_HAMMER = ITEMS.register("diamond_rock_hammer", () -> new RockHammerItem(getItemProperties().stacksTo(1).durability(2048)));
    public static final RegistryObject<Item> SAND_PILE = ITEMS.register("sand_pile", () -> new Item(getItemProperties()));


    public static final HashMap<RegistryObject<Block>, RegistryObject<Feature<SimpleBlockConfiguration>>> BLOCK_TO_FEATURE = new HashMap<>() {{
        put(STONE_PEBBLE, STONE_PEBBLE_FEATURE);
        put(COBBLESTONE_PEBBLE, COBBLESTONE_PEBBLE_FEATURE);
        put(MOSSY_COBBLESTONE_PEBBLE, MOSSY_COBBLESTONE_PEBBLE_FEATURE);
        put(GRANITE_PEBBLE, GRANITE_PEBBLE_FEATURE);
        put(DIORITE_PEBBLE, DIORITE_PEBBLE_FEATURE);
        put(ANDESITE_PEBBLE, ANDESITE_PEBBLE_FEATURE);
        put(SANDSTONE_PEBBLE, SANDSTONE_PEBBLE_FEATURE);
        put(DEEPSLATE_PEBBLE, DEEPSLATE_PEBBLE_FEATURE);
        put(TUFF_PEBBLE, TUFF_PEBBLE_FEATURE);
        put(CALCITE_PEBBLE, CALCITE_PEBBLE_FEATURE);
        put(NETHERRACK_PEBBLE, NETHERRACK_PEBBLE_FEATURE);
        put(BLACKSTONE_PEBBLE, BLACKSTONE_PEBBLE_FEATURE);
        put(END_STONE_PEBBLE, END_STONE_PEBBLE_FEATURE);
    }};


    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        FEATURES.register(eventBus);
//        CONFIGURED_FEATURES.register(eventBus);
        PLACED_FEATURES.register(eventBus);


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
