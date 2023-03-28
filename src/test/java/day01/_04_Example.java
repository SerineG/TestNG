package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Example {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login" page
     * login
     * email:  testngusbatch@gmail.com
     * password: usbatch1234
     * verify that you see My Account
     */


    @Test
    void login() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        //<input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control">

        WebElement login = driver.findElement(By.id("input-email"));
        login.sendKeys("testngusbatch@gmail.com");

//        <input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control">
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("usbatch1234");

//        <input type="submit" value="Login" class="btn btn-primary">
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
//        <h2>My Account</h2>
        WebElement myAccountHeader = driver.findElement(By.xpath("(//div[@id='content']//h2)[1]"));
//        if (myAccountHeader.isDisplayed()) {
//            System.out.println(myAccountHeader.getText().equals("My Account"));
//        }

        String actual=myAccountHeader.getText();
        String expected="My Account";

        Assert.assertEquals(actual,expected,"Test is successful");
        Thread.sleep(3000);
        driver.quit();


    }
}
