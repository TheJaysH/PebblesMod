package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class OtherRecipes extends RecipeProvider {
    public OtherRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(Registration.IRON_ROCK_HAMMER.get())
                .pattern("mm ")
                .pattern(" s ")
                .define('m', Items.IRON_INGOT)
                .define('s', Items.STICK)
                .unlockedBy("has_iron_ingot", RecipeProvider.has(Items.IRON_INGOT))
                .group(UtilReference.MOD_ID)
                .save(consumer);
    }
}
