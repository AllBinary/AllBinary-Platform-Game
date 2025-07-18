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

import org.allbinary.game.canvas.TestGameDemoSoftwareInfo;
import javax.microedition.lcdui.CommandListener;
import org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory;
import org.allbinary.animation.special.SpecialAnimation;

import org.allbinary.game.testgamedemo.init.TestGameDemoStaticInitializerFactory;
import org.allbinary.game.testgamedemo.layer.TestGameDemoLayerManager;

import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.game.GameInfo;
import org.allbinary.game.GameMode;
import org.allbinary.game.GameTypeFactory;
import org.allbinary.game.PlayerTypesFactory;
import org.allbinary.game.configuration.GameSpeed;
import org.allbinary.game.displayable.canvas.DemoCanvas;
import org.allbinary.game.displayable.canvas.GameCanvasRunnableInterface;
import org.allbinary.game.displayable.canvas.TitleResource;
import org.allbinary.game.layer.AllBinaryGameLayerManager;
import org.allbinary.game.paint.ColorFillPaintableFactory;
import org.allbinary.game.score.BasicHighScoresFactory;
import org.allbinary.graphics.color.BasicColorFactory;
import org.allbinary.graphics.form.FormPaintable;
import org.allbinary.graphics.paint.NullInitUpdatePaintable;
import org.allbinary.graphics.paint.NullPaintable;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;

public class TestGameDemoStartCanvas extends DemoCanvas
{
    //protected final LogUtil logUtil = LogUtil.getInstance();

    private final int WAIT = ((GameSpeed.getInstance().getDelay() * 3) >> 1);

    public TestGameDemoStartCanvas(final AbeClientInformationInterface abeClientInformation, final CommandListener commandListener) throws Exception
    {
        super(abeClientInformation, commandListener, 
                new BasicHighScoresFactory(abeClientInformation, TestGameDemoSoftwareInfo.getInstance()),
                NullPaintable.getInstance(), NullInitUpdatePaintable.getInstance(),
                new TestGameDemoStaticInitializerFactory(), false);

        this.setWait(WAIT);
    }

    public void initPostPaint() throws Exception
    {
        this.setBasicGameDemoPaintable(
                new TestDemoPaintable(new FormPaintable(this.getMenuForm()))
                );

        this.setSpecialAnimationInterface(
                (SpecialAnimation) 
                FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(
                        TitleResource.RESOURCE_TITLE).getInstance(0));        

        this.setDefaultPaintableInterface(
                ColorFillPaintableFactory.getInstance().getInstance(BasicColorFactory.getInstance().RED, true));
        
        //TrueTypeFontUtil.getInstance().saveFontAtlasAsFile();
    }

    protected int getNextRandom()
    {
    	PreLogUtil.put("******************Demo Next Random Is Always 1", this, "getNextRandom");
        // return MyRandom.getAbsoluteNextInt(Integer.MAX_VALUE / 10) + 1;
        return 1;
    }

    protected AllBinaryGameLayerManager createGameLayerManager(int randomValue) throws Exception
    {
        GameInfo gameInfo = new GameInfo(GameTypeFactory.getInstance().BOT, GameMode.SERVER, PlayerTypesFactory
                .getInstance().PLAYER_TYPE_ONE, TestGameDemoLayerManager.MAX_LEVEL, randomValue);

        return new TestGameDemoLayerManager(gameInfo);
    }

    public GameCanvasRunnableInterface createRunnable(int randomValue) throws Exception
    {
        return new TestGameDemoGameCanvas(this.abeClientInformation, null, this.createGameLayerManager(this.getNextRandom()));
    }
}