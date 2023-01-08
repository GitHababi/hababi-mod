package com.hababisoft.hababi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import com.hababisoft.hababi.items.*;
import com.hababisoft.hababi.materials.HababiteArmorMaterial;
import com.hababisoft.hababi.materials.HababiteToolMaterial;

import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HababiMod implements ModInitializer {

	public static final String NAMESPACE = "hababi";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);

	/* Block and Item fields */

	public static final Item HABABITE_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
	public static final Item RAW_HABABITE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

	public static final Item HABABITE_SWORD = new SwordItem(HababiteToolMaterial.INSTANCE, 7, -2.4F, new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final Item HABABITE_PICKAXE = new CustomPickaxeItem(HababiteToolMaterial.INSTANCE, 5, -2.8f);
	public static final Item HABABITE_AXE = new CustomAxeItem(HababiteToolMaterial.INSTANCE, 9, -3.0f);
	public static final Item HABABITE_SHOVEL = new ShovelItem(HababiteToolMaterial.INSTANCE, 5, -3.0f, new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final Item HABABITE_HOE = new CustomHoeItem(HababiteToolMaterial.INSTANCE, 0, -0.1f);

	public static final Block HABABITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(5f).resistance(6f).requiresTool());
	public static final Block HABABITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3f).resistance(3f).requiresTool());

	public static final Item HABABITE_HELMET = new ArmorItem(HababiteArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final Item HABABITE_CHESTPLATE = new ArmorItem(HababiteArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final Item HABABITE_LEGGINGS = new ArmorItem(HababiteArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final Item HABABITE_BOOTS = new ArmorItem(HababiteArmorMaterial.INSTANCE, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT));


	/* Ore gen fields (I have no idea how it works, leave that to people smarter than me) */

	//private static final ConfiguredFeature<?, ?> OVERWORLD_HABABITE_ORE_CONFIGURED_FEATURE = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, HABABITE_ORE.getDefaultState(),5));
	//public static final PlacedFeature OVERWORLD_HABABITE_ORE_PLACED_FEATURE = OVERWORLD_HABABITE_ORE_CONFIGURED_FEATURE.withPlacement(CountPlacementModifier.of(4),SquarePlacementModifier.of(),HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(64)));

	@Override
	public void onInitialize() {
		/* Register world gen */

		//Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(NAMESPACE, "overworld_hababite_ore"), OVERWORLD_HABABITE_ORE_CONFIGURED_FEATURE);
		//Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(NAMESPACE, "overworld_hababite_ore"), OVERWORLD_HABABITE_ORE_PLACED_FEATURE);
		//BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY,new Identifier(NAMESPACE, "overworld_hababite_ore")));

		/* Register Blocks and Items */
		
		registerItem("hababite_ingot", HABABITE_INGOT);
		registerItem("hababite_sword", HABABITE_SWORD);
		registerItem("hababite_pickaxe", HABABITE_PICKAXE);
		registerItem("hababite_axe", HABABITE_AXE);
		registerItem("hababite_shovel", HABABITE_SHOVEL);
		registerItem("hababite_hoe", HABABITE_HOE);
		registerItem("hababite_helmet", HABABITE_HELMET);
		registerItem("hababite_chestplate", HABABITE_CHESTPLATE);
		registerItem("hababite_leggings", HABABITE_LEGGINGS);
		registerItem("hababite_boots", HABABITE_BOOTS);
		registerItem("raw_hababite", RAW_HABABITE);

		registerBlock("hababite_ore", HABABITE_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
		registerBlock("hababite_block", HABABITE_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
		LOGGER.info("Ready!");
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
