package org.allbinary.logic.system.security.licensing;

public class TestGameDemoClientInformationInterfaceFactory
{
    private static final AbeClientInformationInterface SINGLETON = 
        new TestGameDemoAndroidMobileClientInformation();

    public static AbeClientInformationInterface getInstance()
    {
        return SINGLETON;
    }
}
