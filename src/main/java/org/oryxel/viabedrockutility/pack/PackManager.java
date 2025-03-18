package org.oryxel.viabedrockutility.pack;

import lombok.Getter;
import org.oryxel.viabedrockutility.pack.content.Content;
import org.oryxel.viabedrockutility.pack.definitions.EntityDefinitions;
import org.oryxel.viabedrockutility.pack.definitions.ModelDefinitions;
import org.oryxel.viabedrockutility.pack.processor.TextureProcessor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Getter
public class PackManager {
    private final Content content;
    private final EntityDefinitions entityDefinitions;
    private final ModelDefinitions modelDefinitions;

    public PackManager(final Content content) {
        this.content = content;

        this.entityDefinitions = new EntityDefinitions(this);
        this.modelDefinitions = new ModelDefinitions(this);

        TextureProcessor.process(content);

        // Test
        try {
            Files.write(new File("output.zip").toPath(), content.toZip());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
