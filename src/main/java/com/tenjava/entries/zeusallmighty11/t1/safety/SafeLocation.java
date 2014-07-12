package com.tenjava.entries.zeusallmighty11.t1.safety;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.util.Vector;


/**
 * A safe location class which does not store World references and can be serialized
 */
public class SafeLocation
{

    // ----------------------------------------------------------------------------------------- \\

    Vector vector;
    String worldName;
    float pitch;
    float yaw;


    // ----------------------------------------------------------------------------------------- \\




    public SafeLocation(Location location)
    {
        this.vector = location.toVector();
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
        return new Location(Bukkit.getWorld(worldName), vector.getX(), vector.getY(), vector.getZ(), pitch, yaw);
    }




    /**
     * Serializes the location to be stored
     *
     * @return a serialized SafeLocation
     */
    public String serialize()
    {
        return worldName + "," + vector.getX() + "," + vector.getY() + "," + vector.getZ() + "," + pitch + "," + yaw;
    }



    // ----------------------------------------------------------------------------------------- \\




    public void setVector(Vector vector)
    {
        this.vector = vector;
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




    public Vector getVector()
    {
        return vector;
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
