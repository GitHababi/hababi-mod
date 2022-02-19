package net.fabricmc.hababisoft.materials;

import net.fabricmc.hababisoft.HababiMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class HababiteArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {385, 560, 525, 455}; 
	private static final int[] PROTECTION_VALUES = new int[] {3, 7, 9, 3};
 
    public static final HababiteArmorMaterial INSTANCE = new HababiteArmorMaterial();

	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()];
	}
 
	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}
 
	@Override
	public int getEnchantability() {
		return 18;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(HababiMod.HABABITE_INGOT);
	}
 
	@Override
	public String getName() {
		// Must be all lowercase
		return "hababite_armor";
	}
 
	@Override
	public float getToughness() {
		return 0;
	}
 
	@Override
	public float getKnockbackResistance() {
		return 0.1F;
	}
}