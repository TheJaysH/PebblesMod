package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = UtilReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {


    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();

        if (event.includeServer()){
            generator.addProvider(new OtherRecipes(generator));
            generator.addProvider(new PebbleRecipes(generator));
        }

        if(event.includeClient()){
            generator.addProvider(new PebbleBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new PebbleItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new OtherItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new LanguageProvider(generator, "en_us"));
//            generator.addProvider(new LanguageProvider(generator, "en_us"));
        }

    }

}
