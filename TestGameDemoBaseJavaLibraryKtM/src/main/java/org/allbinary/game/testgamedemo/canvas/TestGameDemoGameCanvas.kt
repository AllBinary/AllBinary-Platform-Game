
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
        package org.allbinary.game.testgamedemo.canvas




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import javax.microedition.lcdui.CommandListener
import javax.microedition.lcdui.Font
import javax.microedition.lcdui.Graphics
import org.allbinary.game.testgamedemo.init.TestGameDemoStaticInitializerFactory
import org.allbinary.game.testgamedemo.level.TestGameDemoLevelBuilder
import org.allbinary.input.accelerometer.AccelerometerSensorFactory
import org.allbinary.input.gyro.AllBinaryOrientationSensor
import org.allbinary.input.gyro.GyroSensorFactory
import org.allbinary.media.audio.TestGameDemoSoundsFactoryFactory
import org.allbinary.media.audio.TestSound
import org.allbinary.util.BasicArrayList
import org.allbinary.util.BasicArrayListD
import org.allbinary.logic.string.StringUtil
import org.allbinary.logic.communication.log.LogUtil
import org.allbinary.ai.OptimizedArtificialIntelligenceLayerProcessorForCollidableLayer
import org.allbinary.game.GameInfo
import org.allbinary.game.GameTypeFactory
import org.allbinary.game.IntermissionFactory
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo
import org.allbinary.game.collision.OptimizedAllBinaryCollisionLayerProcessorForCollidableLayer
import org.allbinary.game.configuration.GameSpeed
import org.allbinary.game.configuration.event.ChangedGameFeatureListener
import org.allbinary.game.configuration.feature.Features
import org.allbinary.game.configuration.feature.GameFeature
import org.allbinary.game.configuration.feature.GameFeatureFactory
import org.allbinary.game.configuration.feature.TouchFeatureFactory
import org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import org.allbinary.game.displayable.canvas.GamePerformanceInitUpdatePaintable
import org.allbinary.game.displayable.canvas.StartIntermissionPaintable
import org.allbinary.game.input.OptimizedGameInputLayerProcessorForCollidableLayer
import org.allbinary.game.layer.AllBinaryGameLayerManager
import org.allbinary.game.layer.PlayerGameInputGameLayer
import org.allbinary.game.layer.identification.GroupLayerManagerListener
import org.allbinary.game.score.BasicHighScoresFactory
import org.allbinary.game.state.GameState
import org.allbinary.game.tick.OptimizedTickableLayerProcessor
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import org.allbinary.graphics.color.BasicColorFactory
import org.allbinary.graphics.displayable.DisplayInfoSingleton
import org.allbinary.graphics.displayable.command.MyCommandsFactory
import org.allbinary.input.motion.button.BaseTouchInput
import org.allbinary.input.motion.button.TestGameDemoNeededTouchButtonsBuilder
import org.allbinary.input.motion.button.TestGameDemoTouchButtonsBuilder
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import org.allbinary.media.AllBinaryVibration
import org.allbinary.media.audio.AllBinaryMediaManager
import org.allbinary.media.audio.PlayerQueue
import org.allbinary.media.audio.PrimaryPlayerQueueFactory
import org.allbinary.media.audio.SecondaryPlayerQueueFactory
import org.allbinary.time.TimeDelayHelper

open public class TestGameDemoGameCanvas : AllBinaryGameCanvas {
        

    private val WAIT: Int = GameSpeed.getInstance()!!.getDelay()!!

    private val portion: Int = 4

    private val abeClientInformation: AbeClientInformationInterface
public constructor (abeClientInformation: AbeClientInformationInterface, commandListener: CommandListener, allBinaryGameLayerManager: AllBinaryGameLayerManager)                        

                            : super(commandListener, allBinaryGameLayerManager, BasicHighScoresFactory(abeClientInformation, TestGameDemoSoftwareInfo.getInstance()), TestGameDemoStaticInitializerFactory(), false){
    //var abeClientInformation = abeClientInformation
    //var commandListener = commandListener
    //var allBinaryGameLayerManager = allBinaryGameLayerManager


                            //For kotlin this is before the body of the constructor.
                    
this.abeClientInformation= abeClientInformation
}


    override fun initSpecialPaint()
        //nullable = true from not(false or (false and true)) = true
{
super.initSpecialPaint()
this.setStartIntermissionPaintable(StartIntermissionPaintable(this, arrayOf(StringUtil.getInstance()!!.EMPTY_STRING), intArrayOf(0), BasicColorFactory.getInstance()!!.RED, Font.getDefaultFont()))
}


                @Throws(Exception::class)
            
    override fun mediaInit()
        //nullable = true from not(false or (false and true)) = true
{
logUtil!!.putF(commonStrings!!.START, this, "mediaInit")
AllBinaryMediaManager.init(TestGameDemoSoundsFactoryFactory.getInstance())
}


                @Throws(Exception::class)
            
    override fun updateTouch()
        //nullable = true from not(false or (false and true)) = true
{

    var gameInfo: GameInfo = this.gameLayerManager!!.getGameInfo()!!


    
                        if(gameInfo!!.getGameType() != GameTypeFactory.getInstance()!!.BOT)
                        
                                    {
                                    
    var nextTouchInputFactory: BaseTouchInput = TestGameDemoTouchButtonsBuilder.getInstance(this.getSensorGameUpdateProcessor())!!


    
                        if(Features.getInstance()!!.isFeature(TouchFeatureFactory.getInstance()!!.AUTO_HIDE_SHOW_SCREEN_BUTTONS))
                        
                                    {
                                    
    
                        if(gameInfo!!.getCurrentLevel() -getStartLevel() >= 1)
                        
                                    {
                                    nextTouchInputFactory= TestGameDemoNeededTouchButtonsBuilder.getInstance(this.getSensorGameUpdateProcessor())

                                    }
                                

                                    }
                                
this.updateCurrentTouchInputFactory(nextTouchInputFactory)

                                    }
                                
}

@Synchronized //TWB - This is not allowed for Kotlin native. Instead use Coroutine logic instead.

    override fun initConfigurable(abeClientInformation: AbeClientInformationInterface)
        //nullable = true from not(false or (false and false)) = true
{
    //var abeClientInformation = abeClientInformation

        try {
            
    var progressCanvas: ProgressCanvas = ProgressCanvasFactory.getInstance()!!


    
                        if(ChangedGameFeatureListener.getInstance()!!.isChanged())
                        
                                    {
                                    super.initConfigurable(abeClientInformation)
progressCanvas!!.addNormalPortion(portion, "Group Manager")
GroupLayerManagerListener.getInstance()!!.init(3)
AllBinaryVibration.init()
ChangedGameFeatureListener.getInstance()!!.setChanged(false)

    
                        if(!this.isRunningInAnotherThread())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                

                                    }
                                
                        else {
                            progressCanvas!!.addNormalPortion(4, "Skipping Configurable")

                        }
                            
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, "initConfigurable", e)
}

}


                @Throws(Exception::class)
            
    override fun threadInit()
        //nullable = true from not(false or (false and true)) = true
{

        try {
            
    var portion: Int = 60

super.initApp(this.abeClientInformation)

    
                        if(!this.isRunningInAnotherThread())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                

    
                        if(!this.isInitialized())
                        
                                    {
                                    
    
                        if(!this.isRunningInAnotherThread())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                

    var progressCanvas: ProgressCanvas = ProgressCanvasFactory.getInstance()!!

progressCanvas!!.addNormalPortion(portion, "Main Processors")
this.setWait(WAIT)
this.loadState()

    var list: BasicArrayList = BasicArrayListD()


    var features: Features = Features.getInstance()!!


    var gameFeatureFactory: GameFeatureFactory = GameFeatureFactory.getInstance()!!


    
                        if(features.isFeature(gameFeatureFactory!!.ARTIFICIAL_INTELLEGENCE_PROCESSOR))
                        
                                    {
                                    list.add(OptimizedArtificialIntelligenceLayerProcessorForCollidableLayer())

                                    }
                                

    
                        if(features.isFeature(gameFeatureFactory!!.GAME_INPUT_LAYER_PROCESSOR))
                        
                                    {
                                    list.add(OptimizedGameInputLayerProcessorForCollidableLayer())

                                    }
                                

    
                        if(features.isFeature(gameFeatureFactory!!.COLLIDABLE_INTERFACE_LAYER_PROCESSOR))
                        
                                    {
                                    list.add(OptimizedAllBinaryCollisionLayerProcessorForCollidableLayer())

                                    }
                                

    
                        if(features.isFeature(gameFeatureFactory!!.TICKABLE_LAYER_PROCESSOR))
                        
                                    {
                                    list.add(OptimizedTickableLayerProcessor())

                                    }
                                
gameLayerManager!!.setLayerProcessorList(list)
progressCanvas!!.addNormalPortion(portion, "Initializing Game")

                                    }
                                
this.buildGameInit(false)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, "_init", e)
}

}


                @Throws(Exception::class)
            
    override fun buildGameInit(isProgress: Boolean)
        //nullable = true from not(false or (false and false)) = true
{
var isProgress = isProgress

    
                        if(!this.isRunningInAnotherThread())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                
this.loadResources(gameLayerManager!!.getGameInfo()!!.getCurrentLevel())

    var progressCanvas: ProgressCanvas = ProgressCanvasFactory.getInstance()!!


    var portion: Int = 30


    
                        if(isProgress && this.isMainCanvas())
                        
                                    {
                                    progressCanvas!!.start()
this.getCustomCommandListener()!!.commandAction(MyCommandsFactory.getInstance()!!.SET_DISPLAYABLE, progressCanvas)
portion= 4

                                    }
                                
PrimaryPlayerQueueFactory.getInstance()!!.clear()
SecondaryPlayerQueueFactory.getInstance()!!.clear()
gameLayerManager!!.cleanup()

    
                        if(!this.isRunningInAnotherThread())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                
progressCanvas!!.addNormalPortion(portion, "Building Game Level")
TestGameDemoLevelBuilder(this).
                            build()
progressCanvas!!.addNormalPortion(portion, "Set Background")

    
                        if(!this.isRunningInAnotherThread())
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                
gameLayerManager!!.append(PlayerGameInputGameLayer(0))
progressCanvas!!.addNormalPortion(portion, "Ending Custom Build")

    
                        if(gameLayerManager!!.getGameInfo()!!.getGameType() != GameTypeFactory.getInstance()!!.BOT)
                        
                                    {
                                    
                                    }
                                
super.buildGame(portion)
this.getStartIntermissionInterface()!!.setEnabled(true)
this.getEndLevelIntermissionInterface()!!.setEnabled(false)
this.setGameState(GameState.PLAYING_GAME_STATE)
}


                @Throws(Exception::class)
            
    override fun setGameState(gameState: GameState)
        //nullable = true from not(false or (false and false)) = true
{
var gameState = gameState
super.setGameState(gameState)

    var intermissionFactory: IntermissionFactory = IntermissionFactory.getInstance()!!


    
                        if(this.getGameState() == GameState.PLAYING_GAME_STATE)
                        
                                    {
                                    this.setMainStateProcessor(this.getProcessGameProcessor())

                                    }
                                
                             else 
    
                        if(this.getGameState() == intermissionFactory!!.WAIT_LEVEL_INTERMISSION_GAME_STATE || this.getGameState() == intermissionFactory!!.SHOW_RESULTS_LEVEL_INTERMISSION_GAME_STATE || this.getGameState() == intermissionFactory!!.SHOW_HIGH_SCORE_LEVEL_INTERMISSION_GAME_STATE)
                        
                                    {
                                    
                                    }
                                
                        else {
                            this.setMainStateProcessor(this.getProcessGameProcessor())

                        }
                            
}


    private val gamePerformanceInitUpdatePaintable: GamePerformanceInitUpdatePaintable = GamePerformanceInitUpdatePaintable()

    private val gyroOrientationSensor: AllBinaryOrientationSensor = GyroSensorFactory.getInstance()!!

    private val accelerometerOrientationSensor: AllBinaryOrientationSensor = AccelerometerSensorFactory.getInstance()!!

    private val halfHeight: Int = DisplayInfoSingleton.getInstance()!!.getLastHalfHeight()!!

    override fun draw(graphics: Graphics)
        //nullable = true from not(false or (false and false)) = true
{
var graphics = graphics
this.clear(graphics)
this.basicSetColorUtil!!.setBasicColorP(graphics, gameLayerManager!!.getForegroundBasicColor())
gameLayerManager!!.paint(graphics, 0, 0)
nonBotPaintable!!.paint(graphics)
gameSpecificPaintable!!.paint(graphics)
gamePerformanceInitUpdatePaintable!!.paint(graphics)
touchPaintable!!.paint(graphics)
screenCapture!!.saveFrame()
graphics.drawString(this.gyroOrientationSensor!!.toString(), 0, halfHeight +30 +60, 0)
graphics.drawString(this.accelerometerOrientationSensor!!.toString(), 0, halfHeight +30 +75, 0)
this.getTouchPaintableP()!!.paint(graphics)
}


    private var playerTimeDelayHelper: TimeDelayHelper = TimeDelayHelper(2000)

    private val primaryPlayerQueue: PlayerQueue = PrimaryPlayerQueueFactory.getInstance()!!

    private val secondaryPlayerQueue: PlayerQueue = SecondaryPlayerQueueFactory.getInstance()!!

    private val features: Features = Features.getInstance()!!

    private val soundGameFeature: GameFeature = GameFeatureFactory.getInstance()!!.SOUND

                @Throws(Exception::class)
            
    override fun processGame()
        //nullable = true from not(false or (false and true)) = true
{

    
                        if(playerTimeDelayHelper!!.isTimeTNT())
                        
                                    {
                                    
    
                        if(this.features.isFeature(soundGameFeature))
                        
                                    {
                                    this.primaryPlayerQueue!!.add(TestSound.getInstance())

                                    }
                                

                                    }
                                
super.processGame()
this.gamePerformanceInitUpdatePaintable!!.update()
}


}
                
            

