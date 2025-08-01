package org.allbinary.graphics.threed.min3d;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import min3d.core.SceneController;

import org.microemu.opengles.device.PlatformOpenGLESGraphicsFactory;

import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.graphics.displayable.DisplayInfoSingleton;
import org.allbinary.device.OpenGLESGraphicsCompositeFactory;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.testgamedemo.R;
import org.allbinary.graphics.opengles.OpenGLFeatureFactory;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStateStrings;
import org.allbinary.view.OptimizedGLSurfaceView;

/**
 * Extend this class when creating your min3d-based Activity. 
 * Then, override initScene() and updateScene() for your main
 * 3D logic.
 * 
 * Override onCreateSetContentView() to change layout, if desired.
 * 
 * To update 3d scene-related variables from within the the main UI thread,  
 * override onUpdateScene() and onUpdateScene() as needed.
 */
public class RendererActivity extends Activity //implements ISceneController
{
    protected final LogUtil logUtil = LogUtil.getInstance();

    protected final CommonStrings commonStrings = CommonStrings.getInstance();
    protected final CommonStateStrings commonStateStrings = CommonStateStrings.getInstance();
    
    //protected GLSurfaceView _glSurfaceView;
    protected OptimizedGLSurfaceView _glSurfaceView;
	
    private boolean _renderContinuously;    

    //TWB scenecontroller was this RendererActivity
    SceneController sceneController;
        
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);

            ResourceUtil.getInstance().setContext(this);
            ResourceUtil.getInstance().setResources(this.getResources());

            final Features features = Features.getInstance();

            final OpenGLFeatureFactory openGLFeatureFactory
                    = OpenGLFeatureFactory.getInstance();

            //features.addDefault(openGLFeatureFactory.OPENGL_2D);
            //features.addDefault(openGLFeatureFactory.OPENGL_2D_AND_3D);
            features.addDefault(openGLFeatureFactory.OPENGL_3D);
            //features.addDefault(openGLFeatureFactory.OPENGL_SIMPLE_OBJECT3D_PROCESSOR);
            //features.addDefault(openGLFeatureFactory.OPENGL_SIMPLE_TEXTURE_PROCESSOR);

            OpenGLESGraphicsCompositeFactory.getInstance().set(new PlatformOpenGLESGraphicsFactory());
            //OpenGLESGraphicsFactory.getInstance().set(new AndroidDisplayMin3dGraphicsFactory());
            
            //_glSurfaceView = new GLSurfaceView(this);
            //_glSurfaceView = new AllBinaryMidletMin3dSurfaceView2(this);
            this.setContentView(R.layout.testgamedemo_min3d_layout);
            //_glSurfaceView = (GLSurfaceView) this.findViewById(R.id.testgamedemo_gl);
            _glSurfaceView = (OptimizedGLSurfaceView) this.findViewById(R.id.testgamedemo_gl);

            //TWB
            DisplayInfoSingleton displayInfo = DisplayInfoSingleton.getInstance();
            displayInfo.setLastSize(_glSurfaceView.getWidth(), _glSurfaceView.getHeight(), commonStateStrings.CREATE);
            //End - TWB

            //glSurfaceViewConfig();
            //_glSurfaceView.setRenderer(r);
            //_glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

            setContentView(_glSurfaceView);

        } catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, commonStateStrings.CREATE, e);
        }
    }
	
	@Override
	protected void onResume() 
	{
		super.onResume();
		_glSurfaceView.onResume();
	}
	
	@Override
	protected void onPause() 
	{
		super.onPause();
		_glSurfaceView.onPause();
	}
    
    /**
     * Setting this to false stops the render loop, and initScene() and onInitScene() will no longer fire.
     * Setting this to true resumes it. 
     */
    public void renderContinuously(boolean $b)
    {
    	_renderContinuously = $b;
    	if (_renderContinuously)
    		_glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    	
    	else
    		_glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    
}
 