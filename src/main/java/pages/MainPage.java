package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    private By catalogButton = By.cssSelector("a[href=\"https://catalog.onliner.by/\"]");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;}

    public MainPage  openMainPage(){

        driver.get("https://onliner.by");
        return new MainPage(driver);
    }

    public MainPage openCatalog(){

        driver.findElement(catalogButton).click();
        return new MainPage(driver);

    }
}
