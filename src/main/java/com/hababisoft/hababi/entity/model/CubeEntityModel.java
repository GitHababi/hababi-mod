package com.hababisoft.hababi.entity.model;

import com.google.common.collect.ImmutableList;
import com.hababisoft.hababi.entity.CubeEntity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;

public class CubeEntityModel extends EntityModel<CubeEntity> {

	private final ModelPart base;
	
	public CubeEntityModel(ModelPart modelPart) {
        this.base = modelPart.getChild(EntityModelPartNames.CUBE);
    }
	
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild(EntityModelPartNames.CUBE,ModelPartBuilder.create().uv(0, 0).cuboid(-6F, 12F, -6F, 12F, 12F, 12F), ModelTransform.pivot(0F, 0F, 0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
	
	@Override
	public void setAngles(CubeEntity entity, float limbAngle, float limbDistance, float animationProgress,
			float headYaw, float headPitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
			float blue, float alpha) {
		ImmutableList.of(this.base).forEach((modelRenderer) -> {
			modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		}); 		
	}

}
