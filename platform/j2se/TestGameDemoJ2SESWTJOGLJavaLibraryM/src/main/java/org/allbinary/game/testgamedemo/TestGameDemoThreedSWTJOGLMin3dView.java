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
package org.allbinary.game.testgamedemo;

import min3d.core.Renderer;
import min3d.core.SceneController;
import org.allbinary.graphics.opengles.OpenGLThreadUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.logic.string.CommonStrings;

/**
 *
 * @author User
 */
public class TestGameDemoThreedSWTJOGLMin3dView {
    
    private final Renderer renderer;
    
    public TestGameDemoThreedSWTJOGLMin3dView() {
        
        PreLogUtil.put(CommonStrings.getInstance().START, this, CommonStrings.getInstance().CONSTRUCTOR);
        
        SceneController sceneController = 
            TestGameDemoAllBinarySceneControllerFactory.getInstance();

        this.renderer = (Renderer) sceneController.getRenderer();

        //this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        OpenGLThreadUtil.getInstance().set(this);    
        
    }
    
}
