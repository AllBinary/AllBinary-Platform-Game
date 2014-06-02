package playn.core;

import abcs.logic.basic.string.CommonStrings;
import abcs.logic.communication.log.LogFactory;
import abcs.logic.communication.log.LogUtil;
import allbinary.game.configuration.GameConfigurationCentral;
import allbinary.game.configuration.feature.Features;
import allbinary.game.configuration.feature.GameFeatureFactory;
import allbinary.game.configuration.feature.GraphicsFeatureFactory;
import allbinary.game.configuration.feature.HTMLFeatureFactory;
import allbinary.game.configuration.feature.InputFeatureFactory;
import allbinary.game.configuration.feature.SensorFeatureFactory;
import allbinary.input.motion.AllMotionRecognizer;
import allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler;
import allbinary.input.motion.gesture.observer.GameMotionGestureListener;
import allbinary.input.motion.gesture.observer.MotionGestureReceiveInterfaceFactory;
import allbinary.logic.math.SmallIntegerSingletonFactory;
import allbinary.media.audio.EarlySoundsFactoryFactory;
import allbinary.media.audio.Sounds;
import org.allbinary.game.init.DefaultGameInitializationListener;
import org.allbinary.media.audio.TestGameDemoSoundsFactoryFactory;

public class TestGameDemo
    extends org.allbinary.game.testgamedemo.TestGameDemoMIDlet
implements Keyboard.Listener, 
//Mouse.Listener, 
Pointer.Listener
{
    private AllMotionRecognizer motionRecognizer = new AllMotionRecognizer();

    public TestGameDemo()
    {
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
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, CommonStrings.getInstance().INIT));

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
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, CommonStrings.getInstance().CONSTRUCTOR, e));
        }
    }

    public void stopAll()
    {
        try
        {
            new Sounds(EarlySoundsFactoryFactory.getInstance()).stopAll();
            new Sounds(TestGameDemoSoundsFactoryFactory.getInstance()).stopAll();
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "stopAll", e));
        }
    }
    
    public void onKeyDown(Keyboard.Event event)
    {
        LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "onKeyDown"));
        
        this.getCurrentDisplayable().keyPressed(event.keyCode());
    }

    public void onKeyUp(Keyboard.Event event)
    {
        LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "onKeyUp"));
        
        this.getCurrentDisplayable().keyReleased(event.keyCode());
    }

    public void onPointerStart(Pointer.Event mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "onPointerStart"));
            this.motionRecognizer.processStartMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(), 0, 
                0);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "onPointerStart", e));
        }
    }

    public void onPointerEnd(Pointer.Event mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "onPointerEnd"));
            this.motionRecognizer.processEndMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(), 0, 
                0);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "onPointerEnd", e));
        }
    }

    public void onPointerDrag(Pointer.Event mouseEvent)
    {
        try
        {
            //LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "onPointerDrag"));
            this.motionRecognizer.processDraggedMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(), 0, 
                0);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "onPointerDrag", e));
        }
    }

    /*
    public void onMouseDown(Mouse.ButtonEvent mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "onMouseDown"));
            this.motionRecognizer.processStartMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(),
                mouseEvent.button());
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "onMouseDown", e));
        }
    }

    public void onMouseUp(Mouse.ButtonEvent mouseEvent)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "onMouseUp"));
            this.motionRecognizer.processEndMotionEvent(
                (int) mouseEvent.x(), (int) mouseEvent.y(),
                mouseEvent.button());
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "onMouseUp", e));
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
