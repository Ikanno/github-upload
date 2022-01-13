package oszimt.bibliothek;

import java.time.LocalDate;

public class LibCard {

		private int idNumber;
		private LocalDate lastDayOfActivation;
		private boolean isActivated;
		
	public LibCard() {
		
		idNumber = (int)(Math.random()*100000);
		// Ausweis soll ein Jahr lang gelten
		lastDayOfActivation = LocalDate.now().plusYears(1);
		isActivated = true;
		
	}
	
	public LibCard(int number) {
		
		int numberLength = String.valueOf(number).length(); 
		
		if (numberLength < 5) {
			for (int i = numberLength; i < 5; i++) {
				number = number * 10;
			}
		} else if (numberLength > 5) {
			number = number % 100000;
		}
		
		idNumber = number;
		
		// Ausweis soll ein Jahr lang gelten
		lastDayOfActivation = LocalDate.now().plusYears(1);
		isActivated = true;
		
	}
	
	public int getIdNumber() {
		return this.idNumber;
	}
	
	public void setIdNumber(int number) {
		this.idNumber =  number;
	}
	
	public void lockCard() {
		this.isActivated = false;
	}
	
	public void unlockCard() {
		this.isActivated = true;
	}
	
	public boolean getIsActivated() {
		return this.isActivated;
	}
	
	public void setIsActivated(boolean validState) {
		this.isActivated = validState;
	}
	
	public void prolong() {
		if (this.getIsActivated() == true) {
			this.lastDayOfActivation.plusYears(1);
		}
	}
	
	public LocalDate getLastDayOfActivation() {
		return this.lastDayOfActivation;
	}
	
	public void setLastDayOfActivation(LocalDate newDate) {
		this.lastDayOfActivation = newDate;
	}
}
