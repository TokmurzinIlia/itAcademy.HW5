package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.Driver.driver;

public class CatalogPage {

    private By computersAndNetworksButton = By.xpath("//li[@data-id = '2']");

    private By catalogSectionElement = By.xpath("//span[@class='catalog-navigation-classifier__item-title-wrapper']");

    private By computersAndNetworksSectionElement = By.xpath("//div[@data-id=\"2\"]//div[@class=\"catalog-navigation-list__aside-title\"]");

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

    public List<String> getTextElementFromCatalogSection(){


        return driver.findElements(catalogSectionElement)
                     .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTextElementFromComputersAndNetworksSection(){

        return driver.findElements(computersAndNetworksSectionElement)
                     .stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
