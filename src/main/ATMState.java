package main;

//Different states expected
//HasCard, NoCard, HasPin, NoCash
public abstract class ATMState {
	
	public abstract void insertCard(ATMMachine atmMachine);
	
	public abstract void ejectCard(ATMMachine atmMachine);
	
	public abstract void insertPin(ATMMachine atmMachine, int pinEntered);
	
	public abstract void requestCash(ATMMachine atmMachine, int cashToWithdraw);
	
	protected void changeState(ATMMachine atmMachine, ATMState state) {
		atmMachine.changeState( state );
	}
}
