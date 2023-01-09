package com.hababisoft.hababi.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.*;
import net.minecraft.world.*;

public class CubeEntity extends PathAwareEntity {
	 
    public CubeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}