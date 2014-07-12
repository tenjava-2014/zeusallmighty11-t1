package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;


public class TeleportListener implements Listener
{


    public TeleportListener(FancyTransit plugin)
    {
        FancyTransit plugin1 = plugin;
    }




    @EventHandler
    public void onTeleport(PlayerTeleportEvent e)
    {
        Player p = e.getPlayer();


    }

}
