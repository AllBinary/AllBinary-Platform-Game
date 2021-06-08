package org.allbinary.game.testgamedemo;

import javax.microedition.midlet.MIDlet;

import org.allbinary.midlet.MidletFactoryInterface;

public class TestGameDemoFactory extends MidletFactoryInterface
{
    private static MIDlet SINGLETON = null;
    
    public MIDlet getInstance()
    {
        if(SINGLETON == null)
        {
            SINGLETON = new TestGameDemoMIDlet();
        }
        return SINGLETON;
    }
}
