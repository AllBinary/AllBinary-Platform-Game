package org.allbinary.game.testgamedemo.init;

import org.allbinary.animation.image.TestGameDemoEarlyResourcesImageBasedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.animation.image.TestGameDemoEarlyResourcesOpenGLESImageBasedAnimationInterfaceFactoryInterfaceFactory;

import org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.game.resource.ResourceInitialization;

public class TestGameDemoAndroidAnimationInterfaceFactoryEarlyResourceInitialization 
extends ResourceInitialization
{
    public TestGameDemoAndroidAnimationInterfaceFactoryEarlyResourceInitialization()
    {
    }

    public void init()
    throws Exception
    {
        FeaturedAnimationInterfaceFactoryInterfaceFactory 
        featuredAnimationInterfaceFactoryInterfaceFactory = 
            FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance();

        //Early Loading Here
        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TestGameDemoEarlyResourcesImageBasedAnimationInterfaceFactoryInterfaceFactory());

        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TestGameDemoEarlyResourcesOpenGLESImageBasedAnimationInterfaceFactoryInterfaceFactory());
    }
}
