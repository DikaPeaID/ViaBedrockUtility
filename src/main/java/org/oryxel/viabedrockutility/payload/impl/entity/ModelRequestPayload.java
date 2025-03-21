package org.oryxel.viabedrockutility.payload.impl.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.oryxel.viabedrockutility.payload.BasePayload;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class ModelRequestPayload extends BasePayload {
    private final String identifier;
    private final UUID uuid;
    private final Model[] models;

    public record Model(String geometry, String texture) {
    }
}
