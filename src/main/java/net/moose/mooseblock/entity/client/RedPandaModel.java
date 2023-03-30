package net.moose.mooseblock.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.moose.mooseblock.entity.custom.RedPandaEntity;
import net.moose.mooseblock.mooseblock;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RedPandaModel extends GeoModel<RedPandaEntity> {

    @Override
    public Identifier getModelResource(RedPandaEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "geo/red_panda.geo.json");
    }

    @Override
    public Identifier getTextureResource(RedPandaEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "textures/entity/red_panda.png");
    }

    @Override
    public Identifier getAnimationResource(RedPandaEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "animations/red_panda.animation.json");
    }
    @Override
    public void setCustomAnimations(RedPandaEntity animatable, long instanceId, AnimationState<RedPandaEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }



}
