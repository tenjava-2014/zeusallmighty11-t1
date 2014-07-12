package com.tenjava.entries.zeusallmighty11.t1.rails;


import com.tenjava.entries.zeusallmighty11.t1.safety.SafeLocation;
import org.bukkit.Location;


public class RailSign
{
    // ----------------------------------------------------------------------------------------- \\


    RailSignType type;
    float power;
    boolean makeConnection;
    SafeLocation signLoc;
    SafeLocation railLoc;


    // ----------------------------------------------------------------------------------------- \\




    public RailSign(RailSignType type, float power, boolean makeConnection, Location signLoc, Location railLoc)
    {
        this.type = type;
        this.power = power;
        this.makeConnection = makeConnection;
        this.signLoc = new SafeLocation(signLoc);
        this.railLoc = new SafeLocation(railLoc);
    }


    // ----------------------------------------------------------------------------------------- \\




    // ----------------------------------------------------------------------------------------- \\




    public void setType(RailSignType type)
    {
        this.type = type;
    }




    public void setPower(float power)
    {
        this.power = power;
    }




    public void setMakeConnection(boolean makeConnection)
    {
        this.makeConnection = makeConnection;
    }




    public void setSignLoc(SafeLocation signLoc)
    {
        this.signLoc = signLoc;
    }




    public void setRailLoc(SafeLocation railLoc)
    {
        this.railLoc = railLoc;
    }




    // ----------------------------------------------------------------------------------------- \\




    public RailSignType getType()
    {
        return type;
    }




    public float getPower()
    {
        return power;
    }




    public boolean isMakeConnection()
    {
        return makeConnection;
    }




    public SafeLocation getSignLoc()
    {
        return signLoc;
    }




    public SafeLocation getRailLoc()
    {
        return railLoc;
    }



    // ----------------------------------------------------------------------------------------- \\
}
