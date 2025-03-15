package org.oryxel.viabedrockpack.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import org.oryxel.viabedrockpack.entity.CustomEntity;
import org.oryxel.viabedrockpack.entity.renderer.model.CustomEntityModel;

public class CustomEntityRenderer extends MobEntityRenderer<CustomEntity, LivingEntityRenderState, CustomEntityModel> {
    private final Identifier texture;

    public CustomEntityRenderer(EntityRendererFactory.Context context, CustomEntityModel entityModel, Identifier texture) {
        super(context, entityModel, 0);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return this.texture;
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
