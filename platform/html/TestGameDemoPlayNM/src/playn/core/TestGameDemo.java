package playn.core;

import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.game.configuration.GameConfigurationCentral;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GameFeatureFactory;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;
import org.allbinary.game.configuration.feature.HTMLFeatureFactory;
import org.allbinary.game.configuration.feature.InputFeatureFactory;
import org.allbinary.game.configuration.feature.SensorFeatureFactory;
import org.allbinary.input.motion.AllMotionRecognizer;
import org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler;
import org.allbinary.input.motion.gesture.observer.GameMotionGestureListener;
import org.allbinary.input.motion.gesture.observer.MotionGestureReceiveInterfaceFactory;
import org.allbinary.logic.math.SmallIntegerSingletonFactory;
import org.allbinary.media.audio.EarlySoundsFactory;
import org.allbinary.media.audio.Sounds;
import org.allbinary.game.init.DefaultGameInitializationListener;
import org.allbinary.logic.system.security.licensing.TestGameDemoClientInformationInterfaceFactory;
import org.allbinary.media.audio.TestGameDemoSoundsFactoryFactory;
import org.allbinary.playn.input.PlayNToAllBinaryKeyInputUtil;

public class TestGameDemo
    extends org.allbinary.game.testgamedemo.TestGameDemoMIDlet
implements Keyboard.Listener, 
//Mouse.Listener, 
Pointer.Listener
{
    private final int DEVICE_ID = 0;
    private final PlayNToAllBinaryKeyInputUtil playNToAllBinaryKeyInputUtil = PlayNToAllBinaryKeyInputUtil.getInstance();
    private AllMotionRecognizer motionRecognizer = new AllMotionRecognizer();

    public TestGameDemo()
    {
        super(TestGameDemoClientInformationInterfaceFactory.getFactoryInstance());
        
        BasicMotionGesturesHandler motionGesturesHandler =
            motionRecognizer.getMotionGestureRecognizer().getMotionGesturesHandler();

        motionGesturesHandler.addListener(
            new GameMotionGestureListener(
            MotionGestureReceiveInterfaceFactory.getInstance()));
        
        PlayN.keyboard().setListener(this);
        //PlayN.mouse().setListener(this);
        PlayN.pointer().setListener(this);
        
        new DefaultGameInitializationListener();        
    }

    protected void init()
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.START, this, commonStrings.INIT));

            Features features = Features.getInstance();

            GameFeatureFactory gameFeatureFactory =
                GameFeatureFactory.getInstance();

            InputFeatureFactory inputFeatureFactory =
                InputFeatureFactory.getInstance();

            GraphicsFeatureFactory graphicsFeatureFactory =
                GraphicsFeatureFactory.getInstance();

            SensorFeatureFactory sensorFeatureFactory =
                    SensorFeatureFactory.getInstance();

            features.removeDefault(sensorFeatureFactory.ORIENTATION_SENSORS);
            features.addDefault(sensorFeatureFactory.NO_ORIENTATION);

            features.addDefault(graphicsFeatureFactory.IMAGE_GRAPHICS);
            //features.addDefault(gameFeatureFactory.VECTOR_GRAPHICS);

            features.addDefault(graphicsFeatureFactory.SPRITE_FULL_GRAPHICS);
            //features.addDefault(gameFeatureFactory.SPRITE_QUARTER_ROTATION_GRAPHICS);

            features.addDefault(gameFeatureFactory.HEALTH_BARS);
            features.addDefault(gameFeatureFactory.DAMAGE_FLOATERS);

            features.addDefault(gameFeatureFactory.DROPPED_ITEMS);

            features.addDefault(gameFeatureFactory.SOUND);

            features.addDefault(inputFeatureFactory.MULTI_KEY_PRESS);
            //gameFeatureFactory.removeDefault(inputFeatureFactory.MULTI_KEY_PRESS);
            //features.addDefault(inputFeatureFactory.SINGLE_KEY_PRESS);
            features.addDefault(inputFeatureFactory.REMOVE_DUPLICATE_KEY_PRESSES);

            GameConfigurationCentral gameConfigurationCentral =
                    GameConfigurationCentral.getInstance();

            SmallIntegerSingletonFactory smallIntegerSingletonFactory = 
                    SmallIntegerSingletonFactory.getInstance();

            gameConfigurationCentral.VIBRATION.setDefaultValue(smallIntegerSingletonFactory.getInstance(0));
            gameConfigurationCentral.VIBRATION.setDefault();

            gameConfigurationCentral.SPEED_CHALLENGE_LEVEL.setDefaultValue(smallIntegerSingletonFactory.getInstance(4));
            gameConfigurationCentral.SPEED_CHALLENGE_LEVEL.setDefault();

            gameConfigurationCentral.SPEED.setDefaultValue(smallIntegerSingletonFactory.getInstance(9));
            gameConfigurationCentral.SPEED.setDefault();

            gameConfigurationCentral.PLAYER_INPUT_WAIT.setDefaultValue(smallIntegerSingletonFactory.getInstance(0));
            gameConfigurationCentral.PLAYER_INPUT_WAIT.setDefault();

            gameConfigurationCentral.SCALE.setDefaultValue(smallIntegerSingletonFactory.getInstance(3));
            gameConfigurationCentral.SCALE.setDefault();

            features.removeDefault(sensorFeatureFactory.ORIENTATION_SENSORS);
            features.addDefault(sensorFeatureFactory.NO_ORIENTATION);
            features.addDefault(HTMLFeatureFactory.getInstance().HTML);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e));
        }
    }

    public void stopAll()
    {
        try
        {
            new Sounds(EarlySoundsFactory.getInstance()).stopAll();
            new Sounds(TestGameDemoSoundsFactoryFactory.getInstance()).stopAll();
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, "stopAll", e));
        }
    }
    
    //TWB - Added for custom playn 1.0.3
    @Override
    public void onKeyTyped(Keyboard.TypedEvent event) {
        
        //LogUtil.put(LogFactory.getInstance(CommonLabels.getInstance().START_LABEL + event.typedChar(), this, "onKeyTyped"));
        
        //this.getCurrentDisplayable().keyRepeated(event.keyCode());
    }

    @Override
    public void onKeyDown(Keyboard.Event event)
    {
        //LogUtil.put(LogFactory.getInstance(CommonLabels.getInstance().START_LABEL + event.key(), this, "onKeyDown"));
    
        final Key key = event.key();        
        final int abKey = this.playNToAllBinaryKeyInputUtil.PLAYN_KEY_ORDINAL_TO_CANVAS_KEY[key.ordinal()];
        if(abKey != -1) {
            this.getCurrentDisplayable().keyPressed(abKey);
        }
    }

    @Override
    public void onKeyUp(Keyboard.Event event)
    {
        //LogUtil.put(LogFactory.getInstance(CommonLabels.getInstance().START_LABEL + event.key(), this, "onKeyUp"));
        
        final Key key = event.key();

        final int abKey = this.playNToAllBinaryKeyInputUtil.PLAYN_KEY_ORDINAL_TO_CANVAS_KEY[key.ordinal()];
        if(abKey != -1) {
            this.getCurrentDisplayable().keyReleased(abKey);
        }
    }

    public void onPointerStart(Pointer.Event mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.START, this, "onPointerStart"));
            this.motionRecognizer.processStartMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(), this.DEVICE_ID, 
                0);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, "onPointerStart", e));
        }
    }

    public void onPointerEnd(Pointer.Event mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.START, this, "onPointerEnd"));
            this.motionRecognizer.processEndMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(), this.DEVICE_ID, 
                0);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, "onPointerEnd", e));
        }
    }

    public void onPointerDrag(Pointer.Event mouseEvent)
    {
        try
        {
            //LogUtil.put(LogFactory.getInstance(commonStrings.START, this, "onPointerDrag"));
            this.motionRecognizer.processDraggedMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(), this.DEVICE_ID, 
                0);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, "onPointerDrag", e));
        }
    }

    /*
    public void onMouseDown(Mouse.ButtonEvent mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.START, this, "onMouseDown"));
            this.motionRecognizer.processStartMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(),
                mouseEvent.button());
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, "onMouseDown", e));
        }
    }

    public void onMouseUp(Mouse.ButtonEvent mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.START, this, "onMouseUp"));
            this.motionRecognizer.processEndMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(),
                mouseEvent.button());
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, "onMouseUp", e));
        }
    }

    public void onMouseMove(Mouse.MotionEvent event)
    {
        
    }

    public void onMouseWheelScroll(Mouse.WheelEvent event)
    {
        
    }
    * 
    */
}
