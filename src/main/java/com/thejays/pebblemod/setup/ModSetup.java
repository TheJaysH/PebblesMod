package com.thejays.pebblemod.setup;

import com.thejays.pebblemod.utils.UtilReference;
import com.thejays.pebblemod.worldgen.ModGeneration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@Mod.EventBusSubscriber(modid = UtilReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static final String TAB_NAME = UtilReference.MOD_ID;

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public @NotNull ItemStack makeIcon() {

            var pebbles = RegistryItems.getPebbleItems();
            var randomIndex = new Random().nextInt(pebbles.size());
            var pebbleItem = pebbles.get(randomIndex).get();

            return new ItemStack(pebbleItem);
        }
    };


    public static void setup() {
        MinecraftForge.EVENT_BUS.addListener(ModGeneration::onBiomeLoadingEvent);
    }


    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(ModGeneration::registerConfiguredFeatures);
    }


}
