package byTextTest.testMethod;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.CatalogPage;
import utils.byText.ByText;
import utils.byText.WithText;
import utils.chromeDriwer.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.chromeDriwer.Driver.driver;

public class СheckElementCatalogSectionByTextTests {



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
    public void checkElementCatalogSectionByText(String s){

        assertTrue(driver.findElement(new ByText(s)).isDisplayed());

    }


}
