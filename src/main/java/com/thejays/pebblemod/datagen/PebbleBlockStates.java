package com.thejays.pebblemod.datagen;

import com.thejays.pebblemod.PebbleMod;
import com.thejays.pebblemod.blocks.PebbleBlock;
import com.thejays.pebblemod.helpers.PebbleHelper;
import com.thejays.pebblemod.setup.Registration;
import com.thejays.pebblemod.state.ModBlockStateProperties;
import com.thejays.pebblemod.utils.UtilReference;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraftforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class PebbleBlockStates extends BlockStateProvider {


    private String[] pebbleTemplates = {
            "template_pebble",
            "template_two_pebbles",
            "template_three_pebbles",
            "template_four_pebbles"
    };


    public PebbleBlockStates(DataGenerator generator, ExistingFileHelper fileHelper) {

        super(generator, UtilReference.MOD_ID, fileHelper);
        PebbleMod.LOGGER.info("<<<GENERATING MODELS>>>");
    }

    @Override
    protected void registerStatesAndModels() {

        List<RegistryObject<Block>> pebbles = Registration.getPebbleBlocks();

        for (RegistryObject<Block> pebble : pebbles) {
            registerPebble((PebbleBlock) pebble.get());
        }

    }

    public void registerPebble(PebbleBlock pebbleBlock) {
        VariantBlockStateBuilder builder = this.getVariantBuilder(pebbleBlock);
        for (int i = 0; i < pebbleTemplates.length; i++) {

            String template = pebbleTemplates[i];
            String suffix = PebbleHelper.getSuffix(i);
            String path = PebbleHelper.getResourcePath(
                    UtilReference.MOD_ID, BLOCK_FOLDER,
                    pebbleBlock.getRegistryName().getPath() + suffix
            );
            String templatePath = PebbleHelper.getResourcePath(
                    UtilReference.MOD_ID,
                    BLOCK_FOLDER,
                    template
            );
            String parentPath = PebbleHelper.getResourcePath(
                    BLOCK_FOLDER,
                    pebbleBlock.parentBlock.getRegistryName().getPath()
            );
            ResourceLocation parentLocation = mcLoc(parentPath);

            PebbleMod.LOGGER.info("Generating Block Model: " + path);

            BlockModelBuilder modelBuilder = models().getBuilder(path);
            modelBuilder.texture("all", parentLocation);
            modelBuilder.parent(getParent(PebbleHelper.getResourceLocation(templatePath)));

            VariantBlockStateBuilder.PartialBlockstate blockstate = builder.partialState()
                    .with(ModBlockStateProperties.PEBBLES_1_4, PebbleHelper.getInteger(i));

            ConfiguredModel[] configuredModel = ConfiguredModel.allYRotations(modelBuilder, 0, false);

            builder.addModels(blockstate, configuredModel);
        }
    }

    private ModelFile getParent(ResourceLocation resourceLocation) {
        return new ModelFile(resourceLocation) {
            @Override
            protected boolean exists() {
                return true;
            }
        };
    }

}
