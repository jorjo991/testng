package org.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideBar extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(normalize-space(.),'Catalog')]")
    private ExtendedWebElement catalogLink;

    @FindBy(xpath = ".//a[contains(normalize-space(.),'Home')]")
    private ExtendedWebElement homeLink;

    public SideBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCatalog() {
        catalogLink.assertElementPresent();
        catalogLink.click();
    }

    public void clickHome() {
        homeLink.assertElementPresent();
        homeLink.click();
    }

    public ExtendedWebElement getCatalogLink() {
        return catalogLink;
    }

    public ExtendedWebElement getHomeLink() {
        return homeLink;
    }

}
