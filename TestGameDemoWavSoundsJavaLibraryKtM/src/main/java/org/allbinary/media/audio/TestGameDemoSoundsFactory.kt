
        /* Generated Code Do Not Modify */
        package org.allbinary.media.audio




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.media.audio.BaseSoundsFactory
import org.allbinary.media.audio.Sound

open public class TestGameDemoSoundsFactory : BaseSoundsFactory {
        

            //Auto Generated
            public constructor() : super()
            {
            }            
        
                @Throws(Exception::class)
            
    open fun getSoundInterfaceArray()
        //nullable = true from not(false or (false and true)) = true
: Array<Sound?>{

    var soundInterfaceArray: Array<Sound?> = arrayOfNulls(1)


    var index: Int = 0

soundInterfaceArray[index++]= TestSound.getInstance()



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return soundInterfaceArray
}


}
                
            

