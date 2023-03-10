import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {

	public static void main(String[] args) {

		//You need to create ChromeOptins class to deal with certificates 
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//You need to create Proxy class to deal with any proxy related things
		// there a lot of proxy setups, ask your network support team to deal with it
	//Proxy proxy = new Proxy();
		//It may be look like this (you will need options.setCapability too)
	//proxy.setHttpProxy("ipaddress:4444");
	//options.setCapability("proxy", proxy);
		//You can also configure path where downloads will go using ChromeOptions 
		//To deal with pop-up things like "allow your location" use next line of code and they all will be blocking
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		//After you configured ChromeOptions object you need to send it to ChromeDriver as an argument
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
	}

}
