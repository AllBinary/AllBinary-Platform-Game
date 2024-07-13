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
import org.allbinary.logic.system.SoftwareInformation;

public class TestGameDemoPCClientInformation
extends AbeClientInformation
{
    protected static final TestGameDemoPCClientInformation instance = new TestGameDemoPCClientInformation(TestGameDemoSoftwareInfo.getInstance());
    
    private final static String PC_DESC = "PC";
    public TestGameDemoPCClientInformation(final SoftwareInformation softwareInformation)
    {
        super(
                new StringMaker().append(softwareInformation.getName()).append(PC_DESC).toString(),
                softwareInformation.getVersion(),
                new StringMaker().append(softwareInformation.getName()).append(PC_DESC).append(CommonSeps.getInstance().SPACE).append(softwareInformation.getVersion()).toString(),
                softwareInformation.toShortString()
                );
    }
}
