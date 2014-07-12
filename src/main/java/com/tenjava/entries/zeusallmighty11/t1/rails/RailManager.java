package com.tenjava.entries.zeusallmighty11.t1.rails;


import com.tenjava.entries.zeusallmighty11.t1.FancyTransit;
import com.tenjava.entries.zeusallmighty11.t1.util.BlockUtil;
import com.tenjava.entries.zeusallmighty11.t1.util.Messenger;
import com.tenjava.entries.zeusallmighty11.t1.util.MinecartUtil;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;


public class RailManager
{


    /**
     * Creates a RailSign and stores in memory
     *
     * @param p     Player creating the sign
     * @param rst   Type of rail
     * @param lines Lines of the sign
     * @param block Block of the sign
     */
    public static void createSign(Player p, RailSignType rst, String[] lines, Block block)
    {
        Block rail = BlockUtil.getRailsFromSign(block);

        if (rail == null)
        {
            Messenger.tell(p, "&4Couldn't find an above rail! Remember rails must be 2 blocks above the sign.");
            return;
        }

        switch (rst)
        {
            case INVALID:
            {
                Messenger.tell(p, "&4This type of Rail Sign is nonexistant!");
            }
            break;

            case JUMP:
            {
                // create a rail sign
                RailSign rs = new RailSign(RailSignType.JUMP, Float.parseFloat(lines[2]), Boolean.parseBoolean(lines[3]), block.getLocation(), rail.getLocation());

                // add the rail sign to the collection ._.
                FancyTransit.getInstance().getRailSigns().put(rs.getRailLoc(), rs);
            }
            break;

            case PROPEL:
            {
                // create a rail sign
                RailSign rs = new RailSign(RailSignType.PROPEL, Float.parseFloat(lines[2]), Boolean.parseBoolean(lines[3]), block.getLocation(), rail.getLocation());

                // add the rail sign to the collection ._.
                FancyTransit.getInstance().getRailSigns().put(rs.getRailLoc(), rs);
            }
            break;
            case HOVER:
            {
                // create a rail sign
                RailSign rs = new RailSign(RailSignType.HOVER, Float.parseFloat(lines[2]), Boolean.parseBoolean(lines[3]), block.getLocation(), rail.getLocation());

                // add the rail sign to the collection ._.
                FancyTransit.getInstance().getRailSigns().put(rs.getRailLoc(), rs);
            }
            break;
        }


    }




    /**
     * Performs the
     *
     * @param cart
     * @param rs
     */
    public static void perform(Minecart cart, RailSign rs)
    {
        switch (rs.getType())
        {
            case INVALID:
                break;
            case JUMP:
            {
                MinecartUtil.jump(cart, rs.getPower(), rs.isConnect());
            }
            break;
            case PROPEL:
                break;
            case HOVER:
                break;
        }
    }

}
