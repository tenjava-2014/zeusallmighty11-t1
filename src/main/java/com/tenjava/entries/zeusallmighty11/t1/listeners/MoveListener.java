package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;


public class MoveListener implements Listener
{


    FancyTransit plugin;




    public MoveListener(FancyTransit plugin)
    {
        this.plugin = plugin;
    }




    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();

        if (p.getInventory().getBoots() == null)
        {
            return;
        }

        ItemStack boots = p.getInventory().getBoots();

        if (boots.hasItemMeta() && boots.getItemMeta().hasDisplayName() && boots.getItemMeta().getDisplayName().equalsIgnoreCase("Rocket Boots"))
        {
            if (p.getLocation().subtract(0, 1, 0).getBlock() == null || p.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.AIR)
            {
                p.setVelocity(p.getLocation().getDirection().add(new Vector(0, 0.25, 0)).multiply(0.5));
            }
        }

    }


}
