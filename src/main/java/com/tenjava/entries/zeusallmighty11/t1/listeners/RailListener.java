package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import com.tenjava.entries.zeusallmighty11.t1.rails.RailManager;
import com.tenjava.entries.zeusallmighty11.t1.rails.RailSign;
import com.tenjava.entries.zeusallmighty11.t1.temp.CooldownCart;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class RailListener implements Listener
{


    private final FancyTransit plugin;




    public RailListener(FancyTransit fancyTransit)
    {
        this.plugin = fancyTransit;
    }




    @EventHandler
    public void onActivate(VehicleMoveEvent e)
    {
        Vehicle vehicle = e.getVehicle();

        if (vehicle.getType().toString().toLowerCase().contains("minecart"))
        {
            Minecart minecart = (Minecart) vehicle;

            Block to = e.getTo().getBlock();

            if (to == null)
            {
                return;
            }

            if (to.getType() == Material.DETECTOR_RAIL)
            {
                if (!minecart.hasMetadata("rail_cooldown"))
                {
                    minecart.setMetadata("rail_cooldown", new FixedMetadataValue(plugin, "rail_cooldown"));

                    CooldownCart cc = new CooldownCart(minecart.getUniqueId());
                    plugin.getMinecartCooldowns().add(cc);

                    RailSign rs = RailSign.fromLocation(to.getLocation());

                    if (rs == null)
                    {
                        return;
                    }

                    RailManager.perform(minecart, rs);

                }
            }
            else if (to.getType() == Material.WATER || to.getType() == Material.STATIONARY_WATER)
            {
                if (plugin.isMinecartBoats())
                {
                    Vector v = minecart.getVelocity();
                    Entity passenger = minecart.getPassenger();
                    minecart.remove();

                    final Boat boat = (Boat) to.getLocation().getWorld().spawnEntity(to.getLocation(), EntityType.BOAT);
                    boat.getWorld().playEffect(boat.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
                    boat.setPassenger(passenger);
                    boat.setMetadata("minecart", new FixedMetadataValue(plugin, "minecart"));
                    boat.setMetadata("invincible", new FixedMetadataValue(plugin, "invincible"));
                    boat.setVelocity(v);




                    new BukkitRunnable()
                    {


                        @Override
                        public void run()
                        {
                            boat.removeMetadata("invincible", plugin);
                        }
                    }.runTaskLater(plugin, 20L);

                }
            }

        }

    }

}
