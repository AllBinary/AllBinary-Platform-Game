
        /* Generated Code Do Not Modify */
        package org.allbinary.graphics.threed.min3d




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import android.app.Activity
import android.opengl.GLSurfaceView
import android.os.Bundle
import min3d.core.SceneController
import org.microemu.opengles.device.PlatformOpenGLESGraphicsFactory
import org.allbinary.data.resource.ResourceUtil
import org.allbinary.graphics.displayable.DisplayInfoSingleton
import org.allbinary.device.OpenGLESGraphicsCompositeFactory
import org.allbinary.game.configuration.feature.Features
import org.allbinary.game.testgamedemo.R
import org.allbinary.graphics.opengles.OpenGLFeatureFactory
import org.allbinary.string.CommonStrings
import org.allbinary.logic.communication.log.LogUtil
import org.allbinary.string.CommonStateStrings
import org.allbinary.view.OptimizedGLSurfaceView

open public class RendererActivity : Activity {
        

            //Auto Generated
            public constructor() : super()
            {
            }            
        
    val logUtil: LogUtil = LogUtil.getInstance()!!

    val commonStrings: CommonStrings = CommonStrings.getInstance()!!

    val commonStateStrings: CommonStateStrings = CommonStateStrings.getInstance()!!

    var _glSurfaceView: OptimizedGLSurfaceView

    private var _renderContinuously: Boolean= false

    var sceneController: SceneController

    override fun onCreate(savedInstanceState: Bundle?)
        //nullable = true from not(false or (false and false)) = true
{
var savedInstanceState = savedInstanceState

        try {
            super.onCreate(savedInstanceState)
ResourceUtil.getInstance()!!.setContextFromActivity(this)
ResourceUtil.getInstance()!!.setResources(this.getResources())

    var features: Features = Features.getInstance()!!


    var openGLFeatureFactory: OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()!!

features.addDefault(openGLFeatureFactory!!.OPENGL_3D)
OpenGLESGraphicsCompositeFactory.getInstance()!!.set(PlatformOpenGLESGraphicsFactory())
this.setContentView(R.layout.testgamedemo_min3d_layout)
_glSurfaceView= this.findViewById(R.id.testgamedemo_gl) as OptimizedGLSurfaceView

    var displayInfo: DisplayInfoSingleton = DisplayInfoSingleton.getInstance()!!

displayInfo!!.setLastSize(_glSurfaceView.getWidth(), _glSurfaceView.getHeight(), commonStateStrings!!.CREATE)
setContentView(_glSurfaceView)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, commonStateStrings!!.CREATE, e)
}

}


    override fun onResume()
        //nullable = true from not(false or (false and true)) = true
{
super.onResume()
_glSurfaceView.onResume()
}


    override fun onPause()
        //nullable = true from not(false or (false and true)) = true
{
super.onPause()
_glSurfaceView.onPause()
}


    open fun renderContinuously($b: Boolean)
        //nullable = true from not(false or (false and false)) = true
{
var $b = $b
_renderContinuously= $b

    
                        if(_renderContinuously)
                        _glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY)
                             else 
    
                        if()
                        
}


}
                
            

