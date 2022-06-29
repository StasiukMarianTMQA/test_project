package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    private By usernameField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By errorSignIn = By.xpath("//div[@class='px-2']");
    private By submitSighIn = By.xpath("//input[@type='submit']");

    public SignInPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }
    public SignInPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignInPage submitForm(String username , String password){
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(submitSighIn).click();
        return new SignInPage(driver);
    }
    public String errorMessage (){
        return driver.findElement(errorSignIn).getText();
    }


}
