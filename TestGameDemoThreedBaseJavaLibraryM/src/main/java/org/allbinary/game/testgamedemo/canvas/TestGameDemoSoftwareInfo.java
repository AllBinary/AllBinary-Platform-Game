package org.allbinary.game.testgamedemo.canvas;

import org.allbinary.logic.system.SoftwareInformation;

public class TestGameDemoSoftwareInfo
{
    private static final SoftwareInformation SINGLETON = 
        new SoftwareInformation("TestGameDemoThreed", "1.2.0");

    public static SoftwareInformation getInstance()
    {
        return SINGLETON;
    }
}
