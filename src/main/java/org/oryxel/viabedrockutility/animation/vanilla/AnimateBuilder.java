package org.oryxel.viabedrockutility.animation.vanilla;

import org.oryxel.viabedrockutility.animation.Animation;
import org.oryxel.viabedrockutility.animation.element.Cube;
import org.oryxel.viabedrockutility.animation.element.timestamp.ComplexTimeStamp;
import org.oryxel.viabedrockutility.animation.element.timestamp.SimpleTimeStamp;
import org.oryxel.viabedrockutility.util.mojangweirdformat.ValueOrValue;

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.oryxel.viabedrockutility.animation.vanilla.AnimateTransformation.Targets.*;
import static org.oryxel.viabedrockutility.animation.vanilla.AnimateTransformation.*;

public class AnimateBuilder {
    public static VBUAnimation build(final Animation animation) {
        float length = animation.getAnimationLength();
        if (length == -1) {
            float largestTimeStamp = 1;
            for (Cube cube : animation.getCubes()) {
                if (cube.getPosition().getValue() instanceof TreeMap<?, ?> rawMap) {
                    final TreeMap<Float, ValueOrValue<?>> map = (TreeMap<Float, ValueOrValue<?>>) rawMap;
                    for (Float v : map.keySet()) {
                        if (largestTimeStamp < v) {
                            largestTimeStamp = v;
                        }
                    }
                }

                if (cube.getRotation().getValue() instanceof TreeMap<?, ?> rawMap) {
                    final TreeMap<Float, ValueOrValue<?>> map = (TreeMap<Float, ValueOrValue<?>>) rawMap;
                    for (Float v : map.keySet()) {
                        if (largestTimeStamp < v) {
                            largestTimeStamp = v;
                        }
                    }
                }

                if (cube.getScale().getValue() instanceof TreeMap<?, ?> rawMap) {
                    final TreeMap<Float, ValueOrValue<?>> map = (TreeMap<Float, ValueOrValue<?>>) rawMap;
                    for (Float v : map.keySet()) {
                        if (largestTimeStamp < v) {
                            largestTimeStamp = v;
                        }
                    }
                }
            }

            if (largestTimeStamp != 1) {
                largestTimeStamp += 0.01F;
            }
            length = largestTimeStamp;
        }

        final VBUAnimation.Builder builder = VBUAnimation.Builder.create(length);
        for (Cube cube : animation.getCubes()) {
            build(builder, cube.getIdentifier(), OFFSET, cube.getPosition());
            build(builder, cube.getIdentifier(), ROTATE, cube.getRotation());
            build(builder, cube.getIdentifier(), ROTATE, cube.getScale());
        }

        return builder.build();
    }

    private static void build(final VBUAnimation.Builder builder, final String name, final Target target, final Object object) {
        if (object instanceof TreeMap<?, ?> rawMap) {
            final TreeMap<Float, ValueOrValue<?>> map = (TreeMap<Float, ValueOrValue<?>>) rawMap;
            final Queue<Map.Entry<Float, ValueOrValue<?>>> entries = new ConcurrentLinkedQueue<>();
            map.entrySet().forEach(entries::add);

            String[] past = null;
            Map.Entry<Float, ValueOrValue<?>> entry;
            while ((entry = entries.peek()) != null) {
                float timestamp = entry.getKey();

                if (entry.getValue().getValue() instanceof SimpleTimeStamp simple) {
                    builder.addBoneAnimation(name, new AnimateTransformation(target, new VBUKeyFrame(timestamp, simple.value(), Interpolations.CUBIC)));
                } else if (entry.getValue().getValue() instanceof ComplexTimeStamp complex) {
                    // Tf is pre post.... lerp to the next one using post and pre is the starting frame or whatever.
                    Interpolation interpolation = complex.lerpMode().equalsIgnoreCase("catmullrom") ? Interpolations.CUBIC :  Interpolations.LINEAR;

                    if (past != null) {
                        builder.addBoneAnimation(name, new AnimateTransformation(target, new VBUKeyFrame(timestamp, past, interpolation)));
                        past = null;
                    }

                    if (complex.pre() != null) {
                        builder.addBoneAnimation(name, new AnimateTransformation(target, new VBUKeyFrame(timestamp, complex.pre(), interpolation)));
                    }

                    if (complex.post() != null) {
                        past = complex.post();
                    }
                }
            }
        } else {
            builder.addBoneAnimation(name, new AnimateTransformation(target, new VBUKeyFrame(0, get(object), AnimateTransformation.Interpolations.CUBIC)));
        }
    }

    private static String[] get(final Object object) {
        if (object instanceof String[] array) {
            return array;
        } else if (object instanceof Float pos) {
            return new String[] {String.valueOf(pos), String.valueOf(pos), String.valueOf(pos)};
        } else if (object instanceof String pos) {
            return new String[] {pos, pos, pos};
        }

        return new String[] {"0", "0", "0"};
    }
}
