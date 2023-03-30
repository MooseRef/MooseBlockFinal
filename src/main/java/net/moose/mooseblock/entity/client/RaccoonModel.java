package net.moose.mooseblock.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.moose.mooseblock.entity.custom.RaccoonEntity;
import net.moose.mooseblock.mooseblock;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RaccoonModel extends GeoModel<RaccoonEntity> {

    @Override
    public Identifier getModelResource(RaccoonEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public Identifier getTextureResource(RaccoonEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "textures/entity/raccoon.png");
    }

    @Override
    public Identifier getAnimationResource(RaccoonEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "animations/raccoon.animation.json");
    }

    @Override
    public void setCustomAnimations(RaccoonEntity animatable, long instanceId, AnimationState<RaccoonEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }

}
