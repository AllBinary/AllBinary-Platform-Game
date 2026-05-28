
        /* Generated Code Do Not Modify */
        package org.allbinary.animation.image




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import java.util.Hashtable
import org.allbinary.graphics.opengles.OpenGLFeatureFactory
import org.allbinary.graphics.threed.min3d.Min3dSceneResourcesFactory
import org.allbinary.image.opengles.OpenGLImageCacheFactory
import org.allbinary.animation.AnimationInterfaceFactoryInterface
import org.allbinary.animation.NullRotationAnimationFactory
import org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.game.combat.damage.ExplosionResources
import org.allbinary.game.configuration.feature.Features
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import org.allbinary.image.ImageCache

open public class TestGameDemoGameResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory : BaseResourceAnimationInterfaceFactoryInterfaceFactory {
        
public constructor ()                        

                            : super("OpenGL Image Animations", Hashtable<Any, Any>(), Hashtable<Any, Any>(), Hashtable<Any, Any>()){


                            //For kotlin this is before the body of the constructor.
                    
}


    private var index: Int = 1

                @Throws(Exception::class)
            
    open fun init(level: Int)
        //nullable = true from not(false or (false and false)) = true
{
var level = level

    
                        if(this.isInitialized())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                

    var portion: Int = 120


    var loadingString: String = this.toString() +" Loading: "

index= 1

    var progressCanvas: ProgressCanvas = ProgressCanvasFactory.getInstance()!!

progressCanvas!!.addPortion(portion, loadingString, index++)

    var imageCache: ImageCache = OpenGLImageCacheFactory.getInstance()!!


    var min3dSceneResourcesFactory: Min3dSceneResourcesFactory = Min3dSceneResourcesFactory.getInstance()!!

progressCanvas!!.addPortion(portion, loadingString, index++)

    var explosionResources: ExplosionResources = ExplosionResources.getInstance()!!

this.add(explosionResources!!.EXPLOSION_60_RESOURCE, NullRotationAnimationFactory.getFactoryInstance())
progressCanvas!!.addPortion(portion, loadingString, index++)
this.add(explosionResources!!.HALF_EXPLOSION_RESOURCE, NullRotationAnimationFactory.getFactoryInstance())
progressCanvas!!.addPortion(portion, loadingString, index++)
this.add(explosionResources!!.THIRD_EXPLOSION_RESOURCE, NullRotationAnimationFactory.getFactoryInstance())

    var basicAnimationInterfaceFactoryInterfaceArray: Array<AnimationInterfaceFactoryInterface?>

progressCanvas!!.addPortion(portion, loadingString, index++)
super.init(level)
}


    open fun isFeature()
        //nullable = true from not(false or (false and true)) = true
: Boolean{

    var features: Features = Features.getInstance()!!


    var graphicsFeatureFactory: GraphicsFeatureFactory = GraphicsFeatureFactory.getInstance()!!


    var openGLFeatureFactory: OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()!!


    
                        if(features.isFeature(graphicsFeatureFactory!!.IMAGE_GRAPHICS) && features.isFeature(graphicsFeatureFactory!!.IMAGE_TO_ARRAY_GRAPHICS) && features.isDefault(openGLFeatureFactory!!.OPENGL) && (features.isFeature(openGLFeatureFactory!!.OPENGL_2D_AND_3D) || features.isFeature(openGLFeatureFactory!!.OPENGL_3D)))
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return true

                                    }
                                
                        else {
                            


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return false

                        }
                            
}


}
                
            

