package com.tenjava.entries.zeusallmighty11.t1.listeners;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import com.tenjava.entries.zeusallmighty11.t1.rails.RailManager;
import com.tenjava.entries.zeusallmighty11.t1.rails.RailSign;
import com.tenjava.entries.zeusallmighty11.t1.temp.CooldownCart;
import com.tenjava.entries.zeusallmighty11.t1.util.Messenger;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;


public class RailListener implements Listener
{


    private FancyTransit plugin;




    public RailListener(FancyTransit fancyTransit)
    {
        this.plugin = fancyTransit;
    }




    @EventHandler
    public void onActivate(VehicleMoveEvent e)
    {
        Vehicle vehicle = e.getVehicle();

        if (!vehicle.getType().toString().toLowerCase().contains("minecart"))
        {
            Messenger.announce("&eVehicle moved.. not a minecart!");
            return;
        }

        Minecart minecart = (Minecart) vehicle;

        Block to = e.getTo().getBlock();

        if (to == null || to.getType() != Material.DETECTOR_RAIL)
        {
            return;
        }


        if (!minecart.hasMetadata("rail_cooldown"))
        {
            minecart.setMetadata("rail_cooldown", new FixedMetadataValue(plugin, "rail_cooldown"));

            CooldownCart cc = new CooldownCart(minecart.getUniqueId(), 10L);
            plugin.getMinecartCooldowns().add(cc);



            RailSign rs = RailSign.fromLocation(to.getLocation());

            if (rs == null)
            {
                /** TEMPORARY AWHEOFOHAIEWHFPOAIWEFOHIOAEWOHFIAEWPF **/
                Messenger.announce("UH OH...");
                return;
            }

            RailManager.perform(minecart, rs);

        }

    }

}
