package org.allbinary.game.testgamedemo;

import org.allbinary.android.view.AllBinaryMidletView;
import android.content.Context;
import android.util.AttributeSet;
import org.allbinary.logic.basic.string.CommonStrings;
import org.allbinary.logic.communication.log.PreLogUtil;

public class TestGameDemoAndroidView extends AllBinaryMidletView
{	
	public TestGameDemoAndroidView(Context context, AttributeSet attrs) {
		super(context, attrs);
                
                PreLogUtil.put(CommonStrings.getInstance().START, this, CommonStrings.getInstance().CONSTRUCTOR);
	}
}
