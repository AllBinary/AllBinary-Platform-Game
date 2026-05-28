
        /* Generated Code Do Not Modify */
        package org.allbinary.logic.system.security.licensing




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo
import org.allbinary.string.CommonSeps
import org.allbinary.logic.string.StringMaker
import org.allbinary.logic.system.SoftwareInformation

open public class TestGameDemoAndroidMobileClientInformation : MobileClientInformation {
        
companion object {
            
    val instance: TestGameDemoAndroidMobileClientInformation = TestGameDemoAndroidMobileClientInformation(TestGameDemoSoftwareInfo.getInstance())

        }
            public constructor (softwareInformation: SoftwareInformation)                        

                            : super(StringMaker().
                            append(softwareInformation!!.getName())!!.append(ANDROID_DESC)!!.toString(), softwareInformation!!.getVersion(), StringMaker().
                            append(softwareInformation!!.getName())!!.append(ANDROID_DESC)!!.append(CommonSeps.getInstance()!!.SPACE)!!.append(softwareInformation!!.getVersion())!!.toString(), softwareInformation!!.toShortString()){
    //var softwareInformation = softwareInformation


                            //For kotlin this is before the body of the constructor.
                    
}


}
                
            

