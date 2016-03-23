package main;

public class HasPin extends ATMState {

	private static HasPin instance;
	
	private HasPin() {
		
	}
	
	public static ATMState getInstance()
	{
		if( instance == null )
		{
			instance = new HasPin();
		}
		return instance;
	}

	@Override
	public void insertCard(ATMMachine atmMachine) {
		
		System.out.println("You already entered a card");
		
	}

	@Override
	public void ejectCard(ATMMachine atmMachine) {
		
		System.out.println("Your card is ejected");
		changeState(atmMachine, NoCard.getInstance());
		
	}

	@Override
	public void requestCash(ATMMachine atmMachine, int cashToWithdraw) {
		
		if(cashToWithdraw > atmMachine.getCashInMachine()){
			
			System.out.println("You don't have that much cash available");
			System.out.println("Your card is ejected");
			changeState(atmMachine, NoCard.getInstance());
			
		} else {
			
			System.out.println(cashToWithdraw + " is provided by the machine");
			atmMachine.setCashInMachine(atmMachine.getCashInMachine() - cashToWithdraw);
			
			System.out.println("Your card is ejected");
			changeState(atmMachine, NoCard.getInstance());
			
			if(atmMachine.getCashInMachine() <= 0){ 
				
				changeState(atmMachine, NoCash.getInstance());
				
			}
		} 
	}

	@Override
	public void insertPin(ATMMachine atmMachine, int pinEntered) {
		
		System.out.println("You already entered a PIN");
		
	}
}
