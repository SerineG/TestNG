package day02;

import UtilitiesClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_UpdateName extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Edit Account
     * Update name
     * Click on Continue
     * Verify the success message
     * <p>
     * Then update the name with the old name
     */

    @Test
     void editNameTest(){
        updateName("John3");
        updateName("TestNG");

    }
    public void updateName(String name) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver(options);
//
//        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
////        <input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control">
//        WebElement email = driver.findElement(By.id("input-email"));
//        email.sendKeys("john.doe@gmail.com");
//
////        <input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control">
//
//        WebElement password = driver.findElement(By.id("input-password"));
//        password.sendKeys("asd123");
////        <input type="submit" value="Login" class="btn btn-primary">
//        WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
//        submit.click();

//        <a href="https://opencart.abstracta.us:443/index.php?route=account/edit">Edit Account</a>

        WebElement edit = driver.findElement(By.partialLinkText("Edit Account"));
        edit.click();

//<input type="text" name="firstname" value="John" placeholder="First Name" id="input-firstname" class="form-control">
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(name);
//        <input type="submit" value="Continue" class="btn btn-primary">
        WebElement continuee = driver.findElement(By.cssSelector("input[type='submit']"));
        continuee.click();


        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));
//        <div class="alert alert-success alert-dismissible"><i class="fa fa-check-circle"></i> Success: Your account has been successfully updated.</div>

        Assert.assertEquals(successMessage.getText(), "Success: Your account has been successfully updated.", "Test failed");

    }
}
