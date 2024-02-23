package shoppingFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shoppingResorces.BaseTest;
import shoppingResorces.RetryAnalyzer;

public class ShoppingErrorValidations extends BaseTest{
	
	@Test (dataProvider = "getData", retryAnalyzer = RetryAnalyzer.class)
//	@Test (dataProvider = "getData")
	public void errorValidation(String mail, String pass) {
		String errormessage = login.validateError(mail, pass);
		Assert.assertEquals("Incorrect email or password.", errormessage);
	}
	
	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "praveenvydani@gmail.com", "Pravee"},
				{ "vydanipraveen@gmail.com", "Prave"} };
	}
}
