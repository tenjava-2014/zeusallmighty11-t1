package com.tenjava.entries.zeusallmighty11.t1.tasks;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import com.tenjava.entries.zeusallmighty11.t1.temp.CooldownCart;
import com.tenjava.entries.zeusallmighty11.t1.util.EntityUtil;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;


public class RailCooldownTask extends BukkitRunnable
{


    private FancyTransit plugin;
    List<CooldownCart> toRemove;




    public RailCooldownTask(FancyTransit plugin)
    {
        this.plugin = plugin;
        this.toRemove = new ArrayList<>();
    }




    @Override
    public void run()
    {

        for (CooldownCart cc : plugin.getMinecartCooldowns())
        {

            if (cc.getTime() < 0L)
            {

                Entity e = EntityUtil.getEntityByID(cc.getUuid());

                if (e.hasMetadata("rail_cooldown"))
                {
                    e.removeMetadata("rail_cooldown", plugin);
                }

                toRemove.add(cc);

                continue;
            }


            cc.setTime(cc.getTime() - 1);
        }

        plugin.getMinecartCooldowns().removeAll(toRemove);

    }
}
