package asdf;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassPeriod {
	
	ClassPeriod () {}
	ClassPeriod (int period) {
		this.period = period;
		createAssignmentObjects();
		initializeTeacherAndClass ();
		initializeGrades();
	}
	
	private WebDriver d = ghdersbgxfc.driver;
	private String teacherName;
	private String className;
	private int period;
	public ArrayList <Assignment> s1 = new ArrayList <Assignment> ();
	private double grade;
	private String letterGrade;
	
	public double [] whatIfAssignment (int points) {
		double totalPoints = 0;
		double pointsEarned = 0;
		for (Assignment a : s1) {
			totalPoints += a.getPointTotal();
			pointsEarned += a.getPointsEarned();
		}
		double [] res = new double [points];
		for (int i = 0; i < points; i++) {
			res[i] = ((pointsEarned + i) / (totalPoints + points)) * 100;
		}
		return res;
	}
			
	public void initializeGrades() {
		double totalPoints = 0;
		double pointsEarned = 0;
		for (Assignment a : s1) {
			totalPoints += a.getPointTotal();
			pointsEarned += a.getPointsEarned();
		}
		grade = pointsEarned/totalPoints * 100;
		
		int tempGrade = (int) Math.round(grade);
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
	
	public void initializeTeacherAndClass () {
		teacherName = d.findElement(By.xpath
				("/html/body/div[1]/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td[2]")).getText();
		className = d.findElement(By.xpath
				("/html/body/div[1]/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public void createAssignmentObjects () {
		ArrayList <WebElement> assignList = createAssignList();
		int size = assignList.size();
		String [] name = new String [size];
		double [] pointTotal = new double [size];
		double [] pointsEarned= new double [size];
		int [] day = new int [size];
		int [] month = new int [size];
		int [] year = new int [size];
		String [] category = new String [size];
	    
		//Get the values for all the parallel arrays, create the objects
		for (int i = 0; i < size - 1; i++) {
	    	//Get the names of the assignments
	    	name[i] = assignList.get(i).findElement(By.xpath("./td[3]")).getText();
			
	    	/*Get the points for the assignments. 
	    	 If the assignment is --/20 or something similar, then points earned is stored as -1
				Works*/
	    	String scoreTemp = assignList.get(i).findElement(By.xpath("./td[11]/span")).getText();
			String [] scoreArr = scoreTemp.split("/");
		    pointTotal[i] = Double.parseDouble(scoreArr[1]);
		    try {
				 pointsEarned[i] = Double.parseDouble(scoreArr[0]);
			} catch (Exception e){
				 pointsEarned[i] = -1;
			}
		    
		    //Get the date of the assignment in the form of integers for the day, month, and year. Works.
		    String dateTemp = assignList.get(i).findElement(By.xpath("./td[1]")).getText();
		    String [] dateArr = dateTemp.split("/");
		    month[i] = Integer.parseInt(dateArr[0]);
		    day[i] = Integer.parseInt(dateArr[1]);
		    year[i] = Integer.parseInt(dateArr[2]);

		    //Get the category of the assignment
		    category[i] = assignList.get(i).findElement(By.xpath("./td[2]")).getText();
		    
		    s1.add(new Assignment (name[i], pointTotal[i], pointsEarned[i], day[i], month[i], year[i], category[i]));
	    }
	}
	
	//Gets each row of the table of assignments as a webelement. This method works, it had been control tested
	public ArrayList<WebElement> createAssignList() {
		ArrayList <WebElement> assignList = new ArrayList<WebElement> 
		(assignmentTable().findElements(By.xpath
				("/html/body/div[1]/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div/table/tbody/tr")));
		return assignList;
	}
	
	
	public String getTableOfAssignments () {
		return assignmentTable().getText();
	}
	
	public WebElement assignmentTable () {
		d.get(linkToS1());
		WebElement table = d.findElement(By.cssSelector("#scoreTable"));
		return table;
	}
	
	
	public WebElement tablePortion () {
		d.get("https://ps.seattleschools.org/guardian/home.html");
		return d.findElement(By.cssSelector("#tblgrades > tbody > "
				+ "tr:nth-child(" + (period * 2 + 2) + ") > td:nth-child(15) > a"));
	}
	
	public String linkToS1 () {
		return tablePortion().getAttribute("href");

	}
	
	//Getters and Setters
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}
	public double getGrade() {
		return grade;
	}
	public String getLetterGrade() {
		return letterGrade;
	}
	
	

	
	
	
	
	
}
