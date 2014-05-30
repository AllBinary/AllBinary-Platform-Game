package org.allbinary.game.testgamedemo.init;

import javax.microedition.lcdui.CommandListener;

import org.allbinary.game.testgamedemo.configuration.TestGameDemoGameFeatures;
import org.allbinary.game.testgamedemo.init.TestGameDemoStaticInitializer;

import allbinary.game.resource.ResourceInitialization;
import allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;

public class TestGameDemoAndroidStaticInitializer 
extends TestGameDemoStaticInitializer
{
    private boolean platformGameInitialized;
    
    public TestGameDemoAndroidStaticInitializer(
            ResourceInitialization[] resourceInitializationArray, int portion)
    {
        super(resourceInitializationArray, portion);
    }
    
    public void initKey(int portion) throws Exception
    {
        super.initKey(portion);
        
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
    
    protected void setPlatformGameInitialized(boolean androidGameInitialized)
    {
        this.platformGameInitialized = androidGameInitialized;
    }

    protected boolean isPlatformGameInitialized()
    {
        return platformGameInitialized;
    }
}
