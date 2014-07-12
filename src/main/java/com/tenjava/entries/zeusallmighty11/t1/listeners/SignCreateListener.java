package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import com.tenjava.entries.zeusallmighty11.t1.rails.RailManager;
import com.tenjava.entries.zeusallmighty11.t1.rails.RailSignType;
import com.tenjava.entries.zeusallmighty11.t1.util.ChatUtil;
import com.tenjava.entries.zeusallmighty11.t1.util.Messenger;
import com.tenjava.entries.zeusallmighty11.t1.util.NumberUtil;
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


        // if not a transit sign, ignore
        if (!lines[0].equalsIgnoreCase("[Transit]"))
        {
            return;
        }


        // colorize the first line of the sign
        e.setLine(0, ChatUtil.colorize("&d[Transit]"));


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


            if (lines[3].equals(""))
            {
                Messenger.tell(p, "&cYou must specify on line 4 if the Minecart should connect to rails after being airborne.");
                return;
            }

            RailManager.createSign(p, RailSignType.JUMP, lines, e.getBlock());
        }


    }


}
