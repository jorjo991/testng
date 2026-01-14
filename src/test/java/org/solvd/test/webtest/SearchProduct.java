package org.solvd.test.webtest;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.common.CommonUtils;
import org.solvd.web.HomePage;

import static org.testng.Assert.assertTrue;

import org.solvd.web.SearchProductResultPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchProduct extends AbstractTest {

    @Test
    public void searchForProduct() {
        getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getDriver());
        homePage.openHomePage();
        homePage.searchProduct("black");
        SearchProductResultPage searchProductResultPage = new SearchProductResultPage(getDriver());
        searchProductResultPage.isProductPresent("black");
    }

    @AfterTest
    public void Setdown() {
        getDriver().quit();
    }
}
