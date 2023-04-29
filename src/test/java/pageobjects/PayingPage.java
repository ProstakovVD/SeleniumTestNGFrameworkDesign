package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class PayingPage extends AbstractComponent{

	WebDriver driver;
	//We need a constructor (first method that will be execute)
	public PayingPage(WebDriver driver){
		
		//We are sending variable from parent to child class using super keyword
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[placeholder*='Country']") private WebElement dropdownCountry;
	
	@FindBy(css="button[class*='ta-item']:nth-child(5)") private WebElement choosenCountryUS;
	
	@FindBy(css="a[class*='submit']") private WebElement submitBtn;
	
	private By chooseList = By.cssSelector("section[class*='ta-results']");
	
	public void selectCountryUS() {
		
		Actions a = new Actions(driver);
		a.sendKeys(dropdownCountry,"United").build().perform();
		waitForElementToAppear(chooseList);
		choosenCountryUS.click();
		
	}
	
	public ConformationPage submitForm() {
		
		submitBtn.click();
		ConformationPage conformationPage = new ConformationPage(driver);
		return conformationPage;
		
	}
	
}
