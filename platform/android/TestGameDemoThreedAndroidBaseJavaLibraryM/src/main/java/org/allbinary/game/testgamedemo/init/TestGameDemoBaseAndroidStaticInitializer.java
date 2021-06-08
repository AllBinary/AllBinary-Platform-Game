package org.allbinary.game.testgamedemo.init;

import javax.microedition.lcdui.CommandListener;

import org.allbinary.game.resource.ResourceInitialization;
import org.allbinary.game.testgamedemo.configuration.TestGameDemoGameFeatures;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;

public class TestGameDemoBaseAndroidStaticInitializer extends TestGameDemoStaticInitializer
{
    private boolean androidGameInitialized;
    
    public TestGameDemoBaseAndroidStaticInitializer(
            ResourceInitialization[] resourceInitializationArray, int portion)
    {
        super(resourceInitializationArray, portion);
    }

    public void initKey(int portion) throws Exception
    {
        super.initKey(portion);
        
        //AndroidGameKey.init();
        ProgressCanvasFactory.getInstance().addPortion(50, "Game Keys");        
    }

    public void init(CommandListener commandListener, int level) throws Exception
    {
        super.init(commandListener, level);

        if(this.isAndroidGameInitialized())
        {
            return;
        }
        
        this.setAndroidGameInitialized(true);
        
        new TestGameDemoGameFeatures().init();

        //GameOptionsForm.init(commandListener, new TestGameDemoGameFeatures(), "Game Options");
        ProgressCanvasFactory.getInstance().addPortion(50, "Game Options");
    }
    
    protected void setAndroidGameInitialized(boolean androidGameInitialized)
    {
        this.androidGameInitialized = androidGameInitialized;
    }

    protected boolean isAndroidGameInitialized()
    {
        return androidGameInitialized;
    }
}
