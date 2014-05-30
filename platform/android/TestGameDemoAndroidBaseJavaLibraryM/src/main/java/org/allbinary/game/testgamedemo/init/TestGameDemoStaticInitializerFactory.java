/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.allbinary.game.testgamedemo.init;

import org.allbinary.game.testgamedemo.resource.TestGameDemoAndroidEarlyResourceInitialization;
import org.allbinary.game.testgamedemo.resource.TestGameDemoAndroidResourceInitialization;

import allbinary.game.init.BasicBuildGameInitializerFactory;
import allbinary.game.init.GameInitializationInterface;
import allbinary.game.resource.ResourceInitialization;

/**
 *
 * @author Berthelot, Travis
 * @version 1.0
 */
public class TestGameDemoStaticInitializerFactory extends BasicBuildGameInitializerFactory
{
    private static GameInitializationInterface STATIC = 
        new TestGameDemoAndroidStaticInitializer(
                new ResourceInitialization[]{
                        new TestGameDemoAndroidEarlyResourceInitialization(),
                        new TestGameDemoAndroidResourceInitialization(),
                        new TestGameDemoAndroidAnimationInterfaceFactoryEarlyResourceInitialization(),
                        new TestGameDemoAndroidAnimationInterfaceFactoryResourceInitialization(),
                        }, 15);

    public GameInitializationInterface getInstance()
    {
        return STATIC;
    }
}
