package byTextTest.testMethod;

import dataProvider.DataProviderComputersAndNetworksAccessoriesSection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.By;
import pages.CatalogPage;
import utils.chromeDriwer.Driver;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.chromeDriwer.Driver.driver;

public class СheckElementComputersAndNetworksAccessoriesSectionByTextTests {

    @BeforeAll
    public static void getParam(){
        Driver.getChromeDriver();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openCatalogPage()
                   .openComputersAndNetworks()
                   .openComputersAndNetworksSectionAccessories();
    }

    @AfterAll
    public static void quitDriver(){
        driver.close();
        driver.quit();
    }

    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(DataProviderComputersAndNetworksAccessoriesSection.class)
    public void checkElementCatalogSectionByText(String s){

        assertAll(
                () -> assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+ s + "\"]")).isDisplayed()),
                () ->assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+
                        s + "\"]//span[@class=\"catalog-navigation-list__dropdown-description\"]")).isDisplayed()),
                () ->assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+
                        s + "\"]//span[@class=\"catalog-navigation-list__dropdown-description\"]")).getText().contains("товар")),
                () ->assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+
                        s + "\"]//span[@class=\"catalog-navigation-list__dropdown-description\"]")).getText().contains("от")));

    }
}
