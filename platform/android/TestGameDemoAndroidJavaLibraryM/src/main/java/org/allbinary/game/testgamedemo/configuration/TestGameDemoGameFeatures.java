package org.allbinary.game.testgamedemo.configuration;

import org.allbinary.input.gyro.OrientationData;
import org.allbinary.util.BasicArrayList;

import allbinary.game.configuration.GameConfigurationCentral;
import allbinary.game.configuration.GameConfigurationSingleton;
import allbinary.game.configuration.feature.GameFeatureChoiceGroups;
import allbinary.game.configuration.feature.GameFeatureFactory;
import allbinary.game.configuration.feature.SensorFeatureFactory;
import allbinary.init.Init;

public class TestGameDemoGameFeatures extends Init
{
    public TestGameDemoGameFeatures()
    {
        
    }
    
    public void init() throws Exception
    {
        final String GRAPHICS_OPTIONS = "Graphics Options";
        
        BasicArrayList exclusiveOrientationSensorList = new BasicArrayList();

        SensorFeatureFactory sensorFeatureFactory = 
            SensorFeatureFactory.getInstance();

        exclusiveOrientationSensorList.add(
                sensorFeatureFactory.ORIENTATION_SENSORS);
        exclusiveOrientationSensorList.add(
                sensorFeatureFactory.NO_ORIENTATION);
        //exclusiveOrientationSensorList.add(
          //      sensorFeatureFactory.SIMULATED_ORIENTATION_SENSORS);

        //Features.getInstance().removeDefault(
          //      SensorFeatureFactory.getInstance().ORIENTATION_SENSORS);
        //Features.getInstance().addDefault(
          //      SensorFeatureFactory.getInstance().SIMULATED_ORIENTATION_SENSORS);
        
        /*
        BasicArrayList exclusiveOrientationTypeList = new BasicArrayList();
        exclusiveOrientationTypeList.add(GameFeature.YAW_AND_PITCH);
        exclusiveOrientationTypeList.add(GameFeature.PITCH_AND_ROLL);
        */
        
        GameConfigurationSingleton gameConfigurationSingleton = 
            GameConfigurationSingleton.getInstance();
        
        GameConfigurationCentral gameConfigurationCentral = 
            GameConfigurationCentral.getInstance();

        gameConfigurationSingleton.add(gameConfigurationCentral.VIBRATION);
        gameConfigurationSingleton.add(gameConfigurationCentral.ORIENTATION);

        // gameConfigurationSingleton.add(gameConfigurationCentral.CONTROL_LEVEL);
        gameConfigurationSingleton.add(gameConfigurationCentral.SPEED);

        BasicArrayList multipleList = new BasicArrayList();

        multipleList.add(GameFeatureFactory.getInstance().SOUND);
        multipleList.add(GameFeatureFactory.getInstance().SCREEN_SHAKE);
        //multipleList.add(GameFeature.OPENGL);

        //multipleBasicArrayList.add(GameFeature.TRANSISTION_ANIMATIONS);

        // graphicsOptionsBasicArrayList.add(GameFeature.);

        GameFeatureChoiceGroups.getMultipleInstance().add(
                GRAPHICS_OPTIONS, multipleList);

        GameFeatureChoiceGroups.getExclusiveInstance().add(
                OrientationData.getInstance().ORIENTATION_SENSOR_INPUT, 
                exclusiveOrientationSensorList);

        //GameFeatureChoiceGroups.getExclusiveInstance().add(ORIENTATION_TYPE,
          //      exclusiveOrientationTypeBasicArrayList);
    }
}
