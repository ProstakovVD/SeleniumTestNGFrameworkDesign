package legacy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTestBase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("gigaunited@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UnitedNow_1");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		String itemNeeded = "ZARA COAT 3";
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'card-body')]")));
		List<WebElement>allItems = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
		WebElement product = allItems.stream().filter(s->
		s.findElement(By.xpath("//h5[contains(@style,'text-transform')]")).getText().equals(itemNeeded)).findFirst().orElse(null);
		product.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn w-10 rounded']")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection")));
		List<WebElement>allItemsCart = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = allItemsCart.stream().anyMatch(s->
		s.getText().equals(itemNeeded));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector("ul[style*='list-style-type'] button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Country']")),"United").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results']")));
		driver.findElement(By.cssSelector("button[class*='ta-item']:nth-child(5)")).click();
		driver.findElement(By.cssSelector("a[class*='submit']")).click();
		String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		driver.close();
		
	}

}
