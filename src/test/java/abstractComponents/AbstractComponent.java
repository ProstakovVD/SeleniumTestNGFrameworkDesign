package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;
import pageobjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']") WebElement cartHeader;

	@FindBy(css="[routerlink*='myorders']") WebElement orderHeader;

	
	public void waitForElementToAppear(By findBy){
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElementToAppear(WebElement findBy){
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	public void waitForElementToDisappear(WebElement webEle){
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.invisibilityOf(webEle));
		
	}
	
	public CartPage headerMoveToCartPage() {
		
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public OrderPage headerMoveToOrderPage() {
		
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}
	
}
