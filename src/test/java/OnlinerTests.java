
import dataProvider.DaraProviderCheckComputersAndNetworksSections;
import org.junit.jupiter.api.AfterAll;


import org.junit.jupiter.api.BeforeAll;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import pages.CatalogPage;

import utils.chromeDriwer.Driver;


import static org.junit.jupiter.api.Assertions.*;
import static utils.chromeDriwer.Driver.driver;


public class OnlinerTests {



    @BeforeEach
    public void getDriver() {
        Driver.getChromeDriver();

    }


//    @AfterEach
//    public void closeDriver(){
//        driver.close();
//    }

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
    @ArgumentsSource(DaraProviderCheckComputersAndNetworksSections.class)
    public void checkComputersAndNetworksSections(String s) {

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage()
                .openComputersAndNetworks();
        String locator = "//div[@class=\"catalog-navigation-list__aside-title\"][text()=\"" + " " + s + " " + "\"]";
        String name = driver.findElement(By.xpath(locator)).getText();
        assertAll(
                () -> assertTrue(driver.findElement(By.xpath(locator)).isDisplayed()),
                () -> assertEquals(s.replace(" ", ""), name.replace(" ", ""))
        );
    }
}

