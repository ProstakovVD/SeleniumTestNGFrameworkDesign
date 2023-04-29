package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	//We need a constructor (first method that will be execute)
	public ProductCatalogue(WebDriver driver){
		
		//We are sending variable from parent to child class using super keyword
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[contains(@class, 'card-body')]") private List<WebElement> allItems;
	
	@FindBy(css=".ng-animating") private WebElement spinner;
	
	private By allItemsBy = By.xpath("//div[contains(@class, 'card-body')]");
	private By addToCart = By.cssSelector(".card-body button:last-of-type");
	private By toastMessage = By.cssSelector(".toast-container");
	
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(allItemsBy);
		return allItems;
		
	}
	
	public void addProductToCart(String itemNeeded) {
		
		WebElement prod = getProductList().stream().filter(s->
		s.findElement(By.cssSelector("h5 b")).getText().equals(itemNeeded)).findFirst().orElse(null);
		
		WebElement product = prod;
		product.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	
}
