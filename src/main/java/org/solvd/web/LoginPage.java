package org.solvd.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='customer_email']")
    private ExtendedWebElement emailInput;
    @FindBy(xpath = "//input[@id='customer_password']")
    private ExtendedWebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openURL() {
        openURL("https://sauce-demo.myshopify.com/account/login");
    }

    public void login(String email, String password) {
        emailInput.isElementPresent();
        emailInput.type(email);
        passwordInput.isElementPresent();
        passwordInput.type(password);
        ExtendedWebElement loginButton = findExtendedWebElement(By.xpath("//input[@value='Sign In']"));
        loginButton.click();
    }

}
