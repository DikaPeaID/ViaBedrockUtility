package org.oryxel.viabedrockutility.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class PackDownloadingScreen extends Screen {
    public PackDownloadingScreen() {
        super(Text.of("Downloading Screen"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer,  "Downloading bedrock pack...", this.width / 2, this.height / 2 - (this.textRenderer.fontHeight / 2), -1);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return false;
    }
}
