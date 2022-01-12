package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.stream.Collectors;


public class CatalogPage {

    private final By computersAndNetworksButton = By.xpath("//li[@data-id = '2']");

    private final By catalogSectionElement = By.xpath("//span[@class='catalog-navigation-classifier__item-title-wrapper']");

    private final By computersAndNetworksSectionElement = By.cssSelector("div[data-id=\"2\"] div.catalog-navigation-list__aside-title");

    private final By computersAndNetworksSectionAccessoriesButton = By.xpath("//div[contains(text(),'Комплектующие')]");

    private final By computersAndNetworksSectionAccessoriesElement = By.xpath("//div[contains(text(),'Комплектующие')]/.." +
            "//span[@class=\"catalog-navigation-list__dropdown-data\"]");

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

    public CatalogPage openComputersAndNetworksSectionAccessories(){

        driver.findElement(computersAndNetworksSectionAccessoriesButton).click();
        return new CatalogPage(driver);

    }

    public List<String> getTextElementFromCatalogSection(){


        return driver.findElements(catalogSectionElement)
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }

    public List<String> getTextElementFromComputersAndNetworksSection(){

        return driver.findElements(computersAndNetworksSectionElement)
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }

    public List<String> getTextElementFromComputersAndNetworksAccessoriesSection(){

        return driver.findElements(computersAndNetworksSectionAccessoriesElement)
                     .stream()
                     .map(WebElement::getText)
                     .map((s) ->s.replace("\n", " "))
                     .collect(Collectors.toList());
    }

}
