package com.rab.friendtools.utils;

import com.rab.friendtools.handler.ConfigurationHandler;
import com.rab.friendtools.reference.Reference;

public class Rab {
    public static void setBoolean(String catergory, String variable, boolean defaultValue, boolean value){
    	ConfigurationHandler.configuration.get(catergory, variable, defaultValue).set(value);
      }
    public static void setBoolean(String catergory, String variable, boolean value){
    	ConfigurationHandler.configuration.get(catergory, variable, true).set(value);
      }
    public static void getBoolean(String catergory, String variable){
    	ConfigurationHandler.configuration.get(catergory, variable, true);
      }
    public static void setInt(String catergory, String variable, int defaultValue, int value){
    	ConfigurationHandler.configuration.get(catergory, variable, defaultValue).set(value);
      }
    public static void setInt(String catergory, String variable, int value){
    	ConfigurationHandler.configuration.get(catergory, variable, 1).set(value);
      }
    public static void getInt(String catergory, String variable){
    	ConfigurationHandler.configuration.get(catergory, variable, 1);
      }

    public static void setString(String catergory, String variable, String defaultValue, String value){
    	ConfigurationHandler.configuration.get(catergory, variable, defaultValue).set(value);
      }
    public static void setString(String catergory, String variable, String value){
    	ConfigurationHandler.configuration.get(catergory, variable, "").set(value);
      }
    public static void getString(String catergory, String variable){
    	ConfigurationHandler.configuration.get(catergory, variable, "");
      }
    public static String colorForMode(){
    	switch(Reference.mode){
    	case ACCEPT:
    		return ChatColor.GREEN + "Accept";
    	case DENY:
    		return ChatColor.RED + "Deny";
    	case IGNORE:
    		return ChatColor.DARK_GRAY + "Ignore";
    	}
		return "Invalid Mode";
    }
}
