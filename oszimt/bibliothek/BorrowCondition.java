package oszimt.bibliothek;

public class BorrowCondition {

	private static int fees;
	private static int borrowWeeks;
	private static int max_prolong;
	private static int max_fees;
	
	static {
		fees = 1;
		borrowWeeks = 4;
		max_prolong = 2;
		max_fees = 10;
	}
	
	public static int getFees() {
		return fees;
	}
	
	public static void setFees(int newFee) {
		fees = newFee;
	}
	
	public static int getBorrowWeeks() {
		return borrowWeeks;
	}
	
	public static void setBorrowWeeks(int newBorrowWeeks) {
		borrowWeeks = newBorrowWeeks;
	}
	
	public static int getMaxProlong() {
		return max_prolong;
	}
	
	public static void setMaxProlong(int newMaxProlong) {
		max_prolong = newMaxProlong;
	}
	
	public static int getMaxFees() {
		return max_fees;
	}
	
	public static void setMaxFees(int newMaxFees) {
		max_fees = newMaxFees;
	}

}

