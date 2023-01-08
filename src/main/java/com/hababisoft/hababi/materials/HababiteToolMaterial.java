package com.hababisoft.hababi.materials;

import com.hababisoft.hababi.HababiMod;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class HababiteToolMaterial implements ToolMaterial {
   
    public static final HababiteToolMaterial INSTANCE = new HababiteToolMaterial();
    @Override
    public int getDurability() {
        return 1831;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 7.0F;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    /** WARNING! This method returns 0 for better control over attack damage*/
    @Override
    public float getAttackDamage() {
        return 0F;
    }
    @Override
    public int getMiningLevel() {
        return 3;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(HababiMod.HABABITE_INGOT);
    }
}