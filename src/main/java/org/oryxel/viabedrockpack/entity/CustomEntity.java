package org.oryxel.viabedrockpack.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

public class CustomEntity extends MobEntity {
    public CustomEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }


}
