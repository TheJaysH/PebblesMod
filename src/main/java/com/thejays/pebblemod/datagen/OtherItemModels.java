package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.helpers.PebbleHelper;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OtherItemModels extends ItemModelProvider {

    public OtherItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, UtilReference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerModels() {

        withExistingParent(Registration.IRON_ROCK_HAMMER.get().getRegistryName().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("items/iron_rock_hammer"));


    }


}
