package org.allbinary.game.testgamedemo.resource;

/*
 *  Note that errors may occur even though your importing R correctly
 *  This usually is caused by Duplicate R classes
 *  Solution is usually to move the R class from the org.allbinary.game.game_name 
 *  package into the independent src directory not part of the multi process apk
 *  Remark out for independent Activities
 */

import org.allbinary.AndroidResources;
import org.allbinary.media.audio.TestSound;

import allbinary.data.resource.ResourceUtil;
import allbinary.game.resource.ResourceInitialization;
import allbinary.media.audio.ErrorSound;
import allbinary.media.audio.SelectSound;
import allbinary.midlet.MidletIcon;

public class TestGameDemoAndroidEarlyResourceInitialization 
extends ResourceInitialization
{
    public void init() 
    throws Exception
    {
        super.init();

        ResourceUtil resourceUtil = ResourceUtil.getInstance();

        AndroidResources androidResources = AndroidResources.getInstance();
        
        resourceUtil.addResource(MidletIcon.RESOURCE, Integer
                .valueOf(androidResources.drawable.testgamedemo_icon));

        resourceUtil.addResource(SelectSound.getInstance().getResource(), Integer
                .valueOf(androidResources.raw.select));

        resourceUtil.addResource(ErrorSound.getInstance().getResource(), Integer
                .valueOf(androidResources.raw.error));
        
        resourceUtil.addResource(TestSound.getInstance().getResource(), Integer
                .valueOf(androidResources.raw.test));

        //resourceUtil.addResource(ExplosionResources.getInstance().EXPLOSION_60_RESOURCE, Integer
          //      .valueOf(AndroidResources.raw.explosion_sprite_60_by_60));
    }
}
