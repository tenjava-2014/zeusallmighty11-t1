package com.tenjava.entries.zeusallmighty11.t1;


import com.tenjava.entries.zeusallmighty11.t1.listeners.TeleportListener;
import com.tenjava.entries.zeusallmighty11.t1.listeners.TestListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class FancyTransit extends JavaPlugin
{
    // ----------------------------------------------------------------------------------------- \\

    private static FancyTransit instance;


    // ----------------------------------------------------------------------------------------- \\




    /*
    Plugin enabling...
     */
    @Override
    public void onEnable()
    {
        // instantiate singleton for use
        instance = this;


        // handle configuration
        saveDefaultConfig();
        loadConfig();


        // register events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new TeleportListener(this), this);

        // temporary testing listener
        pm.registerEvents(new TestListener(this), this);


    }




    /*
    Plugin disabling...
     */
    @Override
    public void onDisable()
    {



        // kill off the singleton to prevent ram loss
        instance = null;
    }



    // ----------------------------------------------------------------------------------------- \\




    /*
    Load configuration
     */
    private void loadConfig()
    {

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



    // ----------------------------------------------------------------------------------------- \\
}
