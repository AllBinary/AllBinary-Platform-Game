
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo.init




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import javax.microedition.lcdui.CommandListener
import org.allbinary.game.resource.ResourceInitialization
import org.allbinary.game.testgamedemo.configuration.TestGameDemoGameFeatures
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

open public class TestGameDemoBaseJ2SESWTJOGLStaticInitializer : TestGameDemoStaticInitializer {
        

    private var androidGameInitialized: Boolean= false
public constructor (resourceInitializationArray: Array<ResourceInitialization?>, portion: Int)                        

                            : super(resourceInitializationArray, portion){
    //var resourceInitializationArray = resourceInitializationArray
var portion = portion


                            //For kotlin this is before the body of the constructor.
                    
}


                @Throws(Exception::class)
            
    open fun initKey(portion: Int)
        //nullable = true from not(false or (false and false)) = true
{
    //var portion = portion
super.initKey(portion)
ProgressCanvasFactory.getInstance()!!.addNormalPortion(50, "Game Keys")
}


                @Throws(Exception::class)
            
    open fun init(abeClientInformation: AbeClientInformationInterface, commandListener: CommandListener, level: Int)
        //nullable = true from not(false or (false and false)) = true
{
    //var abeClientInformation = abeClientInformation
    //var commandListener = commandListener
    //var level = level
super.init(abeClientInformation, commandListener, level)

    
                        if(this.isAndroidGameInitialized())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                
this.setAndroidGameInitialized(true)
TestGameDemoGameFeatures().
                            init()
ProgressCanvasFactory.getInstance()!!.addNormalPortion(50, "Game Options")
}


    open fun setAndroidGameInitialized(androidGameInitialized: Boolean)
        //nullable = true from not(false or (false and false)) = true
{
    //var androidGameInitialized = androidGameInitialized
this.androidGameInitialized= androidGameInitialized
}


    open fun isAndroidGameInitialized()
        //nullable = true from not(false or (false and true)) = true
: Boolean{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return androidGameInitialized
}


}
                
            

