package org.oryxel.viabedrockpack;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.oryxel.viabedrockpack.entity.CustomEntity;
import org.oryxel.viabedrockpack.entity.renderer.CustomEntityRenderer;
import org.oryxel.viabedrockpack.entity.renderer.model.CustomEntityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ViaBedrockPack implements ModInitializer {
	public static final String MOD_ID = "viabedrockpack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Identifier CUSTOM_ENTITY_IDENTIFIER = Identifier.of(MOD_ID, "custom-entity");
	public static final EntityType<CustomEntity> CUSTOM_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			CUSTOM_ENTITY_IDENTIFIER,
			EntityType.Builder.create(CustomEntity::new, SpawnGroup.CREATURE).dimensions(0F, 0F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, CUSTOM_ENTITY_IDENTIFIER))
	);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello ViaBedrockPack!");

		EntityRendererRegistry.register(CUSTOM_ENTITY, (context) -> new CustomEntityRenderer(context, new CustomEntityModel(new ModelPart(List.of(), Map.of())), Identifier.of("stone")));
		FabricDefaultAttributeRegistry.register(CUSTOM_ENTITY, CustomEntity.createMobAttributes());
	}
}