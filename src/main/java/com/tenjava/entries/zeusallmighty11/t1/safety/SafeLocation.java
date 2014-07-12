package com.tenjava.entries.zeusallmighty11.t1.safety;


import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.Serializable;


/**
 * A safe location class which does not store World references and can be serialized
 */
public class SafeLocation implements Serializable
{

    // ----------------------------------------------------------------------------------------- \\

    String worldName;
    double x;
    double y;
    double z;
    float pitch;
    float yaw;


    // ----------------------------------------------------------------------------------------- \\




    public SafeLocation(Location location)
    {
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.worldName = location.getWorld().getName();
        this.pitch = location.getPitch();
        this.yaw = location.getYaw();
    }


    // ----------------------------------------------------------------------------------------- \\




    /**
     * Change vector back into location
     *
     * @return Bukkit location
     */
    public Location getLocation()
    {
        return new Location(Bukkit.getWorld(worldName), x, y, z, pitch, yaw);
    }




    /**
     * Serializes the location to be stored
     *
     * @return a serialized SafeLocation
     */
    public String serialize()
    {
        return worldName + "," + x + "," + y + "," + z + "," + pitch + "," + yaw;
    }



    // ----------------------------------------------------------------------------------------- \\




    public void setX(double x)
    {
        this.x = x;
    }




    public void setY(double y)
    {
        this.y = y;
    }




    public void setZ(double z)
    {
        this.z = z;
    }




    public void setWorldName(String worldName)
    {
        this.worldName = worldName;
    }




    public void setPitch(float pitch)
    {
        this.pitch = pitch;
    }




    public void setYaw(float yaw)
    {
        this.yaw = yaw;
    }


    // ----------------------------------------------------------------------------------------- \\




    public double getX()
    {
        return x;
    }




    public double getY()
    {
        return y;
    }




    public double getZ()
    {
        return z;
    }




    public String getWorldName()
    {
        return worldName;
    }




    public float getPitch()
    {
        return pitch;
    }




    public float getYaw()
    {
        return yaw;
    }




    // ----------------------------------------------------------------------------------------- \\
}
