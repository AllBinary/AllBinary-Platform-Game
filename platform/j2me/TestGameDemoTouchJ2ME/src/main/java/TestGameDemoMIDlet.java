
import org.allbinary.game.configuration.GameConfigurationCentral;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GameFeatureFactory;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;
import org.allbinary.game.configuration.feature.InputFeatureFactory;
import org.allbinary.game.configuration.feature.SensorFeatureFactory;
import org.allbinary.game.init.DefaultGameInitializationListener;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.math.SmallIntegerSingletonFactory;

public class TestGameDemoMIDlet
        extends org.allbinary.game.testgamedemo.TestGameDemoMIDlet
{
    public TestGameDemoMIDlet()
    {
        new DefaultGameInitializationListener();
    }

    protected void init()
    {
        final LogUtil logUtil = LogUtil.getInstance();
        try
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.START, this, commonStrings.INIT));

            //ResourceUtil.setClassLoader(this.getClass().getClassLoader());

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

        } catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e));
        }
    }
}
