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

import allbinary.game.resource.ResourceInitialization;
import allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import javax.microedition.lcdui.CommandListener;
import org.allbinary.game.testgamedemo.configuration.TestGameDemoGameFeatures;

public class J2METestGameDemoStaticInitializer
    extends TestGameDemoStaticInitializer
{
    private boolean platformGameInitialized;
    
    public J2METestGameDemoStaticInitializer(
            ResourceInitialization[] resourceInitializationArray, int portion)
    {
        super(resourceInitializationArray, portion);
    }

    public void initKey(int portion) throws Exception
    {
        super.initKey(portion);
        
        //new KeyFactoryInitializer().init();
        //ProgressCanvasFactory.getInstance().addPortion(50, "Game Keys");        
    }

    public void init(CommandListener commandListener, int level) throws Exception
    {
        super.init(commandListener, level);

        if(this.isPlatformGameInitialized())
        {
            return;
        }
        
        this.setPlatformGameInitialized(true);
        
        ProgressCanvasFactory.getInstance().addPortion(50, "Game Options");
        
        new TestGameDemoGameFeatures().init();
        //GameOptionsForm.init(commandListener, new TestGameDemoGameFeatures(), "Game Options");
    }
    
    protected void setPlatformGameInitialized(boolean platformGameInitialized)
    {
        this.platformGameInitialized = platformGameInitialized;
    }

    protected boolean isPlatformGameInitialized()
    {
        return platformGameInitialized;
    }
}
