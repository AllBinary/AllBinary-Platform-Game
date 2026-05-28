
        /* Generated Code Do Not Modify */
        package org.allbinary.animation.image




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import java.util.Hashtable
import org.allbinary.game.resource.ResourceLoadingLevelFactory
import org.allbinary.graphics.opengles.OpenGLFeatureFactory
import org.allbinary.graphics.threed.min3d.Min3dSceneResourcesFactory
import org.allbinary.graphics.threed.min3d.TitleThreedResources
import org.allbinary.animation.IndexedAnimation
import org.allbinary.animation.SingletonAnimationInterfaceFactory
import org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.animation.threed.ThreedAnimationSingletonFactory
import org.allbinary.game.configuration.feature.Features
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory
import org.allbinary.game.displayable.canvas.TitleResource
import org.allbinary.game.testgamedemo.canvas.TestGameDemoTitleAnimationFactory
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import org.allbinary.logic.communication.log.LogUtil

open public class TestGameDemoEarlyResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory : BaseResourceAnimationInterfaceFactoryInterfaceFactory {
        

    val logUtil: LogUtil = LogUtil.getInstance()!!
public constructor ()                        

                            : super("Early OpenGL 3D Animations", Hashtable<Any, Any>(), Hashtable<Any, Any>(), Hashtable<Any, Any>()){


                            //For kotlin this is before the body of the constructor.
                    
}


                @Throws(Exception::class)
            
    open fun init(level: Int)
        //nullable = true from not(false or (false and false)) = true
{
    //var level = level
logUtil!!.putF(this.getName(), this, "init")

    
                        if(this.isInitialized())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                

    var resourceLoadingLevelFactory: ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()!!


    var portion: Int = 120


    
                        if(level == resourceLoadingLevelFactory!!.LOAD_EARLY.getLevel())
                        
                                    {
                                    portion= 10

                                    }
                                

    var loadingString: String = this.toString() +" Loading: "


    var index: Int = 1


    var progressCanvas: ProgressCanvas = ProgressCanvasFactory.getInstance()!!

progressCanvas!!.addPortion(portion, loadingString, index++)

    var min3dSceneResourcesFactory: Min3dSceneResourcesFactory = Min3dSceneResourcesFactory.getInstance()!!


    var animationInterfaceArrayTemp: Array<IndexedAnimation?> = TestGameDemoTitleAnimationFactory.getInstance()!!.getArrayInstance()!!


    var animationInterfaceArray: Array<IndexedAnimation?> = arrayOfNulls(3)

animationInterfaceArray[0]= animationInterfaceArrayTemp[0]!!
animationInterfaceArray[1]= animationInterfaceArrayTemp[1]!!

    var titleThreedResources: TitleThreedResources = TitleThreedResources.getInstance()!!

animationInterfaceArray[2]= ThreedAnimationSingletonFactory(min3dSceneResourcesFactory!!.get(titleThreedResources!!.RESOURCE_TITLE_THREE)[0]!!).
                            getInstance(0) as IndexedAnimation
this.add(TitleResource.RESOURCE_TITLE, SingletonAnimationInterfaceFactory(TestGameDemoThreedTitleAnimationFactory.getIntance()!!.getInstance(animationInterfaceArray)))
super.init(level)
}


    open fun isLoadingLevel(level: Int)
        //nullable = true from not(false or (false and false)) = true
: Boolean{
var level = level

    var resourceLoadingLevelFactory: ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()!!


    
                        if(level == resourceLoadingLevelFactory!!.LOAD_EARLY.getLevel())
                        
                                    {
                                    logUtil!!.putF(this.getName(), this, "isLoadingLevel")



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return true

                                    }
                                
                        else {
                            


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return super.isLoadingLevel(level)

                        }
                            
}


    open fun isFeature()
        //nullable = true from not(false or (false and true)) = true
: Boolean{

    var features: Features = Features.getInstance()!!


    var graphicsFeatureFactory: GraphicsFeatureFactory = GraphicsFeatureFactory.getInstance()!!


    var openGLFeatureFactory: OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()!!


    
                        if(features.isFeature(graphicsFeatureFactory!!.IMAGE_GRAPHICS) && features.isFeature(graphicsFeatureFactory!!.IMAGE_TO_ARRAY_GRAPHICS) && features.isDefault(openGLFeatureFactory!!.OPENGL) && (features.isFeature(openGLFeatureFactory!!.OPENGL_2D_AND_3D) || features.isFeature(openGLFeatureFactory!!.OPENGL_3D)))
                        
                                    {
                                    logUtil!!.putF(this.getName(), this, "isFeature")



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return true

                                    }
                                
                        else {
                            


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return false

                        }
                            
}


}
                
            

