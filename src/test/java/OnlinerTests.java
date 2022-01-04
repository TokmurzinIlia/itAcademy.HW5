
import dataProvider.DaraProviderCheckComputersAndNetworksSections;
import org.junit.jupiter.api.AfterAll;


import org.junit.jupiter.api.BeforeAll;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import pages.CatalogPage;

import utils.Driver;


import java.util.stream.Stream;

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


    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(DaraProviderCheckComputersAndNetworksSections.class)
    public void checkComputersAndNetworksSections(String s){

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage()
                   .openComputersAndNetworks();
        String locator = "//div[@class=\"catalog-navigation-list__aside-title\"][text()=\"" + s +  "\"]";
        String name = driver.findElement(By.xpath(locator)).getText();
        assertAll(
                () -> assertTrue(driver.findElement(By.xpath(locator)).isDisplayed()),
                () -> assertEquals(s.replace(" ", ""), name.replace(" ", ""))
        );}
//        static Stream<String> DaraProviderCheckComputersAndNetworksSections () {
//            return Stream.of(
//                    " Ноутбуки, компьютеры, мониторы ",
//                    " Комплектующие ",
//                    " Хранение данных ",
//                    " Сетевое оборудование ");
//        }



//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
//}
