package org.allbinary.game.testgamedemo;

import org.allbinary.view.AllBinaryMidletOpenGLSurfaceView;
import org.allbinary.logic.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;

public class TestGameDemoAndroidOpenGLESView 
extends AllBinaryMidletOpenGLSurfaceView
{	
    private final String TAG = "TestGameDemoAndroidOpenGLESView";
    
	public TestGameDemoAndroidOpenGLESView() {
                
                PreLogUtil.put(CommonStrings.getInstance().START, TAG, CommonStrings.getInstance().CONSTRUCTOR);
	}
}
