package asdf;

public class Assignment {
	
	public Assignment(String name, double pointTotal, double pointsEarned, int date, int month, int year,
			String category) {
		super();
		this.name = name;
		this.pointTotal = pointTotal;
		this.pointsEarned = pointsEarned;
		this.date = date;
		this.month = month;
		this.year = year;
		this.category = category;
		initializePercent();
		initializeLetterGrade();
	}




	private String name;
	private double pointTotal;
	private double pointsEarned;
	private int date;
	private int month;
	private int year;
	private double percent;
	private String category;
    private String letterGrade;                                                                                                                                          
	
	private void initializeLetterGrade() {
		int tempGrade = (int) Math.round(percent);
		if (tempGrade >= 93) {
			letterGrade = "A";
		} else if (tempGrade >= 90) {
			letterGrade = "A-";
		} else if (tempGrade >= 87) {
			letterGrade = "B+";
		} else if (tempGrade >= 83) {
			letterGrade = "B";
		} else if (tempGrade >= 80) {
			letterGrade = "B-";
		} else if (tempGrade >= 77) {
			letterGrade = "C+";
		} else if (tempGrade >= 73) {
			letterGrade = "C";
		} else if (tempGrade >= 70) {
			letterGrade = "C-";
		} else if (tempGrade >= 67) {
			letterGrade = "D+";
		} else if (tempGrade >= 60) {
			letterGrade = "D";
		} else if (tempGrade >= 0) {
			letterGrade = "E";
		} else {
			letterGrade = "UNDEFINED";
		}
	}

	private void initializePercent() {
		percent = pointsEarned/pointTotal * 100;
	}
	
	
	
	//All getters and setters from this point on 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPointTotal() {
		return pointTotal;
	}

	public void setPointTotal(double pointTotal) {
		this.pointTotal = pointTotal;
	}

	public double getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(double pointsEarned) {
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

	public String getLetterGrade() {
		return letterGrade;
	}

	
	

}
