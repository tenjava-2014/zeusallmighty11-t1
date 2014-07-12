package com.tenjava.entries.zeusallmighty11.t1.rails;


import org.bukkit.block.Block;
import org.bukkit.material.Rails;


public enum RailDirection
{
    INVALID,
    NORTH,
    SOUTH,
    EAST,
    WEST;




    @SuppressWarnings("deprecation")
    public static RailDirection getDirection(Block b)
    {
        byte data = b.getData();

        Rails rails = new Rails(b.getType(), b.getData());

        // north.. -z
        if (rails.getDirection().toString().toLowerCase().contains("north"))
        {
            return NORTH;
        }
        // south +z
        else if (rails.getDirection().toString().toLowerCase().contains("south"))
        {
            return SOUTH;
        }
        // east +x
        else if (rails.getDirection().toString().toLowerCase().contains("east"))
        {
            return EAST;
        }
        // west -x
        else if (rails.getDirection().toString().toLowerCase().contains("west"))
        {
            return WEST;
        }
        return INVALID;
    }

}
