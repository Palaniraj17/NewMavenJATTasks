package GuviLoginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuviLoginPage {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.guvi.in/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		WebElement tosignin =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sign up']")));
		tosignin.click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("name")).sendKeys("DummyName");
		driver.findElement(By.id("email")).sendKeys("DummyName2@dummy.com");//change this id for each run
		driver.findElement(By.id("password")).sendKeys("DummyName@dummy7&");
		driver.findElement(By.id("mobileNumber")).sendKeys("8056482646");
		driver.findElement(By.xpath("//a[@id=\"signup-btn\"]")).click();
		driver.findElement(By.id("laterBtn")).click();
		System.out.println("New user created successfully");
		driver.close();//driver.quit();
	}
}
