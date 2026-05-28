
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo.init




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.animation.image.TestGameDemoImageBasedAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.animation.image.TestGameDemoOpenGLESImageBasedAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.game.resource.ResourceInitialization
import org.allbinary.input.motion.button.TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.input.motion.button.TouchButtonResourceOpenGLESAnimationInterfaceFactoryInterfaceFactory

open public class TestGameDemoAndroidAnimationInterfaceFactoryResourceInitialization : ResourceInitialization {
        
public constructor (){
}


                @Throws(Exception::class)
            
    open fun init()
        //nullable = true from not(false or (false and true)) = true
{

    var featuredAnimationInterfaceFactoryInterfaceFactory: FeaturedAnimationInterfaceFactoryInterfaceFactory = FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance()!!

featuredAnimationInterfaceFactoryInterfaceFactory!!.add(TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory.createFactory())
featuredAnimationInterfaceFactoryInterfaceFactory!!.add(TestGameDemoImageBasedAnimationInterfaceFactoryInterfaceFactory())
featuredAnimationInterfaceFactoryInterfaceFactory!!.add(TouchButtonResourceOpenGLESAnimationInterfaceFactoryInterfaceFactory())
featuredAnimationInterfaceFactoryInterfaceFactory!!.add(TestGameDemoOpenGLESImageBasedAnimationInterfaceFactoryInterfaceFactory())
}


}
                
            

