import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopUp2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		//One of a ways to complete basic auth is by folowing next syntax:
		// https://Username:Password@SiteURL
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
	}

}
