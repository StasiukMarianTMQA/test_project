package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {
    private WebDriver driver;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dropDown = By.xpath("//select[@aria-describedby='searchDropdownDescription']");
    private By select = By.xpath("//option[@value='search-alias=stripbooks-intl-ship']");
    private By input = By.xpath("//input[@id='twotabsearchtextbox']");
    private By confirm = By.xpath("//input[@id='nav-search-submit-button']");

    public void valueFinder(){
        driver.findElement(dropDown).click();
        driver.findElement(select).click();
        driver.findElement(input).sendKeys("Java");
        driver.findElement(confirm).click();
    }

}
