package OnlinerTestCollection;


import org.junit.jupiter.api.*;

import pages.CatalogPage;
import utils.chromeDriwer.Driver;
import utils.readFile.ReadFile;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static utils.chromeDriwer.Driver.driver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class OnlinerTests {



    @BeforeEach
    public void getDriver() {
        Driver.getChromeDriver();

    }

    @AfterEach
    public void closeDriver(){
        driver.quit();
    }

//    @AfterAll
//    public static void quitDriver(){
//        driver.quit();
//    }

    @Order(1)
    @Test
    public void checkElementCatalogSection(){

        List<String> actualWebElementList = new CatalogPage(driver)
                .openCatalogPage()
                .getTextElementFromCatalogSection();

        List<String> expectedWebElementList = ReadFile
                .readFile("src/test/resources/dataForTestFromCollection/catalogSectionCheckCollection.txt");

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Order(2)
    @Test
    public void checkElementComputersAndNetworksSections(){

        List<String> actualWebElementList = new CatalogPage(driver)
                .openCatalogPage()
                .openComputersAndNetworks()
                .getTextElementFromComputersAndNetworksSection();

        List<String> expectedWebElementList = ReadFile
                .readFile("src/test/resources/dataForTestFromCollection/computersAndNetworkCollection.txt");

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Order(3)
    @Test
    public void checkElementComputersAndNetworksAccessoriesSection(){

        List<String> actualWebElementList = new CatalogPage(driver).openCatalogPage()
                .openComputersAndNetworks()
                .openComputersAndNetworksSectionAccessories()
                .getTextElementFromComputersAndNetworksAccessoriesSection();

        List<String> expectedWebElementList = ReadFile
                .readFile("src/test/resources/dataForTestFromCollection/ComputersAndNetworksAccessoriesSection.txt");

        assertEquals(expectedWebElementList, actualWebElementList);

    }



}
