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
    
    private ClientInformation clientInformation;

    public ClientInformation getInstance()
    {
        if(this.clientInformation == null) {
            clientInformation = new TestGameDemoAndroidMobileClientInformation();
        }
        return clientInformation;
    }
    
}
