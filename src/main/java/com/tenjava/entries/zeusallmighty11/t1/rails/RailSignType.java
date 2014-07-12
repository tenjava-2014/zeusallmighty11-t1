package com.tenjava.entries.zeusallmighty11.t1.rails;


public enum RailSignType
{
    INVALID,
    JUMP,
    PROPEL,
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
