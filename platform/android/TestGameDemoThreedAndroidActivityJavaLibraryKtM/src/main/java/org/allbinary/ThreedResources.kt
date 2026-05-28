
        /*
                *  
                *  AllBinary Open License Version 1 
                *  Copyright (c) 2022 AllBinary 
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
        package org.allbinary




        import java.lang.Object        
        
        import java.lang.Integer
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.data.resource.ResourceUtil
import org.allbinary.graphics.threed.min3d.TitleThreedResources

open public class ThreedResources
            : Object
         {
        
companion object {
            
    private val threedResources: ThreedResources = ThreedResources()

    open fun getInstance()
        //nullable =  from not(true or (false and true)) = 
: ThreedResources{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return threedResources
}


        }
            
            //Auto Generated
            public constructor() : super()
            {
            }            
        
    open fun add()
        //nullable = true from not(false or (false and true)) = true
{

    var resourceUtil: ResourceUtil = ResourceUtil.getInstance()!!


    var titleThreedResources: TitleThreedResources = TitleThreedResources.getInstance()!!


    var androidResources: AndroidResources = AndroidResources.getInstance()!!

resourceUtil!!.addResource(titleThreedResources!!.RESOURCE_TITLE_THREE, Integer(Integer.valueOf(androidResources!!.raw.threed_obj)))
}


}
                
            

