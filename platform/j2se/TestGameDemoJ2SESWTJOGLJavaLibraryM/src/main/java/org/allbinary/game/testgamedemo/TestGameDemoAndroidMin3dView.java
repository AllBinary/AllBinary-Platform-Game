package org.allbinary.game.testgamedemo;

import min3d.core.SceneController;

import org.allbinary.graphics.opengles.OpenGLThreadUtil;
import org.allbinary.graphics.opengles.renderer.Renderer;
import org.allbinary.j2se.view.AllBinaryMidletMin3dSurfaceView;
import org.allbinary.logic.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;

public class TestGameDemoAndroidMin3dView 
extends AllBinaryMidletMin3dSurfaceView
{
    private final String TAG = "TestGameDemoAndroidMin3dView";
    
    public TestGameDemoAndroidMin3dView()
    {

        PreLogUtil.put(CommonStrings.getInstance().START, TAG, CommonStrings.getInstance().CONSTRUCTOR);
        
        final SceneController sceneController = 
            TestGameDemoAllBinarySceneControllerFactory.getInstance();

        this.setRenderer((Renderer) sceneController.getRenderer());

        //this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        OpenGLThreadUtil.getInstance().set(this);
    }
}
