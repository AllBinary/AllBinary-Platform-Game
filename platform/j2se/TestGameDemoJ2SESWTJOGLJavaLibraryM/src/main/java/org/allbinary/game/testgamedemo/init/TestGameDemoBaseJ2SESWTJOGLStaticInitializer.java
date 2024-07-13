package org.allbinary.game.testgamedemo.init;

import javax.microedition.lcdui.CommandListener;

import org.allbinary.game.resource.ResourceInitialization;
import org.allbinary.game.testgamedemo.configuration.TestGameDemoGameFeatures;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;

public class TestGameDemoBaseJ2SESWTJOGLStaticInitializer extends TestGameDemoStaticInitializer
{
    private boolean androidGameInitialized;
    
    public TestGameDemoBaseJ2SESWTJOGLStaticInitializer(
            final ResourceInitialization[] resourceInitializationArray, int portion)
    {
        super(resourceInitializationArray, portion);
    }

    public void initKey(final int portion) throws Exception
    {
        super.initKey(portion);
        
        //AndroidGameKey.init();
        ProgressCanvasFactory.getInstance().addPortion(50, "Game Keys");        
    }

    public void init(final AbeClientInformationInterface abeClientInformation, final CommandListener commandListener, final int level) throws Exception
    {
        super.init(abeClientInformation, commandListener, level);

        if(this.isAndroidGameInitialized())
        {
            return;
        }
        
        this.setAndroidGameInitialized(true);
        
        new TestGameDemoGameFeatures().init();

        //GameOptionsForm.init(commandListener, new TestGameDemoGameFeatures(), "Game Options");
        ProgressCanvasFactory.getInstance().addPortion(50, "Game Options");
    }
    
    protected void setAndroidGameInitialized(final boolean androidGameInitialized)
    {
        this.androidGameInitialized = androidGameInitialized;
    }

    protected boolean isAndroidGameInitialized()
    {
        return androidGameInitialized;
    }
}
