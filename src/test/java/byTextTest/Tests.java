package byTextTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.CatalogPage;
import utils.ByText;
import utils.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Driver.driver;

public class Tests {
    @BeforeAll
    public static void getParam(){
        Driver.getChromeDriver();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openCatalogPage();
    }

    @AfterAll
    public static void quitDriver(){
        driver.close();
        driver.quit();
    }

    @ParameterizedTest(name = "{0}")
    @CsvFileSource(resources = "/dataForTestFromCollection/catalogSectionCheckCollection.txt")
    public void testByText(String s){

        assertTrue(driver.findElement(new ByText(s)).isDisplayed());


    }
}
