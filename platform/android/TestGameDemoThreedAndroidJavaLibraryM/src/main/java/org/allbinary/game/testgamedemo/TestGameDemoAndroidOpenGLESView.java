package org.allbinary.game.testgamedemo;

import android.content.Context;
import android.util.AttributeSet;

import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.view.AllBinaryMidletOpenGLSurfaceView;

public class TestGameDemoAndroidOpenGLESView 
extends AllBinaryMidletOpenGLSurfaceView
{	
    private final String TAG = "TestGameDemoAndroidOpenGLESView";
    
	public TestGameDemoAndroidOpenGLESView(
	        Context context, AttributeSet attrs) {
		super(context, attrs);
                
                final CommonStrings commonStrings = CommonStrings.getInstance();
                PreLogUtil.put(commonStrings.START, TAG, commonStrings.CONSTRUCTOR);
	}
}
