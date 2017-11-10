package by.htp.rentstation;

public abstract class Equipment {

	private Category category;
	private String title;
	private Status status;
	private int price;

	public Equipment(Category category, String title, Status status, int price) {
		super();
		this.category = category;
		this.title = title;
		this.status = status;
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {

		return " атегори€: " + this.category + ", наименование: " + this.title + ", цена аренды в сутки: " + this.price;
	}

}
