import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Main {
    public static void main(String[] args){
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        //WebElement field = driver.findElements();
        WebElement field = driver.findElement(By.id("email"));
        field.sendKeys("webinar.test@gmail.com");

        WebElement field2 = driver.findElement(By.id("passwd"));
        field2.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement button = driver.findElement(By.name("submitLogin"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, 3000);
        By xpath = By.xpath("//img[@src='http://profile.prestashop.com/webinar.test%40gmail.com.jpg']");
        WebElement element = wait.until(presenceOfElementLocated(xpath));
        element.click();

        WebElement exit = driver.findElement(By.id("header_logout"));
        exit.click();

    }
    
    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
