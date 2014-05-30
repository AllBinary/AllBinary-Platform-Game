/**
 * Copyright 2010 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.core;

import abcs.logic.basic.string.CommonStrings;
import allbinary.data.resource.ResourceUtil;
import allbinary.graphics.color.BasicColorFactory;
import java.io.InputStream;
import org.microemu.device.Device;
import org.microemu.device.DeviceFactory;
import org.microemu.device.playn.PlaynDevice;
import org.microemu.device.playn.PlaynSurfaceDisplayGraphics;
import static playn.core.PlayN.*;

import playn.core.util.Callback;
//http://localhost:8080/minispacewarvector-html-1.0-SNAPSHOT/
public class GraphicsTestGame implements Game, Keyboard.Listener {

  private static final int NUM_STARS = 10;

  private SurfaceLayer gameLayer;

  private float touchVectorX, touchVectorY;

  private Device device;
  private javax.microedition.lcdui.Graphics graphics;
  private javax.microedition.lcdui.Image image;
    
  @Override
  public void init() {
      
      Graphics graphics = graphics();
      
    graphics.setSize(800, 600);

    gameLayer = graphics.createSurfaceLayer(graphics.width(), graphics.height());
    graphics.rootLayer().add(gameLayer);

    keyboard().setListener(this);

    pointer().setListener(new Pointer.Listener() {
      @Override
      public void onPointerEnd(Pointer.Event event) {
        touchVectorX = touchVectorY = 0;
      }
      @Override
      public void onPointerDrag(Pointer.Event event) {
        touchMove(event.x(), event.y());
      }
      @Override
      public void onPointerStart(Pointer.Event event) {
        touchMove(event.x(), event.y());
      }
    });

    //Do something until loading is done here
    /*
    platform().net().get("/rpc?progress", new Callback<String>() {
      @Override
      public void onSuccess(String json) {
          //new game
      }

      @Override
      public void onFailure(Throwable error) {
        platform().log("error loading map");
      }
    });
    */

        DeviceFactory.setDevice(new PlaynDevice());
        this.device = DeviceFactory.getDevice();
        this.graphics = new PlaynSurfaceDisplayGraphics(this.gameLayer.surface());
        this.graphics.setColor(BasicColorFactory.getInstance().WHITE.intValue());

    try
    {
        InputStream inputStream = ResourceUtil.getInstance().getResourceAsStream("/testdemogame_icon.png");
        this.image = javax.microedition.lcdui.Image.createImage(inputStream);
    }
    catch(Exception e)
    {
        PlayN.log().error(CommonStrings.getInstance().EXCEPTION, e);
    }

  }
  
  @Override
  public void onKeyDown(Keyboard.Event event) 
  {
  }

  @Override
  public void onKeyUp(Keyboard.Event event) {
  }

  @Override
  public void update(float delta)
  {
  }

  private final char aChar = 'Z';
  private final char[] charArray = {
      'A','l','l','B','i','n','a','r','y'
  };
  private final String string = "AllBinary";
  
  @Override
  public void paint(float alpha)
  {
    Surface surface = gameLayer.surface();
    surface.clear();

    //TWB - Graphics test code
    this.graphics.drawLine(0, 0, 100, 100);
    this.graphics.drawLine(100, 0, 0, 100);
    this.graphics.drawRect(200, 200, 233, 50);
    this.graphics.fillRect(300, 300, 233, 50);
    this.graphics.drawArc(100, 100, 40, 40, 0, 360);
    this.graphics.fillArc(150, 150, 30, 30, 0, 360);

    this.graphics.drawChar(aChar, 20, 10, 0);
    this.graphics.drawChars(charArray, 0, charArray.length, 45, 10, 0);
    this.graphics.drawString(string, 100, 10, 0);
    this.graphics.drawImage(this.image, 20, 50, 0);
  }

  private void touchMove(float x, float y) {
    float cx = graphics().screenWidth() / 2;
    float cy = graphics().screenHeight() / 2;

    touchVectorX = (x - cx) * 1.0f / cx;
    touchVectorY = (y - cy) * 1.0f / cy;
  }

  private void post(String payload) {
    net().post("/rpc", payload, new Callback<String>() {
      @Override
      public void onSuccess(String response) {
        // Nada.
      }

      @Override
      public void onFailure(Throwable error) {
        // TODO
      }
    });
  }

  @Override
  public int updateRate() {
    return 33;
  }
}
