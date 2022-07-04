import PageObject.Book;
import PageObject.BookDetailsPage;
import PageObject.NavigationPage;
import PageObject.ResultSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultPageTest {
    private WebDriver driver;
    private NavigationPage navigationPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilma\\IdeaProjects\\test_project\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        navigationPage = new NavigationPage(driver);
        driver.get("https://www.amazon.com/");
        navigationPage.valueFinder();
    }

    @Test(priority = 1)
    public void checkSwitchPage() {
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        String resultWord = resultSearchPage.getResultWord();
        Assert.assertEquals("RESULTS", resultWord);
    }

    @Test(priority = 2)
    public void checkList() {
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        List<Book> books = resultSearchPage.getBooks();
        System.out.println(books);
        driver.get("https://www.amazon.com/Head-First-Java-Brain-Friendly-Guide/dp/1491910771/ref=sr_1_2?crid=1LP2U5GS8KJ17&keywords=Java&qid=1656920954&s=books&sprefix=java%2Cstripbooks-intl-ship%2C164&sr=1-2");
        BookDetailsPage bookDetailsPage = new BookDetailsPage(driver);
        Book details = bookDetailsPage.getDetails();
        System.out.println(details);
        Assert.assertTrue(books.contains(details));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
