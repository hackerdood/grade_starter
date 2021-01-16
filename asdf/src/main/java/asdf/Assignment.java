package asdf;

public class Assignment {
	
	Assignment() {
		
		
	}
	
	
	
	
	private String name;
	private int pointTotal;
	private int pointsEarned;
	private int date;
	private int month;
	private int year;
	private double percent = pointsEarned/pointTotal * 100;
	private String category;

	
	
	
	
	
	//All getters and setters from this point on 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPointTotal() {
		return pointTotal;
	}

	public void setPointTotal(int pointTotal) {
		this.pointTotal = pointTotal;
	}

	public int getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public double getPercent() {
		return percent;
	}
	
	public int getDate() {
		return date;
	}



	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	

}
