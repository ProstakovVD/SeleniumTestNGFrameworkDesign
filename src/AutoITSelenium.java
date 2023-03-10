import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AutoITSelenium {

	public static void main(String[] args) throws IOException {

		String downloadPath = System.getProperty("user.dir");
		
		//Here we give a path in a HashMap to ChromeOptions, with this settings
		// files that going to be downloaded will be placed in this project folder
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		driver.get("https://www.freeconvert.com/pdf-to-jpg");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#upload-file-button")));
		driver.switchTo().defaultContent();
		
		//!!! Something intercepts click action so all next code is just to watch and not execute !!!
		//I mean just grab the concept
		
		//Now we have to call our .exe file
		//Btw check lec 242 and 243 if you have forgotten how to write a script or how to convert it etc...
		Runtime.getRuntime().exec("C:\\Users\\Vlad\\Documents\\AutoIT converted scripts\\fileuploadDEMO.exe");
		driver.findElement(By.cssSelector("button[class*=action__convert]")).click();
		driver.findElement(By.id("ItemDownloadButton")).click();
		//Download have done, now let's check if file is now in memory of our machine 
		File file = new File(downloadPath+"/JustAFile.jpg");
		if (file.exists()) {
			
			System.out.println("File exists, deleting...");
			file.delete();
			
		} else {
			
			System.out.println("Error, file doesn't exist or part to file is wrong");
			Assert.assertTrue(false);
			
		}
		
		driver.close();

	}

}
