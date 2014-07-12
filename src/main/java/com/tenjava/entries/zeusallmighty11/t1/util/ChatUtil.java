package com.tenjava.entries.zeusallmighty11.t1.util;


import org.bukkit.ChatColor;


public class ChatUtil
{


    public static String colorize(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }




    public static String colorize(String s, char colorChar)
    {
        return ChatColor.translateAlternateColorCodes(colorChar, s);
    }


}
