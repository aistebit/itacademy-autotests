import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        File file = new File("C:/Intel/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void testCase() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        RegistrationForm page = new RegistrationForm(driver);

        page.goToPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        page.login();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonRegister")));
        page.register();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        page.insertName("Jonas");
        page.insertSurname("Petraitis");
        page.insertPhone("860088888");
        page.selectBank(2);
        page.insertDate("2328-07-14");
        page.selectTime(4);
        page.selectSubject(3);
        page.sendRegistration();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonMyReg")));
        page.myRegistrations();

        page.assertDate("2328-07-14");
    }
}