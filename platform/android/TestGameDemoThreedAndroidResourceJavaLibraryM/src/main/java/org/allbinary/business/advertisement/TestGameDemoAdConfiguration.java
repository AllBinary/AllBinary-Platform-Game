package org.allbinary.business.advertisement;

import org.allbinary.logic.basic.string.StringUtil;
import org.allbinary.direction.Direction;
import org.allbinary.direction.DirectionFactory;

public class TestGameDemoAdConfiguration extends AdConfiguration
{
    private final Direction[] directionArray = {
            DirectionFactory.getInstance().DOWN, DirectionFactory.getInstance().UP
    };

    public TestGameDemoAdConfiguration()
    {
        super(new Object[]
                {
                "AllBinary_TestGameDemo_Android",
                "",
                StringUtil.getInstance().EMPTY_STRING
                }
        );        
    }
    
    public Direction[] getValidAdSpots()
    {
        return directionArray;
    }

    public void process(int state)
    {
    }
}
