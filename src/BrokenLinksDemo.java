import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksDemo {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//In this part we are basically calling URL's to get the status code
		//Selenium solo can't handle this so we need some java methods too
		//Step 1 is to get all URL's using Selenium
		//Then java will scan links and if status code is >400 that link is broken
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert sa = new SoftAssert();
		for(int i=0;i<links.size(); i++) {
			
			//You can just cope this code or watch 111+112 lectures
			String url = links.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			String errorMassage1 = links.get(i).getAttribute("href")+" is broken with code "+respCode;
			sa.assertTrue(respCode<400, errorMassage1);
			
		}
		//To fail your if any soft assertions failed
		sa.assertAll();
		
	}

}
