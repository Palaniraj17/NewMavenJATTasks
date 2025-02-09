package JATTask11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/nested_frames");

		driver.switchTo().frame("frame-top");
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		if (frames.size() == 3) {
			System.out.println("The total frames in top section is 3");
		}

		driver.switchTo().frame("frame-left");
		if (driver.getPageSource().contains("LEFT")) {
			System.out.println("LEFT text is available in top-left frame");
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		if (driver.getPageSource().contains("MIDDLE")) {
			System.out.println("MIDDLE text is available in top-middle frame");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		if (driver.getPageSource().contains("RIGHT")) {
			System.out.println("RIGHT text is available in top-right frame");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		if (driver.getPageSource().contains("BOTTOM")) {
			System.out.println("BOTTOM text is available in bottom frame");
		}
		// The web page is not having any title currently , hence we cannot verify the title
		driver.quit();//Giving this to avoid connection reset error
	}
}