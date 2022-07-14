package com.thejays.pebblemod.blocks;

import com.thejays.pebblemod.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PebbleBlock extends Block {

    public Block parentBlock;


    private static final VoxelShape ONE_PEBBLE_SHAPE =
            Block.box(3.0D, 0.0D, 3.0D, 12.0D, 1.0D, 12.0D);
    private static final VoxelShape MULTI_PEBBLE_SHAPE =
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D);


    public static final IntegerProperty PEBBLES = ModBlockStateProperties.PEBBLES_1_4;


    public PebbleBlock(Block.Properties properties, Block parentBlock) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(PEBBLES, Integer.valueOf(1)));
        this.parentBlock = parentBlock;
    }

    private void removeOnePebble(Level level, BlockPos pos, BlockState state) {

    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, pos, state, blockEntity, itemStack);
        this.removeOnePebble(level, pos, state);

        ItemStack pebble = new ItemStack(this.asItem(), 1);

        if (!player.addItem(pebble)) {
            player.drop(pebble, false);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(PEBBLES);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockState bellowBlockState = levelReader.getBlockState(pos.below());
        return bellowBlockState.canOcclude() && !bellowBlockState.isAir();
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return state.getValue(PEBBLES) > 1 ? MULTI_PEBBLE_SHAPE : ONE_PEBBLE_SHAPE;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return context.getItemInHand().getItem() == this.asItem() && state.getValue(PEBBLES) < 4 || super.canBeReplaced(state, context);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        return blockState.is(this) ? blockState.setValue(PEBBLES, Math.min(4, blockState.getValue(PEBBLES) + 1)) : super.getStateForPlacement(context);
    }
}
