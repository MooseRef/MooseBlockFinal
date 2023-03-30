package net.moose.mooseblock.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.moose.mooseblock.entity.custom.MooseEntity;
import net.moose.mooseblock.mooseblock;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MooseModel extends GeoModel<MooseEntity> {
    @Override
    public Identifier getModelResource(MooseEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "geo/moose.geo.json");
    }

    @Override
    public Identifier getTextureResource(MooseEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "textures/entity/moose.png");
    }

    @Override
    public Identifier getAnimationResource(MooseEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "animations/moose.animation.json");
    }
    @Override
    public void setCustomAnimations(MooseEntity animatable, long instanceId, AnimationState<MooseEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }


}


