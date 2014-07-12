package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;


public class RidingListener implements Listener
{


    private FancyTransit plugin;




    public RidingListener(FancyTransit plugin)
    {
        this.plugin = plugin;
    }




    @EventHandler
    public void onClick(PlayerInteractEntityEvent e)
    {
        Player p = e.getPlayer();
        Entity clicked = e.getRightClicked();


        if (clicked instanceof Villager)
        {
            e.setCancelled(true);
            Villager v = (Villager) clicked;
            v.setPassenger(p);
        }

        if (clicked instanceof Ocelot)
        {
            final Ocelot o = (Ocelot) clicked;
            o.setPassenger(p);


            new BukkitRunnable()
            {


                @Override
                public void run()
                {
                    if (o.getPassenger() == null)
                    {
                        cancel();
                        return;
                    }


                }
            }.runTaskTimer(plugin, 0L, 1L);


        }

    }


}
