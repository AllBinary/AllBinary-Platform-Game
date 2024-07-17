package org.allbinary.game.testgamedemo;

import org.allbinary.view.AllBinaryMidletOpenGLSurfaceView;
import org.allbinary.logic.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;

public class TestGameDemoJOGLOpenGLESView 
extends AllBinaryMidletOpenGLSurfaceView
{	
    private final String TAG = "TestGameDemoJOGLOpenGLESView";
    
	public TestGameDemoJOGLOpenGLESView() {
                
                PreLogUtil.put(CommonStrings.getInstance().START, TAG, CommonStrings.getInstance().CONSTRUCTOR);
	}
}
