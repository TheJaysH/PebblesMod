package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.locale.Language;
import net.minecraft.world.level.block.Block;

import java.util.Map;

import static com.thejays.pebblemod.setup.ModSetup.TAB_NAME;

public class ModLanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    String locale;

    public ModLanguageProvider(DataGenerator generator, String locale) {
        super(generator, UtilReference.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {

        add("itemGroup." + TAB_NAME, "Pebbles");
        add(Registration.IRON_ROCK_HAMMER.get(), "Iron Rock Hammer");
        add(Registration.SAND_PILE.get(), "Sand Pile");

        addPebbleTranslations();
    }

    private void addPebbleTranslations() {
        var pebbles = Registration.getPebbleBlocks();
        var lang = Language.getInstance().getLanguageData();

        for (var pebbleObject : pebbles) {

            PebbleBlock pebbleBlock = (PebbleBlock) pebbleObject.get();
            String translationKey = "block." + UtilReference.MOD_ID + "." + pebbleBlock.getRegistryName().getPath();
            String blockTranslation = getTranslation(pebbleBlock.parentBlock, lang);
            String blockName = blockTranslation + " Pebble";

            PebbleMod.LOGGER.info("Generating Lang: " + translationKey);

            add(translationKey, blockName);
        }
    }

    private String getTranslation(Block block, Map<String, String> languageData) {
        String namespace = block.getRegistryName().getNamespace();
        String blockName = block.getRegistryName().getPath();
        String blockTranslationKey = "block." + namespace + "." + blockName;

        return languageData.get(blockTranslationKey);
    }

}
