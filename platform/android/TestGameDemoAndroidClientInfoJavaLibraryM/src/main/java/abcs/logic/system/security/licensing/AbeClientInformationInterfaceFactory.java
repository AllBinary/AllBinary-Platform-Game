package abcs.logic.system.security.licensing;

public class AbeClientInformationInterfaceFactory
{
    private static final AbeClientInformationInterface SINGLETON = 
        new TestGameDemoAndroidMobileClientInformation();

    public static AbeClientInformationInterface getInstance()
    {
        return SINGLETON;
    }
}
