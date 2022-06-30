package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultSearchPage {
    private WebDriver driver;

    public ResultSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By elementsHeadings = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    private By elementsDate = By.xpath("//span[@class='a-size-base a-color-secondary a-text-normal']");
    private By elementsCover = By.xpath("//a[text()='Paperback']");

    private By resultsString = By.xpath("//span[text()='RESULTS']");

    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(elementsHeadings);
        List<WebElement> elementList1 = driver.findElements(elementsDate);
        List<WebElement> elementList2 = driver.findElements(elementsCover);
        for (int i = 0 ; i < elementList1.size();i++) {
            Book book = new Book();
            book.setName(String.valueOf(elementList.get(i).getText()));
            book.setDate(String.valueOf(elementList1.get(i).getText()));
            book.setCover(String.valueOf(elementList2.get(i).getText()));
            bookList.add(book);
        }
        System.out.println(bookList);
        return bookList;
    }

    public String getResultWord(){
      return driver.findElement(resultsString).getText();
    }

}
