
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import min3d.core.SceneController
import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import org.allbinary.graphics.opengles.OpenGLThreadUtil
import org.allbinary.string.CommonStrings
import org.allbinary.logic.communication.log.PreLogUtil
import org.allbinary.view.AllBinaryMidletMin3dSurfaceView

open public class TestGameDemoAndroidMin3dView : AllBinaryMidletMin3dSurfaceView {
        

    private val TAG: String = "TestGameDemoAndroidMin3dView"
public constructor (context: Context, attrs: AttributeSet)                        

                            : super(context, attrs){
var context = context
var attrs = attrs


                            //For kotlin this is before the body of the constructor.
                    

    var commonStrings: CommonStrings = CommonStrings.getInstance()!!

PreLogUtil.put(commonStrings!!.START, TAG, commonStrings!!.CONSTRUCTOR)

    var sceneController: SceneController = TestGameDemoAllBinarySceneControllerFactory.getInstance()!!

this.setRenderer(sceneController!!.getRenderer() as GLSurfaceView.Renderer)
this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY)
OpenGLThreadUtil.getInstance()!!.set(this)
}


}
                
            

