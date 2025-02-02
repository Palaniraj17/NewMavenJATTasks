package DragandDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class DragandDrop {

	public static void main(String[] args) {

		String expColor = "#777620";
		String expElemvalue ="Dropped!";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement myframe =driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(myframe);
		
		WebElement src = driver.findElement(By.id("draggable"));		
		WebElement target = driver.findElement(By.id("droppable"));
		Actions dd= new Actions(driver);
		dd.dragAndDrop(src, target).perform();
		System.out.println("Dropped successfully");
		
		//Color Validation
		String actslrsatring=driver.findElement(By.id("droppable")).getCssValue("color");
		Color colorObj = Color.fromString(actslrsatring); 
		String acthexColor = colorObj.asHex();

		if(expColor.equals(acthexColor))
		{
			System.out.println("Color validation is done");
			String resultmsg = driver.findElement(By.id("droppable")).getText();
			System.out.println(resultmsg);
			if(expElemvalue.equals(resultmsg))
			System.out.println("Element value is changed to Dropped!");				
		}
		driver.quit();
	}

}
