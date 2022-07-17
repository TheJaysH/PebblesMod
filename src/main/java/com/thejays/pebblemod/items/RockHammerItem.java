package com.thejays.pebblemod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RockHammerItem extends Item {

    private final int itemUseDamage;

    public RockHammerItem(Item.Properties properties) {
        super(properties);
        this.itemUseDamage = 4;
    }
    public RockHammerItem(Item.Properties properties, int itemUseDamage) {
        super(properties);
        this.itemUseDamage = itemUseDamage;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack newStack = new ItemStack(this);
        newStack.setDamageValue(itemStack.getDamageValue() + itemUseDamage);
        return newStack.getDamageValue() >= newStack.getMaxDamage() ? ItemStack.EMPTY : newStack;
    }
}
