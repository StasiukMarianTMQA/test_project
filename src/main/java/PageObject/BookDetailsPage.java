package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BookDetailsPage extends Book {
    public BookDetailsPage(String name, String author, String cover) {
        super(name, author, cover);
    }

    private WebDriver driver;

    public BookDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By detailHeading = By.xpath("//span[@id='productTitle']");
    private By detailCover = By.xpath("(//span[text()='Paperback'])[1]");


    public Book getDetails (){
        Book bookDetail = new Book();
        WebElement h1 = driver.findElement(detailHeading);
        WebElement cover = driver.findElement(detailCover);
        bookDetail.setName(h1.getText());
        bookDetail.setCover(cover.getText());
        return bookDetail;
    }
}
