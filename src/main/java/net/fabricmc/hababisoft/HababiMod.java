package net.fabricmc.hababisoft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HababiMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("hababi");
	public static final Item HABABITE_SWORD = new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1));
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("hababi", "hababite_sword"), HABABITE_SWORD);
		LOGGER.info("Hello Fabric world!");
	}
}
