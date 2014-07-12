package com.tenjava.entries.zeusallmighty11.t1;


import com.tenjava.entries.zeusallmighty11.t1.listeners.*;
import com.tenjava.entries.zeusallmighty11.t1.rails.RailSign;
import com.tenjava.entries.zeusallmighty11.t1.safety.SafeLocation;
import com.tenjava.entries.zeusallmighty11.t1.tasks.RailCooldownTask;
import com.tenjava.entries.zeusallmighty11.t1.temp.CooldownCart;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FancyTransit extends JavaPlugin
{
    // ----------------------------------------------------------------------------------------- \\

    private static FancyTransit instance;


    private Map<SafeLocation, RailSign> railSigns;
    private List<CooldownCart> minecartCooldowns;

    private RailCooldownTask railCooldownTask;


    private File signsDir;


    // config stuff
    private boolean minecartBoats;
    private boolean minecartBoatDrops;
    private boolean obsidianBoatsExist;


    // ----------------------------------------------------------------------------------------- \\




    /*
    Plugin enabling...
     */
    @Override
    public void onEnable()
    {
        // instantiate singleton for use
        instance = this;

        // instantiate the map for railsigns
        railSigns = new HashMap<>();

        // instantiate the map for minecart cooldowns
        minecartCooldowns = new ArrayList<>();


        // handle configuration
        saveDefaultConfig();
        loadConfig();


        // handle rail signs
        loadRailSigns();


        // register events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new TeleportListener(this), this);
        pm.registerEvents(new SignCreateListener(this), this);
        pm.registerEvents(new RailListener(this), this);
        pm.registerEvents(new BoatListener(this), this);


        // temporary testing listener
        pm.registerEvents(new TestListener(this), this);




        // start Rail Cooldown Task
        railCooldownTask = new RailCooldownTask(this);
        railCooldownTask.runTaskTimer(this, 0L, 1L);




        // if obsidian boats enabled, create recipe
        if (obsidianBoatsExist)
        {
            ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.BOAT));
        }

    }




    /*
    Plugin disabling...
     */
    @Override
    public void onDisable()
    {
        // save all rail signs
        saveSigns();


        // kill off the singleton to prevent ram loss
        instance = null;
    }



    // ----------------------------------------------------------------------------------------- \\




    /*
    Load configuration
     */
    private void loadConfig()
    {
        minecartBoats = getConfig().getBoolean("minecart-transform");
        minecartBoatDrops = getConfig().getBoolean("transformed-drops-minecart");

        obsidianBoatsExist = getConfig().getBoolean("obsidian-boats-exist");
    }




    /*
    Load all rail serialized rail signs
     */
    private void loadRailSigns()
    {
        signsDir = new File(getDataFolder(), "/signs/");

        if (!signsDir.exists())
        {
            signsDir.mkdir();
        }

        int count = 0;
        for (File f : signsDir.listFiles())
        {
            RailSign rs = RailSign.load(f);
            railSigns.put(rs.getRailLoc(), rs);
            count++;
        }


        getLogger().info("Loaded " + count + " rail signs.");
    }




    /*
    Save all rail signs to file
     */
    private void saveSigns()
    {
        for (RailSign rs : railSigns.values())
        {
            rs.save(signsDir);
        }
    }


    // ----------------------------------------------------------------------------------------- \\




    /**
     * Grabs the plugin's main class via singleton
     *
     * @return FancyTransit instance
     */
    public static FancyTransit getInstance()
    {
        return instance;
    }




    /**
     * Returns a Map of the rail signs in the map
     *
     * @return a collection of the active rail signs
     */
    public Map<SafeLocation, RailSign> getRailSigns()
    {
        return railSigns;
    }




    /**
     * Returns a Map of the minecarts whom have cooldowns
     *
     * @return a collection of minecarts with cooldowns
     */
    public List<CooldownCart> getMinecartCooldowns()
    {
        return minecartCooldowns;
    }




    public RailCooldownTask getRailCooldownTask()
    {
        return railCooldownTask;
    }




    public File getSignsDir()
    {
        return signsDir;
    }




    /**
     * @return if minecarts should turn into boats
     */
    public boolean isMinecartBoats()
    {
        return minecartBoats;
    }




    /**
     * @return should *boats drop minecarts?
     */
    public boolean isMinecartBoatDrops()
    {
        return minecartBoatDrops;
    }



    // ----------------------------------------------------------------------------------------- \\
}
