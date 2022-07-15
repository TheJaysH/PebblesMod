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

public class PebbleItemModels extends ItemModelProvider {

    public PebbleItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, UtilReference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerModels() {

        var pebbles = Registration.getPebbleItems();
        for (var pebble : pebbles) {

            Item item = pebble.get();
            String itemPath = PebbleHelper.getResourcePath(ITEM_FOLDER, item.getRegistryName().getPath());

            Block block = Block.byItem(item);
            ResourceLocation blockPath = modLoc(PebbleHelper.getResourcePath(BLOCK_FOLDER, block.getRegistryName().getPath()));

            PebbleMod.LOGGER.info("Generating Item Model: " + itemPath);

            withExistingParent(itemPath, blockPath)
                    .transforms()
                    .transform(ModelBuilder.Perspective.GUI)
                    .scale(2f)
                    .rotation(20, 5, 10)
                    .translation(0, 12, 5);
        }

    }


}
