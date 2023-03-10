import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsAndElementValues {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https:/rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https:/rahulshettyacademy.com/");
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> id = windows.iterator();
		String firstId = id.next();
		String secondId = id.next();
		driver.switchTo().window(secondId);
		String name = driver.findElement(By.xpath("(//div[@class='upper-box']/h2/a) [1]")).getText();
		driver.switchTo().window(firstId);
		WebElement fieldName= driver.findElement(By.cssSelector("input[name='name']"));
		fieldName.sendKeys(name);
		
		//To find values of your element use getRect.getDimension()
		System.out.println(fieldName.getRect().getDimension().getHeight());
		System.out.println(fieldName.getRect().getDimension().getWidth());
		
		
	}

}
