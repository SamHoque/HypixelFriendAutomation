package com.rab.friendtools.renderer;

import net.minecraft.client.resources.I18n;

public enum Mode {
    ACCEPT("/f accept %s", "accept"),
    DENY("/f deny %s", "deny"),
    IGNORE("/ignore add %s", "ignore");

    private static final Mode[] VALUES = values();

    private static final String MODE_KEY = "rabfriendtools.mode.";

    private static final String MODE_DISPLAY = "rabfriendtools.modeDisplay";

    private final String commandFormat;

    private final String unlocalizedDisplayName;

    Mode(String commandFormat, String unlocalizedDisplayName) {
        this.commandFormat = commandFormat;
        this.unlocalizedDisplayName = MODE_KEY + unlocalizedDisplayName;
    }

    public String getDisplayText() {
        return I18n.format(MODE_DISPLAY, I18n.format(unlocalizedDisplayName));
    }

    public String getCommand(String playerName) {
      return String.format(commandFormat, playerName);
    }

    public Mode next() {
        return VALUES[(ordinal() + 1) % VALUES.length];
    }
}