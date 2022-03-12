package com.rab.friendtools;

import com.rab.friendtools.Listeners.ChatListener;
import com.rab.friendtools.client.gui.FriendToolsGUI;
import com.rab.friendtools.commands.FriendTools;
import com.rab.friendtools.handler.ConfigurationHandler;
import com.rab.friendtools.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

@Mod(acceptedMinecraftVersions = Reference.ACCEPTEDVERSIONS, modid = Reference.MODID, version = Reference.VERSION)
public class RabFriendToolsMod
{
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    }
    @EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    	ClientCommandHandler.instance.registerCommand(new FriendTools());
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ChatListener());
    }
    @SubscribeEvent
    public void onUpdate(ClientTickEvent event) {
        if (Reference.IS_GUI_OPEN) {
        	Reference.IS_GUI_OPEN = false;
            Minecraft.getMinecraft().displayGuiScreen(new FriendToolsGUI());
        }
    }
}
