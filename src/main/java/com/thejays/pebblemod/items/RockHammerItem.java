package com.thejays.pebblemod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RockHammerItem extends Item {

    public final int DAMAGE_USE = 9;

    public RockHammerItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack newStack = new ItemStack(this);
        newStack.setDamageValue(itemStack.getMaxDamage() + DAMAGE_USE);
        return newStack.getDamageValue() >= newStack.getMaxDamage() ? ItemStack.EMPTY : newStack;
    }
}
