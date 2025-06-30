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
package org.microemu.app;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Collection;

/**
 *
 * @author User
 */
public class DirectByteBufferTest {
    
  public static void assertEquals(byte first, byte second) {
    if(first != second) {
      throw new RuntimeException(first+" is not equals to: "+second);
    }
  }
  
  public static void assertEquals(short first, short second) {
    if(first != second) {
      throw new RuntimeException(first+" is not equals to: "+second);
    }
  }
  
  public static void assertEquals(int first, int second) {
    if(first != second) {
      throw new RuntimeException(first+" is not equals to: "+second);
    }
  }
  
  public static void assertEquals(long first, long second) {
    if(first != second) {
      throw new RuntimeException(first+" is not equals to: "+second);
    }
  }
  
  public static void assertEquals(float first, float second) {
    if(first != second) {
      throw new RuntimeException(first+" is not equals to: "+second);
    }
  }
  
  public static void assertEquals(double first, double second) {
    if(first != second) {
      throw new RuntimeException(first+" is not equals to: "+second);
    }
  }
  
  public static void assertEquals(Object first, Object second) {
    if(first == null && second == null) {
      return;
    }
    if(!first.equals(second)) {
      throw new RuntimeException(first+" is not equals to: "+second);
    }
  }
  
  public static void assertTrue(boolean flag) {
    if (!flag) {
      throw new RuntimeException("Error: "+flag+" is not True");
    }
  }
  
  public static void assertContains(Enum<?> element, Collection<?> collection) {
    if (!collection.contains(element)) {
      throw new RuntimeException("expected " + element + " in the collection:"+collection);
    }
  }
    
  public static void testArrays(Factory factory1, Factory factory2) {
    final int size = 64;
    ByteBuffer b1 = factory1.allocate(size);
    ByteBuffer b2 = factory2.allocate(size);
    
    String s = "1234567890abcdefghijklmnopqrstuvwxyz";
    b1.put(s.getBytes());
    b1.flip();
    byte[] ba = new byte[s.length()];
    b1.get(ba);
    assertEquals(s, new String(ba));
    b1.position(0);
    b2.put(b1);
    b2.flip();
    b2.get(ba);
    assertEquals(s, new String(ba));
    b1.position(0);
    b2.position(0);
    b1.limit(b1.capacity());
    b2.limit(b2.capacity());
    b1.put(s.getBytes(), 4, 5);
    b1.flip();
    ba = new byte[5];
    b1.get(ba);
    assertEquals(s.substring(4, 9), new String(ba));
  }

  public static void testPrimativeGetAndSet(Factory factory1, Factory factory2) {
    { final int size = 64;
      ByteBuffer b1 = factory1.allocate(size);
      try {

        for (int i = 0; i < size; ++i)
          b1.put(i, (byte) 42);

        for (int i = 0; i < size; ++i)
          assertEquals(b1.get(i), 42);
        
        for (int i = 0; i < size/4; i++) 
          b1.putFloat(i*4, (float) 19.12);
        
        for (int i = 0; i < size/4; i++) 
          assertEquals(b1.getFloat(i*4), (float) 19.12);

        ByteBuffer b3 = b1.duplicate();
        for (int i = 0; i < size/4; i++)
          assertEquals(b3.getFloat(), (float) 19.12);
        assertEquals(64, b3.position());
        
        for (int i = 0; i < size/8; i++) 
          b1.putDouble(i*8, (double) 19.12);
        
        for (int i = 0; i < size/8; i++)
          assertEquals(b1.getDouble(i*8), (double) 19.12);
        
        b3.position(0);
        
        for (int i = 0; i < size/8; i++)
          assertEquals(b3.getDouble(i*8), (double) 19.12);

        for (int i = 0; i < size / 2; ++i)
          b1.putShort(i * 2, (short) -12345);

        for (int i = 0; i < size / 2; ++i)
          assertEquals(b1.getShort(i * 2), -12345);

        for (int i = 0; i < size / 4; ++i)
          b1.putInt(i * 4, 0x12345678);

        for (int i = 0; i < size / 4; ++i)
          assertEquals(b1.getInt(i * 4), 0x12345678);

        for (int i = 0; i < size / 8; ++i)
          b1.putLong(i * 8, 0x1234567890ABCDEFL);

        for (int i = 0; i < size / 8; ++i)
          assertEquals(b1.getLong(i * 8),  0x1234567890ABCDEFL);

        ByteBuffer b2 = factory2.allocate(size);
        try {
          b2.put(b1);

          for (int i = 0; i < size / 8; ++i)
            assertTrue(b2.getLong(i * 8) ==  0x1234567890ABCDEFL);

        } finally {
          factory2.dispose(b2);
        }
      } finally {
        factory1.dispose(b1);
      }
    }
  }

    private static interface Factory {

        public ByteBuffer allocate(int capacity);

        public void dispose(ByteBuffer b);

    }
  
  public static void test() {
      
    final Factory array = new Factory() {
        public ByteBuffer allocate(int capacity) {
          return ByteBuffer.allocate(capacity);
        }

        public void dispose(ByteBuffer b) {
          // ignore
        }
      };

    final Factory direct = new Factory() {
        public ByteBuffer allocate(int capacity) {
          return ByteBuffer.allocateDirect(capacity);
        }

        public void dispose(ByteBuffer b) {
          // ignore
        }
      };

        final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4);
        byteBuffer.put(0, (byte) 37);
        byteBuffer.put(1, (byte) -128);
        byteBuffer.put(2, (byte) 0);
        byteBuffer.put(3, (byte) 0);
        
        System.out.println("updateGraphicsConfigurationGDI2 should be 32805: " + byteBuffer.getInt(0));
    
      ByteBuffer bb = direct.allocate(8);
      bb.putInt(4, 4133);
      final int v = bb.getInt(4);
      System.out.println(v);
    
//    testPrimativeGetAndSet(array, direct);
//    testArrays(array, direct);
//
//    testPrimativeGetAndSet(direct, array);
//    testArrays(direct, array);
//    testPrimativeGetAndSet(direct, direct);
//    testArrays(direct, direct);

    try {
      ByteBuffer.allocate(1).getInt();
      assertTrue(false);
    } catch (BufferUnderflowException e) {
      // cool
    }

    try {
      ByteBuffer.allocate(1).getInt(0);
      assertTrue(false);
    } catch (IndexOutOfBoundsException e) {
      // cool
    }

    try {
      ByteBuffer.allocate(1).putInt(1);
      assertTrue(false);
    } catch (BufferOverflowException e) {
      // cool
    }

    try {
      ByteBuffer.allocate(1).putInt(0, 1);
      assertTrue(false);
    } catch (IndexOutOfBoundsException e) {
      // cool
    }
  }
    
}
