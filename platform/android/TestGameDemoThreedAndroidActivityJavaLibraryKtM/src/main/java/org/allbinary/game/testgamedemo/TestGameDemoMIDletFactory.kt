
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import javax.microedition.midlet.MIDlet
import org.allbinary.logic.system.security.licensing.TestGameDemoClientInformationInterfaceFactory
import org.allbinary.midlet.MidletFactoryInterface

open public class TestGameDemoMIDletFactory : MidletFactoryInterface {
        
companion object {
            
    private var SINGLETON: MIDlet = 
                null
            

        }
            
            //Auto Generated
            public constructor() : super()
            {
            }            
        
    open fun getInstance()
        //nullable =  from not(true or (false and true)) = 
: MIDlet{

    
                        if(SINGLETON == 
                                    null
                                )
                        
                                    {
                                    SINGLETON= TestGameDemoMIDlet(TestGameDemoClientInformationInterfaceFactory.getFactoryInstance())

                                    }
                                



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return SINGLETON
}


}
                
            

