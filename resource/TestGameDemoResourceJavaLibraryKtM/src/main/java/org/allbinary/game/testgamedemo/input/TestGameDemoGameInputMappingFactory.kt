
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
        package org.allbinary.game.testgamedemo.input




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.game.input.GameKeyFactory
import org.allbinary.game.input.mapping.GameInputMapping

open public class TestGameDemoGameInputMappingFactory
            : Object
         {
        
companion object {
            
    private val SINGLETON: TestGameDemoGameInputMappingFactory = TestGameDemoGameInputMappingFactory()

    open fun getInstance()
        //nullable =  from not(true or (false and true)) = 
: TestGameDemoGameInputMappingFactory{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return SINGLETON
}


        }
            
    private var gameInputMappingArray: Array<GameInputMapping?> = arrayOfNulls(7)
public constructor ()
            : super()
        {

    var gameKeyFactory: GameKeyFactory = GameKeyFactory.getInstance()!!

gameInputMappingArray[0]= GameInputMapping("Fire", gameKeyFactory!!.KEY_NUM1)
gameInputMappingArray[1]= GameInputMapping("Up", gameKeyFactory!!.UP)
gameInputMappingArray[2]= GameInputMapping("Left", gameKeyFactory!!.LEFT)
gameInputMappingArray[3]= GameInputMapping("Right", gameKeyFactory!!.RIGHT)
gameInputMappingArray[4]= GameInputMapping("Down", gameKeyFactory!!.DOWN)
gameInputMappingArray[5]= GameInputMapping("Zoom Out", gameKeyFactory!!.KEY_NUM3)
gameInputMappingArray[6]= GameInputMapping("Zoom In", gameKeyFactory!!.KEY_NUM0)
}


    open fun get()
        //nullable = true from not(false or (false and true)) = true
: Array<GameInputMapping?>{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return this.gameInputMappingArray
}


}
                
            

