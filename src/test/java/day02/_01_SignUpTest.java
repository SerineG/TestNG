package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_SignUpTest {
    /** Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Click on My Accout
     * Click on Register
     * Fill int he form with valid informations
     * Accept the agreement
     * Click on Continue button
     * Verify that you are signed up
     */

    @Test
    public void SignUpTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
//<span class="hidden-xs hidden-sm hidden-md">My Account</span>

        WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccount.click();
//        <a href="https://opencart.abstracta.us:443/index.php?route=account/register">Register</a>

        WebElement register=driver.findElement(By.partialLinkText("Register"));
        register.click();

//        <input type="text" name="firstname" value="" placeholder="First Name" id="input-firstname" class="form-control">
        WebElement firstName=driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("John");

//        <input type="text" name="lastname" value="" placeholder="Last Name" id="input-lastname" class="form-control">

        WebElement lastName=driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Doe");
//<input type="email" name="email" value="" placeholder="E-Mail" id="input-email" class="form-control">
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("john.doe@gmail.com");
//        <input type="tel" name="telephone" value="" placeholder="Telephone" id="input-telephone" class="form-control">

        WebElement phone=driver.findElement(By.id("input-telephone"));
        phone.sendKeys("8181234567");

//        <input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control">

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("asd123");

//        <input type="password" name="confirm" value="" placeholder="Password Confirm" id="input-confirm" class="form-control">
        WebElement passwordConfirm=driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("asd123");
//<input type="checkbox" name="agree" value="1">

        WebElement checkBox=driver.findElement(By.name("agree"));
        checkBox.click();

//        <input type="submit" value="Continue" class="btn btn-primary">
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']//p"));

        Assert.assertEquals(successMessage.getText(), "Congratulations! Your new account has been successfully created!","Your test is not passed");
        Thread.sleep(3000);
        driver.quit();



    }
}
