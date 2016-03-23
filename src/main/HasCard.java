package main;

public class HasCard extends ATMState {

	private static HasCard instance;
	
	private ATMMachine atmMachine;
	
	
	private HasCard(){

	}
	
	public static ATMState getInstance()
	{
		if( instance == null )
		{
			instance = new HasCard();
		}
		return instance;
	}
	
	@Override
	public void insertCard(ATMMachine atmMachine) {
		System.out.println("You can only insert one card at a time");
	}

	@Override
	public void ejectCard(ATMMachine atmMachine) {
		System.out.println("Your card is ejected");
		changeState(atmMachine, NoCard.getInstance());
	}

	@Override
	public void insertPin(ATMMachine atmMachine, int pinEntered) {
		if(pinEntered == 1234){
			
			System.out.println("You entered the correct PIN");
			atmMachine.setPin(true);
			changeState(atmMachine, HasPin.getInstance());
			
		} else {
			
			System.out.println("You entered the wrong PIN");
			atmMachine.setPin(false);
			System.out.println("Your card is ejected");
			changeState(atmMachine, NoCard.getInstance());
			
		}
	}

	@Override
	public void requestCash(ATMMachine atmMachine, int cashToWithdraw) {
		System.out.println("You have not entered your PIN");
	}
}
