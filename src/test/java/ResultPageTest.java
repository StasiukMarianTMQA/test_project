import PageObject.Book;
import PageObject.BookDetailsPage;
import PageObject.NavigationPage;
import PageObject.ResultSearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultPageTest {
        private WebDriver driver;
        private NavigationPage navigationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilma\\IdeaProjects\\test_project\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        navigationPage = new NavigationPage(driver);
        driver.get("https://www.amazon.com/");
        navigationPage.valueFinder();
    }

    @Test
        public void checkSwitchPage (){
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        String resultWord = resultSearchPage.getResultWord();
        Assert.assertEquals("RESULTS" , resultWord);
    }

    @Test
    public void checkList(){
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        List<Book> books = resultSearchPage.getBooks();
        driver.get("https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_11?keywords=Java&qid=1656507840&s=books&sr=1-11");
        BookDetailsPage bookDetailsPage = new BookDetailsPage(driver);
        Book details = bookDetailsPage.getDetails();
        for (Book book : books) {
            Assert.assertTrue(book.getCover().contains(details.getCover()));
        }


    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
