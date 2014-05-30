package org.allbinary.game.testgamedemo;

import java.util.Hashtable;

import javax.microedition.lcdui.Image;

import org.allbinary.AllBinaryAndroidGameInitializationUtil;
import org.allbinary.AndroidResources;
import org.allbinary.android.AndroidStrings;
import org.allbinary.android.activity.InitEmulatorFactory;
import org.allbinary.android.activity.game.GameMidletActivity;
import org.allbinary.business.advertisement.GameAdStateFactory;
import org.allbinary.configuration.ApplicationConfiguration;
import org.allbinary.graphics.opengles.OpenGLConfiguration;
import org.allbinary.graphics.opengles.OpenGLFeatureFactory;

import abcs.logic.basic.string.CommonStrings;
import abcs.logic.communication.log.LogFactory;
import abcs.logic.communication.log.LogUtil;
import allbinary.game.configuration.GameConfigurationCentral;
import allbinary.game.configuration.feature.Features;
import allbinary.game.configuration.feature.GameFeatureFactory;
import allbinary.game.configuration.feature.GraphicsFeatureFactory;
import allbinary.game.configuration.feature.SensorFeatureFactory;
import allbinary.graphics.canvas.transition.progress.AndroidBasicTitleProgressBar;
import allbinary.graphics.displayable.DisplayInfoSingleton;
import allbinary.image.ImageCacheFactory;
import allbinary.logic.math.SmallIntegerSingletonFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

public class TestDemoGameAndroidActivity extends GameMidletActivity
{
    public TestDemoGameAndroidActivity()
    {
        //super(new ProgressHelper(AndroidResources.id.progressbar));
    }

    protected void init()
    {
        super.init();

        AllBinaryAndroidGameInitializationUtil.init();
    }

    protected void initOpenGL()
    throws Exception
    {
        OpenGLConfiguration openGLConfiguration = 
            OpenGLConfiguration.getInstance();
        openGLConfiguration.setOpenGL(true);
        openGLConfiguration.write();
    }
    
    protected void initViewIds() 
    throws Exception
    {
        this.initOpenGL();

        Features features = Features.getInstance();
        
        OpenGLFeatureFactory openGLFeatureFactory = 
            OpenGLFeatureFactory.getInstance();
        
        features.addDefault(openGLFeatureFactory.OPENGL_2D_AND_3D);
        //features.addDefault(openGLFeatureFactory.OPENGL_SIMPLE_OBJECT3D_PROCESSOR);

        this.initViewIds(
                new int[] {
                        AndroidResources.id.testdemogame,
                        AndroidResources.id.testdemogame_gl
                }
                ,
                new int[] {
                        AndroidResources.layout.testdemogame_layout,
                }
                ,
                new int[] {
                        AndroidResources.layout.testdemogame_gl_layout,
                        AndroidResources.layout.testdemogame_min3d_layout
                      //AndroidResources.layout.testdemogame_alien3d_layout
                }
                ,
                GameAdStateFactory.getInstance().isEnabled()
                );
        
        this.setRootViewId(this.getViewId());
    }

    @Override
    public void onCreate(Bundle icicle)
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, AndroidStrings.getInstance().CREATE));

            super.onCreate(icicle);

            if (this.isStartable())
            {
                this.setBackgrounds();
            }

            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().END, this, AndroidStrings.getInstance().CREATE));
        } catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, AndroidStrings.getInstance().CREATE, e));
        }
    }

    public void onStart()
    {
        try
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, AndroidStrings.getInstance().START));

            super.onStart();

            super.onStart(new TestDemoGameMIDletFactory());

            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().END, this, AndroidStrings.getInstance().START));
        } catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, AndroidStrings.getInstance().START, e));
        }
    }

    /*
    public void onEvent(final AllBinaryEventObject eventObject)
    {
        class OpenGLSetup implements Runnable
        {
            public void run()
            {
                try
                {
                    LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, CommonStrings.getInstance().RUN));

                    AllBinaryMidletOpenGLESView view = (AllBinaryMidletOpenGLESView)
                    TestDemoGameAndroidActivity.this.getView();
                    view.onEvent(eventObject);
                    
                    LogUtil.put(LogFactory.getInstance("End Runnable", this, CommonStrings.getInstance().RUN));
                }
                catch (Exception e)
                {
                    LogUtil.put(LogFactory.getInstance("Execption", this, CommonStrings.getInstance().RUN, e));
                }

            }
        }
        
        this.runOnUiThread(new OpenGLSetup());
    }
    */

    public void initEmulator() throws Exception
    {
        super.initEmulator();

        if (!InitEmulatorFactory.getInstance().isInitEmulator())
        {
            LogUtil.put(LogFactory.getInstance("Init Base GameFeatures", this, "initEmulator"));

            Features features = Features.getInstance();
            
            GameConfigurationCentral gameConfigurationCentral = 
                GameConfigurationCentral.getInstance();

            /*
            gameConfigurationCentral.SCALE
                    .setMinValue(SmallIntegerSingletonFactory.getInstance(2));
            gameConfigurationCentral.SCALE
                    .setMaxValue(SmallIntegerSingletonFactory.getInstance(3));
            gameConfigurationCentral.SCALE
                    .setDefaultValue(SmallIntegerSingletonFactory
                            .getInstance(3));
            gameConfigurationCentral.SCALE.setDefault();
            */

            gameConfigurationCentral.VIBRATION.setDefaultValue(
                    SmallIntegerSingletonFactory.getInstance().getInstance(1));
            gameConfigurationCentral.VIBRATION.setDefault();

            /*
            gameConfigurationCentral.SPEED_CHALLENGE_LEVEL
                    .setDefaultValue(SmallIntegerSingletonFactory
                            .getInstance(4));
            gameConfigurationCentral.SPEED_CHALLENGE_LEVEL.setDefault();

            */

            gameConfigurationCentral.SPEED.setDefaultValue(
                    SmallIntegerSingletonFactory.getInstance().getInstance(9));
            gameConfigurationCentral.SPEED.setDefault();

            GraphicsFeatureFactory graphicsFeatureFactory = 
                GraphicsFeatureFactory.getInstance();
            
            features.addDefault(graphicsFeatureFactory.TRANSPARENT_IMAGE_CREATION);

            features.addDefault(graphicsFeatureFactory.IMAGE_GRAPHICS);

            // Only works for small - large causes unknown problem
            // GameFeatures.getInstance().addDefault(GameFeature.SPRITE_QUARTER_ROTATION_GRAPHICS);
            // Out of memory error
            // GameFeatures.getInstance().addDefault(GameFeature.SPRITE_FULL_ROTATION_GRAPHICS);
            features.addDefault(graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS);

            // GameFeatures.getInstance().addDefault(GameFeature.HEALTH_BARS);
            // GameFeatures.getInstance().addDefault(GameFeature.DAMAGE_FLOATERS);

            // GameFeatures.getInstance().addDefault(GameFeature.DROPPED_ITEMS);

            features.addDefault(
                    GameFeatureFactory.getInstance().SOUND);

            SensorFeatureFactory sensorFeatureFactory = 
                SensorFeatureFactory.getInstance();

            features.removeDefault(sensorFeatureFactory.ORIENTATION_SENSORS);
            features.addDefault(sensorFeatureFactory.NO_ORIENTATION);
            
            InitEmulatorFactory.getInstance().setInitEmulator(true);
        }
    }

    public void setBackgrounds() throws Exception
    {
        LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this, "getBackground"));

        ApplicationConfiguration reloadConfiguration = 
            ApplicationConfiguration.getInstance();
        
        Drawable drawable = this.getResources().getDrawable(
                AndroidResources.drawable.testdemogame_wait_256_by_256);
        
        if (reloadConfiguration.isProgressBarView())
        {
            // Draws a big progress circle in front of image
            // this.getProgressHelper().getProgressBar().setBackgroundDrawable(drawable);
            // Hides progress circle under image

            this.getProgressHelper().getProgressBar().setIndeterminateDrawable(drawable);
        } else
        {
            DisplayInfoSingleton displayInfo = DisplayInfoSingleton.getInstance();
            
            View view = this.getRootView();
            displayInfo.setLastWidth(view.getWidth());
            displayInfo.setLastHeight(view.getHeight());
            
            Bitmap bitmap =((BitmapDrawable)drawable).getBitmap();

            Hashtable hashtable = ImageCacheFactory.getInstance().getHashtable();
            
            hashtable.put(AndroidBasicTitleProgressBar.RESOURCE, new Image(bitmap));
            
            AndroidBasicTitleProgressBar.setBackground(
                    AndroidResources.drawable.testdemogame_wait_256_by_256
                    );
        }
   }        
}