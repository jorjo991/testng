package org.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy(xpath = "//input[@value='Sign In']")
    private ExtendedWebElement singInButton;
    @FindBy(xpath = "//input[@id='customer_email']")
    private ExtendedWebElement emailInput;
    @FindBy(xpath = "//input[@id='customer_password']")
    private ExtendedWebElement passwordInput;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public void clickSingInButton() {
        singInButton.assertElementPresent();
        singInButton.click();
    }

    public void writePasswordAndEmail(String email, String password) {
        emailInput.assertElementPresent();
        emailInput.type(email);
        passwordInput.assertElementPresent();
        passwordInput.type(password);
    }
}
