package org.oryxel.viabedrockpack.pluginmessage;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
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
        final Identifier identifier = Identifier.of(ViaBedrockPack.MOD_ID, data.name());
        final EntityType<CustomEntity> type = Registry.register(
                Registries.ENTITY_TYPE,
                identifier,
                EntityType.Builder.create(CustomEntity::new, SpawnGroup.MISC).dimensions(0, 0).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, identifier)));

        final List<BedrockGeometryModel> models = BedrockGeometryModel.fromJson(data.geometryData());

        EntityRendererRegistry.register(type, (context) -> new CustomEntityRenderer(context, GeometryUtil.buildCustomModel(models.get(data.geometryIndex())), data.texture()));
        FabricDefaultAttributeRegistry.register(type, CustomEntity.createMobAttributes());
    }
}
