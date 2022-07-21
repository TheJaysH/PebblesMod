package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.setup.RegistryItems;
import com.thejays.pebblemod.tags.ModItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, modId, existingFileHelper);
    }

    private void registerPebbleTags() {
        var pebbleItemObjects = RegistryItems.getPebbleItems();
        for (var pebbleObject : pebbleItemObjects) {
            var pebbleItem = pebbleObject.get();
            tag(ModItemTags.ALL_PEBBLES).add(pebbleItem);
            if (!pebbleItem.getRegistryName().getPath().equals("glowstone_pebble"))
                tag(ModItemTags.MAKES_SAND_PEBBLES).add(pebbleItem);
        }
    }

    @Override
    protected void addTags() {
        registerPebbleTags();

        tag(ModItemTags.NETHER_PEBBLES).add(RegistryItems.BLACKSTONE_PEBBLE_ITEM.get());
        tag(ModItemTags.NETHER_PEBBLES).add(RegistryItems.NETHERRACK_PEBBLE_ITEM.get());
        tag(ModItemTags.NETHER_PEBBLES).add(RegistryItems.GLOWSTONE_PEBBLE_ITEM.get());
        tag(ModItemTags.GLOWSTONE_PEBBLES).add(RegistryItems.GLOWSTONE_PEBBLE_ITEM.get());
    }
}
