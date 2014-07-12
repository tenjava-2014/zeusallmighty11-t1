package com.tenjava.entries.zeusallmighty11.t1.temp;


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
