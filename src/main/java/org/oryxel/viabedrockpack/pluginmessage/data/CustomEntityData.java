package org.oryxel.viabedrockpack.pluginmessage.data;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import org.oryxel.viabedrockpack.ViaBedrockPack;
import org.oryxel.viabedrockpack.pluginmessage.BedrockMessageHandler;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public record CustomEntityData(int entityId, UUID entityUUID, JsonObject geometryData) implements CustomPayload {
    public static Id<CustomEntityData> ID = new Id<>(Identifier.of(ViaBedrockPack.MOD_ID, "data"));

    public static String readString(PacketByteBuf buf) {
        int length = buf.readInt();
        String result = buf.toString(buf.readerIndex(), length, StandardCharsets.UTF_8);
        buf.readerIndex(buf.readerIndex() + length);
        return result;
    }

    public void handle(ClientPlayNetworking.Context context, BedrockMessageHandler handler) {
        handler.handle(context, this);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}