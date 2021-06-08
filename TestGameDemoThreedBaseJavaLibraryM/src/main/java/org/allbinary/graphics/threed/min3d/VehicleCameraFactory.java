package org.allbinary.graphics.threed.min3d;

import min3d.vos.Camera;
import min3d.vos.CameraFactory;

public class VehicleCameraFactory extends CameraFactory
{
    public Camera getInstance()
    {
        return new VehicleCamera();
    }
}
