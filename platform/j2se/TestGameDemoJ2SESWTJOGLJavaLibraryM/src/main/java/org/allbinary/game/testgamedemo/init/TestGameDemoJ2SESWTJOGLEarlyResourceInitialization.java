package org.allbinary.game.testgamedemo.init;

import org.allbinary.game.resource.ResourceInitialization;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.media.audio.ErrorSound;
import org.allbinary.media.audio.SelectSound;
import org.allbinary.media.audio.TestSound;
import org.allbinary.midlet.MidletIcon;

public class TestGameDemoJ2SESWTJOGLEarlyResourceInitialization
extends ResourceInitialization
{
    public TestGameDemoJ2SESWTJOGLEarlyResourceInitialization()
    {
    }

    public void init()
        throws Exception
    {
        super.init();
        
        PreLogUtil.put(commonStrings.START, this, commonStrings.INIT);

    }
}
