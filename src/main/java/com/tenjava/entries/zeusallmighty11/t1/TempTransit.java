package com.tenjava.entries.zeusallmighty11.t1;


import org.bukkit.plugin.java.JavaPlugin;


public class TempTransit extends JavaPlugin
{
    // ----------------------------------------------------------------------------------------- \\

    private static TempTransit instance;


    // ----------------------------------------------------------------------------------------- \\




    @Override
    public void onEnable()
    {
        instance = this;

        saveDefaultConfig();
        loadConfig();


    }




    @Override
    public void onDisable()
    {



        instance = null;
    }



    // ----------------------------------------------------------------------------------------- \\




    private void loadConfig()
    {

    }


    // ----------------------------------------------------------------------------------------- \\




    public static TempTransit getInstance()
    {
        return instance;
    }



    // ----------------------------------------------------------------------------------------- \\
}
