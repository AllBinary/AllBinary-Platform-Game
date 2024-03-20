package org.allbinary.logic.system.security.licensing;

import org.allbinary.game.canvas.TestGameDemoSoftwareInfo;
import org.allbinary.logic.string.CommonSeps;

public class TestGameDemoAndroidMobileClientInformation extends
    MobileClientInformation
{
    protected static final TestGameDemoAndroidMobileClientInformation instance = new TestGameDemoAndroidMobileClientInformation();
    
    public TestGameDemoAndroidMobileClientInformation()
    {
        super(
                TestGameDemoSoftwareInfo.getInstance().getName() + ANDROID_DESC, 
                TestGameDemoSoftwareInfo.getInstance().getVersion(),
                TestGameDemoSoftwareInfo.getInstance().getName() + ANDROID_DESC + 
                CommonSeps.getInstance().SPACE + 
                TestGameDemoSoftwareInfo.getInstance().getVersion(),
                TestGameDemoSoftwareInfo.getInstance().toShortString()
                );
    }
}
