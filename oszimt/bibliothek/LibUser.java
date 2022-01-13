package oszimt.bibliothek;

public class LibUser {

	private String userName;
	private int totalFees;
	private int userID;
	private LibCard userLibCard;
	
	
	public LibUser(String name) {
		setUserName(name);
		setTotalFees(0);
		setUserID((int)(Math.random()*100000));
		setUserLibCard(new LibCard());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(int totalFees) {
		this.totalFees = totalFees;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public LibCard getUserLibCard() {
		return userLibCard;
	}

	public void setUserLibCard(LibCard userLibCard) {
		this.userLibCard = userLibCard;
	}
	
}
