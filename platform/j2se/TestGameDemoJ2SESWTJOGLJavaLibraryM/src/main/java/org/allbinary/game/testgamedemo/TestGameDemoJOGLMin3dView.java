package org.allbinary.game.testgamedemo;

import min3d.core.Renderer;
import min3d.core.SceneController;

import org.allbinary.graphics.opengles.OpenGLThreadUtil;
import org.allbinary.j2se.view.AllBinaryMidletMin3dSurfaceView;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.view.OptimizedGLSurfaceView;

public class TestGameDemoJOGLMin3dView 
extends AllBinaryMidletMin3dSurfaceView
{
    //protected final LogUtil logUtil = LogUtil.getInstance();

    private final String TAG = "TestGameDemoJOGLMin3dView";
    
    public TestGameDemoJOGLMin3dView()
    {

        PreLogUtil.put(commonStrings.START, TAG, commonStrings.CONSTRUCTOR);
        
        final SceneController sceneController = TestGameDemoAllBinarySceneControllerFactory.getInstance();

        this.setRenderer((Renderer) sceneController.getRenderer());

        this.setRenderMode(OptimizedGLSurfaceView.RENDERMODE_CONTINUOUSLY);

        OpenGLThreadUtil.getInstance().set(this);
    }
}
