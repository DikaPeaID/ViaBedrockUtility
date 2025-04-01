package org.oryxel.viabedrockutility.renderer.extra;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import org.oryxel.viabedrockutility.renderer.BaseCustomEntityRenderer;

import java.util.List;

public final class CustomEntityRendererImpl<T extends Entity> extends BaseCustomEntityRenderer<T> {
    public CustomEntityRendererImpl(List<Model> list, EntityRendererFactory.Context context) {
        super(list, context);
    }

    @Override
    public void onRenderModel(Model model) {
    }
}
