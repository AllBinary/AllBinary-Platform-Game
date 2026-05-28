
        /* Generated Code Do Not Modify */
        package org.allbinary.graphics.threed.min3d




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import javax.microedition.khronos.opengles.GL10
import min3d.core.Object3d
import min3d.core.TextureManager
import min3d.parser.ModelType
import min3d.parser.ModelTypeFactory
import min3d.vos.CameraFactory
import min3d.vos.light.Light
import org.allbinary.ThreedResources
import org.allbinary.animation.AnimationInterfaceFactoryInterface
import org.allbinary.animation.threed.ThreedAnimationSingletonFactory
import org.allbinary.game.identification.BasicGroupFactory
import org.allbinary.game.identification.Group
import org.allbinary.game.layer.AllBinaryGameLayerManager
import org.allbinary.game.layer.SimpleGameLayer
import org.allbinary.game.testgamedemo.layer.TestGameDemoLayerManager
import org.allbinary.graphics.PointFactory
import org.allbinary.graphics.Rectangle
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import org.allbinary.graphics.opengles.OpenGLCapabilities
import org.allbinary.graphics.opengles.OpenGLVersionValidator
import org.allbinary.graphics.opengles.shader.AppRendererShaderUpdaterFactory
import org.allbinary.graphics.threed.min3d.renderer.AllBinaryToMin3dRendererFactory
import org.allbinary.logic.communication.log.LogUtil
import org.allbinary.logic.communication.log.PreLogUtil
import org.allbinary.logic.java.bool.BooleanFactory
import org.allbinary.view.StaticViewPosition

open public class TestGameDemoSceneController : AllBinaryGameSceneController {
        

    val logUtil: LogUtil = LogUtil.getInstance()!!

    private val TAG: String = "TestGameDemoSceneController"

    private val openGLCapabilities: OpenGLCapabilities = OpenGLCapabilities.getInstance()!!
public constructor ()                        

                            : super(AllBinaryToMin3dRendererFactory(), CameraFactory(), AllBinarySceneFactory(), false, false){


                            //For kotlin this is before the body of the constructor.
                    
PreLogUtil.put(commonStrings!!.START, TAG, commonStrings!!.CONSTRUCTOR)
}


    private var initialized: Boolean= false

    val portion: Int = 100

    val loadingString: String = this.toString() +" Loading: "

    var index: Int= 0

    override fun updateScene()
        //nullable = true from not(false or (false and true)) = true
{
}


    override fun initScene(gl: GL10)
        //nullable = true from not(false or (false and false)) = true
{
var gl = gl

    var METHOD_NAME: String = "initScene"


        try {
            PreLogUtil.put(commonStrings!!.START, this, METHOD_NAME)
index= 1

    var glInstanceVersion: String = openGLCapabilities!!.glInstanceVersion


    var progressCanvas: ProgressCanvas = ProgressCanvasFactory.getInstance()!!

progressCanvas!!.addEarlyPortion(portion, loadingString, index++)

    var min3dSceneResourcesFactory: Min3dSceneResourcesFactory = Min3dSceneResourcesFactory.getInstance()!!


    var modelTypeFactory: ModelTypeFactory = ModelTypeFactory.getInstance()!!


    var OBJ: ModelType = modelTypeFactory!!.OBJ


    var FALSE: Boolean = BooleanFactory.getInstance()!!.FALSE


    var threedLoaderFactory: ThreedLoaderFactory = ThreedLoaderFactory.getInstance()!!


    var titleThreedResources: TitleThreedResources = TitleThreedResources.getInstance()!!


    
                        if(!this.initialized)
                        
                                    {
                                    ThreedResources.getInstance()!!.add()
progressCanvas!!.addEarlyPortion(portion, loadingString, index++)

    var light: Light = Light()


    
                        if(scene.getLights()!!.size() > 0)
                        
                                    {
                                    scene.getLights()!!.reset()

                                    }
                                
scene.getLights()!!.add(light)
PreLogUtil.put("Minimal 3d Example", this, METHOD_NAME)

                                    }
                                
                        else {
                            TextureManager.getInstance()!!.reset(gl)

                        }
                            
progressCanvas!!.addEarlyPortion(portion, loadingString, index++)

    var titleThreeObject3dContainer: Object3d = threedLoaderFactory!!.getObject3dInstance(titleThreedResources!!.RESOURCE_TITLE_THREE, gl, glInstanceVersion, OBJ, FALSE)!!

AppRendererShaderUpdaterFactory.getInstance()!!.setShaderComposite(titleThreeObject3dContainer)
min3dSceneResourcesFactory!!.add(titleThreedResources!!.RESOURCE_TITLE_THREE, arrayOf(titleThreeObject3dContainer))
progressCanvas!!.addEarlyPortion(portion, loadingString, index++)
progressCanvas!!.addEarlyPortion(portion, loadingString, index++)
PreLogUtil.put(commonStrings!!.END, this, METHOD_NAME)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, METHOD_NAME, e)
}

}


                @Throws(Exception::class)
            
    open fun buildScene(layerManager: AllBinaryGameLayerManager)
        //nullable = true from not(false or (false and false)) = true
{
var layerManager = layerManager

        try {
            PreLogUtil.put(commonStrings!!.START, this, "buildScene")

    var testGameDemoLayerManager: TestGameDemoLayerManager = layerManager as TestGameDemoLayerManager


    var min3dSceneResourcesFactory: Min3dSceneResourcesFactory = Min3dSceneResourcesFactory.getInstance()!!


    var titleThreedResources: TitleThreedResources = TitleThreedResources.getInstance()!!


    var titleThreeObject3dContainerArray: Array<Object3d?> = min3dSceneResourcesFactory!!.get(titleThreedResources!!.RESOURCE_TITLE_THREE)!!


    var groupInterface: Group = BasicGroupFactory.getInstance()!!.GOOD


    var animationInterfaceFactoryInterface: AnimationInterfaceFactoryInterface = ThreedAnimationSingletonFactory(titleThreeObject3dContainerArray[0]!!)


    var width: Int = 20


    var height: Int = 20


    var layerInfo: Rectangle = Rectangle(PointFactory.getInstance()!!.ZERO_ZERO, width, height)


    var simpleGameLayer: SimpleGameLayer = SimpleGameLayer(groupInterface, animationInterfaceFactoryInterface, layerInfo, StaticViewPosition(0, 0, 0))

titleThreeObject3dContainerArray[0]!!.getRotationOrigin()!!.y -= 90
testGameDemoLayerManager!!.append(simpleGameLayer)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, "buildScene", e)
}

}


    open fun processEarlyGameAction()
        //nullable = true from not(false or (false and true)) = true
{
}


    open fun processStartGameAction()
        //nullable = true from not(false or (false and true)) = true
{
}


    private val NAME: String = "TestGameDemo Scene"

    override fun toString()
        //nullable =  from not(false or (true and true)) = 
: String{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return NAME
}


}
                
            

