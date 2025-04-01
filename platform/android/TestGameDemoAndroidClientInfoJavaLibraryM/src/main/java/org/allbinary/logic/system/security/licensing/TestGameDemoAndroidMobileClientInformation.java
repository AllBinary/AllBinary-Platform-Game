package org.allbinary.logic.system.security.licensing;

import org.allbinary.game.canvas.TestGameDemoSoftwareInfo;
import org.allbinary.string.CommonSeps;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.system.SoftwareInformation;

public class TestGameDemoAndroidMobileClientInformation 
    extends MobileClientInformation
{
    protected static final TestGameDemoAndroidMobileClientInformation instance = new TestGameDemoAndroidMobileClientInformation(TestGameDemoSoftwareInfo.getInstance());
    
    public TestGameDemoAndroidMobileClientInformation(final SoftwareInformation softwareInformation)
    {
        super(
                new StringMaker().append(softwareInformation.getName()).append(ANDROID_DESC).toString(),
                softwareInformation.getVersion(),
                new StringMaker().append(softwareInformation.getName()).append(ANDROID_DESC).append(CommonSeps.getInstance().SPACE).append(softwareInformation.getVersion()).toString(),
                softwareInformation.toShortString()
                );
    }
}
