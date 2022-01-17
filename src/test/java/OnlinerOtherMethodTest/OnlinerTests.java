package OnlinerOtherMethodTest;

import dataProvider.DaraProviderCheckComputersAndNetworksSectionsElement;
import dataProvider.DataProviderComputersAndNetworksAccessoriesSection;
import org.junit.jupiter.api.AfterAll;


import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.openqa.selenium.By;
import pages.CatalogPage;
import utils.chromeDriwer.MobileDriverChrome;
import static org.junit.jupiter.api.Assertions.*;
import static utils.chromeDriwer.MobileDriverChrome.driver;


public class OnlinerTests {

    @BeforeAll
    public  static void getDriver() {
        MobileDriverChrome.getChromeDriver();


    }


    @AfterAll
    public static void quitDriver(){
        driver.quit();
    }


    @ParameterizedTest(name = "{0}")
    @CsvFileSource(resources = "/otherData/catalogSectionCheck.txt")
    public void checkCatalogSections(String s, String dataId) {

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage();

        String locator = "//li[@data-id = \"" + dataId + "\"]";
        String name = driver.findElement(By.xpath(locator)).getText();

        assertAll(
                () -> assertTrue(driver.findElement(By.xpath(locator)).isDisplayed()),
                () -> assertEquals(s, name)
        );
    }



    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(DaraProviderCheckComputersAndNetworksSectionsElement.class)
    public void checkComputersAndNetworksSections(String s) {

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage()
                .openComputersAndNetworks();
        String locator = "//a[@href=\"https://catalog.onliner.by/"+ s + "\"]/../../..";

                assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());

    }

    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(DataProviderComputersAndNetworksAccessoriesSection.class)
    public void checkElementCatalogSectionByText(String s){

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage()
                .openComputersAndNetworks()
                .openComputersAndNetworksSectionAccessories();
        assertAll(
                () -> assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+
                        s + "\"]")).isDisplayed()),
                () ->assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+
                        s + "\"]//span[@class=\"catalog-navigation-list__dropdown-description\"]")).isDisplayed()),
                () ->assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+
                        s + "\"]//span[@class=\"catalog-navigation-list__dropdown-description\"]"))
                        .getText().contains("товар")),
                () ->assertTrue(driver.findElement(By.xpath("//a[@href=\"https://catalog.onliner.by/"+
                        s + "\"]//span[@class=\"catalog-navigation-list__dropdown-description\"]"))
                        .getText().contains("от")));

    }
}

