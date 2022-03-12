package com.rab.friendtools.commands;

import java.util.ArrayList;
import java.util.List;

import com.rab.friendtools.handler.ConfigurationHandler;
import com.rab.friendtools.reference.Reference;
import com.rab.friendtools.utils.ChatColor;
import com.rab.friendtools.utils.Rab;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;


public class FriendTools extends CommandBase {
	private static final String USAGE = "Usage /friendtools <toggle on/off>";

    @Override
    public String getCommandName() {
        return "friendtools";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return USAGE;
    }

    @Override
    public List < String > getCommandAliases() {
		ArrayList<String> aliases = new ArrayList<String>();
		aliases.add("ft");
		aliases.add("friendtool");
		return aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "on":
                case "true":
                case "enable":
                	ConfigurationHandler.setFriendTools(true);
            		sender.addChatMessage(new ChatComponentText(Reference.PREFIX + "FriendTools: " + ChatColor.GREEN + Reference.ENABLED));
                    break;
                case "off":
                case "false":
                case "disable":
                	ConfigurationHandler.setFriendTools(false);
            		sender.addChatMessage(new ChatComponentText(Reference.PREFIX + "FriendTools: " + ChatColor.RED + Reference.DISABLED));
                    break;
                case "toggle":
                case "t":
                    if (ConfigurationHandler.isFriendToolsOn){
                    	ConfigurationHandler.setFriendTools(false);
                		sender.addChatMessage(new ChatComponentText(Reference.PREFIX + "FriendTools: " + ChatColor.RED + Reference.DISABLED));
                    }
                    else{
                    	ConfigurationHandler.setFriendTools(true);
                		sender.addChatMessage(new ChatComponentText(Reference.PREFIX + "FriendTools: " + ChatColor.GREEN + Reference.ENABLED));
                    }
                    break;
                case "gui":
                	Reference.IS_GUI_OPEN = true;
                	break;
                    default:
                		sender.addChatMessage(new ChatComponentText(Reference.PREFIX  + USAGE));
                    	break;
            }
        }
        else{
    		sender.addChatMessage(new ChatComponentText(Reference.DIVIDER));
    		sender.addChatMessage(new ChatComponentText(ChatColor.GREEN + "" + ChatColor.BOLD + "Friend Tools v1.5 By Rab"));
    		sender.addChatMessage(new ChatComponentText(""));
    		sender.addChatMessage(new ChatComponentText(Reference.PREFIX + "FriendTools: "
    				
    				+ (ConfigurationHandler.isFriendToolsOn ?  ChatColor.GREEN + Reference.ENABLED : ChatColor.RED + Reference.DISABLED)));
    		sender.addChatMessage(new ChatComponentText(Reference.PREFIX + "Mode: " + Rab.colorForMode()));
    		sender.addChatMessage(new ChatComponentText(ChatColor.GRAY + "Type /ft gui for advance options!"));
    		sender.addChatMessage(new ChatComponentText(Reference.DIVIDER));
     }
}
}