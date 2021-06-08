package org.allbinary.game.testgamedemo;

import org.allbinary.graphics.threed.min3d.AllBinarySceneController;
import org.allbinary.graphics.threed.min3d.TestGameDemoSceneController;

public class TestGameDemoAllBinarySceneControllerFactory
{
    private static final AllBinarySceneController instance = new TestGameDemoSceneController();

    public static final AllBinarySceneController getInstance()
    {
        return instance;
    }
}
