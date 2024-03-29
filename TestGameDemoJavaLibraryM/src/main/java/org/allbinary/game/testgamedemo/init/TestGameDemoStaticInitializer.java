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
package org.allbinary.game.testgamedemo.init;

import org.allbinary.game.init.CommonGameInitialization;
import org.allbinary.game.resource.ResourceInitialization;

public class TestGameDemoStaticInitializer
extends CommonGameInitialization
{
    public TestGameDemoStaticInitializer(
            final ResourceInitialization[] resourceInitializationArray, final int portion)
    {
        super(resourceInitializationArray, portion);
    }    

    public void initGame()
    throws Exception
    {
        
    }
}
