package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilma\\IdeaProjects\\test_project\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")).click();
        driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        List<List<WebElement>> elements = new ArrayList<>();
        List<WebElement> elementsHeadings = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> elementsAuthors = driver.findElements(By.xpath("//span[@class='a-size-base']"));
        List<WebElement> elementsPrice = driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));

        String ourBookName = "Head First Java, 2nd Edition";

        elements.add(elementsHeadings);
        elements.add(elementsAuthors);
        elements.add(elementsPrice);
        elements.add(elementsHeadings);
        elements.add(elementsAuthors);
        elements.add(elementsPrice);

        for (List<WebElement> webElement : elements) {
            for (WebElement elementsHeading : elementsHeadings) {
                String text = elementsHeading.getText();
                if (text.contains(ourBookName)) {
                    System.out.println(text);
                }
            }
        }
    }
}
