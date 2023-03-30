package net.moose.mooseblock.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.moose.mooseblock.entity.custom.RaccoonEntity;
import net.moose.mooseblock.mooseblock;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {

    public RaccoonRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RaccoonModel());
    }
    @Override
    public Identifier getTextureLocation(RaccoonEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "textures/entity/raccoon.png");
    }

    @Override
    public void render(RaccoonEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f,0.4f,0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}

