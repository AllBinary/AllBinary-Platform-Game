
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo.init




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.game.testgamedemo.resource.TestGameDemoAndroidResources
import org.allbinary.android.input.motion.button.TouchButtonAndroidResources
import org.allbinary.game.testgamedemo.init.TestGameDemoResourceInitialization

open public class TestGameDemoAndroidResourceInitialization : TestGameDemoResourceInitialization {
        
public constructor (){
}


                @Throws(Exception::class)
            
    open fun init()
        //nullable = true from not(false or (false and true)) = true
{
super.init()
TouchButtonAndroidResources().
                            init()
TestGameDemoAndroidResources.getInstance()!!.init()
}


}
                
            

