
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import min3d.core.Renderer
import min3d.core.SceneController
import org.allbinary.graphics.opengles.OpenGLThreadUtil
import org.allbinary.j2se.view.AllBinaryMidletMin3dSurfaceView
import org.allbinary.logic.communication.log.PreLogUtil
import org.allbinary.view.OptimizedGLSurfaceView

open public class TestGameDemoJOGLMin3dView : AllBinaryMidletMin3dSurfaceView {
        

    private val TAG: String = "TestGameDemoJOGLMin3dView"
public constructor (){
PreLogUtil.put(commonStrings!!.START, TAG, commonStrings!!.CONSTRUCTOR)

    var sceneController: SceneController = TestGameDemoAllBinarySceneControllerFactory.getInstance()!!

this.setRenderer(sceneController!!.getRenderer() as Renderer)
this.setRenderMode(OptimizedGLSurfaceView.RENDERMODE_CONTINUOUSLY)
OpenGLThreadUtil.getInstance()!!.set(this)
}


}
                
            

