package org.allbinary.game.testgamedemo.init;

import org.allbinary.game.testgamedemo.resource.TestGameDemoAndroidResources;

import org.allbinary.android.input.motion.button.TouchButtonAndroidResources;
import org.allbinary.game.testgamedemo.init.TestGameDemoResourceInitialization;

public class TestGameDemoAndroidResourceInitialization
extends TestGameDemoResourceInitialization
{
    public TestGameDemoAndroidResourceInitialization()
    {
    }

    public void init()
        throws Exception
    {
        super.init();
        
        //TWB - TouchButton
        new TouchButtonAndroidResources().init();
        
        TestGameDemoAndroidResources.getInstance().init();
    }
}
