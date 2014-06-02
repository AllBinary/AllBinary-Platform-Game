/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playn.core;

import allbinary.canvas.Processor;
import allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import allbinary.input.motion.button.TouchButtonBlankResource;
import allbinary.input.motion.button.TouchButtonDownResource;
import allbinary.input.motion.button.TouchButtonGenericActionResource;
import allbinary.input.motion.button.TouchButtonStartResource;
import allbinary.input.motion.button.TouchButtonStrafeLeftResource;
import allbinary.input.motion.button.TouchButtonStrafeRightResource;
import allbinary.input.motion.button.TouchButtonTurnLeftResource;
import allbinary.input.motion.button.TouchButtonTurnRightResource;
import allbinary.input.motion.button.TouchButtonUpResource;
import allbinary.input.motion.button.TouchScreenFactory;
import org.allbinary.playn.processors.GameHtmlHasLoadedResourcesProcessor;
import org.allbinary.playn.processors.GameHtmlLoadResourcesProcessor;
import org.allbinary.playn.processors.MidletStartupProcessor;
import org.allbinary.util.BasicArrayList;

/**
 *
 * @author user
 */
public class TestGameDemoProcessor
        extends Processor
{

    private final BasicArrayList list;

    public TestGameDemoProcessor(final BasicArrayList list)
    {
        this.list = list;
    }

    public void process() throws Exception
    {
        this.list.remove(0);

        //ExplosionResources explosionResources = ExplosionResources.getInstance();
        //PlayerShipResources basicShipResources = PlayerShipResources.getInstance();
        if (TouchScreenFactory.getInstance().isTouch())
        {
            String[] resourceStringArray =
            {
                TouchButtonBlankResource.getInstance().RESOURCE,
                TouchButtonGenericActionResource.getInstance().RESOURCE,
                TouchButtonStartResource.getInstance().RESOURCE,
                TouchButtonUpResource.getInstance().RESOURCE,
                TouchButtonDownResource.getInstance().RESOURCE,
                TouchButtonTurnLeftResource.getInstance().RESOURCE,
                TouchButtonTurnRightResource.getInstance().RESOURCE,
                TouchButtonStrafeLeftResource.getInstance().RESOURCE,
                TouchButtonStrafeRightResource.getInstance().RESOURCE,
            };

            list.add(new GameHtmlLoadResourcesProcessor(list, resourceStringArray));

            Processor gameHtmlHasLoadedResourcesProcessor
                    = new GameHtmlHasLoadedResourcesProcessor(list, resourceStringArray);

            list.add(gameHtmlHasLoadedResourcesProcessor);
        }

        list.add(new MidletStartupProcessor(list));

        ProgressCanvasFactory.getInstance().addPortion(10, "Loading");
    }
}
