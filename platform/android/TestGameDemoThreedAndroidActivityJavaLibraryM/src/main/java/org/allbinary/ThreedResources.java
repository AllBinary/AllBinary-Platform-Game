/*
 * AllBinary Open License Version 1
 * Copyright (c) 2022 AllBinary
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
package org.allbinary;

import org.allbinary.data.resource.ResourceUtil;
import org.allbinary.graphics.threed.min3d.TitleThreedResources;

/**
 *
 * @author User
 */
public class ThreedResources {
 
    private static final ThreedResources threedResources = new ThreedResources();

    /**
     * @return the threedResources
     */
    public static ThreedResources getInstance() {
        return threedResources;
    }
    
    public void add() {
        
        final ResourceUtil resourceUtil = ResourceUtil.getInstance();
        //Integer genericBlock = Integer.valueOf(AndroidResources.raw.generic_obj);
        //Integer genericDrop = Integer.valueOf(AndroidResources.raw.genericdrop_obj);

        //resourceUtil.addResource(GenericModel.RESOURCE, genericBlock);
        //resourceUtil.addResource(GenericDropModel.RESOURCE, genericDrop);
        final TitleThreedResources titleThreedResources = TitleThreedResources.getInstance();
        final AndroidResources androidResources = AndroidResources.getInstance();
        resourceUtil.addResource(titleThreedResources.RESOURCE_TITLE_THREE,
            Integer.valueOf(androidResources.raw.threed_obj)
        );

        //resourceUtil.addResource(carModelResources.SIMPLE_CAR, 
        //Integer.valueOf(androidResources.raw.car_obj)
        //);
        
    }
}
