package org.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchFrom extends AbstractUIObject {

    @FindBy(xpath = "//input[@id='search-submit']")
    private ExtendedWebElement searchSubmit;

    @FindBy(xpath = "//input[@class='search']")
    private ExtendedWebElement searchInput;

    public SearchFrom(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void searchProduct(String productName) {
        searchInput.type(productName);
        searchSubmit.isElementPresent();
        searchSubmit.click();
    }
}
