package com.tenjava.entries.zeusallmighty11.t1.rails;


import com.tenjava.entries.zeusallmighty11.t1.safety.SafeLocation;
import org.bukkit.Location;

import java.io.*;


public class RailSign implements Serializable
{
    // ----------------------------------------------------------------------------------------- \\

    RailSignType type;
    float power;
    boolean connect;
    SafeLocation signLoc;
    SafeLocation railLoc;


    // ----------------------------------------------------------------------------------------- \\




    public RailSign(RailSignType type, float power, boolean makeConnection, Location signLoc, Location railLoc)
    {
        this.type = type;
        this.power = power;
        this.connect = makeConnection;
        this.signLoc = new SafeLocation(signLoc);
        this.railLoc = new SafeLocation(railLoc);
    }




    public void save(File dir)
    {
        File f = new File(dir, signLoc.serialize().replace(",", ""));

        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(this);
            oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




    public static RailSign load(File f)
    {
        RailSign rs = null;
        try
        {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(f));
            rs = (RailSign) oos.readObject();
            oos.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return rs;
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




    public void setConnect(boolean connect)
    {
        this.connect = connect;
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




    public boolean isConnect()
    {
        return connect;
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
