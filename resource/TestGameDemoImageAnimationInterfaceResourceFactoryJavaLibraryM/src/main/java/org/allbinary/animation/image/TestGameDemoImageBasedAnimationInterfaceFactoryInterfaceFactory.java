/*
* AllBinary Open License Version 1
* Copyright (c) 2011 AllBinary
* 
* By agreeing to this license you and any business entity you represent are
* legally bound to the AllBinary Open License Version 1 legal agreement.
* 
* You may obtain the AllBinary Open License Version 1 legal agreement from
* AllBinary or the root directory of AllBinary's AllBinary Platform repository.
* 
* Created By: Travis Berthelot
* 
*/
package org.allbinary.animation.image;

import org.allbinary.graphics.opengles.OpenGLFeatureFactory;

import org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GraphicsFeatureFactory;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.image.ImageCache;
import org.allbinary.image.ImageCacheFactory;
import org.allbinary.logic.string.StringMaker;

public class TestGameDemoImageBasedAnimationInterfaceFactoryInterfaceFactory
        extends BaseResourceAnimationInterfaceFactoryInterfaceFactory
{
    public TestGameDemoImageBasedAnimationInterfaceFactoryInterfaceFactory()
    {
        super("Image Animations");
    }

    public TestGameDemoImageBasedAnimationInterfaceFactoryInterfaceFactory(String name)
    {
        super(name);
    }
    
    public void init(int level)
    throws Exception
    {
        this.init(ImageCacheFactory.getInstance(), level);
    }

    protected void init(ImageCache imageCache, int level)
    throws Exception
    {
        if(this.isInitialized())
        {
            return;
        }

        final int portion = 120;
        final StringMaker stringMaker = new StringMaker();
        final String loadingString = stringMaker.append(this.toString()).append(" Loading: ").toString();
        
        int index = 0;

        final ProgressCanvas progressCanvas = 
            ProgressCanvasFactory.getInstance();

        stringMaker.delete(0, stringMaker.length());
        progressCanvas.addPortion(portion, stringMaker.append(loadingString).append(index++).toString());

        this.addRectangles();

        stringMaker.delete(0, stringMaker.length());
        progressCanvas.addPortion(portion, stringMaker.append(loadingString).append(index++).toString());

        //Image EXPLOSION_IMAGE = imageCache.get(
          //      ExplosionResources.getInstance().EXPLOSION_60_RESOURCE);

        //int scaleDenominator = 2;
        //int explosionFrameSize = (60 * GameConfigurationCentral.getInstance().SCALE.getValue().intValue()) / scaleDenominator;

        //LogUtil.put(LogFactory.getInstance("Explosiont: ").append(explosionFrameSize).append(" ").append(explosionFrameSize/2).append(" ").append(explosionFrameSize/4, this, CommonStrings.getInstance().INIT));
        //90 x 360

        //this.add(ExplosionResources.getInstance().EXPLOSION_60_RESOURCE, 
          //      new SpriteIndexedAnimationFactory(
            //    EXPLOSION_IMAGE, 
              //  explosionFrameSize, explosionFrameSize));

        //progressCanvas.addPortion(portion, loadingString, index++);

        //this.add(TouchButtonLoginResource.RESOURCE, 
          //      new OneRowSpriteIndexedAnimationFactory(
            //    imageCache.get(TouchButtonLoginResource.RESOURCE)));
        
        super.init(level);
    }
    
    public boolean isLoadingLevel(int level)
    {
        if(level > 0  && level < Integer.MAX_VALUE - 100)
        {
            return true;
        }
        else
        {
            return super.isLoadingLevel(level);
        }
    }
    
    public boolean isFeature()
    {
        Features features = Features.getInstance();
        
        if (features.isFeature(
                GraphicsFeatureFactory.getInstance().IMAGE_GRAPHICS) &&
            features.isFeature(
                GraphicsFeatureFactory.getInstance().IMAGE_TO_ARRAY_GRAPHICS) &&
            !features.isDefault(
                OpenGLFeatureFactory.getInstance().OPENGL))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void addRectangles() throws Exception
    {
       //this.addRectangle(BossOneShipResources.getInstance().RESOURCE, new Rectangle(PointFactory
         //       .ZERO_ZERO, 52, 52));
    }
}