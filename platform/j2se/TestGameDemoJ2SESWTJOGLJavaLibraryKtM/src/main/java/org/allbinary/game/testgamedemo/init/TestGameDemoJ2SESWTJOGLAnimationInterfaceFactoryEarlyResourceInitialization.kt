
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo.init




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.animation.image.TestGameDemoEarlyResourcesOpenGLBasedAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.animation.image.TestGameDemoEarlyResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory
import org.allbinary.game.resource.ResourceInitialization

open public class TestGameDemoJ2SESWTJOGLAnimationInterfaceFactoryEarlyResourceInitialization : ResourceInitialization {
        
public constructor (){
}


                @Throws(Exception::class)
            
    open fun init()
        //nullable = true from not(false or (false and true)) = true
{

    var featuredAnimationInterfaceFactoryInterfaceFactory: FeaturedAnimationInterfaceFactoryInterfaceFactory = FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance()!!

featuredAnimationInterfaceFactoryInterfaceFactory!!.add(TestGameDemoEarlyResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory())
featuredAnimationInterfaceFactoryInterfaceFactory!!.add(TestGameDemoEarlyResourcesOpenGLBasedAnimationInterfaceFactoryInterfaceFactory())
}


}
                
            

