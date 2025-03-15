package org.oryxel.viabedrockpack.pluginmessage.data;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import org.oryxel.viabedrockpack.ViaBedrockPack;
import org.oryxel.viabedrockpack.pluginmessage.BedrockMessageHandler;

import java.nio.charset.StandardCharsets;

public record CustomEntityData(String name, int geometryIndex, Identifier texture, JsonObject geometryData) implements CustomPayload {
    public static Id<CustomEntityData> ID = new Id<>(Identifier.of(ViaBedrockPack.MOD_ID, "data"));

    public static String readString(PacketByteBuf buf) {
        int length = buf.readInt();
        String result = buf.toString(buf.readerIndex(), length, StandardCharsets.UTF_8);
        buf.readerIndex(buf.readerIndex() + length);
        return result;
    }

    public void handle(BedrockMessageHandler handler) {
        handler.handle(this);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}