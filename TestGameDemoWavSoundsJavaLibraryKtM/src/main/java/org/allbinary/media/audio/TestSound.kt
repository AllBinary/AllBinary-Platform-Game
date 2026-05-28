
        /*
                *  
                * Copyright (c) 2002 All Binary 
                * All Rights Reserved. 
                * Don't Duplicate or Distributed. 
                * Trade Secret Information 
                * For Internal Use Only 
                * Confidential 
                * Unpublished 
                *  
                * Created By: Travis Berthelot 
                * Date: 11/29/02 
                *  
                *  
                * Modified By         When       ?   
        */
        
        /* Generated Code Do Not Modify */
        package org.allbinary.media.audio




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.media.audio.CompositeSound
import org.allbinary.media.audio.Sound

open public class TestSound : CompositeSound {
        
companion object {
            
    private var soundInterface: Sound = TestSound()

    open fun getInstance()
        //nullable =  from not(true or (false and true)) = 
: Sound{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return soundInterface
}


        }
            private constructor ()                        

                            : super("resource:/wav/test.wav"){


                            //For kotlin this is before the body of the constructor.
                    
}


}
                
            

