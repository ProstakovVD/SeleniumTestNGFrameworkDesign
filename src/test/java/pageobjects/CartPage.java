package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	//We need a constructor (first method that will be execute)
	public CartPage(WebDriver driver){
		
		//We are sending variable from parent to child class using super keyword
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3") private List<WebElement> allItemsCart;
	
	@FindBy(css="ul[style*='list-style-type'] button") private WebElement moveToPayingPageBtn;
	
	private By cartSection = By.cssSelector(".cartSection");
	
	public List<WebElement> getProductListCart() {
		
		waitForElementToAppear(cartSection);
		return allItemsCart;
		
	}
	
	public Boolean assertProductInCart(String itemNeeded) {
		
		Boolean match = getProductListCart().stream().anyMatch(s->
		s.getText().equals(itemNeeded));
		return match;
		
	}
	
	public PayingPage moveFromCartPageToPayingPage() {
		
		moveToPayingPageBtn.click();
		PayingPage payingPage = new PayingPage(driver);
		return payingPage;
		
	}
	
}
