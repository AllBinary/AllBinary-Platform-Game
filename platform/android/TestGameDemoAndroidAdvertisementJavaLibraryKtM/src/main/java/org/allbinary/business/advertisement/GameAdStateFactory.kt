
        /* Generated Code Do Not Modify */
        package org.allbinary.business.advertisement




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.game.GameAdState
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo
import org.allbinary.logic.system.SoftwareInformation

open public class GameAdStateFactory
            : Object
        
                , GameAdStateFactoryInterface {
        
companion object {
            
    private val instance: GameAdStateFactory = GameAdStateFactory()

    open fun getInstance()
        //nullable =  from not(true or (false and true)) = 
: GameAdStateFactory{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return instance
}


        }
            
            //Auto Generated
            public constructor() : super()
            {
            }            
        
    private val gameAdStateArray: Array<GameAdState?> = arrayOf(GameAdState(TestGameDemoAdConfiguration()))

    private var gameAdState: GameAdState = this.gameAdStateArray[0]!!

    open fun getCurrentInstance()
        //nullable = true from not(false or (false and true)) = true
: GameAdState{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return this.gameAdState
}


                @Throws(Exception::class)
            
    override fun getInstanceForApp(softwareInformation: SoftwareInformation)
        //nullable = true from not(false or (false and false)) = true
: GameAdStateBase{
    //var softwareInformation = softwareInformation

    
                        if(softwareInformation == TestGameDemoSoftwareInfo.getInstance())
                        
                                    {
                                    this.gameAdState= gameAdStateArray[0]!!



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return gameAdStateArray[0]!!

                                    }
                                
                        else {
                            


                            throw Exception("No Such Ad Configuration: " +softwareInformation)

                        }
                            
}


}
                
            

