package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.setup.Registration;
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

    private void registerPebbleTags(){
        var pebbleItems = Registration.getPebbleItems();
        for (var pebbleItem : pebbleItems) {
            tag(ModItemTags.ALL_PEBBLES).add(pebbleItem.get());
        }
    }

    @Override
    protected void addTags() {
        registerPebbleTags();
    }
}
