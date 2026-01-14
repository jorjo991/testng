package org.solvd.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.solvd.web.components.SideBar;
import org.solvd.web.components.TopHeader;

public class CartPage extends AbstractPage {

    @FindBy(css = "body")
    private ExtendedWebElement cartBody;
    @FindBy(xpath = "//a[text()='x']")
    private ExtendedWebElement removeButton;
    @FindBy(xpath = "//p[contains(., 'cart is currently empty')]")
    private ExtendedWebElement cartEmpty;
    @FindBy(xpath = ".//a[@class='toggle-drawer cart desktop']]")
    private TopHeader cartTopHeader;
    @FindBy(xpath = "//textarea[@id='note']")
    private ExtendedWebElement noteField;

    @FindBy(xpath = "//input[@id='update']")
    private ExtendedWebElement updateCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public TopHeader getTopHeader() {
        return new TopHeader(getDriver(), cartBody.getElement());
    }

    public SideBar getSideBar() {
        return new SideBar(getDriver(), cartBody.getElement());
    }

    public CartPage openCartPage() {
        openURL("https://sauce-demo.myshopify.com/cart");
        return this;
    }

    public CartPage removeProduct() {
        removeButton.assertElementPresent();
        removeButton.scrollTo();
        removeButton.click();
        return this;
    }

    public CartPage addNote(String note) {
        noteField.assertElementPresent();
        noteField.scrollTo();
        noteField.type(note);
        updateCartButton.click();
        return this;
    }

    public boolean isNoteAdded(String note) {
        return noteField.getText().toLowerCase().contains(note.toLowerCase());
    }

    public boolean isCartEmpty() {
        return cartEmpty.isElementPresent();
    }

}
