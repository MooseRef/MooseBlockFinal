package net.moose.mooseblock.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;

public class ModBoatEntity extends BoatEntity {
    public ModBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }
}
