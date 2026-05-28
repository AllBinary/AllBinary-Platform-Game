
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo.init




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.game.init.BasicBuildGameInitializerFactory
import org.allbinary.game.init.GameInitializationInterface
import org.allbinary.game.resource.ResourceInitialization

open public class TestGameDemoStaticInitializerFactory : BasicBuildGameInitializerFactory {
        
companion object {
            
    private var STATIC: GameInitializationInterface = TestGameDemoBaseAndroidStaticInitializer(arrayOf(TestGameDemoAndroidEarlyResourceInitialization(),TestGameDemoAndroidResourceInitialization(),TestGameDemoAndroidAnimationInterfaceFactoryEarlyResourceInitialization(),TestGameDemoAndroidAnimationInterfaceFactoryResourceInitialization()), 15)

        }
            
            //Auto Generated
            public constructor() : super()
            {
            }            
        
    open fun getInstance()
        //nullable =  from not(true or (false and true)) = 
: GameInitializationInterface{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return STATIC
}


}
                
            

