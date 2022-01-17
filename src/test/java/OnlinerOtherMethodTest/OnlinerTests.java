package OnlinerOtherMethodTest;

import dataProvider.DaraProviderCheckComputersAndNetworksSectionsElement;
import dataProvider.DataProviderComputersAndNetworksAccessoriesSection;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CatalogPage;
import utils.chromeDriwer.MobileDriverChrome;
import static org.junit.jupiter.api.Assertions.*;



public class OnlinerTests {

    private static WebDriver driver;


    @BeforeAll
    public static void getDriver() {
        driver = MobileDriverChrome.getChromeDriver();


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
    @ArgumentsSource(DaraProviderCheckComputersAndNetworksSectionsElement.class)
    public void checkComputersAndNetworksSections(String s) {

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage()
                .openComputersAndNetworks();
        String locator = "//a[@href=\"https://catalog.onliner.by/"+ s + "\"]/../../..";
        String name = driver.findElement(By.xpath(locator)).getText();
        assertAll(
                () -> assertTrue(driver.findElement(By.xpath(locator)).isDisplayed())
                //() -> assertEquals(s.replace(" ", ""), name.replace(" ", ""))
        );
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

