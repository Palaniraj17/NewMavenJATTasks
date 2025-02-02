package DatePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {

		String expMonth ="June 2025";
		int date = 22;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		WebElement myframe =driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(myframe);
		driver.findElement(By.id("datepicker")).click();
		
		//Selecting the month
		while(true)
		{
			String actualMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
			if(expMonth.equalsIgnoreCase(actualMonth)) 
			{	
				break;
			}
			else
				driver.findElement(By.linkText("Next")).click();
		}
		//selecting the date
		
		driver.findElement(By.xpath("//a[@data-date="+date+"]")).click();
	 //   String SelectedDate = driver.findElement(By.className("hasDatepicker")).getDomAttribute("value");//In DOM , there is no selected date available
	  //  System.out.println(SelectedDate);
		driver.quit();
	}
}
