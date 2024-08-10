package org.allbinary.game.testgamedemo;

import org.allbinary.graphics.opengles.OpenGLThreadUtil;
import org.allbinary.view.AllBinaryMidletOpenGLSurfaceView;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.view.OptimizedGLSurfaceView;

public class TestGameDemoJOGLOpenGLESView 
extends AllBinaryMidletOpenGLSurfaceView
{	
    private final String TAG = "TestGameDemoJOGLOpenGLESView";
    
	public TestGameDemoJOGLOpenGLESView() {
                
            PreLogUtil.put(commonStrings.START, TAG, commonStrings.CONSTRUCTOR);
                
            this.setRenderMode(OptimizedGLSurfaceView.RENDERMODE_CONTINUOUSLY);

            OpenGLThreadUtil.getInstance().set(this);
                
	}
}
