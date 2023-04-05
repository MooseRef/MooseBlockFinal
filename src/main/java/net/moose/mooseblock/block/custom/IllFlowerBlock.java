package net.moose.mooseblock.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.moose.mooseblock.particle.ModParticles;

public class IllFlowerBlock extends FlowerBlock {
    public IllFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double d = (double)pos.getX() + vec3d.x;
        double e = (double)pos.getZ() + vec3d.z;
        for (int i = 0; i < 3; ++i) {
            if (!random.nextBoolean()) continue;
            world.addParticle(ModParticles.ILL_ROSE_PARTICLE, d + random.nextDouble() / 5.0, (double)pos.getY() + (0.5 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        LivingEntity livingEntity;
        if (world.isClient || world.getDifficulty() == Difficulty.PEACEFUL) {
            return;
        }
        if (entity instanceof LivingEntity && !(livingEntity = (LivingEntity)entity).isInvulnerableTo(world.getDamageSources().wither())) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 40));
        }
    }
}
