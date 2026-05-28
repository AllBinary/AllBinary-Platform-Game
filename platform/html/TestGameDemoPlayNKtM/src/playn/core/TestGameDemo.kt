
        /* Generated Code Do Not Modify */
        package playn.core




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.string.CommonStrings
import org.allbinary.logic.communication.log.LogFactory
import org.allbinary.logic.communication.log.LogUtil
import org.allbinary.game.configuration.GameConfigurationCentral
import org.allbinary.game.configuration.feature.Features
import org.allbinary.game.configuration.feature.GameFeatureFactory
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory
import org.allbinary.game.configuration.feature.HTMLFeatureFactory
import org.allbinary.game.configuration.feature.InputFeatureFactory
import org.allbinary.game.configuration.feature.SensorFeatureFactory
import org.allbinary.input.motion.AllMotionRecognizer
import org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import org.allbinary.input.motion.gesture.observer.GameMotionGestureListener
import org.allbinary.input.motion.gesture.observer.MotionGestureReceiveInterfaceFactory
import org.allbinary.logic.math.SmallIntegerSingletonFactory
import org.allbinary.media.audio.EarlySoundsFactory
import org.allbinary.media.audio.Sounds
import org.allbinary.game.init.DefaultGameInitializationListener
import org.allbinary.logic.system.security.licensing.TestGameDemoClientInformationInterfaceFactory
import org.allbinary.media.audio.TestGameDemoSoundsFactoryFactory
import org.allbinary.playn.input.PlayNToAllBinaryKeyInputUtil

open public class TestGameDemo : org.allbinary.game.testgamedemo.TestGameDemoMIDlet
                , Keyboard.Listener
                , Pointer.Listener {
        

    val logUtil: LogUtil = LogUtil.getInstance()!!

    private val DEVICE_ID: Int = 0

    private val playNToAllBinaryKeyInputUtil: PlayNToAllBinaryKeyInputUtil = PlayNToAllBinaryKeyInputUtil.getInstance()!!

    private var motionRecognizer: AllMotionRecognizer = AllMotionRecognizer()
public constructor ()                        

                            : super(TestGameDemoClientInformationInterfaceFactory.getFactoryInstance()){


                            //For kotlin this is before the body of the constructor.
                    

    var motionGesturesHandler: BasicMotionGesturesHandler = motionRecognizer!!.getMotionGestureRecognizer()!!.getMotionGesturesHandler()!!

motionGesturesHandler!!.addListener(GameMotionGestureListener(MotionGestureReceiveInterfaceFactory.getInstance()))
PlayN.keyboard()!!.setListener(this)
PlayN.pointer()!!.setListener(this)
DefaultGameInitializationListener()
}


    open fun init()
        //nullable = true from not(false or (false and true)) = true
{

        try {
            logUtil!!.putF(commonStrings!!.START, this, commonStrings!!.INIT)

    var features: Features = Features.getInstance()!!


    var gameFeatureFactory: GameFeatureFactory = GameFeatureFactory.getInstance()!!


    var inputFeatureFactory: InputFeatureFactory = InputFeatureFactory.getInstance()!!


    var graphicsFeatureFactory: GraphicsFeatureFactory = GraphicsFeatureFactory.getInstance()!!


    var sensorFeatureFactory: SensorFeatureFactory = SensorFeatureFactory.getInstance()!!

features.removeDefault(sensorFeatureFactory!!.ORIENTATION_SENSORS)
features.addDefault(sensorFeatureFactory!!.NO_ORIENTATION)
features.addDefault(graphicsFeatureFactory!!.IMAGE_GRAPHICS)
features.addDefault(graphicsFeatureFactory!!.SPRITE_FULL_GRAPHICS)
features.addDefault(gameFeatureFactory!!.HEALTH_BARS)
features.addDefault(gameFeatureFactory!!.DAMAGE_FLOATERS)
features.addDefault(gameFeatureFactory!!.DROPPED_ITEMS)
features.addDefault(gameFeatureFactory!!.SOUND)
features.addDefault(inputFeatureFactory!!.MULTI_KEY_PRESS)
features.addDefault(inputFeatureFactory!!.REMOVE_DUPLICATE_KEY_PRESSES)

    var gameConfigurationCentral: GameConfigurationCentral = GameConfigurationCentral.getInstance()!!


    var smallIntegerSingletonFactory: SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()!!

gameConfigurationCentral!!.VIBRATION.setDefaultValue(smallIntegerSingletonFactory!!.getInstance(0))
gameConfigurationCentral!!.VIBRATION.setDefault()
gameConfigurationCentral!!.SPEED_CHALLENGE_LEVEL.setDefaultValue(smallIntegerSingletonFactory!!.getInstance(4))
gameConfigurationCentral!!.SPEED_CHALLENGE_LEVEL.setDefault()
gameConfigurationCentral!!.SPEED.setDefaultValue(smallIntegerSingletonFactory!!.getInstance(9))
gameConfigurationCentral!!.SPEED.setDefault()
gameConfigurationCentral!!.PLAYER_INPUT_WAIT.setDefaultValue(smallIntegerSingletonFactory!!.getInstance(0))
gameConfigurationCentral!!.PLAYER_INPUT_WAIT.setDefault()
gameConfigurationCentral!!.SCALE.setDefaultValue(smallIntegerSingletonFactory!!.getInstance(3))
gameConfigurationCentral!!.SCALE.setDefault()
features.removeDefault(sensorFeatureFactory!!.ORIENTATION_SENSORS)
features.addDefault(sensorFeatureFactory!!.NO_ORIENTATION)
features.addDefault(HTMLFeatureFactory.getInstance()!!.HTML)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, commonStrings!!.CONSTRUCTOR, e)
}

}


    open fun stopAll()
        //nullable = true from not(false or (false and true)) = true
{

        try {
            Sounds(EarlySoundsFactory.getInstance()).
                            stopAll()
Sounds(TestGameDemoSoundsFactoryFactory.getInstance()).
                            stopAll()
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, "stopAll", e)
}

}


    override fun onKeyTyped(event: Keyboard.TypedEvent)
        //nullable = true from not(false or (false and false)) = true
{
var event = event
}


    override fun onKeyDown(event: Keyboard.Event)
        //nullable = true from not(false or (false and false)) = true
{
var event = event

    var key: Key = event.key()!!


    var abKey: Int = this.playNToAllBinaryKeyInputUtil!!.PLAYN_KEY_ORDINAL_TO_CANVAS_KEY[key.ordinal()]!!


    
                        if(abKey !=  -1)
                        
                                    {
                                    this.getCurrentDisplayable()!!.keyPressed(abKey)

                                    }
                                
}


    override fun onKeyUp(event: Keyboard.Event)
        //nullable = true from not(false or (false and false)) = true
{
var event = event

    var key: Key = event.key()!!


    var abKey: Int = this.playNToAllBinaryKeyInputUtil!!.PLAYN_KEY_ORDINAL_TO_CANVAS_KEY[key.ordinal()]!!


    
                        if(abKey !=  -1)
                        
                                    {
                                    this.getCurrentDisplayable()!!.keyReleased(abKey)

                                    }
                                
}


    open fun onPointerStart(mouseEvent: Pointer.Event)
        //nullable = true from not(false or (false and false)) = true
{
var mouseEvent = mouseEvent

        try {
            logUtil!!.putF(commonStrings!!.START, this, "onPointerStart")
this.motionRecognizer!!.processStartMotionEvent(mouseEvent!!.x().toInt(), mouseEvent!!.y().toInt(), this.DEVICE_ID, 0)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, "onPointerStart", e)
}

}


    open fun onPointerEnd(mouseEvent: Pointer.Event)
        //nullable = true from not(false or (false and false)) = true
{
var mouseEvent = mouseEvent

        try {
            logUtil!!.putF(commonStrings!!.START, this, "onPointerEnd")
this.motionRecognizer!!.processEndMotionEvent(mouseEvent!!.x().toInt(), mouseEvent!!.y().toInt(), this.DEVICE_ID, 0)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, "onPointerEnd", e)
}

}


    open fun onPointerDrag(mouseEvent: Pointer.Event)
        //nullable = true from not(false or (false and false)) = true
{
var mouseEvent = mouseEvent

        try {
            this.motionRecognizer!!.processDraggedMotionEvent(mouseEvent!!.x().toInt(), mouseEvent!!.y().toInt(), this.DEVICE_ID, 0)
} catch(e: Exception)
            {
logUtil!!.put(commonStrings!!.EXCEPTION, this, "onPointerDrag", e)
}

}


}
                
            

