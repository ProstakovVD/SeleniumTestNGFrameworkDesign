import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificWebElementScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https:/rahulshettyacademy.com/angularpractice/");
		WebElement fieldName= driver.findElement(By.cssSelector("input[name='name']"));
		fieldName.sendKeys("AAA");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss");
		Calendar now = Calendar.getInstance();
		File file = fieldName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("WebElement"+formatter.format(now.getTime())+".png"));
		
	}

}
