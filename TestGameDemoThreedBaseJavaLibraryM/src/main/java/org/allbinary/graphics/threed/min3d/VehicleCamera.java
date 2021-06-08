package org.allbinary.graphics.threed.min3d;

import javax.microedition.khronos.opengles.GL10;

import min3d.vos.Camera;
import min3d.vos.Number3d;
import android.opengl.GLU;

/**
 * Encapsulates camera-related properties, including view frustrum.
 */
public class VehicleCamera extends Camera
{
    private float offsetY;
    
    public VehicleCamera()
    {
    }

    public void lookAt(GL10 gl)
    {
        // + 33
        Number3d position = target.getPosition();
        GLU.gluLookAt(gl, this.position.x, this.position.y, this.position.z,
                position.x, position.y + offsetY, position.z, 
                upAxis.x, upAxis.y, upAxis.z);
    }

    public void setOffsetY(float offsetY)
    {
        this.offsetY = offsetY;
    }

    public float getOffsetY()
    {
        return offsetY;
    }

}
