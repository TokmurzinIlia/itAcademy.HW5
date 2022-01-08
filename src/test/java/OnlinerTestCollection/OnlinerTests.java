package OnlinerTestCollection;


import org.junit.jupiter.api.*;
import pages.CatalogPage;
import utils.Driver;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Driver.driver;


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


    @Test
    public void checkElementCatalogSection(){

        List<String> actualWebElementList = new CatalogPage(driver)
            .openCatalogPage()
            .getTextElementFromCatalogSection();


        List<String> expectedWebElementList = new ArrayList<>();
        try {
            expectedWebElementList = Files.lines(Paths.get("src/test/resources/catalogSectionCheckCollection.txt"),
                    StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(actualWebElementList, expectedWebElementList);
    }

    @Test
    public void checkElementComputersAndNetworksSections(){

        List<String> actualWebElementList = new CatalogPage(driver)
                .openCatalogPage()
                .openComputersAndNetworks()
                .getTextElementFromComputersAndNetworksSection();


        List<String> expectedWebElementList = new ArrayList<>();
        try {
            expectedWebElementList = Files.lines(Paths.get("src/test/resources/computersAndNetworkCollection.txt"),
                    StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(actualWebElementList, expectedWebElementList);
    }



}
