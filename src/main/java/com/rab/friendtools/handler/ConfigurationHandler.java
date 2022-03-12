package com.rab.friendtools.handler;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

import com.rab.friendtools.reference.Reference;
import com.rab.friendtools.renderer.Mode;
import com.rab.friendtools.utils.Rab;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean isFriendToolsOn = true;

    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
    	isFriendToolsOn = configuration.getBoolean("isFriendToolsOn", "Rab", true, "Enable the mod");
    	Reference.mode = Mode.valueOf(configuration.getString("mode", "Rab", "ACCEPT", "Current Mode"));
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            loadConfiguration();
        }
    }
    public static void setMode(Mode mode){
        Rab.setString("Rab", "mode", mode.name());
        if (configuration.hasChanged()) configuration.save();
    }
    public static void setFriendTools(boolean value){
    	Rab.setBoolean("Rab", "isFriendToolsOn", true , value);
        if (configuration.hasChanged()) configuration.save();
        isFriendToolsOn = value;
    }
}