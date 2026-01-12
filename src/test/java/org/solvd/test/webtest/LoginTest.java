package org.solvd.test.webtest;

import com.zebrunner.carina.core.AbstractTest;
import org.solvd.web.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    @Test
    public void TestLogin() {
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.openURL();
        loginPage.login("g.ugulava12@gmail.com","kacikaci1234");

    }
}
