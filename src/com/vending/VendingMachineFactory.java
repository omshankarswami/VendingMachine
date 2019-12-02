package com.vending;

public class VendingMachineFactory {
	
	
	
	public static VendingMachine createVendingMachine()
	{
		
		return new VendingMachineImpl();
		}

}
