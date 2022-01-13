package oszimt.bibliothek;

import java.time.LocalDate;

public class Book {

	private int number;
	private String title;
	private String author;
	private LocalDate returnDate;
	private int count_prolong;
	private LibUser user;
	private LibUser reserveUser;
	
	public Book() {
		setNumber((int)(Math.random()*100000));
		setTitle("");
		setAuthor("");
		setReturnDate(null);
		setCount_prolong(0);
		setUser(null);
		setReserveUser(null);
	}
	
	public Book(String title, String author) {
		setNumber((int)(Math.random()*100000));
		setTitle(title);
		setAuthor(author);
		setReturnDate(null);
		setCount_prolong(0);
		setUser(null);
		setReserveUser(null);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getCount_prolong() {
		return this.count_prolong;
	}

	public void setCount_prolong(int count_prolong) {
		this.count_prolong = count_prolong;
	}

	public LibUser getUser() {
		return this.user;
	}

	public void setUser(LibUser user) {
		this.user = user;
	}

	public LibUser getReserveUser() {
		return this.reserveUser;
	}

	public void setReserveUser(LibUser reserveUser) {
		this.reserveUser = reserveUser;
	}
	
//Methoden
	
	public String reserve(LibUser reserver) {
		
		String antwort;
		
		if (this.getReserveUser() == null) {
			if (this.getUser() == reserver) {
				antwort = "Sie leihen dieses Buch gerade aus, Sie können es nicht reservieren!";
			} else {
				antwort = "Sie haben dieses Buch jetzt reserviert!";
				this.setReserveUser(reserver);
			}
		} else {
			antwort = "Dieses Buch ist bereits von einem anderen Nutzer reserviert worden!";
		}
		
		return antwort;
	}
	
	public int returnBook() {
		
		int tageUeberzogen = 0;
		
		if (LocalDate.now().isAfter(this.getReturnDate())) {
			tageUeberzogen = (int)LocalDate.now().toEpochDay() - (int)this.getReturnDate().toEpochDay();
			int wochenUeberzogen = tageUeberzogen / 7;
			int feeZuZahlen = BorrowCondition.getFees() * wochenUeberzogen;
			
			this.getUser().setTotalFees(this.getUser().getTotalFees()+feeZuZahlen);
			
			if (this.getUser().getTotalFees() > BorrowCondition.getMaxFees()) {
				this.getUser().getUserLibCard().lockCard();
			}
			
			
		}
				
		this.setUser(null);
		this.setReturnDate(null);
		this.setCount_prolong(0);
		
		return tageUeberzogen;
	}
	
	public String prolong() {
		
		String antwort;
		
		if (this.getReserveUser() != null) {
			antwort = "Dieses Buch ist bereits reserviert!";
		} else if (this.getCount_prolong() > BorrowCondition.getMaxProlong()) {
			antwort = "Sie können die Ausleihzeit nicht weiter verlängern!";
		} else {
			antwort = "Die Ausleihzeit wurde verlängert!";
			this.setCount_prolong(getCount_prolong()+1);
			this.setReturnDate(LocalDate.now().plusWeeks(BorrowCondition.getBorrowWeeks()));
		}
		
		return antwort;		
	}
	
	public String borrow(LibUser user) {
		
		String antwort;
		
		if (this.getUser() != null) {
			antwort = "Dieses Buch ist bereits ausgeliehen!";
		} else if (this.getReserveUser() != null && this.getReserveUser().getUserID() != user.getUserID()) {
			antwort = "Dieses Buch ist bereits reserviert!";
		} else {
			antwort = "Sie haben dieses Buch jetzt ausgeliehen";
			this.setUser(user);
			this.setReserveUser(null);
			this.setReturnDate(LocalDate.now().plusWeeks(BorrowCondition.getBorrowWeeks()));
		}
		
		return antwort;
	}
}
