package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;


public class FloatyBoatyListener implements Listener
{


    private final FancyTransit plugin;




    public FloatyBoatyListener(FancyTransit plugin)
    {
        this.plugin = plugin;
    }




    private final List<Boat> boats = new ArrayList<>();




    @EventHandler
    public void onBreak(VehicleDestroyEvent e)
    {
        Vehicle v = e.getVehicle();

        if (v instanceof Boat)
        {
            if (v.hasMetadata("minecart"))
            {
                if (plugin.isMinecartBoatDrops())
                {
                    e.setCancelled(true);
                    v.getLocation().getWorld().dropItemNaturally(v.getLocation(), new ItemStack(Material.MINECART));
                    v.remove();
                }
            }

            if (v.hasMetadata("invinicible"))
            {
                e.setCancelled(true);
            }

        }
    }




    @EventHandler
    public void onEntityCombust(EntityCombustEvent event)
    {
        if (((event.getEntity() instanceof Boat)) && (this.boats.contains(event.getEntity())))
        {
            event.setCancelled(true);
        }
        if ((event.getEntity() instanceof Player))
        {
            Player player = (Player) event.getEntity();
            if (((player.getVehicle() instanceof Boat)) && (this.boats.contains(player.getVehicle())))
            {
                event.setCancelled(true);
                player.setFireTicks(0);
            }
        }
    }




    @EventHandler
    public void onEntityDamage(EntityDamageEvent event)
    {
        if (!(event.getEntity() instanceof Player))
        {
            return;
        }
        Player player = (Player) event.getEntity();
        if (((player.getVehicle() instanceof Boat)) && (this.boats.contains(player.getVehicle())) && ((event.getCause() == EntityDamageEvent.DamageCause.LAVA) || (event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) || (event.getCause() == EntityDamageEvent.DamageCause.FIRE)))
        {
            player.setFireTicks(0);
            event.setCancelled(true);
        }
    }




    @EventHandler
    public void onClick(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        ItemStack is = p.getItemInHand();


        if (is == null || is.getType() != Material.BOAT)
        {
            return;
        }

        if (is.hasItemMeta() && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("§5Obsidian Boat"))
        {
            if (e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.LAVA || e.getClickedBlock().getType() == Material.STATIONARY_LAVA))
            {
                p.setItemInHand(null);
                Location loc = e.getClickedBlock().getLocation().add(0, 1, 0);
                Boat boat = (Boat) loc.getWorld().spawnEntity(loc, EntityType.BOAT);
                this.boats.add(boat);
            }
        }

    }




    @EventHandler
    public void onVehicleDamage(VehicleDamageEvent event)
    {
        if (((event.getVehicle() instanceof Boat)) && (this.boats.contains(event.getVehicle())) && (event.getAttacker() == null))
        {
            event.setCancelled(true);
            event.getVehicle().setFireTicks(0);
        }
    }




    @EventHandler
    public void onVehicleMove(VehicleMoveEvent e)
    {
        if ((e.getVehicle() instanceof Boat))
        {
            Vector vect = e.getVehicle().getVelocity();
            int y = 0;
            Material mat = e.getVehicle().getLocation().getWorld().getBlockAt(e.getVehicle().getLocation()).getType();
            if ((mat == Material.LAVA) || (mat == Material.STATIONARY_LAVA))
            {
                y = 1;
            }
            e.getVehicle().setVelocity(new Vector(vect.getX(), y, vect.getZ()));
        }
    }




    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent e)
    {
        if ((e.getAttacker() == null) && (this.boats.contains(e.getVehicle())))
        {
            e.setCancelled(true);
        }
    }

}
