/*
 * AllBinary Open License Version 1
 * Copyright (c) 2025 AllBinary
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
package org.allbinary.graphics.opengles.shader;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.allbinary.graphics.opengles.NullOpenGLProcessorFactory;
import org.allbinary.graphics.opengles.OpenGLCapabilities;
import org.allbinary.graphics.opengles.OpenGLVersionValidator;
import org.allbinary.graphics.opengles.renderer.RendererStrings;
import org.allbinary.graphics.threed.min3d.AppShaderResources;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringUtil;

/**
 *
 * @author User
 */
public class AppRendererShaderUpdaterFactory extends ShaderUpdater {

    protected static final AppRendererShaderUpdaterFactory instance = new AppRendererShaderUpdaterFactory();

    /**
     * @return the instance
     */
    public static AppRendererShaderUpdaterFactory getInstance() {
        return instance;
    }

    private final RendererStrings renderStrings = RendererStrings.getInstance();
    
    private final OpenGLCapabilities openGLCapabilities = OpenGLCapabilities.getInstance();
    
    private ShaderManager shaderManager = ShaderManagerFactory.getInstance().create();
    private final AppShaderResources appShaderResources = AppShaderResources.getInstance();

    public final ShaderComposite[] shaderCompositeArray = {

        new PlatformShaderComposite(openGLCapabilities.VERSION_2_0, 
        new int[2],
        new SimpleCompositeShaderUpdater(StringUtil.getInstance().getArrayInstance(), StringUtil.getInstance().getArrayInstance(), new String[]{"a_Position", "a_Color"}),
        SimpleShaderInitializer.getInstance(),
        ModelViewProjection.getInstance(),
        null,
        null
        ),
                
        };

    public void onSurfaceCreated(final GL10 gl, final EGLConfig eglConfig) {

        final int max = 1024 * 32;
        final byte[] byteArray1 = new byte[max];
        
        final int size = shaderCompositeArray.length;

        shaderCompositeArray[0].textureEnableVertexAttribArrayOpenGLProcessor = NullOpenGLProcessorFactory.getInstance();
        shaderCompositeArray[0].textureDisableVertexAttribArrayOpenGLProcessor = NullOpenGLProcessorFactory.getInstance();

        final OpenGLVersionValidator openGLVersionValidator = OpenGLVersionValidator.getInstance();
        for (int index = 0; index < size; index++) {
            final ShaderComposite shaderComposite = shaderCompositeArray[index];
            
            if (openGLVersionValidator.isAvailable(shaderComposite.requiresOpenGLVersion)) {
                if (shaderManager == ShaderManager.getInstance()) {
                    LogUtil.put(LogFactory.getInstance("Shaders already loaded: " + index, this, renderStrings.ON_SURFACE_CREATED));
                } else {
                    shaderComposite.shaderStringArray[0] = appShaderResources.getVertexShader(index);
                    shaderComposite.shaderHandleArray[0] = shaderManager.loadShader(gl, shaderComposite.shaderStringArray[0], max, byteArray1, shaderManager.GL_VERTEX_SHADER);
                    LogUtil.put(LogFactory.getInstance("shaderHandle: " + shaderComposite.shaderHandleArray[0], this, this.rendererStrings.ON_SURFACE_CREATED));
                    shaderComposite.shaderStringArray[1] = appShaderResources.getFragmentShader(index);
                    shaderComposite.shaderHandleArray[1] = shaderManager.loadShader(gl, shaderComposite.shaderStringArray[1], max, byteArray1, shaderManager.GL_FRAGMENT_SHADER);
                    LogUtil.put(LogFactory.getInstance("shaderHandle: " + shaderComposite.shaderHandleArray[1], this, this.rendererStrings.ON_SURFACE_CREATED));
                    shaderComposite.init(gl);
                    LogUtil.put(LogFactory.getInstance("shader programHandle: " + shaderComposite.programHandle, this, this.rendererStrings.ON_SURFACE_CREATED));
                }

                shaderComposite.compositeShaderUpdater.onSurfaceCreated(gl, eglConfig, shaderComposite.programHandle);
            }
        }
        
        shaderManager = ShaderManager.getInstance();
    }
    
    public ShaderOpenGLProcessor[] getTestShaders() {
        final ShaderOpenGLProcessor[] shaderOpenGLProcessorArray = new ShaderOpenGLProcessor[]{
            //new SimpleExampleShaderOpenGLProcessor(this.shaderCompositeArray[0]),
            //new SimpleShaderWithTextureExampleOpenGLProcessor(0),
            //new GammaExampleTextureShaderOpenGLProcessor(this.shaderCompositeArray[1], this.shaderCompositeArray[2])
        };
        
        return shaderOpenGLProcessorArray;
    }
    
}
