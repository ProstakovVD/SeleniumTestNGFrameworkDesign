package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ConformationPage;
import pageobjects.OrderPage;
import pageobjects.PayingPage;
import pageobjects.ProductCatalogue;
import testComponents.BaseForTests;

public class SubmitOrderTest extends BaseForTests{
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException{

		ProductCatalogue productCatalogue = landingPage.loginAplication(input.get("email"), input.get("password"));
		
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("itemNeeded"));
		CartPage cartPage = productCatalogue.headerMoveToCartPage();
		
		cartPage.getProductListCart();
		Boolean match = cartPage.assertProductInCart(input.get("itemNeeded"));
		Assert.assertTrue(match);
		PayingPage payingPage = cartPage.moveFromCartPageToPayingPage();
		
		payingPage.selectCountryUS();
		ConformationPage conformationPage = payingPage.submitForm();

		String confirmMsg = conformationPage.confirmMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dataProvider="getData", dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest(HashMap<String,String> input) {
		
		ProductCatalogue productCatalogue = landingPage.loginAplication(input.get("email"), input.get("password"));
		
		OrderPage orderPage = productCatalogue.headerMoveToOrderPage();
		Assert.assertTrue(orderPage.assertOrderDisplay(input.get("itemNeeded")));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}

}
