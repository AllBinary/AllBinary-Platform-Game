package org.allbinary.game.testgamedemo.init;

import org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.animation.image.TestGameDemoGameResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.animation.image.TestGameDemoOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory;
//import org.allbinary.game.image.TestGameDemoGameResourcesImageArrayBasedAnimationInterfaceFactoryInterfaceFactory;
//import org.allbinary.game.image.TestGameDemoImageArrayBasedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.game.resource.ResourceInitialization;
//import org.allbinary.input.motion.button.TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.input.motion.button.TouchButtonResourceOpenGLESAnimationInterfaceFactoryInterfaceFactory;

public class TestGameDemoJ2SESWTJOGLAnimationInterfaceFactoryResourceInitialization
extends ResourceInitialization
{
    public TestGameDemoJ2SESWTJOGLAnimationInterfaceFactoryResourceInitialization()
    {
    }

    public void init()
    throws Exception
    {
        FeaturedAnimationInterfaceFactoryInterfaceFactory 
        featuredAnimationInterfaceFactoryInterfaceFactory = 
            FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance();
        
        //TWB - TouchButton
        //featuredAnimationInterfaceFactoryInterfaceFactory.add(
                //new TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory());
        
        //featuredAnimationInterfaceFactoryInterfaceFactory.add(
                //new TestGameDemoGameResourcesImageArrayBasedAnimationInterfaceFactoryInterfaceFactory());
        
        //featuredAnimationInterfaceFactoryInterfaceFactory.add(
                //new TestGameDemoImageArrayBasedAnimationInterfaceFactoryInterfaceFactory());

        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TouchButtonResourceOpenGLESAnimationInterfaceFactoryInterfaceFactory());

        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TestGameDemoGameResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory());
        
        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TestGameDemoOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory());
    }
}
