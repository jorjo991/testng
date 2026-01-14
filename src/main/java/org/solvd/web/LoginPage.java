package org.solvd.web;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.solvd.web.components.LoginForm;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='page-content']")
    private LoginForm loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openURL() {
        openURL("https://sauce-demo.myshopify.com/account/login");
    }

    public void login(String email, String password) {
        loginForm.writePasswordAndEmail(email, password);
        loginForm.clickSingInButton();
    }

}
