package org.oryxel.viabedrockpack.pluginmessage;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.cube.converter.model.impl.bedrock.BedrockGeometryModel;
import org.oryxel.viabedrockpack.ViaBedrockPack;
import org.oryxel.viabedrockpack.entity.CustomEntity;
import org.oryxel.viabedrockpack.entity.renderer.CustomEntityRenderer;
import org.oryxel.viabedrockpack.pluginmessage.data.CustomEntityData;
import org.oryxel.viabedrockpack.util.GeometryUtil;

import java.util.List;

public class BedrockMessageHandler {
    public void handle(final CustomEntityData data) {
        MinecraftClient mc = MinecraftClient.getInstance();

        if (mc.world == null) {
            return;
        }

        final Identifier identifier = Identifier.of(ViaBedrockPack.MOD_ID, data.name());
        final EntityType<CustomEntity> type = Registry.register(
                Registries.ENTITY_TYPE,
                identifier,
                EntityType.Builder.create(CustomEntity::new, SpawnGroup.CREATURE).dimensions(0F, 0F).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, identifier)));

        final List<BedrockGeometryModel> models = BedrockGeometryModel.fromJson(data.geometryData());

        EntityRendererRegistry.register(type, (context) -> new CustomEntityRenderer(context, GeometryUtil.buildCustomModel(models.get(data.geometryIndex())), data.texture()));
        FabricDefaultAttributeRegistry.register(type, CustomEntity.createMobAttributes());

        mc.world.addEntity(type.create(mc.world, SpawnReason.LOAD));
    }
}
