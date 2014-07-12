package com.tenjava.entries.zeusallmighty11.t1.util;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;


public class Messenger
{


    private static final String PREFIX = "§3[§dFancyTransit§3]§r ";




    /**
     * Sends message(s) (with color/format support) to receiver
     *
     * @param o - Receiver of the message. Either a CommandSender instance, otherwise sent to console.
     * @param msg - The message(s) to send
     */
    public static void tell(Object o, String... msg)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : msg)
        {
            sb.append(PREFIX).append(ChatUtil.colorize(s)).append("\n");
        }


        if (o instanceof CommandSender)
        {
            ((CommandSender) o).sendMessage(sb.toString());
        }
        else
        {
            FancyTransit.getInstance().getLogger().info(sb.toString());
        }
    }




    /**
     * Broadcasts the message across the server (With color support)
     *
     * @param msg - Message to send
     */
    public static void announce(String... msg)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : msg)
        {
            sb.append(ChatUtil.colorize(PREFIX)).append(ChatUtil.colorize(s)).append("\n");
        }

        Bukkit.broadcastMessage(sb.toString());
    }


}
