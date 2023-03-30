package net.moose.mooseblock.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.moose.mooseblock.entity.custom.MooseEntity;
import net.moose.mooseblock.entity.custom.RaccoonEntity;
import net.moose.mooseblock.entity.custom.RedPandaEntity;
import net.moose.mooseblock.mooseblock;


public class ModEntities {
    public static final EntityType<RedPandaEntity> RED_PANDA = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(mooseblock.MOD_ID,"red_panda"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedPandaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
    public static final EntityType<RaccoonEntity> RACCOON = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(mooseblock.MOD_ID,"raccoon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RaccoonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
    public static final EntityType<MooseEntity> MOOSE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(mooseblock.MOD_ID,"moose"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MooseEntity::new)
                    .dimensions(EntityDimensions.fixed(1.2f, 1.75f)).build());

}
