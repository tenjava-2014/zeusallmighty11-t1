package com.tenjava.entries.zeusallmighty11.t1.tasks;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;


public class CartCheckTask extends BukkitRunnable
{


    private static final List<Material> cartTypes = Arrays.asList(Material.RAILS, Material.POWERED_RAIL, Material.DETECTOR_RAIL, Material.ACTIVATOR_RAIL);


    private Minecart cart;
    private boolean jump;




    public CartCheckTask(Minecart cart, boolean jump)
    {
        this.cart = cart;
        this.jump = jump;
    }




    @Override
    public void run()
    {
        if (cart.getVelocity().getY() < 0 || !jump)
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

                        cart.teleport(near.getLocation());
                        cancel();
                        return;
                    }
                }
            }
        }
    }
}
