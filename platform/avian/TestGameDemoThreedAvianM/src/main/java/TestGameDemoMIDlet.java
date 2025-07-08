
import org.microemu.app.MidletJOGLInterface;

import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.emulator.InitEmulatorFactory;
import org.allbinary.game.configuration.GameConfigurationCentral;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GameFeatureFactory;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;
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
import org.allbinary.game.testgamedemo.TestGameDemoJOGLMin3dView;
import org.allbinary.graphics.opengles.OpenGLConfiguration;
import org.allbinary.logic.system.security.licensing.TestGameDemoClientInformationInterfaceFactory;
import org.allbinary.media.audio.TestGameDemoSoundsFactory;

public class TestGameDemoMIDlet
        extends org.allbinary.game.testgamedemo.TestGameDemoMIDlet
    implements MidletJOGLInterface
{
    protected final LogUtil logUtil = LogUtil.getInstance();

    private final int DEVICE_ID = 0;
    private AllMotionRecognizer motionRecognizer = new AllMotionRecognizer();

    //TestGameDemoThreedSWTJOGLMin3dView?
    //private TestGameDemoJOGLOpenGLESView testGameDemoJOGLMin3dView;
    private TestGameDemoJOGLMin3dView glSurfaceView;
    
    public TestGameDemoMIDlet()
    {
        super(TestGameDemoClientInformationInterfaceFactory.getFactoryInstance());
        
        final BasicMotionGesturesHandler motionGesturesHandler =
            motionRecognizer.getMotionGestureRecognizer().getMotionGesturesHandler();

        motionGesturesHandler.addListener(
            new GameMotionGestureListener(
            MotionGestureReceiveInterfaceFactory.getInstance()));    

        new DefaultGameInitializationListener();
    }

    protected void init()
    {
        final LogUtil logUtil = LogUtil.getInstance();
        try
        {
            logUtil.put(commonStrings.START, this, commonStrings.INIT);

            ResourceUtil.getInstance().setClassLoader(this.getClass().getClassLoader());

            final Features features = Features.getInstance();

            final GameFeatureFactory gameFeatureFactory =
                GameFeatureFactory.getInstance();

            final InputFeatureFactory inputFeatureFactory =
                InputFeatureFactory.getInstance();

            final GraphicsFeatureFactory graphicsFeatureFactory =
                GraphicsFeatureFactory.getInstance();

            final SensorFeatureFactory sensorFeatureFactory =
                    SensorFeatureFactory.getInstance();
            
            features.removeDefault(sensorFeatureFactory.ORIENTATION_SENSORS);
            features.addDefault(sensorFeatureFactory.NO_ORIENTATION);

            features.addDefault(graphicsFeatureFactory.IMAGE_GRAPHICS);
            features.addDefault(graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS);
            
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

            final GameConfigurationCentral gameConfigurationCentral =
                    GameConfigurationCentral.getInstance();

            final SmallIntegerSingletonFactory smallIntegerSingletonFactory = 
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

            this.initOpenGL();

            InitEmulatorFactory.getInstance().setInitEmulator(true);
            
            //this.testGameDemoJOGLMin3dView = new TestGameDemoJOGLOpenGLESView();
            this.glSurfaceView = new TestGameDemoJOGLMin3dView();
            //this.testGameDemoJOGLMin3dView.onEmulatorInitComplete(null);

        } catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e);
        }
    }

    protected void initOpenGL()
    throws Exception
    {
        final OpenGLConfiguration openGLConfiguration = OpenGLConfiguration.getInstance();
        openGLConfiguration.setOpenGL(true);
        openGLConfiguration.init();
        openGLConfiguration.write();        
    }
    
    public void stopAll()
    {
        try
        {
            new Sounds(EarlySoundsFactory.getInstance()).stopAll();
            new Sounds(new TestGameDemoSoundsFactory()).stopAll();
        }
        catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, "stopAll", e);
        }
    }
    
    public void initView() {
        this.glSurfaceView.setMidlet(this);
    }

    protected void exit(boolean isProgress) {
        this.glSurfaceView.onDetachedFromWindow();
        super.exit(isProgress);
    }

    //public void mouseClicked(MouseEvent mouseEvent)
    public void mouseClicked(final int x, final int y, final int button)
    {
        /*
        try
        {
        //logUtil.put(commonStrings.START, this, "mouseClicked");
        motionGestureRecognizer.processPressedMotionEvent(
        PointFactory.getInstance(mouseEvent.getX(), mouseEvent.getY()),
        mouseEvent.getButton());
        }
        catch (Exception e)
        {
        logUtil.put("Exception", this, "mouseClicked", e);
        }
         */
    }

    //public void mousePressed(MouseEvent mouseEvent)
    public void mousePressed(final int x, final int y, final int button)
    {
        try
        {
            //logUtil.put(commonStrings.START + button, this, "mousePressed");
            this.motionRecognizer.processStartMotionEvent(x, y, this.DEVICE_ID, button);
        }
        catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, "mousePressed", e);
        }
    }

    //public void mouseReleased(MouseEvent mouseEvent)
    public void mouseReleased(final int x, final int y, final int button)
    {
        try
        {
            //logUtil.put(commonStrings.START + button, this, "mouseReleased");
            this.dragged = false;
            this.motionRecognizer.processEndMotionEvent(x, y, this.DEVICE_ID, button);
        }
        catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, "mouseReleased", e);
        }
    }

    //public void mouseEntered(MouseEvent mouseEvent)
    {
        //logUtil.put(commonStrings.START, this, "mouseEntered");
    }

    //public void mouseExited(MouseEvent mouseEvent)
    {
        //logUtil.put(commonStrings.START, this, "mouseExited");
    }

    //public void mouseMoved(MouseEvent mouseEvent)
    public void mouseMoved(final int x, final int y, final int button)
    {
        try
        {
            //logUtil.put(commonStrings.START, this, "mouseMoved");
            if(this.dragged) {
                this.motionRecognizer.processDraggedMotionEvent(x, y, this.DEVICE_ID, button);
            } else {
                this.motionRecognizer.processMovedMotionEvent(x, y, DEVICE_ID, button);
            }
        }
        catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, "mouseMoved", e);
        }
    }

    private boolean dragged = false;
    
    //public void mouseDragged(MouseEvent mouseEvent)
    public void mouseDragged(final int x, final int y, final int button)
    {
        try
        {
            //logUtil.put(commonStrings.START, this, "mouseDragged");
            this.dragged = true;
            this.motionRecognizer.processDraggedMotionEvent(x, y, this.DEVICE_ID, button);
        }
        catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, "mouseDragged", e);
        }
    }

    //public void mouseWheelMoved(MouseWheelEvent mouseEvent)
    public void mouseWheelMoved(final int x, final int y, final int button)
    {
        //logUtil.put(commonStrings.START, this, "mouseWheelMoved");
    }

    /*
    private MouseAdapter mouseListener = new MouseAdapter()
    {

    public void mouseClicked(MouseEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mouseClicked");
    }

    public void mousePressed(MouseEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mousePressed");
    }
    };
    private MouseMotionListener mouseMotionListener = new MouseMotionListener()
    {

    public void mouseReleased(MouseEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mouseReleased");
    }

    public void mouseEntered(MouseEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mouseEntered");
    }

    public void mouseExited(MouseEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mouseExited");
    }

    public void mouseMoved(MouseEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mouseMoved");
    }

    public void mouseDragged(MouseEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mouseDragged");
    }
    };
    private MouseWheelListener mouseWheelListener = new MouseWheelListener()
    {

    public void mouseWheelMoved(MouseWheelEvent mouseEvent)
    {
    logUtil.put(commonStrings.START, this, "mouseWheelMoved");
    }
    };
     */
    
}
