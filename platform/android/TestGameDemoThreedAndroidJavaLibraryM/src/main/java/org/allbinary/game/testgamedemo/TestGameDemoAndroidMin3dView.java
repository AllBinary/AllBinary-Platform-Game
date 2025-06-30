package org.allbinary.game.testgamedemo;

import min3d.core.SceneController;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import org.allbinary.graphics.opengles.OpenGLThreadUtil;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.view.AllBinaryMidletMin3dSurfaceView;

public class TestGameDemoAndroidMin3dView 
extends AllBinaryMidletMin3dSurfaceView
{
    private final String TAG = "TestGameDemoAndroidMin3dView";
    
    public TestGameDemoAndroidMin3dView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        final CommonStrings commonStrings = CommonStrings.getInstance();
        PreLogUtil.put(commonStrings.START, TAG, commonStrings.CONSTRUCTOR);
        
        SceneController sceneController = 
            TestGameDemoAllBinarySceneControllerFactory.getInstance();

        this.setRenderer((GLSurfaceView.Renderer) sceneController.getRenderer());

        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        OpenGLThreadUtil.getInstance().set(this);
    }
}
