/*
* AllBinary Open License Version 1
* Copyright (c) 2011 AllBinary
* 
* By agreeing to this license you and any business entity you represent are
* legally bound to the AllBinary Open License Version 1 legal agreement.
* 
* You may obtain the AllBinary Open License Version 1 legal agreement from
* AllBinary or the root directory of AllBinary's AllBinary Platform repository.
* 
* Created By: Travis Berthelot
* 
*/
package org.allbinary.logic.system.security.licensing;

import org.allbinary.logic.string.CommonSeps;
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo;
import org.allbinary.logic.string.StringMaker;

public class TestGameDemoPCClientInformation
extends AbeClientInformation
{
    protected static final TestGameDemoPCClientInformation instance = new TestGameDemoPCClientInformation();
    
    private final static String PC_DESC = "PC";
    public TestGameDemoPCClientInformation()
    {
        super(
                new StringMaker().append(TestGameDemoSoftwareInfo.getInstance().getName()).append(PC_DESC).toString(),
                TestGameDemoSoftwareInfo.getInstance().getVersion(),
                new StringMaker().append(TestGameDemoSoftwareInfo.getInstance().getName()).append(PC_DESC)
                        .append(CommonSeps.getInstance().SPACE).append(TestGameDemoSoftwareInfo.getInstance().getVersion()).toString(),
                TestGameDemoSoftwareInfo.getInstance().toShortString()
                );
    }
}
