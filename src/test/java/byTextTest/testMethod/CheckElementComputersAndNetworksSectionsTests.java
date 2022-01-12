package byTextTest.testMethod;

import dataProvider.DaraProviderCheckComputersAndNetworksSections;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;
import utils.byText.ByText;
import utils.byText.WithText;
import utils.chromeDriwer.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.chromeDriwer.Driver.driver;

public class CheckElementComputersAndNetworksSectionsTests {


    @BeforeAll
    public static void getParam(){
        Driver.getChromeDriver();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openCatalogPage()
                .openComputersAndNetworks();
    }

    @AfterAll
    public static void quitDriver(){
        driver.close();
        driver.quit();
    }


    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(DaraProviderCheckComputersAndNetworksSections.class)
    public void checkElementComputersAndNetworksSectionsByText(String s){


        assertTrue(driver.findElement(new ByText(s)).isDisplayed());

    }
}
