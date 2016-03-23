package main;

public class NoCard extends ATMState {
	
	private static NoCard instance;
	
	private NoCard() {
		
	}
	
	public static ATMState getInstance()
	{
		if( instance == null )
		{
			instance = new NoCard();
		}
		return instance;
	}

	@Override
	public void insertCard(ATMMachine atmMachine) {
		
		System.out.println("Please enter your pin");
		changeState(atmMachine, HasCard.getInstance());
		
	}

	@Override
	public void ejectCard(ATMMachine atmMachine) {
		
		System.out.println("You didn't enter a card");
		
	}

	@Override
	public void requestCash(ATMMachine atmMachine, int cashToWithdraw) {
		
		System.out.println("You have not entered your card");
		
	}

	@Override
	public void insertPin(ATMMachine atmMachine, int pinEntered) {
		
		System.out.println("You have not entered your card");
		
	}
}
