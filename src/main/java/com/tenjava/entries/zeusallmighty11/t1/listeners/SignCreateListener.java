package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import com.tenjava.entries.zeusallmighty11.t1.util.ChatUtil;
import com.tenjava.entries.zeusallmighty11.t1.util.Messenger;
import com.tenjava.entries.zeusallmighty11.t1.util.NumberUtil;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;


public class SignCreateListener implements Listener
{


    private FancyTransit plugin;




    public SignCreateListener(FancyTransit plugin)
    {
        this.plugin = plugin;
    }




    @EventHandler
    public void onCreate(SignChangeEvent e)
    {
        Player p = e.getPlayer();
        String[] lines = e.getLines();
        Sign sign = (Sign) e.getBlock().getState();


        // if not a transit sign, ignore
        if (!lines[0].equals("[Transit]") && !lines[0].equals("[FT]"))
        {
            return;
        }


        // colorize the first line of the sign
        e.setLine(0, ChatUtil.colorize(e.getLine(0)));


        // if sign is a jump sign
        if (lines[1].equalsIgnoreCase("jump"))
        {

            // if user doesn't have permission
            if (!p.hasPermission("fancytransit.sign.create.jump"))
            {
                Messenger.tell(p, "&cYou don't have permission to create jump rails!");
                return;
            }

            if (!NumberUtil.isFloat(lines[2]))
            {
                Messenger.tell(p, "&cVlaue not a valid float value: '&e" + lines[2] + "&c'!");
                return;
            }




        }




        // if sign is a propel sign
        else if (lines[1].equalsIgnoreCase("propel"))
        {
            // if user doesn't have permission
            if (!p.hasPermission("fancytransit.sign.create.propel"))
            {
                Messenger.tell(p, "&cYou don't have permission to create propel rails!");
                return;
            }

            if (!NumberUtil.isFloat(lines[2]))
            {
                Messenger.tell(p, "&cVlaue not a valid float value: '&e" + lines[2] + "&c'!");
                return;
            }


        }


    }


}
