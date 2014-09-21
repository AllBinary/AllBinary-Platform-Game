package org.allbinary.media.audio;


import org.allbinary.media.audio.BaseSoundsFactory;
import org.allbinary.media.audio.Sound;

public class TestGameDemoSoundsFactory
extends BaseSoundsFactory
{
    public Sound[] getSoundInterfaceArray() throws Exception
    {
        Sound[] soundInterfaceArray = new Sound[1];
        int index = 0;

        soundInterfaceArray[index++] = TestSound.getInstance();

        return soundInterfaceArray;
    }
}
