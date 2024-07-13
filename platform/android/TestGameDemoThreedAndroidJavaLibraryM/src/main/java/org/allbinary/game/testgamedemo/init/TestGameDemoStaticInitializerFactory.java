package org.allbinary.game.testgamedemo.init;

import org.allbinary.game.init.BasicBuildGameInitializerFactory;
import org.allbinary.game.init.GameInitializationInterface;
import org.allbinary.game.resource.ResourceInitialization;

public class TestGameDemoStaticInitializerFactory
   extends BasicBuildGameInitializerFactory
{
    private static GameInitializationInterface STATIC = 
        new TestGameDemoBaseAndroidStaticInitializer(
                new ResourceInitialization[]{
                        new TestGameDemoAndroidEarlyResourceInitialization(),
                        new TestGameDemoAndroidResourceInitialization(),
                        new TestGameDemoAndroidAnimationInterfaceFactoryEarlyResourceInitialization(),
                        new TestGameDemoAndroidAnimationInterfaceFactoryResourceInitialization(),
                },                
                15);

    public GameInitializationInterface getInstance()
    {
        return STATIC;
    }
}
