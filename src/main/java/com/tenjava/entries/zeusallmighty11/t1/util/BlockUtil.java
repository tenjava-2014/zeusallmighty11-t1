package com.tenjava.entries.zeusallmighty11.t1.util;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.Arrays;
import java.util.List;


public class BlockUtil
{


    private static final BlockFace[] faces = {BlockFace.UP, BlockFace.DOWN, BlockFace.EAST, BlockFace.WEST, BlockFace.NORTH, BlockFace.SOUTH};
    private static final List<Material> rails = Arrays.asList(Material.RAILS, Material.ACTIVATOR_RAIL, Material.DETECTOR_RAIL, Material.POWERED_RAIL);




    public static Block getRailsFromSign(Block signblock)
    {
        Block up2 = signblock.getLocation().add(0, 2, 0).getBlock();


        if (up2 != null && rails.contains(up2.getType()))
        {
            return up2;
        }

        return null;
    }

}
