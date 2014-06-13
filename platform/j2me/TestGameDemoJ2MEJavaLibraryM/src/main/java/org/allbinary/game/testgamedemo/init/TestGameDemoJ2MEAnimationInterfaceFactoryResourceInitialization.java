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

import org.allbinary.animation.image.TestGameDemoImageBasedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.animation.image.TestGameDemoOpenGLESImageBasedAnimationInterfaceFactoryInterfaceFactory;

import allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory;
import allbinary.game.resource.ResourceInitialization;

public class TestGameDemoJ2MEAnimationInterfaceFactoryResourceInitialization
extends ResourceInitialization
{
    public TestGameDemoJ2MEAnimationInterfaceFactoryResourceInitialization()
    {
    }
    
    public void init()
    throws Exception
    //throws Exception
    {
        FeaturedAnimationInterfaceFactoryInterfaceFactory featuredAnimationInterfaceFactoryInterfaceFactory = 
                FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance();

        //Normal Loading Here
        
        //TWB - TouchButton
        //featuredAnimationInterfaceFactoryInterfaceFactory.add(
                //new TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory());
        
        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TestGameDemoImageBasedAnimationInterfaceFactoryInterfaceFactory());

        //featuredAnimationInterfaceFactoryInterfaceFactory.add(
          //      new TouchButtonResourceOpenGLESAnimationInterfaceFactoryInterfaceFactory());
        
        featuredAnimationInterfaceFactoryInterfaceFactory.add(
                new TestGameDemoOpenGLESImageBasedAnimationInterfaceFactoryInterfaceFactory());
    }
}
