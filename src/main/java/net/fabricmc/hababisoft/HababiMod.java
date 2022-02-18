package net.fabricmc.hababisoft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.hababisoft.materials.HababiteToolMaterial;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.hababisoft.items.*;

public class HababiMod implements ModInitializer {

	public static final String NAMESPACE = "hababi";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);

	public static final Item HABABITE_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

	public static final Item HABABITE_SWORD = new SwordItem(HababiteToolMaterial.INSTANCE, 7, -2.4F, new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final Item HABABITE_PICKAXE = new CustomPickaxeItem(HababiteToolMaterial.INSTANCE, 5, -2.8f);
	public static final Item HABABITE_AXE = new CustomAxeItem(HababiteToolMaterial.INSTANCE, 9, -3.0f);
	public static final Item HABABITE_SHOVEL = new ShovelItem(HababiteToolMaterial.INSTANCE, 5, -3.0f, new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final Item HABABITE_HOE = new CustomHoeItem(HababiteToolMaterial.INSTANCE, 0, -0.1f);

	public static final Block HABABITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(5f).resistance(6f).requiresTool());
	public static final Block HABABITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3f).resistance(3f).requiresTool());
	@Override
	public void onInitialize() {
		registerItem("hababite_ingot", HABABITE_INGOT);
		registerItem("hababite_sword", HABABITE_SWORD);
		registerItem("hababite_pickaxe", HABABITE_PICKAXE);
		registerItem("hababite_axe", HABABITE_AXE);
		registerItem("hababite_shovel", HABABITE_SHOVEL);
		registerItem("hababite_hoe", HABABITE_HOE);

		registerBlock("hababite_ore", HABABITE_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
		registerBlock("hababite_block", HABABITE_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
		LOGGER.info("Hello Fabric world!");
	}

	/** registerBlock turns block into both item and block */
	public static void registerBlock(String path, Block block, FabricItemSettings settings) {
		Registry.register(Registry.BLOCK, new Identifier(NAMESPACE, path), block);
		registerItem(path,new BlockItem(block, settings));
	}
	public static void registerItem(String path, Item item) {
		Registry.register(Registry.ITEM, new Identifier(NAMESPACE, path), item);
	}
}
