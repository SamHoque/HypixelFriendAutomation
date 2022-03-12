package com.rab.friendtools.reference;

import com.rab.friendtools.utils.ChatColor;

import net.minecraft.client.resources.I18n;

import com.rab.friendtools.renderer.Mode;

public class Reference {
	public static final String ACCEPTEDVERSIONS = "[1.8.9]";
    public static final String MODID = "rabfriendtools";
    public static final String VERSION = "1.5.0";
    public static final String GUI_FACTORY_CLASS = "";
    public static final String PREFIX =  ChatColor.GREEN + "F" + ChatColor.BLUE + "T" + ChatColor.DARK_GRAY + " > " + ChatColor.GRAY;
    public static final String ENABLED = I18n.format("rabfriendtools.enabled");
    public static final String DISABLED = I18n.format("rabfriendtools.disabled");
    public static final String DIVIDER = ChatColor.RED + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "----------------------------------";
    public static boolean IS_GUI_OPEN = false;
    public static Mode mode = Mode.ACCEPT;
}
