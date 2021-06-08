package org.allbinary.game.testgamedemo.init;

import org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.animation.image.TestGameDemoEarlyResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory;
//import org.allbinary.game.image.TestGameDemoEarlyResourcesImageArrayBasedAnimationInterfaceFactoryInterfaceFactory;
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

        //featuredAnimationInterfaceFactoryInterfaceFactory.add(
                //new TestGameDemoEarlyResourcesImageArrayBasedAnimationInterfaceFactoryInterfaceFactory());

        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TestGameDemoEarlyResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory());
        
    }
}
