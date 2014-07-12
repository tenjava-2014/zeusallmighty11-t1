package com.tenjava.entries.zeusallmighty11.t1.util;


import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;

import java.util.UUID;


public class EntityUtil
{


    /**
     * Cycles through the loaded worlds and grabs an entity with a matching UUID
     *
     * @param id UUID of the entity to find
     * @return an entity with a matching UUID
     */
    public static Entity getEntityByID(UUID id)
    {

        for (World world : Bukkit.getWorlds())
        {
            for (Entity e : world.getEntitiesByClass(Minecart.class))
            {
                if (e.getUniqueId().equals(id))
                {
                    return e;
                }
            }
        }
        return null;
    }
}
