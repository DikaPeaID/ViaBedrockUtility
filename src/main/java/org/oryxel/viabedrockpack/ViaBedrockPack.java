package org.oryxel.viabedrockpack;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.Identifier;
import org.oryxel.viabedrockpack.pluginmessage.BedrockMessageHandler;
import org.oryxel.viabedrockpack.pluginmessage.data.CustomEntityData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViaBedrockPack implements ModInitializer {
	public static final String MOD_ID = "viabedrockpack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final PacketCodec<PacketByteBuf, CustomEntityData> STREAM_CODEC = PacketCodec.of(null, buf -> {
		final String name = CustomEntityData.readString(buf);

		final int geometryIndex = buf.readInt();

		final Identifier identifier = Identifier.of("viabedrock", "textures/" + CustomEntityData.readString(buf) + ".png");

		final String geometryRaw = CustomEntityData.readString(buf);
		final JsonObject geometry = JsonParser.parseString(geometryRaw).getAsJsonObject();

		return new CustomEntityData(name, geometryIndex, identifier, geometry);
	});

	@Override
	public void onInitialize() {
		LOGGER.info("Hello ViaBedrockPack!");



		final BedrockMessageHandler handler = new BedrockMessageHandler();
		PayloadTypeRegistry.playS2C().register(CustomEntityData.ID, STREAM_CODEC);
		ClientPlayNetworking.registerGlobalReceiver(CustomEntityData.ID, (payload, context) -> payload.handle(handler));
	}
}