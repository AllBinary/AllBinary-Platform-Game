package org.allbinary.game.testgamedemo;

import javax.microedition.midlet.MIDlet;
import org.allbinary.logic.system.security.licensing.TestGameDemoClientInformationInterfaceFactory;
import org.allbinary.midlet.MidletFactoryInterface;

public class TestGameDemoMIDletFactory extends MidletFactoryInterface {

    private static MIDlet SINGLETON = null;

    public MIDlet getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new TestGameDemoMIDlet(TestGameDemoClientInformationInterfaceFactory.getFactoryInstance());
        }
        return SINGLETON;
    }
}
