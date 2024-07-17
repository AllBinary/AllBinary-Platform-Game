/*
 * AllBinary Open License Version 1
 * Copyright (c) 2022 AllBinary
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
package org.microemu.app;

import org.allbinary.device.OpenGLESGraphicsFactory;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GameFeatureFactory;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;
import org.allbinary.game.configuration.feature.InputFeatureFactory;
import org.allbinary.game.configuration.feature.SensorFeatureFactory;
import org.allbinary.graphics.opengles.OpenGLFeatureFactory;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.CommonStrings;
import org.microemu.opengles.device.PlatformOpenGLESGraphicsFactory;

/**
 *
 * @author User
 */
public class NativeBareMain {

    public static void main(final String args[]) {
        
        final Features features = Features.getInstance();

        final OpenGLFeatureFactory openGLFeatureFactory = OpenGLFeatureFactory.getInstance();
        
        try {
            
            //features.addDefault(openGLFeatureFactory.OPENGL_2D);
            features.addDefault(openGLFeatureFactory.OPENGL_2D_AND_3D);
            //features.addDefault(openGLFeatureFactory.OPENGL_3D);
            //features.addDefault(openGLFeatureFactory.OPENGL_SIMPLE_OBJECT3D_PROCESSOR);
            //features.addDefault(openGLFeatureFactory.OPENGL_SIMPLE_TEXTURE_PROCESSOR);

            OpenGLESGraphicsFactory.getInstance().set(new PlatformOpenGLESGraphicsFactory());
            //OpenGLESGraphicsFactory.getInstance().set(new PlatformDisplayMin3dGraphicsFactory());
            
        } catch(Exception e) {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, features, CommonStrings.getInstance().PROCESS, e));
        }
        
        BareMain.main2(args, "TestGameDemoMIDlet", "/testgamedemo_icon.ico");
    }

}
