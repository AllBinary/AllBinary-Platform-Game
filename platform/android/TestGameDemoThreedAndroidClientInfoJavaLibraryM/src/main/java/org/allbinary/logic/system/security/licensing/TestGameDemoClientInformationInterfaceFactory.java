package org.allbinary.logic.system.security.licensing;

public class TestGameDemoClientInformationInterfaceFactory extends ClientInformationFactory
{
    private static final ClientInformationFactory instance = new TestGameDemoClientInformationInterfaceFactory();

    /**
     * @return the instance
     */
    public static ClientInformationFactory getFactoryInstance() {
        return instance;
    }
    
    public ClientInformation getInstance()
    {
        return TestGameDemoAndroidMobileClientInformation.instance;
    }

}