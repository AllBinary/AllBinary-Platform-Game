package org.allbinary.graphics.threed.min3d;

import javax.microedition.khronos.opengles.GL10;

import min3d.core.Object3d;
import min3d.core.TextureManager;
import min3d.parser.ModelType;
import min3d.parser.ModelTypeFactory;
import min3d.vos.CameraFactory;
import min3d.vos.light.Light;

import org.allbinary.ThreedResources;
import org.allbinary.animation.AnimationInterfaceFactoryInterface;
import org.allbinary.animation.threed.ThreedAnimationSingletonFactory;
import org.allbinary.game.identification.BasicGroupFactory;
import org.allbinary.game.identification.Group;
import org.allbinary.game.layer.AllBinaryGameLayerManager;
import org.allbinary.game.layer.SimpleGameLayer;
import org.allbinary.game.testgamedemo.layer.TestGameDemoLayerManager;
import org.allbinary.graphics.PointFactory;
import org.allbinary.graphics.Rectangle;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.graphics.opengles.OpenGLCapabilities;
import org.allbinary.graphics.opengles.shader.AppRendererShaderUpdaterFactory;
import org.allbinary.graphics.threed.min3d.renderer.AllBinaryToMin3dRendererFactory;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.logic.java.bool.BooleanFactory;
import org.allbinary.string.CommonStrings;
import org.allbinary.view.StaticViewPosition;

public class TestGameDemoSceneController 
extends AllBinaryGameSceneController
{
    private final String TAG = "TestGameDemoSceneController";

    private final OpenGLCapabilities openGLCapabilities = OpenGLCapabilities.getInstance();

    public TestGameDemoSceneController()
    {
        // super(new RendererFactory());
        //super(new RendererFactory(), new CameraFactory(), new AllBinarySceneFactory(), true);
        //super(new CompositeMin3dRendererFactory(), new CameraFactory(), new AllBinarySceneFactory(), true);
        ////super(new Min3dAllBinaryRendererFactory(), new CameraFactory(), new AllBinarySceneFactory(), true);
        super(new AllBinaryToMin3dRendererFactory(), new CameraFactory(), new AllBinarySceneFactory(), false, false);
        
        PreLogUtil.put(CommonStrings.getInstance().START, TAG, CommonStrings.getInstance().CONSTRUCTOR);
    }

    private boolean initialized;

    final int portion = 100;
    final String loadingString = this.toString() + " Loading: ";
    int index;
    

    //private final TextureListFactory textureListFactory = TextureListFactory.getInstance();
    //private final Min3dSceneResourcesFactory min3dSceneResourcesFactory = Min3dSceneResourcesFactory.getInstance();

    //Object3dContainer _cube;
    
	@Override 
	public void updateScene()
	{
		//PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, "updateScene");

		/*
		 * Do any manipulation of scene properties or to objects in the scene here.
		 */
		//_cube.getRotationOrigin().y++;
	}

    @Override
    public void initScene(GL10 gl)
    {
        final String METHOD_NAME = "initScene";

        try
        {
            PreLogUtil.put(CommonStrings.getInstance().START, this, METHOD_NAME);

            index = 1;

            final String glInstanceVersion = openGLCapabilities.glInstanceVersion;
            
            final ProgressCanvas progressCanvas = ProgressCanvasFactory.getInstance();
            
            progressCanvas.addEarlyPortion(portion, loadingString, index++);
            
            //When I can get resources fixed for opengl then I reload without loading models again.
            //if(!this.initialized) 
            //{
              //  this.initialized = true;
            //}

            final Min3dSceneResourcesFactory min3dSceneResourcesFactory = 
                    Min3dSceneResourcesFactory.getInstance();
            final ModelTypeFactory modelTypeFactory = ModelTypeFactory.getInstance();
            final ModelType OBJ = modelTypeFactory.OBJ;
            final Boolean FALSE = BooleanFactory.getInstance().FALSE;
            final ThreedLoaderFactory threedLoaderFactory = ThreedLoaderFactory.getInstance();
                        
            final TitleThreedResources titleThreedResources = TitleThreedResources.getInstance();
            
          //Lights and resources don't need to be added again
            if(!this.initialized)
            {

              ThreedResources.getInstance().add();
              
              progressCanvas.addEarlyPortion(portion, loadingString, index++);

              final Light light = new Light();

              light.ambient.setAll(128,128,128, 255);
              light.ambient.commitToFloatBuffer();

              if(scene.getLights().size() > 0)
              {
                  scene.getLights().reset();
              }
              
              scene.getLights().add(light);

              PreLogUtil.put("Minimal 3d Example", this, METHOD_NAME);
            
//                _cube = new Box(1, 1, 1, null, BooleanFactory.getInstance().TRUE,
//                        BooleanFactory.getInstance().TRUE, BooleanFactory.getInstance().FALSE);
//
//                _cube.setNormalsEnabled(true);
//
//                _cube.setColorMaterialEnabled(false);
//
//                scene.addChild(_cube);              
              
              //this.initialized = true;
            }
            else
            {
                TextureManager.getInstance().reset(gl);
            }

            progressCanvas.addEarlyPortion(portion, loadingString, index++);
            
          final Object3d titleThreeObject3dContainer = threedLoaderFactory.getObject3dInstance(
                  titleThreedResources.RESOURCE_TITLE_THREE, gl, glInstanceVersion, OBJ, FALSE);

          titleThreeObject3dContainer.setShaderComposite(AppRendererShaderUpdaterFactory.getInstance().shaderCompositeArray[0]);

          //titleThreeObject3dContainer.getScale().x = 
              //titleThreeObject3dContainer.getScale().y = 
                  //titleThreeObject3dContainer.getScale().z = 3f;

          min3dSceneResourcesFactory.add(titleThreedResources.RESOURCE_TITLE_THREE, new Object3d[] {titleThreeObject3dContainer});
                  
            progressCanvas.addEarlyPortion(portion, loadingString, index++);

            //vehicleObject3dContainer = threedLoaderFactory.getObject3dInstance(
                    //carModelResources.SIMPLE_CAR, gl, OBJ, FALSE);

            //vehicleObject3dContainer.getScale().x = 
                //vehicleObject3dContainer.getScale().y = 
                    //vehicleObject3dContainer.getScale().z = 13f;

            //min3dSceneResourcesFactory.add(
                    //carModelResources.SIMPLE_CAR, vehicleObject3dContainer);
            
            progressCanvas.addEarlyPortion(portion, loadingString, index++);

            PreLogUtil.put(CommonStrings.getInstance().END, this, METHOD_NAME);                
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, METHOD_NAME, e));
        }
    }

    //private CameraLayer cameraLayer;
    
    public void buildScene(AllBinaryGameLayerManager layerManager) throws Exception
    {
        try
        {
            PreLogUtil.put(CommonStrings.getInstance().START, this, "buildScene");
            
            //Reset the scene
            //scene.reset();

            final TestGameDemoLayerManager testGameDemoLayerManager = (TestGameDemoLayerManager) layerManager;

            final Min3dSceneResourcesFactory min3dSceneResourcesFactory = 
                    Min3dSceneResourcesFactory.getInstance();
            
            final TitleThreedResources titleThreedResources = TitleThreedResources.getInstance();
            
//              final Group groupInterface = BasicGroupFactory.getInstance().GOOD;
//              final AnimationInterfaceFactoryInterface animationInterfaceFactoryInterface = 
//                      new ThreedAnimationSingletonFactory(_cube);
//              final int width = 20;
//              final int height = 20;
//              final Rectangle layerInfo = new Rectangle(PointFactory.getInstance().ZERO_ZERO, width, height);
//
//              final SimpleGameLayer simpleGameLayer = new SimpleGameLayer(
//                      groupInterface,
//                      animationInterfaceFactoryInterface,
//                      layerInfo, new StaticViewPosition(0,0,0));
//              
//              ((AllBinaryScene) scene).getThreedLayerManagerListener().getList().add(simpleGameLayer);
            
            final Object3d[] titleThreeObject3dContainerArray = min3dSceneResourcesFactory.get(titleThreedResources.RESOURCE_TITLE_THREE);
            
              final Group groupInterface = BasicGroupFactory.getInstance().GOOD;
              final AnimationInterfaceFactoryInterface animationInterfaceFactoryInterface = 
                      new ThreedAnimationSingletonFactory(titleThreeObject3dContainerArray[0]);
              final int width = 20;
              final int height = 20;
              final Rectangle layerInfo = new Rectangle(PointFactory.getInstance().ZERO_ZERO, width, height);

              final SimpleGameLayer simpleGameLayer = new SimpleGameLayer(
                      groupInterface,
                      animationInterfaceFactoryInterface,
                      layerInfo, new StaticViewPosition(0,0,0));

              titleThreeObject3dContainerArray[0].getRotationOrigin().y -= 90;
              
              testGameDemoLayerManager.append(simpleGameLayer);
            
            /*
            Object3d object3d1 = ((ThreedAnimation) 
                    featuredAnimationInterfaceFactoryInterfaceFactory.get(RedBlockModel.RESOURCE).getInstance()).getObject3d();

            Object3d rectangleObject3d = ((ThreedAnimation) 
                    featuredAnimationInterfaceFactoryInterfaceFactory.get(RectangleModel.RESOURCE).getInstance()).getObject3d();

            object3d.getScale().x = object3d.getScale().y = object3d.getScale().z = 7f;
            
            object3d1.getScale().x = object3d1.getScale().y = object3d1.getScale().z = 4f;

            rectangleObject3d.getPosition().x = -5f;
            rectangleObject3d.getPosition().z = -5f;
            rectangleObject3d.setDoubleSidedEnabled(true);
            rectangleObject3d.setLightingEnabled(false);
            */

            //scene.getCamera().target = object3d;

//            cameraLayer.processTick(layerManager);
//            layerManager.append(cameraLayer);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "buildScene", e));
        }
    }

    public void processEarlyGameAction()
    {
    }

    public void processStartGameAction()
    {
    }

    private final String NAME = "TestGameDemo Scene";

    public String toString()
    {
        return NAME;
    }
}
