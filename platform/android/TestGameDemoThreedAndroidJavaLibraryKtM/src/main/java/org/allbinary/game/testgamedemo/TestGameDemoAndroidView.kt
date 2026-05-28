
        /* Generated Code Do Not Modify */
        package org.allbinary.game.testgamedemo




        import java.lang.Object        
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import org.allbinary.android.view.AllBinaryMidletView
import android.content.Context
import android.util.AttributeSet
import org.allbinary.string.CommonStrings
import org.allbinary.logic.communication.log.PreLogUtil

open public class TestGameDemoAndroidView : AllBinaryMidletView {
        

    private val TAG: String = "TestGameDemoAndroidView"
public constructor (context: Context, attrs: AttributeSet)                        

                            : super(context, attrs){
var context = context
var attrs = attrs


                            //For kotlin this is before the body of the constructor.
                    

    var commonStrings: CommonStrings = CommonStrings.getInstance()!!

PreLogUtil.put(commonStrings!!.START, TAG, commonStrings!!.CONSTRUCTOR)
}


}
                
            

