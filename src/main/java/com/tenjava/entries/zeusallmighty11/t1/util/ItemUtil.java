package com.tenjava.entries.zeusallmighty11.t1.util;


import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class ItemUtil
{


    public static ItemStack withName(ItemStack is, String name)
    {
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(ChatUtil.colorize(name));
        is.setItemMeta(meta);
        return is;
    }




    public static ItemStack withLore(ItemStack is, String... lore)
    {
        ItemMeta meta = is.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        is.setItemMeta(meta);
        return is;
    }


}
