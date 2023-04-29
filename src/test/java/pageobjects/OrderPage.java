package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	//We need a constructor (first method that will be execute)
	public OrderPage(WebDriver driver){
		
		//We are sending variable from parent to child class using super keyword
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)") private List<WebElement> productNames;
	
	public Boolean assertOrderDisplay(String itemNeeded) {
		
		Boolean match = productNames.stream().anyMatch(s->
		s.getText().equalsIgnoreCase(itemNeeded));
		return match;
		
	}
	
}
