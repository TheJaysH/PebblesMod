package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PebbleItemModels extends ItemModelProvider {

    public PebbleItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, UtilReference.MOD_ID, fileHelper);
    }


    @Override
    protected void registerModels() {

        var pebbles = Registration.getPebbleItems();
        for (var pebble : pebbles) {

            var item = pebble.get();
            var itemPath = "item/" + item.getRegistryName().getPath();

            var block = Block.byItem(item);
            var blockPath =  modLoc("block/" +  block.getRegistryName().getPath());

            PebbleMod.LOGGER.info("Generating Item Model: " + itemPath);
            PebbleMod.LOGGER.info("\tWith Block: " + blockPath);

//            singleTexture(itemPath, mcLoc("item/generated"), "layer0", blockPath);

            withExistingParent(itemPath, blockPath);
//            withExistingParent(path, modLoc(Block.byItem(pebble.get().asItem()).getRegistryName().getPath()));
        }

    }


}
