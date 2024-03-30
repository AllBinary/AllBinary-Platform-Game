package org.allbinary.animation.image;

import org.allbinary.graphics.opengles.OpenGLFeatureFactory;
import org.allbinary.graphics.threed.min3d.Min3dSceneResourcesFactory;
import org.allbinary.image.opengles.OpenGLImageCacheFactory;

import org.allbinary.animation.AnimationInterfaceFactoryInterface;
import org.allbinary.animation.NullRotationAnimationFactory;
import org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.game.combat.damage.ExplosionResources;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.image.ImageCache;

public class TestGameDemoGameResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory
        extends BaseResourceAnimationInterfaceFactoryInterfaceFactory
{
    public TestGameDemoGameResourcesOpenGLThreedBasedAnimationInterfaceFactoryInterfaceFactory()
    {
        super("OpenGL Image Animations");
    }

    private int index = 1;
    
    public void init(int level) 
    throws Exception
    {
        if(this.isInitialized())
        {
            return;
        }
        
        final int portion = 120;
        final String loadingString = this.toString() + " Loading: ";
        
        index = 1;

        ProgressCanvas progressCanvas = ProgressCanvasFactory.getInstance();

        progressCanvas.addPortion(portion, loadingString, index++);

        //this.addRectangles();

        ImageCache imageCache = OpenGLImageCacheFactory.getInstance();
        Min3dSceneResourcesFactory min3dSceneResourcesFactory = 
            Min3dSceneResourcesFactory.getInstance();

        progressCanvas.addPortion(portion, loadingString, index++);

        ExplosionResources explosionResources = ExplosionResources.getInstance();

        this.add(explosionResources.EXPLOSION_60_RESOURCE,
                NullRotationAnimationFactory.getFactoryInstance());

        progressCanvas.addPortion(portion, loadingString, index++);

        this.add(explosionResources.HALF_EXPLOSION_RESOURCE,
                NullRotationAnimationFactory.getFactoryInstance()
        );

        progressCanvas.addPortion(portion, loadingString, index++);

        // 3 or 5
        this.add(explosionResources.THIRD_EXPLOSION_RESOURCE,
                NullRotationAnimationFactory.getFactoryInstance()
        );

        AnimationInterfaceFactoryInterface[] basicAnimationInterfaceFactoryInterfaceArray;

        progressCanvas.addPortion(portion, loadingString, index++);

        super.init(level);
    }
    
    public boolean isFeature()
    {
        Features features = Features.getInstance();

        GraphicsFeatureFactory graphicsFeatureFactory = 
            GraphicsFeatureFactory.getInstance();

        OpenGLFeatureFactory openGLFeatureFactory = 
            OpenGLFeatureFactory.getInstance();

        if (features.isFeature(graphicsFeatureFactory.IMAGE_GRAPHICS) && 
            features.isFeature(graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS) &&
            features.isDefault(openGLFeatureFactory.OPENGL) &&
            (features.isFeature(openGLFeatureFactory.OPENGL_2D_AND_3D) || features.isFeature(openGLFeatureFactory.OPENGL_3D))
            )
        {
            return true;
        } else
        {
            return false;
        }
    }
    
}