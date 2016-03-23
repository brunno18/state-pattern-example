package main;

public class ATMMachine {
	
	private ATMState state;
	
	private int cashInMachine = 2000;
	
	private boolean correctPinEntered = false;
	
	
	public ATMMachine(){
		
		state = NoCard.getInstance();
		
		if(cashInMachine < 0){
			
			state = NoCash.getInstance();
			
		}
		
	}
	
	public void setPin (boolean correctPin) {
		
		correctPinEntered = correctPin;
		
	}
	
	public void setCashInMachine(int newCashInMachine){
		
		cashInMachine = newCashInMachine;
		
	}
	
	public int getCashInMachine() {
		return cashInMachine;
	}
	
	public void insertCard() {
		
		state.insertCard(this);
		
	}

	public void ejectCard() {
		
		state.ejectCard(this);
		
	}

	public void requestCash(int cashToWithdraw) {
		
		state.requestCash(this, cashToWithdraw);
		
	}

	public void insertPin(int pinEntered){
		
		state.insertPin(this, pinEntered);
		
	}
	
	public void changeState( ATMState state )
	{
		System.out.println( "ATMMachine: Changing state to " + state.getClass().getSimpleName() );
		this.state = state;
	}
}
