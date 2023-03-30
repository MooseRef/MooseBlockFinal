package net.moose.mooseblock.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.moose.mooseblock.entity.custom.MooseEntity;
import net.moose.mooseblock.mooseblock;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MooseRenderer extends GeoEntityRenderer<MooseEntity> {
    public MooseRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MooseModel());
    }

    @Override
    public Identifier getTextureLocation(MooseEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "textures/entity/moose.png");
    }
    @Override
    public void render(MooseEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f,0.5f,0.5f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
