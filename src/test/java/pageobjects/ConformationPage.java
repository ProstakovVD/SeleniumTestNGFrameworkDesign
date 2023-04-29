package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ConformationPage extends AbstractComponent{

	WebDriver driver;
	//We need a constructor (first method that will be execute)
	public ConformationPage(WebDriver driver){
		
		//We are sending variable from parent to child class using super keyword
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".hero-primary") private WebElement confirmMsgOnPage;
	
	public String confirmMsg() {
		
		return confirmMsgOnPage.getText();
	
	}
	
}
