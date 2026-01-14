package org.solvd.test.webtest;

import com.zebrunner.carina.core.AbstractTest;
import org.solvd.web.CartPage;
import org.solvd.web.CatalogPage;
import org.solvd.web.HomePage;
import org.solvd.web.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddNoteToProduct extends AbstractTest {

    @Test
    public void addNoteToProductTest() {
        getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getDriver());
        homePage.openHomePage();
        CatalogPage catalogPage = homePage.catalogPage();
        ProductPage productPage = catalogPage.chooseProduct("Black heels");
        CartPage cartPage = productPage.addProductCart();
        cartPage.openCartPage();
        cartPage.addNote("for my sister");
        Assert.assertTrue(cartPage.isNoteAdded("for my sister"));
    }
}
