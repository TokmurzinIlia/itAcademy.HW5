
import dataProvider.DaraProviderCheckComputersAndNetworksSections;
import org.junit.jupiter.api.AfterAll;


import org.junit.jupiter.api.BeforeAll;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import pages.CatalogPage;

import utils.chromeDriwer.Driver;


import static org.junit.jupiter.api.Assertions.*;
import static utils.chromeDriwer.Driver.driver;


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
    public void checkComputersAndNetworksSections(String s) {

        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openCatalogPage()
                .openComputersAndNetworks();
        String locator = "//div[@class=\"catalog-navigation-list__aside-title\"][text()=\"" + s + "\"]";
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
    }
//    @ParameterizedTest(name = "{0}")
//    @CsvFileSource(resources = "/catalogSectionCheck.txt")
//        public void testList(String s){
//    CatalogPage catalogPage = new CatalogPage(driver);
//
//    catalogPage.openCatalogPage();
//
//    List<WebElement> elements = driver.findElements(By.cssSelector("ul[class=\"catalog-navigation-classifier \"]"));
//
//    //System.out.println("Number of elements:" +elements.size());
//        ArrayList<String> sortedList = new ArrayList<>();
//    for (int i=0; i<elements.size();i++){
//
//        sortedList.add(elements.get(i).getText());
//    }
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("catalogSectionCheck.txt");
//            String string =null;
//            while((string=fileInputStream.read()){
//                System.out.print((char)i);
//            }
//            fin.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



//}
