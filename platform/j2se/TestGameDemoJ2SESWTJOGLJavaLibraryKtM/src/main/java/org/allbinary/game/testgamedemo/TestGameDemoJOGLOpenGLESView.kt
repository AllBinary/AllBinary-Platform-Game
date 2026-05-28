
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.graphics.opengles.OpenGLThreadUtil
import org.allbinary.view.AllBinaryMidletOpenGLSurfaceView
import org.allbinary.logic.communication.log.PreLogUtil
import org.allbinary.view.OptimizedGLSurfaceView

open public class TestGameDemoJOGLOpenGLESView : AllBinaryMidletOpenGLSurfaceView {
        

    private val TAG: String = "TestGameDemoJOGLOpenGLESView"
public constructor (){
PreLogUtil.put(commonStrings!!.START, TAG, commonStrings!!.CONSTRUCTOR)
this.setRenderMode(OptimizedGLSurfaceView.RENDERMODE_CONTINUOUSLY)
OpenGLThreadUtil.getInstance()!!.set(this)
}


}
                
            

