package org.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopHeader extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@href,'/cart') and  contains(normalize-space(.),'My Cart')]")
    private ExtendedWebElement myCart;

    public TopHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickMyCart() {
        myCart.assertElementPresent();
        myCart.scrollTo();
        myCart.click();
    }

    public ExtendedWebElement getMyCart() {
        return myCart;
    }
}
