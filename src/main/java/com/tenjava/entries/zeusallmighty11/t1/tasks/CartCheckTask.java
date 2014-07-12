package com.tenjava.entries.zeusallmighty11.t1.tasks;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;


public class CartCheckTask extends BukkitRunnable
{


    private static final List<Material> cartTypes = Arrays.asList(Material.RAILS, Material.POWERED_RAIL, Material.DETECTOR_RAIL, Material.ACTIVATOR_RAIL);


    private final Minecart cart;




    public CartCheckTask(Minecart cart, boolean jump)
    {
        this.cart = cart;
        boolean jump1 = jump;
    }




    @Override
    public void run()
    {
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                for (int z = 0; z < 3; z++)
                {
                    Block near = cart.getLocation().getBlock().getRelative(x, y, z);

                    if (near == null || !cartTypes.contains(near.getType()))
                    {
                        continue;
                    }

                    Entity passenger = cart.getPassenger();
                    cart.eject();
                    cart.teleport(near.getLocation());
                    cart.setPassenger(passenger);

                    new BukkitRunnable()
                    {


                        @Override
                        public void run()
                        {
                            cart.setVelocity(cart.getLocation().getDirection().multiply(2.0));
                        }
                    }.runTaskLater(FancyTransit.getInstance(), 5L);

                    cancel();
                    return;
                }
            }
        }
    }
}
