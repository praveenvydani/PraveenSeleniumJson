package shoppingPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingAbstractClass.AbstractClass;

public class LoginPage extends AbstractClass{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "userEmail")
	WebElement userMail;

	@FindBy(id = "userPassword")
	WebElement userPass;
	
	@FindBy(id ="login")
	WebElement loginButton;
	
	@FindBy(id= "toast-container")
	WebElement error;
	
	public void getUrl() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public Dashboard loginApplication(String mail, String pass) {
		userMail.sendKeys(mail);
		userPass.sendKeys(pass);
		loginButton.click();
		return new Dashboard(driver);
	}
	
	public String validateError(String mail, String pass) {
		userMail.sendKeys(mail);
		userPass.sendKeys(pass);
		loginButton.click();
		visibilityOfElement(error);
		return error.getText();
	}
}
