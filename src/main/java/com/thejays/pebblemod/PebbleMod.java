package com.thejays.pebblemod;

import com.mojang.logging.LogUtils;
import com.thejays.pebblemod.setup.*;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(UtilReference.MOD_ID)
public class PebbleMod {
    public static final Logger LOGGER = LogUtils.getLogger();

    public PebbleMod() {


        ModSetup.setup();
        RegistryBlocks.init();
        RegistryItems.init();
        RegistryFeatures.init();

        Config.register();


        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();

        modbus.addListener(ModSetup::init);


        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }

}
