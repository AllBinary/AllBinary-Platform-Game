package org.allbinary.game.testgamedemo.resource;

import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;

public class TestGameDemoAndroidResources extends TestGameDemoBaseAndroidResources
{
    private static final TestGameDemoAndroidResources STATIC = new TestGameDemoAndroidResources();

    protected boolean initialized;

    public static TestGameDemoAndroidResources getInstance()
    {
        return STATIC;
    }

    protected void initImages(String[] RESOURCES) throws Exception
    {
        if (Features.getInstance().isFeature(
                GraphicsFeatureFactory.getInstance().IMAGE_TO_ARRAY_GRAPHICS))
        {
            //this.initImageArray(RESOURCES);
        }
        else
        {
            throw new Exception("TestGameDemo Resource Error");
        }
    }
}
