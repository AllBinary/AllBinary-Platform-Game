
        /*
                * 
                *  AllBinary Open License Version 1
                *  Copyright (c) 2011 AllBinary
                *  
                *  By agreeing to this license you and any business entity you represent are
                *  legally bound to the AllBinary Open License Version 1 legal agreement.
                *  
                *  You may obtain the AllBinary Open License Version 1 legal agreement from
                *  AllBinary or the root directory of AllBinary's AllBinary Platform repository.
                *  
                *  Created By: Travis Berthelot  
        */
        
        /* Generated Code Do Not Modify */
        package org.allbinary.logic.system.security.licensing




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.string.CommonSeps
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo
import org.allbinary.logic.string.StringMaker
import org.allbinary.logic.system.SoftwareInformation

open public class TestGameDemoPCClientInformation : AbeClientInformation {
        
companion object {
            
    val instance: TestGameDemoPCClientInformation = TestGameDemoPCClientInformation(TestGameDemoSoftwareInfo.getInstance())

    private val PC_DESC: String = "PC"

        }
            public constructor (softwareInformation: SoftwareInformation)                        

                            : super(StringMaker().
                            append(softwareInformation!!.getName())!!.append(PC_DESC)!!.toString(), softwareInformation!!.getVersion(), StringMaker().
                            append(softwareInformation!!.getName())!!.append(PC_DESC)!!.append(CommonSeps.getInstance()!!.SPACE)!!.append(softwareInformation!!.getVersion())!!.toString(), softwareInformation!!.toShortString()){
    //var softwareInformation = softwareInformation


                            //For kotlin this is before the body of the constructor.
                    
}


}
                
            

