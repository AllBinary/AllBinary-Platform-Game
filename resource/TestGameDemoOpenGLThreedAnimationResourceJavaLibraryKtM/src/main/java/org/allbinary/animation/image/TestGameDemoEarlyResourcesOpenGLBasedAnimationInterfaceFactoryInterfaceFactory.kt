
        /* Generated Code Do Not Modify */
        package org.allbinary.animation.image




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import java.util.Hashtable
import org.allbinary.animation.NullSpecialAnimationFactory
import org.allbinary.game.resource.ResourceLoadingLevelFactory
import org.allbinary.graphics.opengles.OpenGLFeatureFactory
import org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.game.configuration.feature.Features
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory
import org.allbinary.game.displayable.canvas.TitleResource
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import org.allbinary.logic.communication.log.LogFactory
import org.allbinary.logic.communication.log.LogUtil

open public class TestGameDemoEarlyResourcesOpenGLBasedAnimationInterfaceFactoryInterfaceFactory : BaseResourceAnimationInterfaceFactoryInterfaceFactory {
        

    val logUtil: LogUtil = LogUtil.getInstance()!!
public constructor ()                        

                            : super("Early OpenGL Animations", Hashtable<Any, Any>(), Hashtable<Any, Any>(), Hashtable<Any, Any>()){


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
this.add(TitleResource.RESOURCE_TITLE, NullSpecialAnimationFactory.getFactoryInstance())
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


    
                        if(features.isFeature(graphicsFeatureFactory!!.IMAGE_GRAPHICS) && features.isFeature(graphicsFeatureFactory!!.IMAGE_TO_ARRAY_GRAPHICS) && features.isDefault(openGLFeatureFactory!!.OPENGL) && !(features.isFeature(openGLFeatureFactory!!.OPENGL_2D_AND_3D) || features.isFeature(openGLFeatureFactory!!.OPENGL_3D)))
                        
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
                
            

