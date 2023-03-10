
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@aria-sort='descending']")).click();
		
		List<WebElement>items = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		List<String>originalItems = items.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedList =originalItems.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(originalItems, sortedList);
		//Or Assert.assertTrue(originalItems.equals(sortedList));
		
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("ri");
		List<WebElement>items3 = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		List<WebElement>filteredItems3 = items3.stream().filter(s->s.getText().toLowerCase().contains("ri")).collect(Collectors.toList());
		Assert.assertEquals(items3, filteredItems3);
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(Keys.BACK_SPACE);
		
		List<String>price;
		//I think that do{} while() can be replaced to usual while
		do {
			
		List<WebElement>items2 = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		price = items2.stream().filter(s->s.getText().contains("Carrot")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
			if(price.size()<1) {
			
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			
			}
		
		}while(price.size()<1);
		
	}

	private static String getPriceVeggie(WebElement s) {

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
		
	}

}
