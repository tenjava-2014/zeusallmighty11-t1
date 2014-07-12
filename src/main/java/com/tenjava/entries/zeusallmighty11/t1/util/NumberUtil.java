package com.tenjava.entries.zeusallmighty11.t1.util;


public class NumberUtil
{


    public static boolean isInt(String s)
    {
        try
        {
            Integer.parseInt(s);
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }




    public static boolean isFloat(String s)
    {
        try
        {
            Float.parseFloat(s);
            return true;
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
    }


}
