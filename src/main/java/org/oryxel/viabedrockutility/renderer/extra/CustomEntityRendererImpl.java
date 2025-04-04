package org.oryxel.viabedrockutility.renderer.extra;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import org.oryxel.viabedrockutility.ViaBedrockUtility;
import org.oryxel.viabedrockutility.animation.animator.Animator;
import org.oryxel.viabedrockutility.pack.definitions.AnimationDefinitions;
import org.oryxel.viabedrockutility.renderer.BaseCustomEntityRenderer;
import team.unnamed.mocha.runtime.Scope;

import java.util.List;
import java.util.UUID;

public final class CustomEntityRendererImpl<T extends Entity> extends BaseCustomEntityRenderer<T> {
    public CustomEntityRendererImpl(List<Model> list, EntityRendererFactory.Context context) {
        super(list, context);
    }

    public void reset() {
        this.getModels().forEach(m -> m.model().reset());
    }

    public void play(final UUID uuid, final String geometry, final AnimationDefinitions.AnimationData data) {
        if (data == null) {
            return;
        }

        boolean found = false;
        for (final Model model : this.getModels()) {
            if (geometry.equals(model.geometry())) {
                final Scope scope = ViaBedrockUtility.getInstance().getPayloadHandler().getCachedScopes().get(uuid);
                model.model().play(data.animation().getIdentifier(), new Animator(model.model(), scope, data));
                found = true;
            }
            System.out.println(geometry + "," + model.geometry());
        }

        if (found) {
            System.out.println("Play successfully!");
        }
    }
}
