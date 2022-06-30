package RozetkaPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FridgesListPage {
   private static WebDriver driver;

    public FridgesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By fridgeTitle = By.xpath("//span[@class='goods-tile__title']");
    private By fridgePrice = By.xpath("//span[@class='goods-tile__price-value']");

    public List<Fridge> getListOfFridges(){
        List<Fridge> fridgesList = new ArrayList<>();
        List<WebElement> titlesList = driver.findElements(fridgeTitle);
        List<WebElement> pricesList = driver.findElements(fridgePrice);
        for (int i = 0 ; i < titlesList.size(); i++ ){
            Fridge fridge = new Fridge();
            fridge.setTitle(titlesList.get(i).getText());
            fridge.setPrice(pricesList.get(i).getText());
            fridgesList.add(fridge);
        }
        System.out.println(fridgesList);
        return fridgesList;
    }
}
