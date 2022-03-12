package com.rab.friendtools.client.gui;

import java.io.IOException;

import com.rab.friendtools.handler.ConfigurationHandler;
import com.rab.friendtools.reference.Reference;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class FriendToolsGUI extends GuiScreen {
    private static final String ENABLED = "rabfriendtools.enabled";
    private static final String DISABLED = "rabfriendtools.disabled";
    private GuiButton Toggle;
    private GuiButton Modes;

	@Override
	  public void initGui()
	  {
        Toggle = new GuiButton(1, width / 2 - 75, height / 2 - 22, 150, 20, I18n.format(ConfigurationHandler.isFriendToolsOn ? ENABLED : DISABLED));
        Modes = new GuiButton(2, width / 2 - 75, height / 2 + 2, 150, 20, "Mode: " + Reference.mode.getDisplayText());
	    buttonList.add(Modes);
	    buttonList.add(Toggle);
	  }
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    drawDefaultBackground();
	    super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
    protected void actionPerformed(GuiButton button) throws IOException {
        boolean z = false;
        if (button == Toggle) {
            if (!ConfigurationHandler.isFriendToolsOn) {
                 z = true;
            	ConfigurationHandler.setFriendTools(true);
            }
        	ConfigurationHandler.setFriendTools(z);
        	this.Toggle.displayString = I18n.format(ConfigurationHandler.isFriendToolsOn ? ENABLED : DISABLED);

      }
        else if (button == Modes) {
        	Reference.mode = Reference.mode.next();
            ConfigurationHandler.setMode(Reference.mode);
        	this.Modes.displayString = Reference.mode.getDisplayText();
        }
	}
	@Override
	public boolean doesGuiPauseGame() {
	    return false;
	}
}