package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.helpers.PebbleHelper;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.setup.RegistryItems;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider {

    public final ResourceLocation ITEM_GENERATED = mcLoc("item/generated");

    public ModItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, UtilReference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerModels() {

        registerPebbleModels();

        withExistingParent(RegistryItems.WOODEN_ROCK_HAMMER.get().getRegistryName().getPath(), ITEM_GENERATED).texture("layer0", modLoc("items/wooden_rock_hammer"));
        withExistingParent(RegistryItems.STONE_ROCK_HAMMER.get().getRegistryName().getPath(), ITEM_GENERATED).texture("layer0", modLoc("items/stone_rock_hammer"));
        withExistingParent(RegistryItems.IRON_ROCK_HAMMER.get().getRegistryName().getPath(),ITEM_GENERATED).texture("layer0", modLoc("items/iron_rock_hammer"));
        withExistingParent(RegistryItems.DIAMOND_ROCK_HAMMER.get().getRegistryName().getPath(),ITEM_GENERATED).texture("layer0", modLoc("items/diamond_rock_hammer"));
        withExistingParent(RegistryItems.SAND_PILE.get().getRegistryName().getPath(), ITEM_GENERATED).texture("layer0", modLoc("items/sand_pile"));

    }

    private void registerPebbleModels() {
        var pebbles = RegistryItems.getPebbleItems();
        for (var pebble : pebbles) {
            Item item = pebble.get();
            String itemPath = PebbleHelper.getResourcePath(ITEM_FOLDER, item.getRegistryName().getPath());
            Block block = Block.byItem(item);
            ResourceLocation blockPath = modLoc(PebbleHelper.getResourcePath(BLOCK_FOLDER, block.getRegistryName().getPath()));
            PebbleMod.LOGGER.info("Generating Item Model: " + itemPath);
            withExistingParent(itemPath, blockPath);
        }
    }


}
