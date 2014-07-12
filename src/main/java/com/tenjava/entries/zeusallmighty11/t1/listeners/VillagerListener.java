package com.tenjava.entries.zeusallmighty11.t1.listeners;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class VillagerListener implements Listener
{
    @EventHandler
    public void onClick(PlayerInteractEntityEvent e)
    {
        Player p = e.getPlayer();
        Entity clicked = e.getRightClicked();


        if(clicked instanceof Villager)
        {

        }

    }


}
