/*
* AllBinary Open License Version 1
* Copyright (c) 2011 AllBinary
* 
* By agreeing to this license you and any business entity you represent are
* legally bound to the AllBinary Open License Version 1 legal agreement.
* 
* You may obtain the AllBinary Open License Version 1 legal agreement from
* AllBinary or the root directory of AllBinary's AllBinary Platform repository.
* 
* Created By: Travis Berthelot
* 
*/
package org.allbinary.input.motion.button;

import org.allbinary.input.motion.button.BaseTouchInput;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.input.gyro.SensorGameUpdateProcessor;


public class TestGameDemoTouchButtonsBuilder
extends BaseTouchInput
{
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final TestGameDemoTouchButtonsBuilder instance = 
            new TestGameDemoTouchButtonsBuilder();
    
    public static BaseTouchInput getInstance(
            SensorGameUpdateProcessor sensorGameUpdateProcessor)
    {
        return instance;
    }
    
    public void build()
    {
       logUtil.put(commonStrings.START, this, "build");
    }
}
