package org.allbinary.game.testgamedemo.init;

import org.allbinary.game.init.BasicBuildGameInitializerFactory;
import org.allbinary.game.init.GameInitializationInterface;
import org.allbinary.game.resource.ResourceInitialization;

public class TestGameDemoStaticInitializerFactory
   extends BasicBuildGameInitializerFactory
{
    private static GameInitializationInterface STATIC = 
        new TestGameDemoBaseJ2SESWTJOGLStaticInitializer(
                new ResourceInitialization[]{
                        new TestGameDemoJ2SESWTJOGLEarlyResourceInitialization(),
                        new TestGameDemoJ2SESWTJOGLResourceInitialization(),
                        new TestGameDemoJ2SESWTJOGLAnimationInterfaceFactoryEarlyResourceInitialization(),
                        new TestGameDemoJ2SESWTJOGLAnimationInterfaceFactoryResourceInitialization(),
                },                
                15);

    public GameInitializationInterface getInstance()
    {
        return STATIC;
    }
}
