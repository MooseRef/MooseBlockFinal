package net.moose.mooseblock.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.moose.mooseblock.entity.custom.RedPandaEntity;
import net.moose.mooseblock.mooseblock;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RedPandaRenderer extends GeoEntityRenderer<RedPandaEntity> {
    public RedPandaRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RedPandaModel());
    }

    @Override
    public Identifier getTextureLocation(RedPandaEntity animatable) {
        return new Identifier(mooseblock.MOD_ID, "textures/entity/red_panda.png");
    }

    @Override
    public void render(RedPandaEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f,0.4f,0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
