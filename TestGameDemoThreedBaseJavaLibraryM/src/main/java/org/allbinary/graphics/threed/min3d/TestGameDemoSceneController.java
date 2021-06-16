package org.allbinary.graphics.threed.min3d;

import org.allbinary.logic.basic.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.logic.java.bool.BooleanFactory;
import org.allbinary.logic.system.os.OperatingSystemFactory;
import org.allbinary.logic.system.os.OperatingSystemInterface;
import org.allbinary.animation.RotationAnimation;
import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.game.GameTypeFactory;
import org.allbinary.game.layer.AllBinaryGameLayerManager;
import org.allbinary.graphics.RectangleFactory;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.graphics.color.BasicColorFactory;
import org.allbinary.view.ViewPosition;
import javax.microedition.khronos.opengles.GL10;
import min3d.core.Object3d;
import min3d.core.TextureManager;
import min3d.objectPrimitives.Rectangle;
import min3d.parser.ModelType;
import min3d.parser.ModelTypeFactory;
import min3d.vos.CameraFactory;
import min3d.vos.light.Light;
import org.allbinary.AndroidResources;
import org.allbinary.android.AndroidInfoFactory;
import org.allbinary.animation.TextureListFactory;
import org.allbinary.animation.ThreedAnimation;
import org.allbinary.game.layer.CameraLayer;
import org.allbinary.game.layer.SimpleVehicleFollowCameraLayer;
import org.allbinary.graphics.opengles.OpenGLCapabilities;
import org.allbinary.graphics.threed.min3d.renderer.Min3dAllBinaryRendererFactory;
import org.allbinary.graphics.threed.min3d.renderer.Object3dContainerUtil;
import org.allbinary.graphics.threed.min3d.renderer.RendererFactory;

public class TestGameDemoSceneController 
extends AllBinaryGameSceneController
{
    private final String TAG = "TestGameDemoSceneController";
    
    public TestGameDemoSceneController()
    {
        // super(new RendererFactory());
        //super(new Min3dAllBinaryRendererFactory(), new VehicleCameraFactory(), new AllBinarySceneFactory(), true);
        super(new Min3dAllBinaryRendererFactory(), new CameraFactory(), new AllBinarySceneFactory(), true);
        //super(new RendererFactory(), new CameraFactory(), new AllBinarySceneFactory(), true);
        
        PreLogUtil.put(CommonStrings.getInstance().START, TAG, CommonStrings.getInstance().CONSTRUCTOR);
    }

    private boolean initialized;

    final int portion = 100;
    final String loadingString = this.toString() + " Loading: ";
    int index;
    

    //private final TextureListFactory textureListFactory = TextureListFactory.getInstance();
    //private final Min3dSceneResourcesFactory min3dSceneResourcesFactory = Min3dSceneResourcesFactory.getInstance();

    @Override
    public void initScene(GL10 gl)
    {
        final String METHOD_NAME = "initScene";

        try
        {
            PreLogUtil.put(CommonStrings.getInstance().START, this, METHOD_NAME);

            index = 1;

            ProgressCanvas progressCanvas = ProgressCanvasFactory.getInstance();
            
            progressCanvas.addEarlyPortion(portion, loadingString, index++);
            
            ResourceUtil resourceUtil = ResourceUtil.getInstance();
            
            //When I can get resources fixed for opengl then I reload without loading models again.
            //if(!this.initialized) 
            //{
              //  this.initialized = true;
            //}

            //Integer genericBlock = Integer.valueOf(AndroidResources.raw.generic_obj);
            //Integer genericDrop = Integer.valueOf(AndroidResources.raw.genericdrop_obj);
            
            //resourceUtil.addResource(GenericModel.RESOURCE, genericBlock);
            //resourceUtil.addResource(GenericDropModel.RESOURCE, genericDrop);

            Min3dSceneResourcesFactory min3dSceneResourcesFactory = 
                    Min3dSceneResourcesFactory.getInstance();
            ModelTypeFactory modelTypeFactory = ModelTypeFactory.getInstance();
            ModelType OBJ = modelTypeFactory.OBJ;
            Boolean FALSE = BooleanFactory.getInstance().FALSE;
            ThreedLoaderFactory threedLoaderFactory = ThreedLoaderFactory.getInstance();
                        
            TitleThreedResources titleThreedResources = TitleThreedResources.getInstance();

            //CarModelResources carModelResources = CarModelResources.getInstance();

            final AndroidResources androidResources = AndroidResources.getInstance();
            
          //Lights and resources don't need to be added again
            if(!this.initialized)
            {              
              resourceUtil.addResource(titleThreedResources.RESOURCE_TITLE_THREE, 
                      Integer.valueOf(androidResources.raw.threed_obj)
                      );
              
              //resourceUtil.addResource(carModelResources.SIMPLE_CAR, 
                      //Integer.valueOf(androidResources.raw.car_obj)
                      //);
              
              progressCanvas.addEarlyPortion(portion, loadingString, index++);

              Light light = new Light();

              light.ambient.setAll(128,128,128, 255);
              light.ambient.commitToFloatBuffer();

              //scene.getLights().reset();
              scene.getLights().add(light);

              this.initialized = true;
            }
            else
            {
                TextureManager.getInstance().reset(gl);
            }
              
            /*
            Object3d genericObject3dContainer = threedLoaderFactory.getObject3dInstance(
                    GenericModel.RESOURCE, gl, OBJ, TRUE);

            genericObject3dContainer.getScale().x = 
                genericObject3dContainer.getScale().y = 
                    genericObject3dContainer.getScale().z = 10f;

            progressCanvas.addEarlyPortion(portion, loadingString, index++);
            
            Object3d genericSmallObject3dContainer = genericObject3dContainer.clone();
            genericSmallObject3dContainer.getScale().x = 
                genericSmallObject3dContainer.getScale().y = 
                    genericSmallObject3dContainer.getScale().z = 0.5f;
            
            progressCanvas.addEarlyPortion(portion, loadingString, index++);
            
            Object3d genericDropObject3dContainer = threedLoaderFactory.getObject3dInstance(
                    GenericDropModel.RESOURCE, gl, OBJ, TRUE);

            genericDropObject3dContainer.getScale().x = 
                genericDropObject3dContainer.getScale().y = 
                    genericDropObject3dContainer.getScale().z = 10f;
            */

            //Object3d titleOneObject3dContainer = threedLoaderFactory.getObject3dInstance(
            //      titleThreedResources.RESOURCE_TITLE_ONE, gl, OBJ, TRUE);

          //titleOneObject3dContainer.getScale().x = 
            //  titleOneObject3dContainer.getScale().y = 
              //    titleOneObject3dContainer.getScale().z = 6f;
          
          //Object3d titleTwoObject3dContainer = threedLoaderFactory.getObject3dInstance(
            //      titleThreedResources.RESOURCE_TITLE_TWO, gl, OBJ, TRUE);

          //titleTwoObject3dContainer.getScale().x = 
            //  titleTwoObject3dContainer.getScale().y = 
              //    titleTwoObject3dContainer.getScale().z = 6f;

            progressCanvas.addEarlyPortion(portion, loadingString, index++);
            
          Object3d titleThreeObject3dContainer = threedLoaderFactory.getObject3dInstance(
                  titleThreedResources.RESOURCE_TITLE_THREE, gl, OBJ, FALSE);
          
          titleThreeObject3dContainer.getScale().x = 
              titleThreeObject3dContainer.getScale().y = 
                  titleThreeObject3dContainer.getScale().z = 3f;

          //min3dSceneResourcesFactory.add(titleThreedResources.RESOURCE_TITLE_ONE, titleOneObject3dContainer);
          //min3dSceneResourcesFactory.add(titleThreedResources.RESOURCE_TITLE_TWO, titleTwoObject3dContainer);
          min3dSceneResourcesFactory.add(titleThreedResources.RESOURCE_TITLE_THREE, titleThreeObject3dContainer);
            
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
    
    //private PlayerVehicleLayer playerVehicleLayer;

    private CameraLayer cameraLayer;
    
    public void buildScene(AllBinaryGameLayerManager layerManager) throws Exception
    {
        try
        {
            PreLogUtil.put(CommonStrings.getInstance().START, this, "buildScene");
            
            //Reset the scene
            scene.reset();

            VehicleCamera vehicleCamera = (VehicleCamera) scene.getCamera();

            cameraLayer = new SimpleVehicleFollowCameraLayer( 
                //new SimpleFollowCameraLayer(
                //new ExampleRotateAroundTargetCameraLayer(
                //new ExampleLockedCameraLayer(
                    vehicleCamera, RectangleFactory.SINGLETON, new ViewPosition(),
                    200, 200, 200);

            if (layerManager.getGameInfo().getGameType() != GameTypeFactory.getInstance().BOT)
            {
                vehicleCamera.setOffsetY(10f);
            }
            else
            {
                vehicleCamera.setOffsetY(8f);
            }

            //rear angle - may need to change as incline grade changes
            //cameraLayer.setRotationY((short) 5);
            //cameraLayer.setRotationY((short) 15);

            int SDK_VERSION = AndroidInfoFactory.getInstance().getVersion();

            if(SDK_VERSION > 7)
            {
                if (OpenGLCapabilities.getInstance().isVertexBufferObjectSupport()) {
                    OperatingSystemInterface operatingSystem
                            = OperatingSystemFactory.getInstance().getOperatingSystemInstance();

                    if (operatingSystem.isOverScan()) {
                        cameraLayer.setRotationY((short) 33);
                    } else {
                        cameraLayer.setRotationY((short) 45);
                    }

                } else {
                    OperatingSystemInterface operatingSystem
                            = OperatingSystemFactory.getInstance().getOperatingSystemInstance();

                    if (operatingSystem.isOverScan()) {
                        cameraLayer.setRotationY((short) 45);
                    } else {
                        cameraLayer.setRotationY((short) 67);
                    }
                }
            } else {
                cameraLayer.setRotationY((short) 67);
            }

            //cameraLayer.setRotationY((short) 90);

            cameraLayer.updateCamera();

            //ZeptoRacerLayerManager zeptoRacerLayerManager = (ZeptoRacerLayerManager) layerManager;

            //PlayerVehicleLayer playerVehicleLayer = (PlayerVehicleLayer) zeptoRacerLayerManager.getVehicleLayerArray()[0];

            //VehicleRotationAnimation vehicleRotationAnimation = (VehicleRotationAnimation) playerVehicleLayer.getIndexedAnimationInterface();

            //RotationAnimation rotationAnimation = 
                //vehicleRotationAnimation.getRotationAnimationInterface();

            //Object3d object3d = ((ThreedAnimation) rotationAnimation).getObject3d();

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

            cameraLayer.processTick(layerManager);
            layerManager.append(cameraLayer);
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "buildScene", e));
        }
    }

    public void processEarlyGameAction()
    {
        OperatingSystemInterface operatingSystem = 
                OperatingSystemFactory.getInstance().getOperatingSystemInstance();
        
        if(operatingSystem.isOverScan())
        {
            this.cameraLayer.zoomIn(70, 550);
        }
        else
        {
            this.cameraLayer.zoomIn(50, 200);
        }
    }

    public void processStartGameAction()
    {
        OperatingSystemInterface operatingSystem = 
                OperatingSystemFactory.getInstance().getOperatingSystemInstance();
        
        if(operatingSystem.isOverScan())
        {
            this.cameraLayer.setZoom(75);
        }
        else
        {
            this.cameraLayer.setZoom(55);
        }
    }

    private final String NAME = "ZeptoRacer Scene";

    public String toString()
    {
        return NAME;
    }

    public CameraLayer getCameraLayer()
    {
        return cameraLayer;
    }

    /*
    public PlayerGameInputCompositeInterface getPlayerGameInputCompositeInterface()
    {
        return (PlayerGameInputCompositeInterface) playerVehicleLayer;
    }
    */
}
