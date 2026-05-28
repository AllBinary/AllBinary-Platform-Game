
        /*
                *  
                *  AllBinary Open License Version 1 
                *  Copyright (c) 2022 AllBinary 
                *   
                *  By agreeing to this license you and any business entity you represent are 
                *  legally bound to the AllBinary Open License Version 1 legal agreement. 
                *   
                *  You may obtain the AllBinary Open License Version 1 legal agreement from 
                *  AllBinary or the root directory of AllBinary's AllBinary Platform repository. 
                *   
                *  Created By: Travis Berthelot    
        */
        
        /* Generated Code Do Not Modify */
        package org.microemu.app




        import java.lang.Object        
        
        import java.lang.System
        
        
        import kotlin.Array
        import kotlin.reflect.KClass
        
import java.nio.BufferOverflowException
import java.nio.BufferUnderflowException
import java.nio.ByteBuffer
import java.util.Collection

open public class DirectByteBufferTest
            : Object
         {
        
companion object {
            
    open fun assertEquals(first: Byte, second: Byte)
        //nullable = true from not(false or (false and false)) = true
{
var first = first
var second = second

    
                        if(first != second)
                        
                                    {
                                    


                            throw RuntimeException(first +" is not equals to: " +second)

                                    }
                                
}


    open fun assertEquals(first: Short, second: Short)
        //nullable = true from not(false or (false and false)) = true
{
var first = first
var second = second

    
                        if(first != second)
                        
                                    {
                                    


                            throw RuntimeException(first +" is not equals to: " +second)

                                    }
                                
}


    open fun assertEquals(first: Int, second: Int)
        //nullable = true from not(false or (false and false)) = true
{
var first = first
var second = second

    
                        if(first != second)
                        
                                    {
                                    


                            throw RuntimeException(first +" is not equals to: " +second)

                                    }
                                
}


    open fun assertEquals(first: Long, second: Long)
        //nullable = true from not(false or (false and false)) = true
{
var first = first
var second = second

    
                        if(first != second)
                        
                                    {
                                    


                            throw RuntimeException(first +" is not equals to: " +second)

                                    }
                                
}


    open fun assertEquals(first: Float, second: Float)
        //nullable = true from not(false or (false and false)) = true
{
var first = first
var second = second

    
                        if(first != second)
                        
                                    {
                                    


                            throw RuntimeException(first +" is not equals to: " +second)

                                    }
                                
}


    open fun assertEquals(first: Double, second: Double)
        //nullable = true from not(false or (false and false)) = true
{
var first = first
var second = second

    
                        if(first != second)
                        
                                    {
                                    


                            throw RuntimeException(first +" is not equals to: " +second)

                                    }
                                
}


    open fun assertEquals(first: Any, second: Any)
        //nullable = true from not(false or (false and false)) = true
{
var first = first
var second = second

    
                        if(first == 
                                    null
                                 && second == 
                                    null
                                )
                        
                                    {
                                    


                        //if statement needs to be on the same line and ternary does not work the same way.
                        return 

                                    }
                                

    
                        if(!first.equals(second))
                        
                                    {
                                    


                            throw RuntimeException(first +" is not equals to: " +second)

                                    }
                                
}


    open fun assertTrue(flag: Boolean)
        //nullable = true from not(false or (false and false)) = true
{
var flag = flag

    
                        if(!flag)
                        
                                    {
                                    


                            throw RuntimeException("Error: " +flag +" is not True")

                                    }
                                
}


    open fun assertContains(element: Enum<
                //Otherwise - typeArguments - type - WildcardType
>, collection: Collection<
                //Otherwise - typeArguments - type - WildcardType
>)
        //nullable = true from not(false or (false and false)) = true
{
var element = element
var collection = collection

    
                        if(!collection.contains(element))
                        
                                    {
                                    


                            throw RuntimeException("expected " +element +" in the collection:" +collection)

                                    }
                                
}


    open fun testArrays(factory1: Factory, factory2: Factory)
        //nullable = true from not(false or (false and false)) = true
{
var factory1 = factory1
var factory2 = factory2

    var size: Int = 64


    var b1: ByteBuffer = factory1.allocate(size)!!


    var b2: ByteBuffer = factory2.allocate(size)!!


    var s: String = "1234567890abcdefghijklmnopqrstuvwxyz"

b1.put(s.encodeToByteArray())
b1.flip()

    var ba: ByteArray = ByteArray(s.length)

b1.get(ba)
assertEquals(s, ba.decodeToString())
b1.position(0)
b2.put(b1)
b2.flip()
b2.get(ba)
assertEquals(s, ba.decodeToString())
b1.position(0)
b2.position(0)
b1.limit(b1.capacity())
b2.limit(b2.capacity())
b1.put(s.encodeToByteArray()4, 5)
b1.flip()
ba= ByteArray(5)
b1.get(ba)
assertEquals(s.substring(4, 9), ba.decodeToString())
}


    open fun testPrimativeGetAndSet(factory1: Factory, factory2: Factory)
        //nullable = true from not(false or (false and false)) = true
{
var factory1 = factory1
var factory2 = factory2


                            {
                            
    var size: Int = 64


    var b1: ByteBuffer = factory1.allocate(size)!!


        try {
            



                        for (i in 0 until size)

        




                        for (i in 0 until size)

        




                        for (i in 0 until size /4)

        




                        for (i in 0 until size /4)

        

    var b3: ByteBuffer = b1.duplicate()!!





                        for (i in 0 until size /4)

        
assertEquals(64, b3.position())




                        for (i in 0 until size /8)

        




                        for (i in 0 until size /8)

        
b3.position(0)




                        for (i in 0 until size /8)

        




                        for (i in 0 until size /2)

        




                        for (i in 0 until size /2)

        




                        for (i in 0 until size /4)

        




                        for (i in 0 until size /4)

        




                        for (i in 0 until size /8)

        




                        for (i in 0 until size /8)

        

    var b2: ByteBuffer = factory2.allocate(size)!!


        try {
            b2.put(b1)




                        for (i in 0 until size /8)

        

         finally {
            factory2.dispose(b2)

         }
        

         finally {
            factory1.dispose(b1)

         }
        

                            }
                    
}


interface Factory {
        
/*Static stuff is not allowed for Kotlin inner classescompanion object {
            *//*
        }
            */


    open fun allocate(capacity: Int)
        //nullable = true from not(false or (false and false)) = true
: ByteBuffer

    open fun dispose(b: ByteBuffer)
        //nullable = true from not(false or (false and false)) = true


}
                
            
    open fun test()
        //nullable = true from not(false or (false and true)) = true
{

    var array: Factory = object: Factory()
                                {
                                
    open override fun allocate(capacity: Int)
        //nullable = true from not(false or (false and false)) = true
: ByteBuffer{
var capacity = capacity



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return ByteBuffer.allocate(capacity)
}

    open override fun dispose(b: ByteBuffer)
        //nullable = true from not(false or (false and false)) = true
{
var b = b
}

                                }
                            


    var direct: Factory = object: Factory()
                                {
                                
    open override fun allocate(capacity: Int)
        //nullable = true from not(false or (false and false)) = true
: ByteBuffer{
var capacity = capacity



                        //if statement needs to be on the same line and ternary does not work the same way.
                        return ByteBuffer.allocateDirect(capacity)
}

    open override fun dispose(b: ByteBuffer)
        //nullable = true from not(false or (false and false)) = true
{
var b = b
}

                                }
                            


    var byteBuffer: ByteBuffer = ByteBuffer.allocateDirect(4)!!

byteBuffer!!.put(0, 37.toByte())
byteBuffer!!.put(1,  -128.toByte())
byteBuffer!!.put(2, 0.toByte())
byteBuffer!!.put(3, 0.toByte())
System.out.println("updateGraphicsConfigurationGDI2 should be 32805: " +byteBuffer!!.getInt(0))

    var bb: ByteBuffer = direct.allocate(8)!!

bb.putInt(4, 4133)

    var v: Int = bb.getInt(4)!!

System.out.println(v)

        try {
            ByteBuffer.allocate(1)!!.getInt()
assertTrue(false)
} catch(e: BufferUnderflowException)
            {
}


        try {
            ByteBuffer.allocate(1)!!.getInt(0)
assertTrue(false)
} catch(e: IndexOutOfBoundsException)
            {
}


        try {
            ByteBuffer.allocate(1)!!.putInt(1)
assertTrue(false)
} catch(e: BufferOverflowException)
            {
}


        try {
            ByteBuffer.allocate(1)!!.putInt(0, 1)
assertTrue(false)
} catch(e: IndexOutOfBoundsException)
            {
}

}


        }
            
            //Auto Generated
            public constructor() : super()
            {
            }            
        
}
                
            

