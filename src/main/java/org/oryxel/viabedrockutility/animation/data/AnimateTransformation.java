package org.oryxel.viabedrockutility.animation.data;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.util.math.MathHelper;
import org.joml.Vector3f;
import org.oryxel.viabedrockutility.mixin.interfaces.IModelPart;

// Taken from vanilla Transformation.
public record AnimateTransformation(Target target, Keyframe[] keyframes) {
    public static class Interpolations {
        public static final Interpolation LINEAR = (dest, delta, keyframes, start, end, scale) -> {
            Vector3f vector3f2 = keyframes[start].target();
            Vector3f vector3f3 = keyframes[end].target();
            return vector3f2.lerp(vector3f3, delta, dest).mul(scale);
        };
        public static final Interpolation CUBIC = (dest, delta, keyframes, start, end, scale) -> {
            Vector3f vector3f2 = keyframes[Math.max(0, start - 1)].target();
            Vector3f vector3f3 = keyframes[start].target();
            Vector3f vector3f4 = keyframes[end].target();
            Vector3f vector3f5 = keyframes[Math.min(keyframes.length - 1, end + 1)].target();
            dest.set(MathHelper.catmullRom(delta, vector3f2.x(), vector3f3.x(), vector3f4.x(), vector3f5.x()) * scale, MathHelper.catmullRom(delta, vector3f2.y(), vector3f3.y(), vector3f4.y(), vector3f5.y()) * scale, MathHelper.catmullRom(delta, vector3f2.z(), vector3f3.z(), vector3f4.z(), vector3f5.z()) * scale);
            return dest;
        };
    }

    public static class Targets {
        public static final Target OFFSET = (part, vec3) -> ((IModelPart)((Object)part)).viaBedrockUtility$setOffset(vec3);
        public static final Target ROTATE = (part, vec3) -> ((IModelPart)((Object)part)).viaBedrockUtility$setAngles(vec3);
        public static final Target SCALE = (part, vec3) -> {
            part.xScale = vec3.x;
            part.yScale = vec3.y;
            part.zScale = vec3.z;
        };
    }

    public interface Target {
        void apply(ModelPart var1, Vector3f var2);
    }

    public interface Interpolation {
        Vector3f apply(Vector3f var1, float var2, Keyframe[] var3, int var4, int var5, float var6);
    }
}


