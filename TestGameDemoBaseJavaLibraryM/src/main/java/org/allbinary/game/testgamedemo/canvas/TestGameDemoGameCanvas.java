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
package org.allbinary.game.testgamedemo.canvas;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Graphics;

import org.allbinary.game.testgamedemo.init.TestGameDemoStaticInitializerFactory;
import org.allbinary.game.testgamedemo.level.TestGameDemoLevelBuilder;
import org.allbinary.input.accelerometer.AccelerometerSensorFactory;
import org.allbinary.input.gyro.AllBinaryOrientationSensor;
import org.allbinary.input.gyro.GyroSensorFactory;
import org.allbinary.media.audio.TestGameDemoSoundsFactoryFactory;
import org.allbinary.media.audio.TestSound;
import org.allbinary.util.BasicArrayList;

import org.allbinary.string.CommonStrings;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.ai.OptimizedArtificialIntelligenceLayerProcessorForCollidableLayer;
import org.allbinary.game.GameInfo;
import org.allbinary.game.GameTypeFactory;
import org.allbinary.game.IntermissionFactory;
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo;
import org.allbinary.game.collision.OptimizedAllBinaryCollisionLayerProcessorForCollidableLayer;
import org.allbinary.game.configuration.GameSpeed;
import org.allbinary.game.configuration.event.ChangedGameFeatureListener;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GameFeature;
import org.allbinary.game.configuration.feature.GameFeatureFactory;
import org.allbinary.game.configuration.feature.TouchFeatureFactory;
import org.allbinary.game.displayable.canvas.AllBinaryGameCanvas;
import org.allbinary.game.displayable.canvas.GamePerformanceInitUpdatePaintable;
import org.allbinary.game.displayable.canvas.StartIntermissionPaintable;
import org.allbinary.game.input.OptimizedGameInputLayerProcessorForCollidableLayer;
import org.allbinary.game.layer.AllBinaryGameLayerManager;
import org.allbinary.game.layer.PlayerGameInputGameLayer;
import org.allbinary.game.layer.identification.GroupLayerManagerListener;
import org.allbinary.game.score.BasicHighScoresFactory;
import org.allbinary.game.state.GameState;
import org.allbinary.game.tick.OptimizedTickableLayerProcessor;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvas;
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import org.allbinary.graphics.color.BasicColorFactory;
import org.allbinary.graphics.displayable.DisplayInfoSingleton;
import org.allbinary.graphics.displayable.command.MyCommandsFactory;
import org.allbinary.input.motion.button.BaseTouchInput;
import org.allbinary.input.motion.button.TestGameDemoNeededTouchButtonsBuilder;
import org.allbinary.input.motion.button.TestGameDemoTouchButtonsBuilder;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.media.AllBinaryVibration;
import org.allbinary.media.audio.AllBinaryMediaManager;
import org.allbinary.media.audio.PlayerQueue;
import org.allbinary.media.audio.PrimaryPlayerQueueFactory;
import org.allbinary.media.audio.SecondaryPlayerQueueFactory;
import org.allbinary.time.TimeDelayHelper;

public class TestGameDemoGameCanvas extends AllBinaryGameCanvas
{
    protected final LogUtil logUtil = LogUtil.getInstance();

    private final int WAIT = GameSpeed.getInstance().getDelay();

    private final int portion = 4;
    
    private final AbeClientInformationInterface abeClientInformation;
    
    public TestGameDemoGameCanvas(final AbeClientInformationInterface abeClientInformation, final CommandListener commandListener,
            final AllBinaryGameLayerManager allBinaryGameLayerManager) throws Exception
    {
        super(commandListener, allBinaryGameLayerManager, 
                new BasicHighScoresFactory(abeClientInformation, TestGameDemoSoftwareInfo.getInstance()),
                new TestGameDemoStaticInitializerFactory(),
           //new BasicBuildGameInitializerFactory(),
           false);
        
        this.abeClientInformation = abeClientInformation;
    }
    
    protected void initSpecialPaint()
    {
        super.initSpecialPaint();

        this.setStartIntermissionPaintable(new StartIntermissionPaintable(
                this, new String[] {StringUtil.getInstance().EMPTY_STRING}, new int[] {0}, BasicColorFactory.getInstance().RED));
    }

    public void mediaInit() throws Exception
    {
        logUtil.put(commonStrings.START, this, "mediaInit");
        AllBinaryMediaManager.init(TestGameDemoSoundsFactoryFactory.getInstance());
    }

    //Don't Auto Hide instead update the list
    protected  void updateTouch()
    throws Exception
    {
        GameInfo gameInfo = this.gameLayerManager.getGameInfo();
        
        if(gameInfo.getGameType() != GameTypeFactory.getInstance().BOT)
        {
            BaseTouchInput nextTouchInputFactory =
                TestGameDemoTouchButtonsBuilder.getInstance(
                        this.getSensorGameUpdateProcessor());

            if(Features.getInstance().isFeature(
                    TouchFeatureFactory.getInstance().AUTO_HIDE_SHOW_SCREEN_BUTTONS))
            {
                if(gameInfo.getCurrentLevel() - getStartLevel() >= 1)
                {
                    nextTouchInputFactory = 
                        TestGameDemoNeededTouchButtonsBuilder.getInstance(
                                this.getSensorGameUpdateProcessor());
                }
            }
            this.updateCurrentTouchInputFactory(nextTouchInputFactory);
        }
    }

    protected synchronized void initConfigurable(final AbeClientInformationInterface abeClientInformation)
    {
        try
        {

            final ProgressCanvas progressCanvas = ProgressCanvasFactory.getInstance();

            if (ChangedGameFeatureListener.getInstance().isChanged())
            {
                super.initConfigurable(abeClientInformation);

                progressCanvas.addPortion(portion, "Group Manager");
                GroupLayerManagerListener.getInstance().init(3);

                AllBinaryVibration.init();

                //super.initConfigurable(portion);

                ChangedGameFeatureListener.getInstance().setChanged(false);

                if (!this.isRunningInAnotherThread())
                {
                    return;
                }
            } else
            {
            	progressCanvas.addPortion(4, "Skipping Configurable");
            }
            
        } catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, "initConfigurable", e);
        }
    }

    protected void threadInit() throws Exception
    {
        try
        {
            final int portion = 60;
            super.init(this.abeClientInformation);

            if (!this.isRunningInAnotherThread())
            {
                return;
            }

            if (!this.isInitialized())
            {
                if (!this.isRunningInAnotherThread())
                {
                    return;
                }

                ProgressCanvas progressCanvas = 
                    ProgressCanvasFactory.getInstance();
                
                progressCanvas.addPortion(portion, "Main Processors");

                this.setWait(WAIT);
                this.loadState();

                BasicArrayList list = new BasicArrayList();

                Features features = Features.getInstance();
                
                GameFeatureFactory gameFeatureFactory = GameFeatureFactory.getInstance();
                
                if (features.isFeature(gameFeatureFactory.ARTIFICIAL_INTELLEGENCE_PROCESSOR))
                {
                    list.add(new OptimizedArtificialIntelligenceLayerProcessorForCollidableLayer());
                }

                if (features.isFeature(gameFeatureFactory.GAME_INPUT_LAYER_PROCESSOR))
                {
                    list.add(new OptimizedGameInputLayerProcessorForCollidableLayer());
                }

                if (features.isFeature(gameFeatureFactory.COLLIDABLE_INTERFACE_LAYER_PROCESSOR))
                {
                    list.add(new OptimizedAllBinaryCollisionLayerProcessorForCollidableLayer());
                }

                if (features.isFeature(gameFeatureFactory.TICKABLE_LAYER_PROCESSOR))
                {
                    list.add(new OptimizedTickableLayerProcessor());
                }

                gameLayerManager.setLayerProcessorList(list);

                progressCanvas.addPortion(portion, "Initializing Game");
            }

            this.buildGame(false);

        } catch (Exception e)
        {
            logUtil.put(commonStrings.EXCEPTION, this, "_init", e);
        }
    }

    public void buildGame(boolean isProgress) throws Exception
    {
        if (!this.isRunningInAnotherThread()) {
            return;
        }
        
        this.loadResources(gameLayerManager.getGameInfo().getCurrentLevel());
        
        ProgressCanvas progressCanvas = ProgressCanvasFactory.getInstance();
        
        int portion = 30;
        if (isProgress && this.isMainCanvas())
        {            
            progressCanvas.start();

            this.getCustomCommandListener().commandAction(
                    MyCommandsFactory.getInstance().SET_DISPLAYABLE,
                    progressCanvas);
            //progressCanvas.waitUntilDisplayed();
            portion = 4;
        }

        //Combat games
        //this.cleanupGame();
        PrimaryPlayerQueueFactory.getInstance().clear();
        SecondaryPlayerQueueFactory.getInstance().clear();
        gameLayerManager.cleanup();

        if (!this.isRunningInAnotherThread())
        {
            return;
        }

        //this.getLayerManager().append(new PlayerGameInputGameLayer());

        //DestroyedEventHandler.getInstance().removeAllListeners();

        //Some games update intermission here

        progressCanvas.addPortion(portion, "Building Game Level");

        new TestGameDemoLevelBuilder(this).build();

        progressCanvas.addPortion(portion, "Set Background");

        //Some games update backgrounds here

        //this.playerLayer = ((TestGameDemoLayerManager) this.getLayerManager()).getPlayerLayer();

        //DestroyedEventHandler.getInstance().addListener((EventListenerInterface) playerLayer);

        if (!this.isRunningInAnotherThread())
        {
            return;
        }

        gameLayerManager.append(new PlayerGameInputGameLayer(0));

        progressCanvas.addPortion(portion, "Ending Custom Build");

        if (gameLayerManager.getGameInfo().getGameType() != GameTypeFactory.getInstance().BOT)
        {
            //PrimaryPlayerQueueFactory.getInstance().add(
                    //GameSounds.getBegin());
        }

        super.buildGame(portion);

        this.getStartIntermissionInterface().setEnabled(true);
        this.getEndLevelIntermissionInterface().setEnabled(false);
        
        // A canvas not in GameState.PLAYING_GAME_STATE will not appear in
        // democanvas
        this.setGameState(GameState.PLAYING_GAME_STATE);
    }

    public void setGameState(GameState gameState) throws Exception
    {
        super.setGameState(gameState);

        IntermissionFactory intermissionFactory = IntermissionFactory.getInstance();
        
        if (this.getGameState() == GameState.PLAYING_GAME_STATE)
        {
            this.setMainStateProcessor(this.getProcessGameProcessor());
        }
        else if (this.getGameState() == intermissionFactory.WAIT_LEVEL_INTERMISSION_GAME_STATE
                || this.getGameState() == intermissionFactory.SHOW_RESULTS_LEVEL_INTERMISSION_GAME_STATE
                || this.getGameState() == intermissionFactory.SHOW_HIGH_SCORE_LEVEL_INTERMISSION_GAME_STATE)
        {
            //GameKeyEventHandler.getInstance().addListener(this.getIntermissionPlayerGameInput());
            
            //this.setMainStateProcessor(this.processEndIntermissionProcessor);
        }
        else
        {
            // Game plays in non intermission and after death
            this.setMainStateProcessor(this.getProcessGameProcessor());
        }
    }
    
    private final GamePerformanceInitUpdatePaintable gamePerformanceInitUpdatePaintable = 
        new GamePerformanceInitUpdatePaintable();

    private final AllBinaryOrientationSensor gyroOrientationSensor = GyroSensorFactory.getInstance();
    private final AllBinaryOrientationSensor accelerometerOrientationSensor = AccelerometerSensorFactory.getInstance();
    
    private final int halfHeight = DisplayInfoSingleton.getInstance().getLastHalfHeight();

    //private String soundQueue = PrimaryPlayerQueueFactory.getInstance().toString();
    
    public void draw(Graphics graphics)
    {
        //logUtil.put(commonStrings.START, this, "draw");
        
        this.clear(graphics);

        this.basicSetColorUtil.setBasicColor(graphics, gameLayerManager.getForegroundBasicColor());

        //graphics.drawString(TEXT, 0, halfHeight, 0);

        /*
        graphics.drawString(soundQueue, 0, halfHeight + 15, 0);
        */

    	gameLayerManager.paint(graphics, 0, 0);

    	nonBotPaintable.paint(graphics);

        gameSpecificPaintable.paint(graphics);    	

    	gamePerformanceInitUpdatePaintable.paint(graphics);
        
        touchPaintable.paint(graphics);
        
        screenCapture.saveFrame();

        graphics.drawString(this.gyroOrientationSensor.toString(), 0, halfHeight + 30 + 60, 0);
        graphics.drawString(this.accelerometerOrientationSensor.toString(), 0, halfHeight + 30 + 75, 0);

        this.getTouchPaintable().paint(graphics);
    }

    private TimeDelayHelper playerTimeDelayHelper = new TimeDelayHelper(2000);
            //890);

    private final PlayerQueue primaryPlayerQueue = PrimaryPlayerQueueFactory.getInstance();
    private final PlayerQueue secondaryPlayerQueue = SecondaryPlayerQueueFactory.getInstance();
    
    private final Features features = Features.getInstance();
    
    private final GameFeature soundGameFeature = GameFeatureFactory.getInstance().SOUND;
    
    protected void processGame() throws Exception
    {
        if (playerTimeDelayHelper.isTime())
        {
            if(this.features.isFeature(soundGameFeature))
            {
                this.primaryPlayerQueue.add(TestSound.getInstance());
            }
        }
    	
        super.processGame();
        
        /*
        if (playerTimeDelayHelper.isTime())
        {
            if (!this.primaryPlayerQueue.process())
            {
                if (this.secondaryPlayerQueue.process())
                {
                    playerTimeDelayHelper.setStartTime();
                }
            } else
            {
                playerTimeDelayHelper.setStartTime();
            }
        }

        
        if (!this.primaryPlayerQueue.process())
        {
            this.secondaryPlayerQueue.process();
        }
        
        */
        
        //soundQueue = this.primaryPlayerQueue.toString();
        
        this.gamePerformanceInitUpdatePaintable.update();
    }
}