package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;


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
        final Player p = e.getPlayer();
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

                    o.setVelocity(p.getLocation().getDirection().multiply(0.3));
                }
            }.runTaskTimer(plugin, 0L, 1L);

            new BukkitRunnable()
            {


                @Override
                public void run()
                {
                    if (p.getVehicle() == null)
                    {
                        cancel();
                        return;
                    }


                    final Block b = p.getLocation().subtract(0, 2, 0).getBlock();
                    final Block left = b.getRelative(BlockFace.EAST);
                    final Block right = b.getRelative(BlockFace.WEST);

                    final Material prev = b.getType();
                    final Material prev2 = left.getType();
                    final Material prev3 = right.getType();

                    left.setType(Material.WOOL);
                    left.setData(Byte.parseByte(getRandomNumber(14) + ""));

                    right.setType(Material.WOOL);
                    right.setData(Byte.parseByte(getRandomNumber(14) + ""));

                    b.setType(Material.WOOL);
                    b.setData(Byte.parseByte(getRandomNumber(14) + ""));



                    new BukkitRunnable()
                    {


                        @Override
                        public void run()
                        {
                            b.setType(prev);
                            left.setType(prev2);
                            right.setType(prev3);
                        }
                    }.runTaskLater(plugin, 40L);
                }
            }.runTaskTimer(plugin, 0L, 4L);


        }

    }




    private int getRandomNumber(int i)
    {
        return new Random().nextInt(i);
    }


}
