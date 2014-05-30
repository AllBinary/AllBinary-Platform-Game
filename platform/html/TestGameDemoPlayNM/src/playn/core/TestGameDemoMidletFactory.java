/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playn.core;

import allbinary.midlet.MidletFactoryInterface;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author user
 */
public class TestGameDemoMidletFactory
extends MidletFactoryInterface
{
	public MIDlet getInstance()
	{
	    return new TestGameDemo();
	}    
}
