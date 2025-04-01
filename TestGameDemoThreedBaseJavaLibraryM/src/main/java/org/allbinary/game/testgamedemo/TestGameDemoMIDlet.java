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
package org.allbinary.game.testgamedemo;

import org.allbinary.game.testgamedemo.canvas.TestGameDemoGameCanvas;
import org.allbinary.game.testgamedemo.canvas.TestGameDemoInputMappingHelpPaintable;
import org.allbinary.game.canvas.TestGameDemoSoftwareInfo;
import org.allbinary.game.testgamedemo.canvas.TestGameDemoStartCanvas;
import org.allbinary.game.testgamedemo.layer.TestGameDemoLayerManager;
import org.allbinary.media.audio.TestGameDemoSoundsFactoryFactory;

import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.game.GameInfo;
import org.allbinary.game.GameMode;
import org.allbinary.game.GameTypeFactory;
import org.allbinary.game.PlayerTypesFactory;
import org.allbinary.game.displayable.canvas.GameCanvasRunnableInterface;
import org.allbinary.game.layer.AllBinaryGameLayerManager;
import org.allbinary.game.midlet.LicenseLevelUtil;
import org.allbinary.game.midlet.LicenseLoadingTypeFactory;
import org.allbinary.game.midlet.SpecialDemoGameMidlet;
import org.allbinary.game.paint.help.HelpPaintable;
import org.allbinary.game.score.BasicHighScoresFactory;
import org.allbinary.game.score.HighScoresPaintable;
import org.allbinary.game.score.displayable.HighScoresCanvas;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.logic.system.security.licensing.ClientInformationFactory;
import org.allbinary.media.audio.AllBinaryMediaManagerShutdown;
import org.allbinary.media.audio.EarlySoundsFactory;

/**
 * @author user
 */
public class TestGameDemoMIDlet extends
   SpecialDemoGameMidlet
   //DemoGameMidlet
{
   public TestGameDemoMIDlet(final ClientInformationFactory clientInformationFactory)
   {
       super(clientInformationFactory, LicenseLoadingTypeFactory.getIntance().OTHER);
       //this.setSaveGameForm(SaveGameForm.getInstance(this, "Save Game"));
   }
   
   protected HelpPaintable getHelpPaintable()
   throws Exception
   {
       //return TestGameDemoHelpPaintable.getInstance();
       return TestGameDemoInputMappingHelpPaintable.getInstance();
   }
   
   public GameCanvasRunnableInterface createDemoGameCanvasRunnableInterface() throws Exception
   {
      return new TestGameDemoStartCanvas(this.abeClientInformation, this);
   }

   protected GameCanvasRunnableInterface createGameCanvasRunnableInterface(
		   final AllBinaryGameLayerManager allBinaryGameLayerManager) throws Exception
   {
	   return new TestGameDemoGameCanvas(this.abeClientInformation, this, allBinaryGameLayerManager);
   }
   
   protected HighScoresCanvas createHighScoresCanvas() throws Exception
   {
       return new HighScoresCanvas(this,
               this.createGameLayerManager(),
               new HighScoresPaintable(),
               new BasicHighScoresFactory(this.abeClientInformation, TestGameDemoSoftwareInfo.getInstance()));
   }

   public int getHighestLevel()
   {
	   PreLogUtil.put("******************Demo Level Limited To: 6", this, "getMaxLevel");
       return LicenseLevelUtil.getInstance().getMaxLevel(TestGameDemoLayerManager.MAX_LEVEL, 6);
   }

   protected AllBinaryGameLayerManager createGameLayerManager()
   {
       GameInfo gameInfo = new GameInfo(
               GameTypeFactory.getInstance().SINGLE_PLAYER, GameMode.SERVER,
               PlayerTypesFactory.getInstance().PLAYER_TYPE_ONE,
               this.getHighestLevel(), 1);

       return new TestGameDemoLayerManager(gameInfo);
   }

   /*
   protected void mediaInit() throws Exception
   {
   }
   */

   protected void mediaShutdown() throws Exception
   {
        //PreLogUtil.put(CommonStrings.getInstance().START, this, "mediaShutdown - postStopGameCanvasRunnableInterface");

        LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().START, this,
                "mediaShutdown - postStopGameCanvasRunnableInterface"));

        AllBinaryMediaManagerShutdown.shutdown(
           EarlySoundsFactory.getInstance());
        AllBinaryMediaManagerShutdown.shutdown(
           TestGameDemoSoundsFactoryFactory.getInstance());

        LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().END, this,
                "mediaShutdown - postStopGameCanvasRunnableInterface"));
   }
}