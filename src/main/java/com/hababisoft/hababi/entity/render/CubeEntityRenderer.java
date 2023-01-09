package com.hababisoft.hababi.entity.render;

import com.hababisoft.hababi.HababiMod;
import com.hababisoft.hababi.HababiModClient;
import com.hababisoft.hababi.entity.CubeEntity;
import com.hababisoft.hababi.entity.model.CubeEntityModel;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel>{

	
	public CubeEntityRenderer(Context context) {
		super(context, new CubeEntityModel(context.getPart(HababiModClient.MODEL_CUBE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(CubeEntity entity) {
		return new Identifier(HababiMod.NAMESPACE, "textures/entity/blank.png");
	}

}
