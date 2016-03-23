package main;

public class NoCash extends ATMState {
	
	private static NoCash instance;
	
	private NoCash() {
		
	}
	
	public static ATMState getInstance()
	{
		if( instance == null )
		{
			instance = new NoCash();
		}
		return instance;
	}

	@Override
	public void insertCard(ATMMachine atmMachine) {
		
		System.out.println("We don't have any money");
		System.out.println("Your card is ejected");
		
	}

	@Override
	public void ejectCard(ATMMachine atmMachine) {
		
		System.out.println("We don't have any money");
		System.out.println("There is no card to eject");
		
	}

	@Override
	public void requestCash(ATMMachine atmMachine, int cashToWithdraw) {
		
		System.out.println("We don't have any money");
		
	}

	@Override
	public void insertPin(ATMMachine atmMachine, int pinEntered) {
		
		System.out.println("We don't have any money");
		
	}
}
