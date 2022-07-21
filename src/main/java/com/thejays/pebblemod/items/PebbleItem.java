package com.thejays.pebblemod.items;

import com.thejays.pebblemod.PebbleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class PebbleItem extends BlockItem {

    public final float PEBBLE_DAMAGE = 1f;

    public PebbleItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            Snowball snowball = new Snowball(level, player) {
                @Override
                protected void onHitEntity(EntityHitResult entityHitResult) {
                    super.onHitEntity(entityHitResult);
                    Entity entity = entityHitResult.getEntity();
                    entity.hurt(DamageSource.thrown(this, this.getOwner()), PEBBLE_DAMAGE);
                }

                @Override
                protected void onHit(HitResult hitResult) {
                    super.onHit(hitResult);
                    var pos = new BlockPos(hitResult.getLocation());
                    var boundingBox = new BoundingBox(pos).inflatedBy(16);
                    var mobs = this.level.getEntitiesOfClass(Monster.class, AABB.of(boundingBox));
                    for (var mob : mobs) {
                        mob.getNavigation().createPath(pos, 16);
//                        PebbleMod.LOGGER.info("Found mob {} at {}", mob.getDisplayName().getString(), mob.position());
                    }
                }
            };
            snowball.setItem(itemstack);
            snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(snowball);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        InteractionResult interactionresult = this.place(new BlockPlaceContext(useOnContext));
        if (!interactionresult.consumesAction() && this.isEdible()) {
            InteractionResult interactionresult1 = this.use(useOnContext.getLevel(), useOnContext.getPlayer(), useOnContext.getHand()).getResult();
            return interactionresult1 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : interactionresult1;
        }
        return interactionresult;
    }


}
