package RozetkaPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class FridgeDetails extends Fridge{
   private WebDriver driver;
    public FridgeDetails(String title, String price) {
        super(title, price);
    }
    private By singleFridgeTitle = By.xpath("//h1[@class='product__title']");
    private By singleFridgePrice = By.xpath("(//p[@class='product-prices__big'])[1]");

    public FridgeDetails(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FridgeDetails that = (FridgeDetails) o;
        return Objects.equals(driver, that.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driver);
    }

    @Override
    public String toString() {
        return "FridgeDetails{" +
                "driver=" + driver +
                '}';
    }

    public Fridge getSingleFridge(){
        Fridge fridge = new Fridge();
        WebElement fridgeTitle = driver.findElement(singleFridgeTitle);
        WebElement fridgePrice = driver.findElement(singleFridgePrice);
        fridge.setTitle(fridgeTitle.getText());
        String textWithSymbol = fridgePrice.getText();
        String editedPrice = textWithSymbol.substring(0, textWithSymbol.length() - 1);
        fridge.setPrice(editedPrice);
        System.out.println(fridge);
        return fridge;
    }
}
