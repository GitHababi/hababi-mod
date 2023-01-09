package com.hababisoft.hababi;

import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import com.hababisoft.hababi.entity.model.CubeEntityModel;
import com.hababisoft.hababi.entity.render.CubeEntityRenderer;

import net.fabricmc.api.*;

@Environment(EnvType.CLIENT)
public class HababiModClient implements ClientModInitializer {
	
	public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier(HababiMod.NAMESPACE, "cube"), "main");
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(HababiMod.CUBE,(context) -> new CubeEntityRenderer(context));
		EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTexturedModelData);
		HababiMod.LOGGER.info("Client side initializing!");
	}

}
