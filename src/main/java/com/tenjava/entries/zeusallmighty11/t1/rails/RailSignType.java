package com.tenjava.entries.zeusallmighty11.t1.rails;


import java.io.Serializable;


public enum RailSignType implements Serializable
{
    INVALID,
    JUMP,
    HOVER,;




    public static RailSignType parse(String s)
    {
        for (RailSignType rst : RailSignType.values())
        {
            if (rst.toString().toLowerCase().equals(s.toLowerCase()))
            {
                return rst;
            }
        }
        return INVALID;
    }


}
