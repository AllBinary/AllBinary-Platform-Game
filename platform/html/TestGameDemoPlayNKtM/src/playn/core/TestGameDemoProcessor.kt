
        /*
                *  
                *  To change this template, choose Tools | Templates  and open the template in the editor.  
        */
        
        /* Generated Code Do Not Modify */
        package playn.core




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.canvas.Processor
import org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import org.allbinary.input.motion.button.TouchButtonBlankResource
import org.allbinary.input.motion.button.TouchButtonDownResource
import org.allbinary.input.motion.button.TouchButtonGenericActionResource
import org.allbinary.input.motion.button.TouchButtonStartResource
import org.allbinary.input.motion.button.TouchButtonStrafeLeftResource
import org.allbinary.input.motion.button.TouchButtonStrafeRightResource
import org.allbinary.input.motion.button.TouchButtonTurnLeftResource
import org.allbinary.input.motion.button.TouchButtonTurnRightResource
import org.allbinary.input.motion.button.TouchButtonUpResource
import org.allbinary.input.motion.button.TouchScreenFactory
import org.allbinary.playn.processors.GameHtmlHasLoadedResourcesProcessor
import org.allbinary.playn.processors.GameHtmlLoadResourcesProcessor
import org.allbinary.playn.processors.MidletStartupProcessor
import org.allbinary.util.BasicArrayList

open public class TestGameDemoProcessor : Processor {
        

    private val list: BasicArrayList
public constructor (list: BasicArrayList){
    //var list = list
this.list= list
}


                @Throws(Exception::class)
            
    open fun process()
        //nullable = true from not(false or (false and true)) = true
{
this.list.remove(0)

    
                        if(TouchScreenFactory.getInstance()!!.isTouch())
                        
                                    {
                                    
    var resourceStringArray: Array<String?> = arrayOf(TouchButtonBlankResource.getInstance()!!.RESOURCE,TouchButtonGenericActionResource.getInstance()!!.RESOURCE,TouchButtonStartResource.getInstance()!!.RESOURCE,TouchButtonUpResource.getInstance()!!.RESOURCE,TouchButtonDownResource.getInstance()!!.RESOURCE,TouchButtonTurnLeftResource.getInstance()!!.RESOURCE,TouchButtonTurnRightResource.getInstance()!!.RESOURCE,TouchButtonStrafeLeftResource.getInstance()!!.RESOURCE,TouchButtonStrafeRightResource.getInstance()!!.RESOURCE)

list.add(GameHtmlLoadResourcesProcessor(list, resourceStringArray))

    var gameHtmlHasLoadedResourcesProcessor: Processor = GameHtmlHasLoadedResourcesProcessor(list, resourceStringArray)

list.add(gameHtmlHasLoadedResourcesProcessor)

                                    }
                                
list.add(MidletStartupProcessor(list))
ProgressCanvasFactory.getInstance()!!.addPortion(10, "Loading")
}


}
                
            

