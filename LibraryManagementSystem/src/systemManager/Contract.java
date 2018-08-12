package systemManager;

import java.util.Date;

public class Contract {
	Date takeDate;
	Date returnDate;
	
	
	public Contract(Date takeDate, Date returnDate) {
		super();
		this.takeDate = takeDate;
		this.returnDate = returnDate;
	}
	
	public Date getTakeDate() {
		return takeDate;
	}
	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
}
