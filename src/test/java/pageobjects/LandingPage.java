package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	//We need a constructor (first method that will be execute)
	public LandingPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@type='email']") private WebElement userEmail;
	
	@FindBy(xpath="//input[@type='password']") private WebElement userPassword;
	
	@FindBy(xpath="//input[@id='login']") private WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']") private WebElement errorMessage;
	
	public ProductCatalogue loginAplication(String email, String password) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		errorMessage.getText();
		return errorMessage.getText();
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
}
