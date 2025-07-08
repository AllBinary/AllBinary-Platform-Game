package org.allbinary.game.testgamedemo;

import org.allbinary.android.view.AllBinaryMidletView;
import android.content.Context;
import android.util.AttributeSet;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;

public class TestGameDemoAndroidView extends AllBinaryMidletView
{
    //protected final LogUtil logUtil = LogUtil.getInstance();
	
    private final String TAG = "TestGameDemoAndroidView";
    
	public TestGameDemoAndroidView(Context context, AttributeSet attrs) {
		super(context, attrs);
                
                final CommonStrings commonStrings = CommonStrings.getInstance();
                PreLogUtil.put(commonStrings.START, TAG, commonStrings.CONSTRUCTOR);
	}
}
