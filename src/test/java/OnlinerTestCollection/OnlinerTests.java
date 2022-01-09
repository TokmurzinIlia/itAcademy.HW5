package OnlinerTestCollection;


import org.junit.jupiter.api.*;

import pages.CatalogPage;
import utils.Driver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Driver.driver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class OnlinerTests {



    @BeforeEach
    public void getDriver() {
        Driver.getChromeDriver();

    }

    @AfterEach
    public void closeDriver(){
        driver.close();
    }

    @AfterAll
    public static void quitDriver(){
        driver.quit();
    }

    @Order(1)
    @Test
    public void checkElementCatalogSection(){

        List<String> actualWebElementList = new CatalogPage(driver)
            .openCatalogPage()
            .getTextElementFromCatalogSection();


        List<String> expectedWebElementList = null;
        try {
            expectedWebElementList = Files.lines(Paths.get("src/test/resources/dataForTestFromCollection/catalogSectionCheckCollection.txt"),
                    StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Order(2)
    @Test
    public void checkElementComputersAndNetworksSections(){

        List<String> actualWebElementList = new CatalogPage(driver)
                .openCatalogPage()
                .openComputersAndNetworks()
                .getTextElementFromComputersAndNetworksSection();


        List<String> expectedWebElementList = null;
        try {
            expectedWebElementList = Files.lines(Paths.get("src/test/resources/dataForTestFromCollection/computersAndNetworkCollection.txt"),
                    StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedWebElementList, actualWebElementList);
    }

    @Order(3)
    @Test
    public void checkElementComputersAndNetworksAccessoriesSection(){

        List<String> actualWebElementList = new CatalogPage(driver).openCatalogPage()
                .openComputersAndNetworks()
                .openComputersAndNetworksSectionAccessories()
                .getTextElementFromComputersAndNetworksAccessoriesSection();

        List<String> expectedWebElementList = null;
        try {
            expectedWebElementList = Files.lines(Paths.get("src/test/resources/dataForTestFromCollection/ComputersAndNetworksAccessoriesSection.txt"),
                    StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedWebElementList, actualWebElementList);

    }



}
