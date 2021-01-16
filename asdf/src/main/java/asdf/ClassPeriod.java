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
	}
	
	private WebDriver d = ghdersbgxfc.driver;
	private String teacherName;
	private String className;
	private int period;
	public ArrayList <Assignment> s1 = new ArrayList <Assignment> ();

	public void createAssignmentObjects () {
		

		
		
		ArrayList <WebElement> assignList = createAssignList();
		int size = assignList.size();
		String [] name = new String [size];
		int [] pointTotal = new int [size];
		int [] pointsEarned= new int [size];
		int [] date= new int [size];
		int [] month= new int [size];
		int [] year= new int [size];
		String [] category = new String [size];
	    for (int i = 0; i < size - 1; i++) {
	    	name[i] = assignList.get(i).findElement(By.xpath("./td[3]")).getText();
			 String scoreTemp = assignList.get(i).findElement(By.xpath("./td[11]/span")).getText();
			 String [] scoreArr = scoreTemp.split("/");
			 try {
				 pointTotal[i] = Integer.parseInt(scoreArr[1]);
			 } catch (Exception e){
				 pointTotal[i] = 0;
			 }
			 try {
				 pointsEarned[i] = Integer.parseInt(scoreArr[0]);
			 } catch (Exception e){
				 pointsEarned[i] = 0;
			 }
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

	
	
	
	
	
}
