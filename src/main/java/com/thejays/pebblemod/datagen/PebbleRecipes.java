package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class PebbleRecipes extends RecipeProvider {
    public PebbleRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        var pebbleItems = Registration.getPebbleItems();

        for(var pebbleItem : pebbleItems){

            Item pebble = pebbleItem.get();
            PebbleBlock pebbleBlock = (PebbleBlock)Block.byItem(pebble);
            Block parentBlock = pebbleBlock.parentBlock;
            PebbleMod.LOGGER.info("Generating Recipe: " + parentBlock);
            ShapedRecipeBuilder.shaped(parentBlock)
                    .pattern("pp")
                    .pattern("pp")
                    .define('p', pebble)
                    .unlockedBy("has_" + pebble.getRegistryName().getPath(), RecipeProvider.has(pebble))
                    .group(UtilReference.MOD_ID)
                    .save(consumer);

        }
    }
}
