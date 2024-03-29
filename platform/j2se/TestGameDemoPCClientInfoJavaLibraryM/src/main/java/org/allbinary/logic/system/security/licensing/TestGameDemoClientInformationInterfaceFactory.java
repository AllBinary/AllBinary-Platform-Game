/*
* AllBinary Open License Version 1
* Copyright (c) 2011 AllBinary
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
        return TestGameDemoPCClientInformation.instance;
    }
}
