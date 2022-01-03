package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    private By computersAndNetworksButton = By.xpath("//li[@data-id = '2']");

    private WebDriver driver;

    public CatalogPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public CatalogPage openCatalogPage()
    {

        driver.get("https://catalog.onliner.by/");
        return new CatalogPage(driver);

    }

    public CatalogPage openComputersAndNetworks(){

        driver.findElement(computersAndNetworksButton).click();
        return new CatalogPage(driver);

    }
}
