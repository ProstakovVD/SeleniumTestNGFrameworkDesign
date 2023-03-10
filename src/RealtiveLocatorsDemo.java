import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// !!!To use relative locators you need to import one package manually because this package is static one
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RealtiveLocatorsDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https:/rahulshettyacademy.com/angularpractice/");
		//This is a syntax for relative (or friendly) locators
		// driver.findElement(with(By.tagName("XX")).xxx(WebElement))
		// no the xxx place can be "above" or "below" or something else
		WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));
		// !!!To use relative locators you need to import one package manually because this package is static one
		String name = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(name);
		WebElement passwordEditBox = driver.findElement(By.cssSelector("input[id='exampleInputPassword1']"));
		String something = driver.findElement(with(By.tagName("div")).below(passwordEditBox)).getText();
		System.out.println(something);
		WebElement secondCheckBox = driver.findElement(By.cssSelector("label[for='inlineRadio2']"));
		String firstCheckBox = driver.findElement(with(By.tagName("label")).toLeftOf(secondCheckBox)).getText();
		System.out.println(firstCheckBox);
		String thirdCheckBox = driver.findElement(with(By.tagName("label")).toRightOf(secondCheckBox)).getText();
		System.out.println(thirdCheckBox);
		
	}

}
