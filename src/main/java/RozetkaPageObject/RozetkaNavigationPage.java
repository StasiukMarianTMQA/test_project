package RozetkaPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaNavigationPage {
    private WebDriver driver;

    public RozetkaNavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By findInList = By.xpath("(//a[@class='menu-categories__link'][contains(text(),'Побутова техніка')])[1]");
    private By goToFridges = By.xpath("//a[@title='Холодильники']");


    public void navigationMethods (){
        driver.findElement(findInList).click();
        driver.findElement(goToFridges).click();
    }
}
