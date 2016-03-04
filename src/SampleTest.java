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
import java.util.concurrent.TimeUnit;

public class SampleTest {

    @Test
    public void testCase() throws InterruptedException {

        File file = new File("C:/Intel/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng")));
        WebElement myData = driver.findElement(By.xpath("//td[contains(text(),'2328-07-14')]"));
        Assert.assertEquals("2328-07-14",myData.getText());


    }


}