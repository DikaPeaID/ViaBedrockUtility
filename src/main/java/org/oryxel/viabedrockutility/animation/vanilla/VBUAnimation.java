package org.oryxel.viabedrockutility.animation.vanilla;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record VBUAnimation(float lengthInSeconds, boolean looping, Map<String, List<AnimateTransformation>> boneAnimations) {
    public static class Builder {
        private final float lengthInSeconds;
        private final Map<String, List<AnimateTransformation>> transformations = Maps.newHashMap();
        private boolean looping;

        public static Builder create(float lengthInSeconds) {
            return new Builder(lengthInSeconds);
        }

        private Builder(float lengthInSeconds) {
            this.lengthInSeconds = lengthInSeconds;
        }

        // Never going to use this, I'm going to handle this separately in Animator class.
        public Builder looping() {
            this.looping = true;
            return this;
        }

        public Builder addBoneAnimation(String name, AnimateTransformation transformation) {
            this.transformations.computeIfAbsent(name, (namex) -> new ArrayList<>()).add(transformation);
            return this;
        }

        public VBUAnimation build() {
            return new VBUAnimation(this.lengthInSeconds, this.looping, this.transformations);
        }
    }
}
