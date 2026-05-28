
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo.resource




        import java.lang.Object        
        
        import java.lang.Integer
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.AndroidResources
import org.allbinary.media.audio.TestSound
import org.allbinary.data.resource.ResourceUtil
import org.allbinary.game.resource.ResourceInitialization
import org.allbinary.media.audio.ErrorSound
import org.allbinary.media.audio.SelectSound
import org.allbinary.midlet.MidletIcon

open public class TestGameDemoAndroidEarlyResourceInitialization : ResourceInitialization {
        

            //Auto Generated
            public constructor() : super()
            {
            }            
        
                @Throws(Exception::class)
            
    open fun init()
        //nullable = true from not(false or (false and true)) = true
{
super.init()

    var resourceUtil: ResourceUtil = ResourceUtil.getInstance()!!


    var androidResources: AndroidResources = AndroidResources.getInstance()!!

resourceUtil!!.addResource(MidletIcon.RESOURCE, Integer(Integer.valueOf(androidResources!!.drawable.testgamedemo_icon)))
resourceUtil!!.addResource(SelectSound.getInstance()!!.getResource(), Integer(Integer.valueOf(androidResources!!.raw.select)))
resourceUtil!!.addResource(ErrorSound.getInstance()!!.getResource(), Integer(Integer.valueOf(androidResources!!.raw.error)))
resourceUtil!!.addResource(TestSound.getInstance()!!.getResource(), Integer(Integer.valueOf(androidResources!!.raw.test)))
}


}
                
            

