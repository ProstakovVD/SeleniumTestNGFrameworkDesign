import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSizeAndCookies {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//use .manage().window() to set window size that you want
		driver.manage().window().maximize();
		//To deal with cookies you need .manage() and then something related to cookies depends on what especially you need
		driver.manage().deleteAllCookies();
		driver.get("https://google.com");
		
	}

}
