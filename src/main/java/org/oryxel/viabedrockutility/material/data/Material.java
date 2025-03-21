package org.oryxel.viabedrockutility.material.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import net.minecraft.util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public record Material(String identifier, String baseIdentifier, Function<Identifier, RenderLayer> function) {
    public static Map<String, Material> parse(final JsonObject object) {
        final Map<String, Material> map = new HashMap<>();

        if (!object.has("materials")) {
            return map;
        }

        final JsonObject materials = object.getAsJsonObject("materials");
        for (final String elementName : materials.keySet()) {
            final JsonElement element = materials.get(elementName);
            if (elementName.equals("version") || !element.isJsonObject()) {
                continue;
            }

            final String[] split = elementName.split(":");
            if (split.length > 2) {
                continue;
            }

            // Still a WIP.
            final String identifier = split[0], baseIdentifier = split.length == 1 ? "" : split[1];
            final Function<Identifier, RenderLayer> function = Util.memoize(texture -> {
                final RenderLayer.MultiPhaseParameters.Builder builder = RenderLayer.MultiPhaseParameters.builder();
                builder.texture(new RenderPhase.Texture(texture, TriState.FALSE, false));

                return null;
            });
        }

        return map;
    }
}
