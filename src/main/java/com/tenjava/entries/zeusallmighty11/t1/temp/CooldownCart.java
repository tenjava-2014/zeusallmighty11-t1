package com.tenjava.entries.zeusallmighty11.t1.temp;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;

import java.util.UUID;


public class CooldownCart
{


    UUID uuid;
    long time;




    public CooldownCart(UUID id, long time)
    {
        this.uuid = id;
        this.time = time;
    }




    public static CooldownCart fromid(UUID id)
    {
        for (CooldownCart cc : FancyTransit.getInstance().getMinecartCooldowns())
        {
            if (cc.getUuid().equals(id))
            {
                return cc;
            }
        }
        return null;
    }




    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }




    public void setTime(long time)
    {
        this.time = time;
    }




    public UUID getUuid()
    {
        return uuid;
    }




    public long getTime()
    {
        return time;
    }
}
