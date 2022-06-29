package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver ;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailRegister = By.xpath("//input[@id='email']");
    private By submitEmailRegister = By.xpath("(//button[@class='js-continue-button signup-continue-button form-control px-3 width-full width-sm-auto mt-4 mt-sm-0'])[1]");
    private By passwordRegister = By.xpath("//input[@id='password']");
    private By submitPasswordRegister = By.xpath("//button[@class='js-continue-button signup-continue-button form-control px-3 width-full width-sm-auto mt-4 mt-sm-0'])[2]");

    public RegisterPage submitEmail (String email){
        driver.findElement(emailRegister).sendKeys(email);
        driver.findElement(submitEmailRegister).click();
        return new RegisterPage(driver);
    }
    public RegisterPage submitPassword (String password){
        driver.findElement(passwordRegister).sendKeys(password);
        driver.findElement(submitPasswordRegister).click();
        return new RegisterPage(driver);
    }
}
