package org.allbinary.animation.image;

import org.allbinary.animation.NullSpecialAnimationFactory;
import org.allbinary.game.resource.ResourceLoadingLevelFactory;
import org.allbinary.graphics.opengles.OpenGLFeatureFactory;
import org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;
import org.allbinary.game.displayable.canvas.TitleResource;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;

public class TestGameDemoEarlyResourcesOpenGLBasedAnimationInterfaceFactoryInterfaceFactory
extends 
//ZeptoRacerEarlyResourcesImageArrayBasedAnimationInterfaceFactoryInterfaceFactory
BaseResourceAnimationInterfaceFactoryInterfaceFactory
{
    protected final LogUtil logUtil = LogUtil.getInstance();

    public TestGameDemoEarlyResourcesOpenGLBasedAnimationInterfaceFactoryInterfaceFactory()
    {
        super("Early OpenGL Animations");
    }

    public void init(final int level) throws Exception
    {
        logUtil.put(this.getName(), this, "init");
        
        //this.init(OpenGLImageCacheFactory.getInstance(), level);

        if(this.isInitialized())
        {
            return;
        }

        final ResourceLoadingLevelFactory resourceLoadingLevelFactory = 
            ResourceLoadingLevelFactory.getInstance();

        int portion = 120;
        if(level == resourceLoadingLevelFactory.LOAD_EARLY.getLevel())
        {
            portion = 10;
        }

        final String loadingString = this.toString() + " Loading: ";

        int index = 1;

        final ProgressCanvas progressCanvas = ProgressCanvasFactory.getInstance();

        progressCanvas.addPortion(portion, loadingString, index++);
        
        //final String TIRE = VehicleStrings.getInstance().TIRE;

        /*
        animationInterfaceArray[0] = (IndexedAnimation)
        new ThreedAnimationFactory(min3dSceneResourcesFactory.get(
                titleThreedResources.RESOURCE_TITLE_ONE)).getInstance();
        animationInterfaceArray[1] = (IndexedAnimation)
        new ThreedAnimationFactory(min3dSceneResourcesFactory.get(
                titleThreedResources.RESOURCE_TITLE_TWO)).getInstance();
        */
        
        this.add(TitleResource.RESOURCE_TITLE,
            NullSpecialAnimationFactory.getFactoryInstance()
        );

        super.init(level);
    }

    public boolean isLoadingLevel(int level)
    {
        final ResourceLoadingLevelFactory resourceLoadingLevelFactory = 
            ResourceLoadingLevelFactory.getInstance();

        if (level == resourceLoadingLevelFactory.LOAD_EARLY.getLevel())
        {
            logUtil.put(this.getName(), this, "isLoadingLevel");
            return true;
        }
        else
        {
            return super.isLoadingLevel(level);
        }
    }
    
    public boolean isFeature()
    {
        final Features features = Features.getInstance();
        
        final GraphicsFeatureFactory graphicsFeatureFactory = 
            GraphicsFeatureFactory.getInstance();
        
        final OpenGLFeatureFactory openGLFeatureFactory = 
            OpenGLFeatureFactory.getInstance();
        
        if (features.isFeature(graphicsFeatureFactory.IMAGE_GRAPHICS) && 
            features.isFeature(graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS) &&
            features.isDefault(openGLFeatureFactory.OPENGL) &&
            !(features.isFeature(openGLFeatureFactory.OPENGL_2D_AND_3D) || features.isFeature(openGLFeatureFactory.OPENGL_3D))
            )
        {
            logUtil.put(this.getName(), this, "isFeature");
            return true;
        } else
        {
            return false;
        }
    }
}
