package org.oryxel.viabedrockutility.pack.definitions;

import lombok.Getter;
import org.oryxel.viabedrockutility.animation.Animation;
import org.oryxel.viabedrockutility.animation.vanilla.AnimateBuilder;
import org.oryxel.viabedrockutility.animation.vanilla.VBUAnimation;
import org.oryxel.viabedrockutility.fabric.ViaBedrockUtilityFabric;
import org.oryxel.viabedrockutility.pack.PackManager;
import org.oryxel.viabedrockutility.pack.content.Content;

import java.util.HashMap;
import java.util.Map;

@Getter
public class AnimationDefinitions {
    private final Map<String, AnimationData> animations = new HashMap<>();

    public AnimationDefinitions(final PackManager packManager) {
        for (final Content content : packManager.getPacks()) {
            for (final String modelPath : content.getFilesDeep("animations/", ".json")) {
                try {
                    for (final Animation animation : Animation.parse(content.getJson(modelPath))) {
                        this.animations.put(animation.getIdentifier(), new AnimationData(animation, AnimateBuilder.build(animation)));
                    }
                } catch (Throwable e) {
                    ViaBedrockUtilityFabric.LOGGER.warn("Failed to parse model definition {}", modelPath);
                }
            }
        }
    }

    public record AnimationData(Animation animation, VBUAnimation compiled) {}
}
