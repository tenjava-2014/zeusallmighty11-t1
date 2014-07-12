package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.event.Listener;


public class TestListener implements Listener
{


    private FancyTransit plugin;




    public TestListener(FancyTransit plugin)
    {
        this.plugin = plugin;
    }




//    @EventHandler
//    public void onInteract(PlayerInteractEntityEvent e)
//    {
//        Player p = e.getPlayer();
//        ItemStack is = p.getItemInHand();
//        Entity clicked = e.getRightClicked();
//
//        if (is == null)
//        {
//            return;
//        }
//
//        if (is.getType() == Material.BLAZE_ROD)
//        {
//
//            if (clicked.getType() == EntityType.MINECART)
//            {
//                Minecart minecart = (Minecart) clicked;
//
//                e.setCancelled(true);
//                clicked.setVelocity(p.getLocation().getDirection().add(new Vector(0, 1, 0)).multiply(1.0));
//            }
//
//        }
//
//    }


}
