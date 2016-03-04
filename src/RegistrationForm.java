import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

/**
 * Created by p998btn on 2016.03.04.
 */
public class RegistrationForm {

    private static WebDriver driver;


    public RegistrationForm(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("http://swedbank-us1bteam.rhcloud.com/?email=admin%40admin.lt&password=admin#/");
    }


    public void login() {
        WebElement loginEmail = driver.findElement(By.id("email"));
        WebElement loginPassword = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.className("buttonLogin"));

        loginEmail.clear();
        loginEmail.sendKeys("admin@admin.lt");
        loginPassword.clear();
        loginPassword.sendKeys("admin");
        login.click();
    }

    public void register(){
        WebElement register = driver.findElement(By.className("buttonRegister"));
        register.click();
    }

    public void insertName(String name) {
        WebElement vardas = driver.findElement(By.id("name"));
        vardas.clear();
        vardas.sendKeys(name);
    }
    public void insertSurname(String surname) {
        WebElement pavarde = driver.findElement(By.id("surname"));
        pavarde.clear();
        pavarde.sendKeys(surname);
    }
    public void insertPhone(String phone) {
        WebElement telefonas = driver.findElement(By.id("tel"));
        telefonas.clear();
        telefonas.sendKeys(phone);
    }
    public void selectBank(int bankNumber){
        Select bankoSkyrius = new Select(driver.findElement(By.id("bank")));
        bankoSkyrius.selectByIndex(bankNumber);
    }
    public void insertDate(String date) {
        WebElement data = driver.findElement(By.id("date"));
        data.clear();
        data.sendKeys(date);
    }
    public void selectTime (int timeNumber) {
        Select konsultacijosLaikas = new Select(driver.findElement(By.id("time")));
        konsultacijosLaikas.selectByIndex(timeNumber);
    }
    public void selectSubject (int subjectNumber) {
        Select tema = new Select(driver.findElement(By.id("subject")));
        tema.selectByIndex(subjectNumber);
    }

    public void sendRegistration () {
        WebElement siusti = driver.findElement(By.className("btn"));
        siusti.click();
    }
    public void myRegistrations () {
        WebElement manoRegistracijos = driver.findElement(By.className("buttonMyReg"));
        manoRegistracijos.click();
    }
    public void assertDate(String myDate){
        List<WebElement> myList = driver.findElements(By.xpath("//tr[@class='ng-scope']"));
        Assert.assertTrue(myList.get(myList.size()-1).getText().contains(myDate));
    }
}
