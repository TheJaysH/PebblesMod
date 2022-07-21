package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.helpers.PebbleConfig;
import com.thejays.pebblemod.helpers.PebbleGeneration;
import com.thejays.pebblemod.state.ModBlockStateProperties;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.stream.Collectors;

public class RegistryBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UtilReference.MOD_ID);


    public static final RegistryObject<Block> STONE_PEBBLE = registerPebbleBlock("stone_pebble", PebbleConfig.create("minecraft:stone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> COBBLESTONE_PEBBLE = registerPebbleBlock("cobblestone_pebble", PebbleConfig.create("minecraft:cobblestone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> MOSSY_COBBLESTONE_PEBBLE = registerPebbleBlock("mossy_cobblestone_pebble", PebbleConfig.create("minecraft:mossy_cobblestone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> GRANITE_PEBBLE = registerPebbleBlock("granite_pebble", PebbleConfig.create("minecraft:granite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> DIORITE_PEBBLE = registerPebbleBlock("diorite_pebble", PebbleConfig.create("minecraft:diorite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> ANDESITE_PEBBLE = registerPebbleBlock("andesite_pebble", PebbleConfig.create("minecraft:andesite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> SANDSTONE_PEBBLE = registerPebbleBlock("sandstone_pebble", PebbleConfig.create("minecraft:sandstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> RED_SANDSTONE_PEBBLE = registerPebbleBlock("red_sandstone_pebble", PebbleConfig.create("minecraft:red_sandstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> DEEPSLATE_PEBBLE = registerPebbleBlock("deepslate_pebble", PebbleConfig.create("minecraft:deepslate", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> TUFF_PEBBLE = registerPebbleBlock("tuff_pebble", PebbleConfig.create("minecraft:tuff", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> CALCITE_PEBBLE = registerPebbleBlock("calcite_pebble", PebbleConfig.create("minecraft:calcite", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION)));
    public static final RegistryObject<Block> NETHERRACK_PEBBLE = registerPebbleBlock("netherrack_pebble", PebbleConfig.create("minecraft:netherrack", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setLevel(Level.NETHER)));
    public static final RegistryObject<Block> BLACKSTONE_PEBBLE = registerPebbleBlock("blackstone_pebble", PebbleConfig.create("minecraft:blackstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setLevel(Level.NETHER)));
    public static final RegistryObject<Block> END_STONE_PEBBLE = registerPebbleBlock("end_stone_pebble", PebbleConfig.create("minecraft:end_stone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setLevel(Level.END)));
    public static final RegistryObject<Block> GLOWSTONE_PEBBLE = registerPebbleBlock("glowstone_pebble", PebbleConfig.create("minecraft:glowstone", PebbleGeneration.create(GenerationStep.Decoration.VEGETAL_DECORATION).setLevel(Level.NETHER)), getPebbleProperties().lightLevel((blockState) -> Mth.clamp(blockState.getValue(ModBlockStateProperties.PEBBLES_1_4) * 4, 4, 16)));

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static RegistryObject<Block> registerPebbleBlock(String name, PebbleConfig pebbleConfig) {
        return registerPebbleBlock(name, pebbleConfig, getPebbleProperties());
    }

    public static RegistryObject<Block> registerPebbleBlock(String name, PebbleConfig pebbleConfig, Block.Properties properties) {
        return BLOCKS.register(name, () -> PebbleBlock.create(properties, pebbleConfig));
    }

    private static Block.Properties getPebbleProperties() {
        return Block.Properties.of(Material.STONE)
                .noOcclusion()
                .strength(0.1f)
                .noCollission()
                .sound(SoundType.STONE);
    }

    public static List<RegistryObject<Block>> getPebbleBlocks() {
        return BLOCKS.getEntries()
                .stream()
                .filter((blockRegistryObject) -> blockRegistryObject.get() instanceof PebbleBlock)
                .collect(Collectors.toList());
    }
}
