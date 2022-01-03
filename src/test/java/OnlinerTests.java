
import org.junit.jupiter.api.AfterAll;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import pages.CatalogPage;

import utils.Driver;


import static org.junit.jupiter.api.Assertions.*;
import static utils.Driver.driver;


public class OnlinerTests {



    @BeforeAll
    public static void getDriver() {
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
    @CsvFileSource(resources = "/catalogSectionCheck.txt")
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


    @Test
    public void checkCatalogSections(){

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage()
                   .openComputersAndNetworks();
        assertFalse(driver.findElement
                (By.xpath("//div[@class=\"catalog-navigation-list__aside-title\"][text()=\" Ноутбуки, компьютеры, мониторы \"]"))
                .isDisplayed());




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
