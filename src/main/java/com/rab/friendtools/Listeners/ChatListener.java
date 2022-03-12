package com.rab.friendtools.Listeners;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rab.friendtools.handler.ConfigurationHandler;
import com.rab.friendtools.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatListener {
    private static final Pattern FRIEND_REQUEST = Pattern.compile("\u00A7m-{52}\nFriend request from (\\[[^]]+] )?(\\S+)\n.*", Pattern.DOTALL);
    @SubscribeEvent
    public void onReceivedMessage(ClientChatReceivedEvent event) {
    if (ConfigurationHandler.isFriendToolsOn){
        String isRequestIncoming = event.message.getUnformattedText();
            Matcher matcher = FRIEND_REQUEST.matcher(isRequestIncoming);
            if (matcher.matches()) {
            	Minecraft.getMinecraft().thePlayer.sendChatMessage(Reference.mode.getCommand(matcher.group(2)));
            }
        }
    }
}