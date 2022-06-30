package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class BookDetailsPage extends Book {
    public BookDetailsPage(String name, String price) {
        super(name, price);
    }

    private WebDriver driver;

    public BookDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By detailHeading = By.xpath("//span[@id='productTitle']");
    private By detailCover = By.xpath("(//span[text()='Paperback'])[1]");

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookDetailsPage that = (BookDetailsPage) o;
        return Objects.equals(driver, that.driver) && Objects.equals(detailHeading, that.detailHeading) && Objects.equals(detailCover, that.detailCover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driver, detailHeading, detailCover);
    }

    public Book getDetails (){
        Book bookDetail = new Book();
        WebElement h1 = driver.findElement(detailHeading);
        WebElement cover = driver.findElement(detailCover);
        bookDetail.setName(h1.getText());
        bookDetail.setCover(cover.getText());

        return bookDetail;
    }
}
