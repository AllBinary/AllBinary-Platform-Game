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
package org.allbinary.graphics.threed.min3d;

import org.allbinary.graphics.opengles.OpenGLCapabilities;

/**
 *
 * @author User
 */
public class AppShaderResources {
    
    protected static final AppShaderResources instance = new AppShaderResources();

    /**
     * @return the instance
     */
    public static AppShaderResources getInstance() {
        return instance;
    }

    public final String SIMPLE_VERTEX_SHADER_2 = "simple_vertex_shader_glsl";

    public final String SIMPLE_FRAGMENT_SHADER = "simple_fragment_shader_glsl";
     
    private final String[] VERTEX_ARRAY = {
        SIMPLE_VERTEX_SHADER_2,
    };
    
    private final String[] FRAGMENT_ARRAY = {
        SIMPLE_FRAGMENT_SHADER,
    };
    
    public String getVertexShader(final int shaderIndex) {
//        final OpenGLCapabilities openGLCapabilities = OpenGLCapabilities.getInstance();
//        if (openGLCapabilities.shaderVersion == 110) {
//            return this.SIMPLE_VERTEX_SHADER_110;
//        } else if (openGLCapabilities.shaderVersion == 120) {
//            return this.SIMPLE_VERTEX_SHADER_120;
//        } else if (openGLCapabilities.shaderVersion == 460) {
//            return this.SIMPLE_VERTEX_SHADER_460;
//        }
        
//        return this.SIMPLE_VERTEX_SHADER_110_COMPATIBILITY;

        return this.VERTEX_ARRAY[shaderIndex];
        
    }

    public String getFragmentShader(final int shaderIndex) {
//        final OpenGLCapabilities openGLCapabilities = OpenGLCapabilities.getInstance();
//        if (openGLCapabilities.shaderVersion == 110) {
//            return this.SIMPLE_FRAGMENT_SHADER_110;
//        } else if (openGLCapabilities.shaderVersion == 120) {
//            return this.SIMPLE_FRAGMENT_SHADER_120;
//        } else if (openGLCapabilities.shaderVersion == 460) {
//            return this.SIMPLE_FRAGMENT_SHADER_460;
//        } else if (openGLCapabilities.shaderVersion > 460) {
//            return this.SIMPLE_FRAGMENT_SHADER_460_COMPATIBILITY;
//        }
        
//        return this.SIMPLE_FRAGMENT_SHADER_110_COMPATIBILITY;

        return this.FRAGMENT_ARRAY[shaderIndex];
    }
    
}
