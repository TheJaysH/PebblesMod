package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.tags.ModItemTags;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {
    public ModRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        buildPebbleRecipes(consumer);
        buildShapelessRecipes(consumer);
        buildShapedRecipes(consumer);
        buildCookingRecipes(consumer);
    }

    private void buildShapelessRecipes(Consumer<FinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapeless(Registration.SAND_PILE.get())
                .group(UtilReference.MOD_ID)
                .requires(Registration.IRON_ROCK_HAMMER.get())
                .requires(ModItemTags.ALL_PEBBLES)
                .unlockedBy("has_iron_hammer", RecipeProvider.has(Registration.IRON_ROCK_HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.SAND_PILE.get(), 4)
                .group(UtilReference.MOD_ID)
                .requires(Registration.IRON_ROCK_HAMMER.get())
                .requires(Blocks.GRAVEL)
                .unlockedBy("has_iron_hammer", RecipeProvider.has(Registration.IRON_ROCK_HAMMER.get()))
                .save(consumer, new ResourceLocation(UtilReference.MOD_ID, "sand_pile_from_gravel"));
    }

    private void buildShapedRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(Registration.WOODEN_ROCK_HAMMER.get())
                .pattern("##")
                .pattern(" s")
                .define('#', ItemTags.PLANKS)
                .define('s', Items.STICK)
                .unlockedBy("has_stick", RecipeProvider.has(Items.STICK))
                .group(UtilReference.MOD_ID)
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.STONE_ROCK_HAMMER.get())
                .pattern("##")
                .pattern(" s")
                .define('#', ItemTags.STONE_CRAFTING_MATERIALS)
                .define('s', Items.STICK)
                .unlockedBy("has_cobblestone", RecipeProvider.has(ItemTags.STONE_CRAFTING_MATERIALS))
                .group(UtilReference.MOD_ID)
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.IRON_ROCK_HAMMER.get())
                .pattern("##")
                .pattern(" s")
                .define('#', Items.IRON_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_iron_ingot", RecipeProvider.has(Items.IRON_INGOT))
                .group(UtilReference.MOD_ID)
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.DIAMOND_ROCK_HAMMER.get())
                .pattern("##")
                .pattern(" s")
                .define('#', Items.DIAMOND)
                .define('s', Items.STICK)
                .unlockedBy("has_diamond", RecipeProvider.has(Items.DIAMOND))
                .group(UtilReference.MOD_ID)
                .save(consumer);

        ShapedRecipeBuilder.shaped(Blocks.GRAVEL)
                .pattern("pp")
                .pattern("pp")
                .define('p', ModItemTags.ALL_PEBBLES)
                .unlockedBy("has_any_pebble", RecipeProvider.has(ModItemTags.ALL_PEBBLES))
                .group(UtilReference.MOD_ID)
                .save(consumer, new ResourceLocation(UtilReference.MOD_ID, Blocks.GRAVEL.getRegistryName().getPath()));


        ShapedRecipeBuilder.shaped(Blocks.SAND)
                .pattern("ss")
                .pattern("ss")
                .define('s', Registration.SAND_PILE.get())
                .unlockedBy("has_sand_pile", RecipeProvider.has(Registration.SAND_PILE.get()))
                .group(UtilReference.MOD_ID)
                .save(consumer, new ResourceLocation(UtilReference.MOD_ID, Blocks.SAND.getRegistryName().getPath()));
    }

    private void buildCookingRecipes(Consumer<FinishedRecipe> consumer) {

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.SAND_PILE.get()), Blocks.GLASS_PANE, 0.03f, 60)
                .unlockedBy("has_sand_pile", RecipeProvider.has(Registration.SAND_PILE.get()))
                .group(UtilReference.MOD_ID)
                .save(consumer, new ResourceLocation(UtilReference.MOD_ID, "glass_pane_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.SAND_PILE.get()), Blocks.GLASS_PANE, 0.03f, 30)
                .unlockedBy("has_sand_pile", RecipeProvider.has(Registration.SAND_PILE.get()))
                .group(UtilReference.MOD_ID)
                .save(consumer, new ResourceLocation(UtilReference.MOD_ID, "glass_pane_blasting"));

    }

    private void buildPebbleRecipes(Consumer<FinishedRecipe> consumer) {
        var pebbleItems = Registration.getPebbleItems();

        for (var pebbleItem : pebbleItems) {
            Item pebble = pebbleItem.get();
            PebbleBlock pebbleBlock = (PebbleBlock) Block.byItem(pebble);
            Block parentBlock = pebbleBlock.getPebbleConfig().getParentBlock();

            PebbleMod.LOGGER.info("Generating Recipe: " + parentBlock);

            ShapedRecipeBuilder.shaped(parentBlock)
                    .pattern("ppp")
                    .pattern("ppp")
                    .pattern("ppp")
                    .define('p', pebble)
                    .unlockedBy("has_" + pebble.getRegistryName().getPath(), RecipeProvider.has(pebble))
                    .group(UtilReference.MOD_ID)
                    .save(consumer, new ResourceLocation(UtilReference.MOD_ID, parentBlock.getRegistryName().getPath()));

            PebbleMod.LOGGER.info("Generating Recipe: " + pebble);

            ShapelessRecipeBuilder.shapeless(pebble, 4)
                    .group(UtilReference.MOD_ID)
                    .requires(Registration.IRON_ROCK_HAMMER.get())
                    .requires(parentBlock)
                    .unlockedBy("has_iron_hammer", RecipeProvider.has(Registration.IRON_ROCK_HAMMER.get()))
                    .save(consumer);

        }
    }
}
