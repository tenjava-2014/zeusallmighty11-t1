package com.tenjava.entries.zeusallmighty11.t1.util;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import com.tenjava.entries.zeusallmighty11.t1.tasks.CartCheckTask;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class MinecartUtil
{


    public static void jump(Minecart cart, float power, boolean connect)
    {
        final Block rail = cart.getLocation().getBlock();
        final byte data = rail.getData();


        if (connect)
        {
            // face rail toward more rails
            new CartCheckTask(cart).runTaskTimer(FancyTransit.getInstance(), 0L, 1L);
        }

        rail.setType(Material.AIR);
        cart.setVelocity(new Vector(0, power, 0));


        new BukkitRunnable()
        {


            @Override
            public void run()
            {
                rail.setType(Material.DETECTOR_RAIL);
                rail.setData(data);
            }
        }.runTaskLater(FancyTransit.getInstance(), 4L);


    }
}
