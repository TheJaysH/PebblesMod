package com.thejays.pebblemod.setup;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registration {

//    public static final ResourceKey PLACED_FEATURES_ID = ResourceKey.createRegistryKey(new ResourceLocation(UtilReference.MOD_ID, "placed_features"));
//    public static final DeferredRegister<PebbleFeaturePair> PLACED_FEATURES = DeferredRegister.create(PLACED_FEATURES_ID, UtilReference.MOD_ID);

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        PLACED_FEATURES.register(eventBus);
    }

}
