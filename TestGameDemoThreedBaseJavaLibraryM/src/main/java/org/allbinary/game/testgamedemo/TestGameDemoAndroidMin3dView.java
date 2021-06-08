package org.allbinary.game.testgamedemo;

import min3d.core.SceneController;

import org.allbinary.android.view.AllBinaryMidletMin3dSurfaceView;
import org.allbinary.graphics.opengles.OpenGLThreadUtil;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import org.allbinary.logic.basic.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;

public class TestGameDemoAndroidMin3dView 
extends AllBinaryMidletMin3dSurfaceView
{
    public TestGameDemoAndroidMin3dView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        PreLogUtil.put(CommonStrings.getInstance().START, this, CommonStrings.getInstance().CONSTRUCTOR);
        
        SceneController sceneController = 
            TestGameDemoAllBinarySceneControllerFactory.getInstance();

        this.setRenderer(sceneController.getRenderer());

        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        OpenGLThreadUtil.getInstance().set(this);
    }
}
