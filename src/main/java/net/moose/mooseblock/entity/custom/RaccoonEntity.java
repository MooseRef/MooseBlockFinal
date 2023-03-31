package net.moose.mooseblock.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TadpoleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.moose.mooseblock.entity.ModEntities;
import net.moose.mooseblock.entity.goals.JumpInComposterGoal;
import net.moose.mooseblock.entity.goals.SearchComposterGoal;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class RaccoonEntity extends AnimalEntity implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private BlockPos blockTarget;
    private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.ROTTEN_FLESH);

    public RaccoonEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 2.0));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(4, new TemptGoal(this, 1, Ingredient.ofItems(Items.POISONOUS_POTATO), false));
        this.goalSelector.add(5, new FollowParentGoal(this, 1));
        this.goalSelector.add(6, new SearchComposterGoal(this));
        this.goalSelector.add(7, new JumpInComposterGoal(this));
        this.goalSelector.add(8, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(9, new WanderAroundFarGoal(this, 1.0f));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(11, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, EndermiteEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, SilverfishEntity.class, true));

    }
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }



    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.RACCOON.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0,this::predicate));

    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {

        if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.raccoon.walk", Animation.LoopType.LOOP));
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.raccoon.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    public BlockPos getBlockTarget() {
        return this.blockTarget;
    }
    public void setBlockTarget(@Nullable BlockPos blockTarget) {
        this.blockTarget = blockTarget;
    }

    public void clearBlockTarget() { this.blockTarget = null; }
}
