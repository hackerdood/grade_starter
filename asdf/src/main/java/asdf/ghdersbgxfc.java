package asdf;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;



public class ghdersbgxfc {
	public static final String USERNAME = "1geking";
	public static final String PASSWORD = "Homert12";
	static WebDriver driver = setUp();
	
	public static void main (String [] args) {
		ArrayList<ClassPeriod> mainClasses = new ArrayList<ClassPeriod> ();
		for (int i = 1; i <= 6; i++) {
			mainClasses.add(new ClassPeriod(i));
		}
		
		
		
		driver.close();
	}
	
	public static WebDriver setUp () {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ps.seattleschools.org/public/home.html");
		driver.findElement(By.cssSelector("#fieldAccount")).sendKeys(USERNAME);
		driver.findElement(By.cssSelector("#fieldPassword")).sendKeys(PASSWORD);
		driver.findElement(By.cssSelector("#btn-enter")).click();
		//unsure if necessary	
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void commentDump () {
		//Find the teacher names, class names, and room numbers. Put those elements in a list
		/*WebElement e = driver.findElement(By.cssSelector("#tblgrades"));
		ArrayList<WebElement> grades = new ArrayList <WebElement> ();
		for (int i = 1; i <= 17; i += 2) {
			grades.add(driver.findElement(By.xpath
					("//*[@id=\"tblgrades\"]/tbody/tr[" + (i + 3) + "]/td[11]")));
		}*/
		
		//Find the links to the semester grade pages
		/*ArrayList<WebElement> listOfClassSems = new ArrayList <WebElement> ();
		for (int i = 1; i <= 11; i += 2) {
			listOfClassSems.add(driver.findElement(By.xpath
					("//*[@id=\"tblgrades\"]/tbody/tr[" + (i + 3) + "]/td[14]/a")));
		}
		
		ArrayList <String> semesterGradeLinks = new ArrayList<String> ();
		for (WebElement link: listOfClassSems) {
			semesterGradeLinks.add(link.getAttribute("href"));
		}
		
		for (String s: semesterGradeLinks) {
			driver.get(s);
			WebElement table = driver.findElement(By.cssSelector("#scoreTable"));
			System.out.println(table.getText());
			System.out.println("\n\n\n");
		}*/
			
		//Print the list
		/*  int count = 1;
		for (WebElement specGrade : grades) {
			if (count <= 6) {
				System.out.println("Period " + count);
			}
			System.out.println(specGrade.getText());
			System.out.println();
			count++;
		}   */
	}
	

}


