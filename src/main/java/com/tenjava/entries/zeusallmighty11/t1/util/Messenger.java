package com.tenjava.entries.zeusallmighty11.t1.util;


import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class Messenger
{


    private static final String PREFIX = "&3[&cBLAH&3]&r ";




    public static void sendMessage(Object o, String... msg)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : msg)
        {
            sb.append(PREFIX).append(s).append("\n");
        }


        if (o instanceof Player)
        {
            ((Player) o).sendMessage(sb.toString());
        }
        else if(o instanceof ConsoleCommandSender)
        {
            ((ConsoleCommandSender)o).sendMessage(sb.toString());
        }
        else
        {

        }
    }


}
