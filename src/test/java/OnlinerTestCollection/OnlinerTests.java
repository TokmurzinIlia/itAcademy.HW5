package OnlinerTestCollection;


import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
    @ParameterizedTest(name = "Data from file catalogSectionCheckCollection.txt")
    @ValueSource(strings = "src/test/resources/dataForTestFromCollection/catalogSectionCheckCollection.txt")
    public void checkElementCatalogSection(String fileName){

        List<String> actualWebElementList = new CatalogPage(driver)
                .openCatalogPage()
                .getTextElementFromCatalogSection();

        List<String> expectedWebElementList = ReadFile
                .readFile(fileName);

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Order(2)
    @ParameterizedTest(name = "Data from file computersAndNetworkCollection.txt")
    @ValueSource(strings = "src/test/resources/dataForTestFromCollection/computersAndNetworkCollection.txt")
    public void checkElementComputersAndNetworksSections(String fileName){

        List<String> actualWebElementList = new CatalogPage(driver)
                .openCatalogPage()
                .openComputersAndNetworks()
                .getTextElementFromComputersAndNetworksSection();

        List<String> expectedWebElementList = ReadFile
                .readFile(fileName);

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Order(3)
    @ParameterizedTest(name = "Data from file ComputersAndNetworksAccessoriesSection.txt")
    @ValueSource(strings = "src/test/resources/dataForTestFromCollection/ComputersAndNetworksAccessoriesSection.txt")
    public void checkElementComputersAndNetworksAccessoriesSection(String fileName){

        List<String> actualWebElementList = new CatalogPage(driver).openCatalogPage()
                .openComputersAndNetworks()
                .openComputersAndNetworksSectionAccessories()
                .getTextElementFromComputersAndNetworksAccessoriesSection();

        List<String> expectedWebElementList = ReadFile
                .readFile(fileName);

        assertEquals(expectedWebElementList, actualWebElementList);

    }



}
