package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ProductCatalogue;
import testComponents.BaseForTests;
import testComponents.Retry;

public class ErrorValidations extends BaseForTests{

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException{

		landingPage.loginAplication("Gigaunited@gmail.com", "unitedNow_1");
		//Error is in assertion
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
	
	//productErrorValidation does not have groups= {"ErrorHandling"}, so it won't execute
	@Test(retryAnalyzer=Retry.class)
	public void productErrorValidation() throws IOException{

		String itemNeeded = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginAplication("gigaunited@gmail.com", "UnitedNow_1");
		
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(itemNeeded);
		CartPage cartPage = productCatalogue.headerMoveToCartPage();
		
		cartPage.getProductListCart();
		//Error is in boolean 
		Boolean match = cartPage.assertProductInCart("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
