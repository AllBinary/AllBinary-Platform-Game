
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
        package org.allbinary.game.testgamedemo




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.game.midlet.LicenseCheckRunnableFactory
import org.allbinary.game.midlet.LicensedDemoSetupFactory
import org.allbinary.game.score.HighScoresCanvasNoInputProcessorFactory
import org.allbinary.game.testgamedemo.canvas.TestGameDemoGameCanvas
import org.allbinary.game.testgamedemo.canvas.TestGameDemoInputMappingHelpPaintable
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo
import org.allbinary.game.testgamedemo.canvas.TestGameDemoStartCanvas
import org.allbinary.game.testgamedemo.layer.TestGameDemoLayerManager
import org.allbinary.media.audio.TestGameDemoSoundsFactoryFactory
import org.allbinary.string.CommonStrings
import org.allbinary.logic.communication.log.LogFactory
import org.allbinary.logic.communication.log.LogUtil
import org.allbinary.logic.communication.log.PreLogUtil
import org.allbinary.game.GameInfo
import org.allbinary.game.GameMode
import org.allbinary.game.GameTypeFactory
import org.allbinary.game.PlayerTypesFactory
import org.allbinary.game.displayable.canvas.GameCanvasRunnableInterface
import org.allbinary.game.layer.AllBinaryGameLayerManager
import org.allbinary.game.midlet.LicenseLevelUtil
import org.allbinary.game.midlet.LicenseLoadingTypeFactory
import org.allbinary.game.midlet.SpecialDemoGameMidlet
import org.allbinary.game.paint.help.HelpPaintable
import org.allbinary.game.score.BasicHighScoresFactory
import org.allbinary.game.score.HighScoresPaintable
import org.allbinary.game.score.displayable.HighScoresCanvas
import org.allbinary.logic.system.security.licensing.ClientInformationFactory
import org.allbinary.media.audio.AllBinaryMediaManagerShutdown
import org.allbinary.media.audio.EarlySoundsFactory

open public class TestGameDemoMIDlet : SpecialDemoGameMidlet {
        
public constructor (clientInformationFactory: ClientInformationFactory)                        

                            : super(clientInformationFactory, LicenseLoadingTypeFactory.getIntance()!!.OTHER, LicensedDemoSetupFactory(), LicenseCheckRunnableFactory()){
    //var clientInformationFactory = clientInformationFactory


                            //For kotlin this is before the body of the constructor.
                    
}


                @Throws(Exception::class)
            
    override fun getHelpPaintable()
        //nullable = true from not(false or (false and true)) = true
: HelpPaintable{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return TestGameDemoInputMappingHelpPaintable.getInstance()
}


                @Throws(Exception::class)
            
    override fun createDemoGameCanvasRunnableInterface()
        //nullable = true from not(false or (false and true)) = true
: GameCanvasRunnableInterface{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return TestGameDemoStartCanvas(this.abeClientInformation, this)
}


                @Throws(Exception::class)
            
    override fun createGameCanvasRunnable(allBinaryGameLayerManager: AllBinaryGameLayerManager)
        //nullable = true from not(false or (false and false)) = true
: GameCanvasRunnableInterface{
    //var allBinaryGameLayerManager = allBinaryGameLayerManager



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return TestGameDemoGameCanvas(this.abeClientInformation, this, allBinaryGameLayerManager)
}


                @Throws(Exception::class)
            
    override fun createHighScoresCanvas()
        //nullable = true from not(false or (false and true)) = true
: HighScoresCanvas{



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return HighScoresCanvas(this, this.createGameLayerManager(), this.createGameLayerManager()!!.getGameInfo(), HighScoresPaintable(), BasicHighScoresFactory(this.abeClientInformation, TestGameDemoSoftwareInfo.getInstance()), HighScoresCanvasNoInputProcessorFactory())
}


    override fun getHighestLevel()
        //nullable = true from not(false or (false and true)) = true
: Int{
PreLogUtil.put("******************Demo Level Limited To: 6", this, "getMaxLevel")



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return LicenseLevelUtil.getInstance()!!.getMaxLevel(TestGameDemoLayerManager.MAX_LEVEL, 6)
}


    override fun createGameLayerManager()
        //nullable = true from not(false or (false and true)) = true
: AllBinaryGameLayerManager{

    var gameInfo: GameInfo = GameInfo(GameTypeFactory.getInstance()!!.SINGLE_PLAYER, GameMode.SERVER, PlayerTypesFactory.getInstance()!!.PLAYER_TYPE_ONE, this.getHighestLevel(), 1)




                        //if statement needs to be on the same line and ternary does not work the same way.
                        return TestGameDemoLayerManager(gameInfo)
}


                @Throws(Exception::class)
            
    override fun mediaShutdown()
        //nullable = true from not(false or (false and true)) = true
{
logUtil!!.putF(commonStrings!!.START, this, "mediaShutdown - postStopGameCanvasRunnableInterface")
AllBinaryMediaManagerShutdown.shutdown(EarlySoundsFactory.getInstance())
AllBinaryMediaManagerShutdown.shutdown(TestGameDemoSoundsFactoryFactory.getInstance())
logUtil!!.putF(commonStrings!!.END, this, "mediaShutdown - postStopGameCanvasRunnableInterface")
}


}
                
            

