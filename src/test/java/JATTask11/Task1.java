package JATTask11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		String expectText = "New Window";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");

		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windows = driver.getWindowHandles();
		List<String> allwindows = new ArrayList<String>(windows);
		int totalwindow = allwindows.size();
		for (int i = 0; i <= totalwindow; i++) {
			if (driver.getPageSource().contains(expectText)) {

				System.out.println("User currently on new window page and New Window text is displaying");
				String newWindowID = driver.getWindowHandle();
				if (!newWindowID.equals(mainWindow)) {
					driver.close();
					driver.switchTo().window(mainWindow);
					System.out.println("Now the user is on main page");
				}
			} else {
				driver.switchTo().window(allwindows.get(i));
			}
		}
		driver.quit();//Giving this to avoid connection reset error
	}
}