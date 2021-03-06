package org.allbinary.logic.system.security.licensing;

import org.allbinary.logic.system.security.licensing.MobileClientInformation;
import org.allbinary.game.testgamedemo.canvas.TestGameDemoSoftwareInfo;

import org.allbinary.logic.basic.string.CommonSeps;

public class TestGameDemoAndroidMobileClientInformation 
extends MobileClientInformation
{
    public TestGameDemoAndroidMobileClientInformation()
    {
        super(
                TestGameDemoSoftwareInfo.getInstance().getName() + ANDROID_DESC,
                TestGameDemoSoftwareInfo.getInstance().getVersion(),
                TestGameDemoSoftwareInfo.getInstance().getName() + ANDROID_DESC +
                CommonSeps.getInstance().SPACE + 
                TestGameDemoSoftwareInfo.getInstance().getVersion()
                );
    }
}
