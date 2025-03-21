// This file is part of ViaBedrock - https://github.com/RaphiMC/ViaBedrock - Copyright 2025 - 2026
package org.oryxel.viabedrockutility.pack.definitions.controller;

import lombok.Getter;
import org.cube.converter.data.bedrock.controller.BedrockRenderController;
import org.cube.converter.parser.bedrock.controller.BedrockControllerParser;
import org.oryxel.viabedrockutility.fabric.ViaBedrockUtilityFabric;
import org.oryxel.viabedrockutility.pack.PackManager;
import org.oryxel.viabedrockutility.pack.content.Content;

import java.util.HashMap;
import java.util.Map;

// https://wiki.bedrock.dev/entities/render-controllers
@Getter
public class RenderControllerDefinitions {
    private final Map<String, BedrockRenderController> renderControllers = new HashMap<>();

    public RenderControllerDefinitions(final PackManager packManager) {
        for (Content content : packManager.getPacks()) {
            for (String controllerPath : content.getFilesDeep("render_controllers/", ".json")) {
                try {
                    for (BedrockRenderController bedrockRenderController : BedrockControllerParser.parse(content.getString(controllerPath))) {
                        this.renderControllers.put(bedrockRenderController.identifier(), bedrockRenderController);
                    }
                } catch (Throwable e) {
                    ViaBedrockUtilityFabric.LOGGER.warn("Failed to parse render controller definition {}", controllerPath);
                }
            }
        }
    }
}
