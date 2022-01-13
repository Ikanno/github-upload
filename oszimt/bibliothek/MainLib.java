package oszimt.bibliothek;

public class MainLib {

	public static void main(String[] args) {
		
		System.out.println("Library");
		
		//LibCard
		LibCard testCard = new LibCard();
		
		System.out.println("\n" + testCard.getIdNumber() + "\n" + testCard.getLastDayOfActivation() + "\n" + testCard.getIsActivated());
		
		testCard.lockCard();
		
		System.out.println("\n" + testCard.getIsActivated());
		
		testCard.unlockCard();

		System.out.println(testCard.getIsActivated());
		
		//LibUser
		LibUser testUser = new LibUser("Tim Taler");
		
		System.out.println("\nLibUser:\n" + testUser.getUserName() + "\n" + testUser.getUserID() + "\n" + testUser.getTotalFees() + "\n\nLibcard:\n" + testUser.getUserLibCard().getIdNumber() + "\n" + testUser.getUserLibCard().getLastDayOfActivation() + "\n" + testUser.getUserLibCard().getIsActivated());
		System.out.println("\n" + testUser.getUserLibCard().getLastDayOfActivation());
		
		testUser.getUserLibCard().lockCard();
		
		System.out.println("\n" + testUser.getUserLibCard().getIdNumber() + "\n" + testUser.getUserLibCard().getIsActivated());
	}

}
