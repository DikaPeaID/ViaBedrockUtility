package org.oryxel.viabedrockutility.renderer;

import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import java.util.List;

public class CustomEntityRenderer<T extends Entity> extends EntityRenderer<T, CustomEntityRenderer.CustomEntityRenderState> {
    private final List<Model> models;

    public CustomEntityRenderer(final List<Model> models, EntityRendererFactory.Context context) {
        super(context);
        this.models = models;
    }

    @Override
    public void render(CustomEntityRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        for (Model model : this.models) {
            matrices.push();

            this.setupTransforms(state, matrices);
            matrices.scale(-1.0F, -1.0F, 1.0F);
            matrices.translate(0.0F, -1.501F, 0.0F);

            RenderLayer renderLayer = RenderLayer.getItemEntityTranslucentCull(model.texture);
            if (renderLayer != null) {
                VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
                model.model.render(matrices, vertexConsumer, light, OverlayTexture.packUv(0, 10));
            }

            matrices.pop();
        }
    }

    @Override
    public boolean shouldRender(T entity, Frustum frustum, double x, double y, double z) {
        double d = 64.0F * Entity.getRenderDistanceMultiplier();
        return entity.squaredDistanceTo(x, y, z) <= d * d;
    }

    @Override
    public void updateRenderState(T entity, CustomEntityRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.yaw = entity.getYaw(tickDelta);
        // state.pitch = entity.getPitch(tickDelta);
    }

    private void setupTransforms(CustomEntityRenderState state, MatrixStack matrices) {
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180 - state.yaw));
    }

    @Override
    public CustomEntityRenderState createRenderState() {
        return new CustomEntityRenderState();
    }

    public record Model(EntityModel<?> model, Identifier texture) {
    }

    public static class CustomEntityRenderState extends EntityRenderState {
        private float yaw, pitch;
    }
}
