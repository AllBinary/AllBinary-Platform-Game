package org.allbinary.game.testgamedemo;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.NullMIDlet;

import org.allbinary.logic.system.security.licensing.TestGameDemoClientInformationInterfaceFactory;
import org.allbinary.midlet.MidletFactoryInterface;

public class TestGameDemoMIDletFactory extends MidletFactoryInterface {

    private static MIDlet SINGLETON = NullMIDlet.NULL_MIDLET;

    @Override
    public MIDlet getInstance() {
        if (SINGLETON == NullMIDlet.NULL_MIDLET) {
            SINGLETON = new TestGameDemoMIDlet(TestGameDemoClientInformationInterfaceFactory.getFactoryInstance());
        }
        return SINGLETON;
    }
}
