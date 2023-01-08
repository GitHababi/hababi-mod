package com.hababisoft.hababi.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

public class CustomAxeItem extends AxeItem {
    public CustomAxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(ItemGroup.TOOLS));
    }
}