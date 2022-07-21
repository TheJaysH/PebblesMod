package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = UtilReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {


    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            var blockTagsProvider = new BlockTagsProvider(generator, UtilReference.MOD_ID, event.getExistingFileHelper());
            generator.addProvider(new ModRecipes(generator));
            generator.addProvider(new ModItemTagsProvider(generator, blockTagsProvider, UtilReference.MOD_ID, event.getExistingFileHelper()));
        }

        if (event.includeClient()) {
            generator.addProvider(new ModBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new ModItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new ModLanguageProvider(generator, "en_us"));
        }

    }

}
